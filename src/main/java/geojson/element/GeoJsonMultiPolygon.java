package geojson.element;

import geojson.util.Functions;
import lombok.Builder;
import lombok.Getter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.StringReader;
import java.util.List;
import java.util.Objects;

@Getter
@Builder(toBuilder = true)
public class GeoJsonMultiPolygon implements GeoJsonElement<List<List<List<Double>>>> {

    public static final String TYPE = "MultiPolygon";


    private List<List<List<List<Double>>>> coordinates;

    @Override
    public String getType() {
        return TYPE;
    }

    public static GeoJsonMultiPolygon from(JsonObject json) {
        if (!Objects.equals(json.getString("type"), TYPE)) {
            throw new IllegalArgumentException();
        }

        JsonArray coordinatesArray = json.getJsonArray("coordinates");


        List<List<List<List<Double>>>> coordinates = Functions.to4DCoordinatesList(coordinatesArray);

        return GeoJsonMultiPolygon.builder()
                .coordinates(coordinates)
                .build();
    }


    public static GeoJsonMultiPolygon from(String jsonString) {
        JsonObject json = Json.createReader(new StringReader(jsonString)).readObject();
        return from(json);
    }

    @Override
    public Point firstPoint() {
        return Point.fromGeoJsonList(coordinates.get(0).get(0).get(0));
    }
}

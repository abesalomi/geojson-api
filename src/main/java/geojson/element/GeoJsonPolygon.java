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
public class GeoJsonPolygon implements GeoJsonElement<List<List<Double>>> {

    public static final String TYPE = "Polygon";


    private List<List<List<Double>>> coordinates;

    @Override
    public String getType() {
        return TYPE;
    }

    public static GeoJsonPolygon from(JsonObject json) {
        if (!Objects.equals(json.getString("type"), TYPE)) {
            throw new IllegalArgumentException();
        }

        JsonArray coordinatesArray = json.getJsonArray("coordinates");


        List<List<List<Double>>> coordinates = Functions.to3DCoordinatesList(coordinatesArray);

        return GeoJsonPolygon.builder()
                .coordinates(coordinates)
                .build();
    }

    public static GeoJsonPolygon from(String jsonString) {
        JsonObject json = Json.createReader(new StringReader(jsonString)).readObject();
        return from(json);
    }


    @Override
    public Point getFirstPoint() {
        return Point.fromGeoJsonList(coordinates.get(0).get(0));
    }
}

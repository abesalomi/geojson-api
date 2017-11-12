package geojson.element;

import geojson.util.Functions;
import lombok.Builder;
import lombok.Getter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import java.io.StringReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Builder(toBuilder = true)
public class GeoJsonMultiPoint implements GeoJsonElement<List<Double>> {

    public static final String TYPE = "MultiPoint";


    private List<List<Double>> coordinates;

    @Override
    public String getType() {
        return TYPE;
    }

    public static GeoJsonMultiPoint from(JsonObject json) {
        if (!Objects.equals(json.getString("type"), TYPE)) {
            throw new IllegalArgumentException();
        }

        JsonArray coordinatesArray = json.getJsonArray("coordinates");


        List<List<Double>> coordinates = Functions.to2DCoordinatesList(coordinatesArray);

        return GeoJsonMultiPoint.builder()
                .coordinates(coordinates)
                .build();
    }

    public static GeoJsonMultiPoint from(String jsonString) {
        JsonObject json = Json.createReader(new StringReader(jsonString)).readObject();
        return from(json);
    }
}

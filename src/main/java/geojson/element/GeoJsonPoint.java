package geojson.element;

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
public class GeoJsonPoint implements GeoJsonElement<Double> {

    public static final String TYPE = "Point";

    private List<Double> coordinates;

    @Override
    public String getType() {
        return TYPE;
    }

    public static GeoJsonPoint from(JsonObject json) {
        if (!Objects.equals(json.getString("type"), TYPE)) {
            throw new IllegalArgumentException();
        }

        JsonArray coordinatesArray = json.getJsonArray("coordinates");


        List<Double> coordinates = coordinatesArray.getValuesAs(JsonNumber.class).stream()
                .map(JsonNumber::doubleValue)
                .collect(Collectors.toList());

        return GeoJsonPoint.builder()
                .coordinates(coordinates)
                .build();
    }

    public static GeoJsonPoint from(String jsonString) {
        JsonObject json = Json.createReader(new StringReader(jsonString)).readObject();
        return from(json);
    }
}

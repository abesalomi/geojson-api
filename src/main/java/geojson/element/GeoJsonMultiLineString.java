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
public class GeoJsonMultiLineString implements GeoJson<List<List<Double>>> {

    public static final String TYPE = "MultiLineString";


    private List<List<List<Double>>> coordinates;

    @Override
    public String getType() {
        return TYPE;
    }

    public static GeoJsonMultiLineString from(JsonObject json) {
        if (!Objects.equals(json.getString("type"), TYPE)) {
            throw new IllegalArgumentException();
        }

        JsonArray coordinatesArray = json.getJsonArray("coordinates");


        List<List<List<Double>>> coordinates = coordinatesArray.getValuesAs(JsonArray.class).stream()
                .map(arr -> arr.getValuesAs(JsonArray.class)
                        .stream()
                        .map(c -> c.getValuesAs(JsonNumber.class)
                                .stream()
                                .map(JsonNumber::doubleValue)
                                .collect(Collectors.toList()))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        return GeoJsonMultiLineString.builder()
                .coordinates(coordinates)
                .build();
    }

    public static GeoJsonMultiLineString from(String jsonString) {
        JsonObject json = Json.createReader(new StringReader(jsonString)).readObject();
        return from(json);
    }
}

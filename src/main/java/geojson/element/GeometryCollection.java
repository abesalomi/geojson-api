package geojson.element;

import geojson.GeoJsonElementParser;
import lombok.Builder;
import lombok.Getter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.io.StringReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Builder(toBuilder = true)
public class GeometryCollection implements GeoJson {

    public static final String TYPE = "GeometryCollection";

    private List<GeoJsonElement> geometries;

    @Override
    public String getType() {
        return TYPE;
    }

    public int size() {
        return geometries.size();
    }

    public static GeometryCollection from(JsonObject json) {
        if (!Objects.equals(json.getString("type"), TYPE)) {
            throw new IllegalArgumentException();
        }

        JsonArray geometriesArray = json.getJsonArray("geometries");


        List<GeoJsonElement> geometries = geometriesArray
                .getValuesAs(JsonValue::asJsonObject).stream()
                .map(GeoJsonElementParser::from)
                .collect(Collectors.toList());

        return GeometryCollection.builder()
                .geometries(geometries)
                .build();
    }

    public static GeometryCollection from(String jsonString) {
        JsonObject json = Json.createReader(new StringReader(jsonString)).readObject();
        return from(json);
    }


    @Override
    public Point getFirstPoint() {
        return geometries.get(0).getFirstPoint();
    }

}

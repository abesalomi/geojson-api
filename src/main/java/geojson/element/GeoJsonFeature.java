package geojson.element;

import geojson.GeoJsonElementParser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.codehaus.jackson.map.ObjectMapper;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@AllArgsConstructor(staticName = "create")
@Builder(toBuilder = true)
public class GeoJsonFeature<T> implements GeoJson {

    private static final String TYPE = "Feature";

    private GeoJsonElement geometry;

    private static ObjectMapper mapper = new ObjectMapper();

    private T properties;

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public Point firstPoint() {
        return geometry.firstPoint();
    }


    public static GeoJsonFeature<Object> from(JsonObject json) {
        if (!Objects.equals(json.getString("type"), TYPE)) {
            throw new IllegalArgumentException();
        }

        JsonObject geometryObject = json.getJsonObject("geometry");


        GeoJsonElement geometry = GeoJsonElementParser.from(geometryObject);

        return GeoJsonFeature.builder()
                .geometry(geometry)
                .build();
    }


    public static GeoJsonFeature from(String jsonString) {
        JsonObject json = Json.createReader(new StringReader(jsonString)).readObject();
        return from(json);
    }


    public static GeoJsonFeature<Map> createWithPropertiesMap(JsonObject json) {
        if (!Objects.equals(json.getString("type"), TYPE)) {
            throw new IllegalArgumentException();
        }

        JsonObject geometryObject = json.getJsonObject("geometry");
        JsonObject propertiesObject = json.getJsonObject("properties");

        Map properties = jsonToMap(propertiesObject);

        GeoJsonElement geometry = GeoJsonElementParser.from(geometryObject);

        return create(geometry, properties);
    }


    public static GeoJsonFeature<Map> createWithPropertiesMap(String jsonString) {
        JsonObject json = Json.createReader(new StringReader(jsonString)).readObject();
        return createWithPropertiesMap(json);
    }


    private static Map jsonToMap(JsonObject json) {
        try {
            return mapper.readValue(new ByteArrayInputStream(json.toString().getBytes()), HashMap.class);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}

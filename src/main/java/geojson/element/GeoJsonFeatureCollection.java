package geojson.element;

import lombok.Builder;
import lombok.Getter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Builder(toBuilder = true)
public class GeoJsonFeatureCollection<T> implements GeoJson {
    private static final String TYPE = "FeatureCollection";

    List<GeoJsonFeature<T>> features;

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public Point firstPoint() {
        return features.get(0).firstPoint();
    }

    public int size() {
        return features.size();
    }


    private GeoJsonFeatureCollection(List<GeoJsonFeature<T>> features) {
        this.features = features;
    }

    public static GeoJsonFeatureCollection from(JsonObject json) {
        if (!Objects.equals(json.getString("type"), TYPE)) {
            throw new IllegalArgumentException();
        }

        JsonArray featuresArray = json.getJsonArray("features");


        List<GeoJsonFeature<Object>> features = featuresArray.getValuesAs(JsonObject.class).stream()
                .map(GeoJsonFeature::from)
                .collect(Collectors.toList());

        return GeoJsonFeatureCollection.builder()
                .features(features)
                .build();
    }


    public static GeoJsonFeatureCollection from(String jsonString) {
        JsonObject json = Json.createReader(new StringReader(jsonString)).readObject();
        return from(json);
    }

    public static GeoJsonFeatureCollection<Map> createWithPropertiesMap(JsonObject json) {
        if (!Objects.equals(json.getString("type"), TYPE)) {
            throw new IllegalArgumentException();
        }

        JsonArray featuresArray = json.getJsonArray("features");


        List<GeoJsonFeature<Map>> features = featuresArray.getValuesAs(JsonObject.class).stream()
                .map(GeoJsonFeature::createWithPropertiesMap)
                .collect(Collectors.toList());

        return new GeoJsonFeatureCollection<>(features);
    }


    public static GeoJsonFeatureCollection<Map> createWithPropertiesMap(String jsonString) {
        JsonObject json = Json.createReader(new StringReader(jsonString)).readObject();
        return createWithPropertiesMap(json);
    }

    public GeometryCollection toGeometryCollection() {

        List<GeoJsonElement> geometries = features.stream().map(GeoJsonFeature::getGeometry).collect(Collectors.toList());

        return GeometryCollection.builder()
                .geometries(geometries)
                .build();
    }

}

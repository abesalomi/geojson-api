package geojson;

import geojson.element.GeoJson;
import geojson.element.GeoJsonPoint;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import java.io.StringReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GeoJsonParser {


    private static final String TYPE_FIELD = "type";

    public static <T extends GeoJson> T parse(String geoJsonStr) {

        if (Objects.isNull(geoJsonStr) || geoJsonStr.trim().isEmpty()) {
            return null;
        }

        JsonObject json = Json.createReader(new StringReader(geoJsonStr)).readObject();

        T geoJson = null;

        if (json.getString(TYPE_FIELD).equals(GeoJsonPoint.TYPE)) {


            geoJson = (T) parsePoint(json);

        }


        return geoJson;
    }

    private static GeoJsonPoint parsePoint(JsonObject json) {
        JsonArray coordinatesArray = json.getJsonArray("coordinates");

        List<Double> coordinates = coordinatesArray.getValuesAs(JsonNumber.class).stream()
                .map(JsonNumber::doubleValue)
                .collect(Collectors.toList());

        return GeoJsonPoint.builder()
                .coordinates(coordinates)
                .build();
    }
}

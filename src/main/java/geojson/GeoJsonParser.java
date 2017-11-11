package geojson;

import geojson.element.GeoJson;
import geojson.element.GeoJsonMultiPoint;
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


    public static GeoJson parse(String geoJsonStr) {

        if (Objects.isNull(geoJsonStr) || geoJsonStr.trim().isEmpty()) {
            return null;
        }

        JsonObject json = Json.createReader(new StringReader(geoJsonStr)).readObject();

        GeoJson geoJson = null;

        switch (json.getString(TYPE_FIELD)) {
            case GeoJsonPoint.TYPE:
                geoJson = GeoJsonPoint.from(json);
                break;
            case GeoJsonMultiPoint.TYPE:
                geoJson = GeoJsonMultiPoint.from(json);
                break;
        }

        return geoJson;
    }


}

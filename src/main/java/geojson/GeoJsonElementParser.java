package geojson;

import geojson.element.*;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;
import java.util.Objects;

public class GeoJsonElementParser {


    private static final String TYPE_FIELD = "type";


    public static GeoJsonElement parse(String geoJsonStr) {

        if (Objects.isNull(geoJsonStr) || geoJsonStr.trim().isEmpty()) {
            return null;
        }

        JsonObject json = Json.createReader(new StringReader(geoJsonStr)).readObject();

        return parse(json);
    }

    private static GeoJsonElement parse(JsonObject json) {
        GeoJsonElement geoJson = null;

        switch (json.getString(TYPE_FIELD)) {
            case GeoJsonPoint.TYPE:
                geoJson = GeoJsonPoint.from(json);
                break;
            case GeoJsonMultiPoint.TYPE:
                geoJson = GeoJsonMultiPoint.from(json);
                break;
            case GeoJsonLineString.TYPE:
                geoJson = GeoJsonLineString.from(json);
                break;
            case GeoJsonPolygon.TYPE:
                geoJson = GeoJsonPolygon.from(json);
                break;
            case GeoJsonMultiLineString.TYPE:
                geoJson = GeoJsonMultiLineString.from(json);
                break;
            case GeoJsonMultiPolygon.TYPE:
                geoJson = GeoJsonMultiPolygon.from(json);
                break;
        }
        return geoJson;
    }


}

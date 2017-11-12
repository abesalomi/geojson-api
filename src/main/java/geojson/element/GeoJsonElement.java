package geojson.element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GeoJsonElement<T> extends GeoJson {

    List<T> getCoordinates();

    default Map<String, Object> toElasticsearchMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("type", getType().toLowerCase());
        map.put("coordinates", getCoordinates());

        return map;
    }

}

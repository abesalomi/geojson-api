package geojson.element;

import java.util.List;

public interface GeoJsonElement<T> extends GeoJson {

    List<T> getCoordinates();

}

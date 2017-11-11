package geojson.element;

import java.util.List;

public interface GeoJson<T> {

    String getType();

    List<T> getCoordinates();

}

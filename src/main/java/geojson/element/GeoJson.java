package geojson.element;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public interface GeoJson {


    ObjectMapper mapper = new ObjectMapper();

    String getType();


    Point getFirstPoint();


    default String toJson() {
        try {
            return mapper.writeValueAsString(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

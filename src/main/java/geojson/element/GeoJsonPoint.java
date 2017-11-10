package geojson.element;

import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Getter
@Builder
public class GeoJsonPoint implements GeoJson {

    public static final String TYPE = "Point";

    private List<Double> coordinates;


}

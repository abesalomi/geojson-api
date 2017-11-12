package geojson.element;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor(staticName = "create")
public class Point {

    Double latitude;
    Double longitude;

    public static Point fromGeoJsonList(List<Double> points) {
        return new Point(points.get(1), points.get(0));
    }
}

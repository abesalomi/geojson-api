package geojson.util;

import javax.json.JsonArray;
import javax.json.JsonNumber;
import java.util.List;
import java.util.stream.Collectors;

public class Functions {

    public static List<List<List<List<Double>>>> to4DCoordinatesList(JsonArray coordinatesArray) {
        return coordinatesArray.getValuesAs(JsonArray.class).stream()
                .map(Functions::to3DCoordinatesList)
                .collect(Collectors.toList());
    }

    public static List<List<List<Double>>> to3DCoordinatesList(JsonArray array) {
        return array.getValuesAs(JsonArray.class)
                .stream()
                .map(Functions::to2DCoordinatesList)
                .collect(Collectors.toList());
    }

    public static List<List<Double>> to2DCoordinatesList(JsonArray array) {
        return array.getValuesAs(JsonArray.class)
                .stream()
                .map(Functions::toCoordinatesList)
                .collect(Collectors.toList());
    }

    public static List<Double> toCoordinatesList(JsonArray array) {
        return array.getValuesAs(JsonNumber.class)
                .stream()
                .map(JsonNumber::doubleValue)
                .collect(Collectors.toList());
    }
}

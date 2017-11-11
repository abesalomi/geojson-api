package geojson;

public interface GeoJsonSamples {

    String POINT = "{\n" +
            "        \"type\": \"Point\",\n" +
            "        \"coordinates\": [\n" +
            "          33.33,\n" +
            "          44.44\n" +
            "        ]\n" +
            "      }";


    String NOT_POINT = "{\n" +
            "        \"type\": \"NotPoint\",\n" +
            "        \"coordinates\": [\n" +
            "          33.33,\n" +
            "          44.44\n" +
            "        ]\n" +
            "      }";

    String MULTI_POINT = "{\n" +
            "  \"type\": \"MultiPoint\",\n" +
            "  \"coordinates\": [\n" +
            "     [ -73.9580, 40.8003 ],\n" +
            "     [ -73.9498, 40.7968 ],\n" +
            "     [ -73.9737, 40.7648 ],\n" +
            "     [ -73.9814, 40.7681 ]\n" +
            "  ]\n" +
            "}";


    String NOT_MULTI_POINT = "{\n" +
            "  \"type\": \"NotMultiPoint\",\n" +
            "  \"coordinates\": [\n" +
            "     [ -73.9580, 40.8003 ],\n" +
            "     [ -73.9498, 40.7968 ],\n" +
            "     [ -73.9737, 40.7648 ],\n" +
            "     [ -73.9814, 40.7681 ]\n" +
            "  ]\n" +
            "}";

    String LINE_STRING = "{ \"type\": \"LineString\", \"coordinates\": [ [ 40, 5 ], [ 41, 6 ] ] }";


    String NOT_LINE_STRING = "{ \"type\": \"NotLineString\", \"coordinates\": [ [ 40, 5 ], [ 41, 6 ] ] }";


    String NOT_POLYGON = "{\n" +
            "  \"type\": \"NotPolygon\",\n" +
            "  \"coordinates\": [ [ [ 0 , 0 ] , [ 3 , 6 ] , [ 6 , 1 ] , [ 0 , 0  ] ] ]\n" +
            "}";

    String POLYGON = "{\n" +
            "  \"type\": \"Polygon\",\n" +
            "  \"coordinates\": [ [ [ 0 , 0 ] , [ 3 , 6 ] , [ 6 , 1 ] , [ 0 , 0  ] ] ]\n" +
            "}";
}

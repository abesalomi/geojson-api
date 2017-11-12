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

    String NOT_MULTI_LINE_STRING = "{\n" +
            "       \"type\": \"NotMultiLineString\",\n" +
            "       \"coordinates\": [\n" +
            "          [ [ -73.96943, 40.78519 ], [ -73.96082, 40.78095 ] ],\n" +
            "          [ [ -73.96415, 40.79229 ], [ -73.95544, 40.78854 ] ],\n" +
            "          [ [ -73.97162, 40.78205 ], [ -73.96374, 40.77715 ] ],\n" +
            "          [ [ -73.97880, 40.77247 ], [ -73.97036, 40.76811 ] ]\n" +
            "       ]\n" +
            "     }";

    String MULTI_LINE_STRING = "{\n" +
            "       \"type\": \"MultiLineString\",\n" +
            "       \"coordinates\": [\n" +
            "          [ [ -73.96943, 40.78519 ], [ -73.96082, 40.78095 ] ],\n" +
            "          [ [ -73.96415, 40.79229 ], [ -73.95544, 40.78854 ] ],\n" +
            "          [ [ -73.97162, 40.78205 ], [ -73.96374, 40.77715 ] ],\n" +
            "          [ [ -73.97880, 40.77247 ], [ -73.97036, 40.76811 ] ]\n" +
            "       ]\n" +
            "     }";

    String NOT_MULTI_POLYGON = "{\n" +
            "  \"type\": \"NotMultiPolygon\",\n" +
            "  \"coordinates\": [\n" +
            "     [ [ [ -73.958, 40.8003 ], [ -73.9498, 40.7968 ], [ -73.9737, 40.7648 ], [ -73.9814, 40.7681 ], [ -73.958, 40.8003 ] ] ],\n" +
            "     [ [ [ -73.958, 40.8003 ], [ -73.9498, 40.7968 ], [ -73.9737, 40.7648 ], [ -73.958, 40.8003 ] ] ]\n" +
            "  ]\n" +
            "}";

    String MULTI_POLYGON = "{\n" +
            "  \"type\": \"MultiPolygon\",\n" +
            "  \"coordinates\": [\n" +
            "     [ [ [ -73.958, 40.8003 ], [ -73.9498, 40.7968 ], [ -73.9737, 40.7648 ], [ -73.9814, 40.7681 ], [ -73.958, 40.8003 ] ] ],\n" +
            "     [ [ [ -73.958, 40.8003 ], [ -73.9498, 40.7968 ], [ -73.9737, 40.7648 ], [ -73.958, 40.8003 ] ] ]\n" +
            "  ]\n" +
            "}";

    String NOT_GEOMETRY_COLLECTION = "{\n" +
            "  \"type\": \"NotGeometryCollection\",\n" +
            "  \"geometries\": [\n" +
            "     {\n" +
            "       \"type\": \"MultiPoint\",\n" +
            "       \"coordinates\": [\n" +
            "          [ -73.9580, 40.8003 ],\n" +
            "          [ -73.9498, 40.7968 ],\n" +
            "          [ -73.9737, 40.7648 ],\n" +
            "          [ -73.9814, 40.7681 ]\n" +
            "       ]\n" +
            "     },\n" +
            "     {\n" +
            "       \"type\": \"MultiLineString\",\n" +
            "       \"coordinates\": [\n" +
            "          [ [ -73.96943, 40.78519 ], [ -73.96082, 40.78095 ] ],\n" +
            "          [ [ -73.96415, 40.79229 ], [ -73.95544, 40.78854 ] ],\n" +
            "          [ [ -73.97162, 40.78205 ], [ -73.96374, 40.77715 ] ],\n" +
            "          [ [ -73.97880, 40.77247 ], [ -73.97036, 40.76811 ] ]\n" +
            "       ]\n" +
            "     }\n" +
            "  ]\n" +
            "}";


    String GEOMETRY_COLLECTION = "{\n" +
            "  \"type\": \"GeometryCollection\",\n" +
            "  \"geometries\": [\n" +
            "     {\n" +
            "       \"type\": \"MultiPoint\",\n" +
            "       \"coordinates\": [\n" +
            "          [ -73.9580, 40.8003 ],\n" +
            "          [ -73.9498, 40.7968 ],\n" +
            "          [ -73.9737, 40.7648 ],\n" +
            "          [ -73.9814, 40.7681 ]\n" +
            "       ]\n" +
            "     },\n" +
            "     {\n" +
            "       \"type\": \"MultiLineString\",\n" +
            "       \"coordinates\": [\n" +
            "          [ [ -73.96943, 40.78519 ], [ -73.96082, 40.78095 ] ],\n" +
            "          [ [ -73.96415, 40.79229 ], [ -73.95544, 40.78854 ] ],\n" +
            "          [ [ -73.97162, 40.78205 ], [ -73.96374, 40.77715 ] ],\n" +
            "          [ [ -73.97880, 40.77247 ], [ -73.97036, 40.76811 ] ]\n" +
            "       ]\n" +
            "     }\n" +
            "  ]\n" +
            "}";

    String FEATURE = "{\n" +
            "      \"type\": \"Feature\",\n" +
            "      \"properties\": {\n" +
            "        \"sampleProperty\": \"present\"\n" +
            "      },\n" +
            "      \"geometry\": {\n" +
            "        \"type\": \"Point\",\n" +
            "        \"coordinates\": [\n" +
            "          79.1015625,\n" +
            "          53.12040528310657\n" +
            "        ]\n" +
            "      }\n" +
            "    }";


    String FEATURE_COLLECTION = "{\n" +
            "  \"type\": \"FeatureCollection\",\n" +
            "  \"features\": [\n" +
            "    {\n" +
            "      \"type\": \"Feature\",\n" +
            "      \"properties\": {\n" +
            "        \"sample\": \"sample\"\n" +
            "      },\n" +
            "      \"geometry\": {\n" +
            "        \"type\": \"Point\",\n" +
            "        \"coordinates\": [\n" +
            "          79.1015625,\n" +
            "          53.12040528310657\n" +
            "        ]\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";
}

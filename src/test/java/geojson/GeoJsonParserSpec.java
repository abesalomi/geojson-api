package geojson;

import geojson.element.GeoJson;
import geojson.element.GeoJsonMultiPoint;
import geojson.element.GeoJsonPoint;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class GeoJsonParserSpec {

    @Test
    public void givenNullWhenParseThenReturnNull() {

        GeoJson geoJson = GeoJsonParser.parse(null);

        assertThat(geoJson, nullValue());
    }

    @Test
    public void givenEmptyStringWhenParseThenReturnNull() {

        GeoJson geoJson = GeoJsonParser.parse(" ");

        assertThat(geoJson, nullValue());
    }

    @Test
    public void whenParsePointThenReturnGeoJsonPoint() {

        GeoJson geoJson = GeoJsonParser.parse(GeoJsonSamples.POINT);

        assertThat(geoJson, instanceOf(GeoJsonPoint.class));

    }

    @Test
    public void whenParseMultiPointThenReturnGeoJsonMultiPoint() {

        GeoJson geoJson = GeoJsonParser.parse(GeoJsonSamples.MULTI_POINT);

        assertThat(geoJson, instanceOf(GeoJsonMultiPoint.class));

    }


}
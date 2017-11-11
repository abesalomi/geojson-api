package geojson;

import geojson.element.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;
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


    @Test
    public void whenParseLineStringThenReturnGeoJsonLineString() {

        GeoJson geoJson = GeoJsonParser.parse(GeoJsonSamples.LINE_STRING);

        assertThat(geoJson, instanceOf(GeoJsonLineString.class));

    }

    @Test
    public void whenParsePolygonThenReturnGeoJsonPolygon() {

        GeoJson geoJson = GeoJsonParser.parse(GeoJsonSamples.POLYGON);

        assertThat(geoJson, instanceOf(GeoJsonPolygon.class));

    }

    @Test
    public void whenParseMultiLineStringThenReturnGeoJsonMultiLineString() {

        GeoJson geoJson = GeoJsonParser.parse(GeoJsonSamples.MULTI_LINE_STRING);

        assertThat(geoJson, instanceOf(GeoJsonMultiLineString.class));

    }

    @Test
    public void whenParseMultiLineStringThenReturnGeoJsonMultiPolygon() {

        GeoJson geoJson = GeoJsonParser.parse(GeoJsonSamples.MULTI_POLYGON);

        assertThat(geoJson, instanceOf(GeoJsonMultiPolygon.class));

    }


}
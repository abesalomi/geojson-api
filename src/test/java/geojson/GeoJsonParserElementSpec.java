package geojson;

import geojson.element.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class GeoJsonParserElementSpec {

    @Test
    public void givenNullWhenParseThenReturnNull() {

        GeoJsonElement geoJson = GeoJsonElementParser.parse(null);

        assertThat(geoJson, nullValue());
    }

    @Test
    public void givenEmptyStringWhenParseThenReturnNull() {

        GeoJsonElement geoJson = GeoJsonElementParser.parse(" ");

        assertThat(geoJson, nullValue());
    }

    @Test
    public void whenParsePointThenReturnGeoJsonPoint() {

        GeoJsonElement geoJson = GeoJsonElementParser.parse(GeoJsonSamples.POINT);

        assertThat(geoJson, instanceOf(GeoJsonPoint.class));

    }

    @Test
    public void whenParseMultiPointThenReturnGeoJsonMultiPoint() {

        GeoJsonElement geoJson = GeoJsonElementParser.parse(GeoJsonSamples.MULTI_POINT);

        assertThat(geoJson, instanceOf(GeoJsonMultiPoint.class));

    }


    @Test
    public void whenParseLineStringThenReturnGeoJsonLineString() {

        GeoJsonElement geoJson = GeoJsonElementParser.parse(GeoJsonSamples.LINE_STRING);

        assertThat(geoJson, instanceOf(GeoJsonLineString.class));

    }

    @Test
    public void whenParsePolygonThenReturnGeoJsonPolygon() {

        GeoJsonElement geoJson = GeoJsonElementParser.parse(GeoJsonSamples.POLYGON);

        assertThat(geoJson, instanceOf(GeoJsonPolygon.class));

    }

    @Test
    public void whenParseMultiLineStringThenReturnGeoJsonMultiLineString() {

        GeoJsonElement geoJson = GeoJsonElementParser.parse(GeoJsonSamples.MULTI_LINE_STRING);

        assertThat(geoJson, instanceOf(GeoJsonMultiLineString.class));

    }

    @Test
    public void whenParseMultiLineStringThenReturnGeoJsonMultiPolygon() {

        GeoJsonElement geoJson = GeoJsonElementParser.parse(GeoJsonSamples.MULTI_POLYGON);

        assertThat(geoJson, instanceOf(GeoJsonMultiPolygon.class));

    }


}
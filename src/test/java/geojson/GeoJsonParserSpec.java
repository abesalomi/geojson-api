package geojson;

import geojson.element.GeoJson;
import geojson.element.GeoJsonPoint;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
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
    public void whenParsePointThenReturnGeoPoint() {

        GeoJson geoJson = GeoJsonParser.parse(GeoJsonSamples.POINT);

        assertThat(geoJson.getClass(), equalTo(GeoJsonPoint.class));

    }

    @Test
    public void whenParsePointThenReturnGeoPointWithCoordinates() {

        GeoJsonPoint geoJson = GeoJsonParser.parse(GeoJsonSamples.POINT);

        assertThat(geoJson.getCoordinates(), contains(33.33, 44.44));

    }


}
package geojson.element;

import geojson.GeoJsonSamples;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GeoJsonLineStringSpec {


    @Rule
    public ExpectedException expected = ExpectedException.none();


    GeoJsonLineString multiPoint;

    @Before
    public void before() {
        multiPoint = GeoJsonLineString.builder()
                .coordinates(Arrays.asList(Arrays.asList(33.33, 44.44), Arrays.asList(33.33, 44.44)))
                .build();
    }

    @Test
    public void whenInitializedThenTypeIsGeoPoint() {
        String type = multiPoint.getType();

        assertThat(type, equalTo("LineString"));
    }


    @Test
    public void whenInitializedThenCoordinatesIsAList() {
        List<List<Double>> coordinates = multiPoint.getCoordinates();
        assertThat(coordinates, notNullValue());
    }


    @Test
    public void whenJsonIsNotPointThenIllegalArgumentException() {
        expected.expect(IllegalArgumentException.class);

        GeoJsonLineString.from(GeoJsonSamples.NOT_LINE_STRING);
    }


    @Test
    public void whenJsonIsValifThenCoordinatesShouldSet() {
        GeoJsonLineString point = GeoJsonLineString.from(GeoJsonSamples.LINE_STRING);
        assertThat(point.getCoordinates(), notNullValue());
    }

}
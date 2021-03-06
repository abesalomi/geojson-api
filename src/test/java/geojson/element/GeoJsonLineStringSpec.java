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


    GeoJsonLineString lineString;

    @Before
    public void before() {
        lineString = GeoJsonLineString.builder()
                .coordinates(Arrays.asList(Arrays.asList(33.33, 44.44), Arrays.asList(33.33, 44.44)))
                .build();
    }

    @Test
    public void whenInitializedThenTypeIsLineString() {
        String type = lineString.getType();

        assertThat(type, equalTo("LineString"));
    }


    @Test
    public void whenInitializedThenCoordinatesIsAList() {
        List<List<Double>> coordinates = lineString.getCoordinates();
        assertThat(coordinates, notNullValue());
    }


    @Test
    public void whenJsonIsNotPointThenIllegalArgumentException() {
        expected.expect(IllegalArgumentException.class);

        GeoJsonLineString.from(GeoJsonSamples.NOT_LINE_STRING);
    }


    @Test
    public void whenJsonIsValidThenCoordinatesShouldSet() {
        GeoJsonLineString point = GeoJsonLineString.from(GeoJsonSamples.LINE_STRING);
        assertThat(point.getCoordinates(), notNullValue());
    }

}
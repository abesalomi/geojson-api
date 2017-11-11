package geojson.element;

import geojson.GeoJsonSamples;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GeoJsonMultiLineStringSpec {


    @Rule
    public ExpectedException expected = ExpectedException.none();


    GeoJsonMultiLineString multiLineString;

    @Before
    public void before() {
        multiLineString = GeoJsonMultiLineString.builder()
                .coordinates(Collections.singletonList(Arrays.asList(Arrays.asList(33.33, 44.44), Arrays.asList(33.33, 44.44))))
                .build();
    }

    @Test
    public void whenInitializedThenTypeIsMultiLineString() {
        String type = multiLineString.getType();

        assertThat(type, equalTo("MultiLineString"));
    }


    @Test
    public void whenInitializedThenCoordinatesIsAList() {
        List<List<List<Double>>> coordinates = multiLineString.getCoordinates();
        assertThat(coordinates, notNullValue());
    }


    @Test
    public void whenJsonIsNotPointThenIllegalArgumentException() {
        expected.expect(IllegalArgumentException.class);

        GeoJsonMultiLineString.from(GeoJsonSamples.NOT_MULTI_LINE_STRING);
    }


    @Test
    public void whenJsonIsValidThenCoordinatesShouldSet() {
        GeoJsonMultiLineString point = GeoJsonMultiLineString.from(GeoJsonSamples.MULTI_LINE_STRING);
        assertThat(point.getCoordinates(), notNullValue());
    }

}
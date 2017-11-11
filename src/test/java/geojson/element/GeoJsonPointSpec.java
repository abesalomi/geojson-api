package geojson.element;

import geojson.GeoJsonSamples;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class GeoJsonPointSpec {


    @Rule
    public ExpectedException expected = ExpectedException.none();

    private GeoJsonPoint point;

    @Before
    public void before() {
        point = GeoJsonPoint.builder()
                .coordinates(Arrays.asList(33.33, 44.44))
                .build();
    }

    @Test
    public void whenInitializedThenTypeIsGeoPoint() {
        String type = point.getType();
        assertThat(type, equalTo("Point"));
    }


    @Test
    public void whenInitializedThenCoordinatesIsAList() {
        List<Double> coordinates = point.getCoordinates();
        assertThat(coordinates, notNullValue());
    }

    @Test
    public void whenJsonIsNotPointThenIllegalArgumentException() {
        expected.expect(IllegalArgumentException.class);

        GeoJsonPoint.from(GeoJsonSamples.NOT_POINT);
    }


    @Test
    public void whenJsonIsValifThenCoordinatesShouldSet() {
        GeoJsonPoint point = GeoJsonPoint.from(GeoJsonSamples.POINT);
        assertThat(point.getCoordinates(), notNullValue());
    }


}
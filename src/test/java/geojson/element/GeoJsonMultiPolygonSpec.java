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

public class GeoJsonMultiPolygonSpec {


    @Rule
    public ExpectedException expected = ExpectedException.none();


    GeoJsonMultiPolygon multiPolygon;

    @Before
    public void before() {
        multiPolygon = GeoJsonMultiPolygon.builder()
                .coordinates(Collections.singletonList(Collections.singletonList(Arrays.asList(Arrays.asList(33.33, 44.44), Arrays.asList(33.33, 44.44)))))
                .build();
    }

    @Test
    public void whenInitializedThenTypeIsGeoMultiPolygon() {
        String type = multiPolygon.getType();

        assertThat(type, equalTo("MultiPolygon"));
    }


    @Test
    public void whenInitializedThenCoordinatesIsAList() {
        List<List<List<List<Double>>>> coordinates = multiPolygon.getCoordinates();
        assertThat(coordinates, notNullValue());
    }


    @Test
    public void whenJsonIsNotPointThenIllegalArgumentException() {
        expected.expect(IllegalArgumentException.class);

        GeoJsonMultiPolygon.from(GeoJsonSamples.NOT_MULTI_POLYGON);
    }


    @Test
    public void whenJsonIsValidThenCoordinatesShouldSet() {
        GeoJsonMultiPolygon point = GeoJsonMultiPolygon.from(GeoJsonSamples.MULTI_POLYGON);
        assertThat(point.getCoordinates(), notNullValue());
    }

}
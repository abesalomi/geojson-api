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

public class GeoJsonPolygonSpec {


    @Rule
    public ExpectedException expected = ExpectedException.none();


    GeoJsonPolygon multiPoint;

    @Before
    public void before() {
        multiPoint = GeoJsonPolygon.builder()
                .coordinates(Collections.singletonList(Arrays.asList(Arrays.asList(33.33, 44.44), Arrays.asList(33.33, 44.44))))
                .build();
    }

    @Test
    public void whenInitializedThenTypeIsGeoPoint() {
        String type = multiPoint.getType();

        assertThat(type, equalTo("Polygon"));
    }


    @Test
    public void whenInitializedThenCoordinatesIsAList() {
        List<List<List<Double>>> coordinates = multiPoint.getCoordinates();
        assertThat(coordinates, notNullValue());
    }


    @Test
    public void whenJsonIsNotPointThenIllegalArgumentException() {
        expected.expect(IllegalArgumentException.class);

        GeoJsonPolygon.from(GeoJsonSamples.NOT_POLYGON);
    }


    @Test
    public void whenJsonIsValifThenCoordinatesShouldSet() {
        GeoJsonPolygon point = GeoJsonPolygon.from(GeoJsonSamples.POLYGON);
        assertThat(point.getCoordinates(), notNullValue());
    }

}
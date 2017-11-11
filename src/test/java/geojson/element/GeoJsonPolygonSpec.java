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


    GeoJsonPolygon polygon;

    @Before
    public void before() {
        polygon = GeoJsonPolygon.builder()
                .coordinates(Collections.singletonList(Arrays.asList(Arrays.asList(33.33, 44.44), Arrays.asList(33.33, 44.44))))
                .build();
    }

    @Test
    public void whenInitializedThenTypeIsGeoPolygon() {
        String type = polygon.getType();

        assertThat(type, equalTo("Polygon"));
    }


    @Test
    public void whenInitializedThenCoordinatesIsAList() {
        List<List<List<Double>>> coordinates = polygon.getCoordinates();
        assertThat(coordinates, notNullValue());
    }


    @Test
    public void whenJsonIsNotPointThenIllegalArgumentException() {
        expected.expect(IllegalArgumentException.class);

        GeoJsonPolygon.from(GeoJsonSamples.NOT_POLYGON);
    }


    @Test
    public void whenJsonIsValidThenCoordinatesShouldSet() {
        GeoJsonPolygon point = GeoJsonPolygon.from(GeoJsonSamples.POLYGON);
        assertThat(point.getCoordinates(), notNullValue());
    }

}
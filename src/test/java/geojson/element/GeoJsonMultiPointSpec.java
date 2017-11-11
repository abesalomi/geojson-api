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

public class GeoJsonMultiPointSpec {


    @Rule
    public ExpectedException expected = ExpectedException.none();


    GeoJsonMultiPoint multiPoint;

    @Before
    public void before() {
        multiPoint = GeoJsonMultiPoint.builder()
                .coordinates(Arrays.asList(Arrays.asList(33.33, 44.44), Arrays.asList(33.33, 44.44)))
                .build();
    }

    @Test
    public void whenInitializedThenTypeIsGeoMultiPoint() {
        String type = multiPoint.getType();

        assertThat(type, equalTo("MultiPoint"));
    }


    @Test
    public void whenInitializedThenCoordinatesIsAList() {
        List<List<Double>> coordinates = multiPoint.getCoordinates();
        assertThat(coordinates, notNullValue());
    }


    @Test
    public void whenJsonIsNotPointThenIllegalArgumentException() {
        expected.expect(IllegalArgumentException.class);

        GeoJsonMultiPoint.from(GeoJsonSamples.NOT_MULTI_POINT);
    }


    @Test
    public void whenJsonIsValidThenCoordinatesShouldSet() {
        GeoJsonMultiPoint point = GeoJsonMultiPoint.from(GeoJsonSamples.MULTI_POINT);
        assertThat(point.getCoordinates(), notNullValue());
    }

}
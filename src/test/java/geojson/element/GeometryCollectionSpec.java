package geojson.element;

import geojson.GeoJsonSamples;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GeometryCollectionSpec {


    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void whenInitializedThenTypeIsGeometryCollection() {
        String type = GeometryCollection.builder().build().getType();

        assertThat(type, equalTo("GeometryCollection"));
    }


    @Test
    public void whenJsonIsNotPointThenIllegalArgumentException() {
        expected.expect(IllegalArgumentException.class);

        GeometryCollection.from(GeoJsonSamples.NOT_GEOMETRY_COLLECTION);
    }


    @Test
    public void whenJsonIsValidThenCoordinatesShouldSet() {
        GeometryCollection collection = GeometryCollection.from(GeoJsonSamples.GEOMETRY_COLLECTION);

        assertThat(collection.getGeometries(), notNullValue());
    }

}
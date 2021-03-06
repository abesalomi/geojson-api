package geojson.element;

import geojson.GeoJsonSamples;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GeoJsonFeatureCollectionSpec {

    @Test
    public void whenInitializedThenTypeIsFeatureCollection() {
        String type = GeoJsonFeatureCollection.builder().build().getType();

        assertThat(type, equalTo("FeatureCollection"));
    }


    @Test
    public void whenJsonIsValidThenParse() {
        GeoJsonFeatureCollection<Map> collection = GeoJsonFeatureCollection.createWithPropertiesMap(GeoJsonSamples.FEATURE_COLLECTION);

        assertThat(collection, notNullValue());
    }


    @Test
    public void givenFeatureCollectionWhenConvertToGeometryCollectionThenReutnGeometryCollection() {
        GeoJsonFeatureCollection<Map> featureCollection = GeoJsonFeatureCollection
                .createWithPropertiesMap(GeoJsonSamples.FEATURE_COLLECTION);

        GeometryCollection geometryCollection = featureCollection.toGeometryCollection();

        assertThat(geometryCollection.size(), equalTo(featureCollection.size()));
    }
}
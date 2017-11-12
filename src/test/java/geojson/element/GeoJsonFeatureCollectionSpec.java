package geojson.element;

import geojson.GeoJsonSamples;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import javax.json.JsonObject;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class GeoJsonFeatureCollectionSpec {

    @Test
    public void whenInitializedThenTypeIsFeatureCollection() {
        String type = GeoJsonFeatureCollection.builder().build().getType();

        assertThat(type, equalTo("FeatureCollection"));
    }


    @Test
    public void whenJsonIsValidThenParse() {
        GeoJsonFeatureCollection<Map> collection = GeoJsonFeatureCollection.createWithPropertiesMap(GeoJsonSamples.FEATURE_COLLECTION);
        System.out.println(collection.toJson());
        assertThat(collection, notNullValue());
    }
}
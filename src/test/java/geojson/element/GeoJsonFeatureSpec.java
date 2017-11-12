package geojson.element;

import geojson.GeoJsonSamples;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class GeoJsonFeatureSpec {
    @Test
    public void whenInitializedThenTypeIsFeature() {
        String type = GeoJsonFeature.builder().build().getType();

        assertThat(type, equalTo("Feature"));
    }

    @Test
    public void whenCreateFromJsonThenPropertiesIsPresent() {
        GeoJsonFeature feature = GeoJsonFeature.createWithPropertiesMap(GeoJsonSamples.FEATURE);

        assertThat(feature.getProperties(), notNullValue());
    }


    @Test
    public void whenCreateFromJsonThenPropertiesValuesIsPresent() {
        GeoJsonFeature<Map> feature = GeoJsonFeature.createWithPropertiesMap(GeoJsonSamples.FEATURE);
        Map properties = feature.getProperties();

        assertThat(properties.get("sampleProperty"), equalTo("present"));
    }

}
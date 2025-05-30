package com.shixin;

import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MapUtilsTest {
    @Test
    public void test_isEmpty() {
        Assertions.assertTrue(MapUtils.isEmpty(null));
        Assertions.assertTrue(MapUtils.isEmpty(new HashMap<>()));
        Assertions.assertFalse(MapUtils.isEmpty(Map.of(1, 2)));
    }

    @Test
    public void test_isNotEmpty() {
        Assertions.assertFalse(MapUtils.isNotEmpty(null));
        Assertions.assertFalse(MapUtils.isNotEmpty(new HashMap<>()));
        Assertions.assertTrue(MapUtils.isNotEmpty(Map.of(1, 2)));
    }

    @Test
    public void test_toProperties() {
        Properties properties = MapUtils.toProperties(Map.of("key", "value"));
        Assertions.assertEquals("value", properties.get("key"));
    }

    @Test
    public void test_invertMap() {
        Assertions.assertEquals(Map.of("value", "key"), MapUtils.invertMap(Map.of("key", "value")));
    }
}

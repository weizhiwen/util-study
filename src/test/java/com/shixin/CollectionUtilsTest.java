package com.shixin;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtilsTest {
    @Test
    public void test_isEmpty() {
        Assertions.assertTrue(CollectionUtils.isEmpty(null));
        Assertions.assertTrue(CollectionUtils.isEmpty(new ArrayList<>()));
        Assertions.assertFalse(CollectionUtils.isEmpty(List.of(1, 2, 3)));
    }

    @Test
    public void test_isNotEmpty() {
        Assertions.assertFalse(CollectionUtils.isNotEmpty(null));
        Assertions.assertFalse(CollectionUtils.isNotEmpty(new ArrayList<>()));
        Assertions.assertTrue(CollectionUtils.isNotEmpty(List.of(1, 2, 3)));
    }

    @Test
    public void test_intersection() {
        List<Integer> a = List.of(1, 2, 3);
        List<Integer> b = List.of(1, 2, 4);
        Assertions.assertEquals(List.of(1, 2), CollectionUtils.intersection(a, b));
        Assertions.assertEquals(new ArrayList<>(), CollectionUtils.intersection(a, CollectionUtils.emptyIfNull(null)));
    }

    @Test
    public void test_union() {
        List<Integer> a = List.of(1, 2, 3);
        List<Integer> b = List.of(1, 2, 4);
        Assertions.assertEquals(List.of(1, 2, 3, 4), CollectionUtils.union(a, b));
    }

    @Test
    public void test_subtract() {
        List<Integer> a = List.of(1, 2, 3);
        List<Integer> b = List.of(1, 2, 4);
        Assertions.assertEquals(List.of(3), CollectionUtils.subtract(a, b));
        Assertions.assertEquals(List.of(4), CollectionUtils.subtract(b, a));
    }

    @Test
    public void test_disjunction() {
        List<Integer> a = List.of(1, 2, 3);
        List<Integer> b = List.of(1, 2, 4);
        Assertions.assertEquals(List.of(3, 4), CollectionUtils.disjunction(a, b));
    }
}

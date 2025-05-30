package com.shixin;

import org.apache.commons.collections4.ListUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ListUtilsTest {
    @Test
    public void test_partition() {
        List<Integer> a = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<List<Integer>> parts = ListUtils.partition(a, 2);
        Assertions.assertEquals(5, parts.size());
    }

    @Test
    public void test_sum() {
        List<Integer> a = List.of(1, 2, 3);
        List<Integer> b = List.of(1, 2, 4);
        Assertions.assertEquals(List.of(3, 1, 2, 4), ListUtils.sum(a, b));
    }
}

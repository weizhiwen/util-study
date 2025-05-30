package com.shixin;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObjectUtilsTest {
    @Test
    public void test_compare() {
        Assertions.assertEquals(0, ObjectUtils.compare(1, 1));
        Assertions.assertEquals(-1, ObjectUtils.compare(null, 1));
        Assertions.assertEquals(1, ObjectUtils.compare(1, null));
        Assertions.assertEquals(-1, ObjectUtils.compare(1, 2));
    }

    @Test
    public void test_defaultIfNull() {
        Assertions.assertEquals(2, ObjectUtils.defaultIfNull(null, 2));
        Assertions.assertEquals(1, ObjectUtils.defaultIfNull(1, 2));
    }

    @Test
    public void test_firstNonNull() {
        Assertions.assertEquals("1", ObjectUtils.firstNonNull(null, "1", "2"));
    }

    @Test
    public void test_identityToString() {
        System.out.println(ObjectUtils.identityToString(1));
        Assertions.assertNull(ObjectUtils.identityToString(null));
    }

    @Test
    public void test_clone() {
        Integer[] a = new Integer[]{1, 2, 3};
        Integer[] clone = ObjectUtils.clone(a);
        Assertions.assertNotSame(a, clone);
        Assertions.assertArrayEquals(a, clone);

        // 不可clone对象返回null
        Pair<Long, Long> pair = Pair.of(2L, 3L);
        Pair<Long, Long> pairClone = ObjectUtils.clone(pair);
        Assertions.assertNull(pairClone);
    }
}

package com.shixin;

import org.apache.commons.lang3.ClassUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ClassUtilsTest {
    @Test
    public void test_getName() {
        Assertions.assertEquals("java.lang.String", ClassUtils.getName(String.class));
        Assertions.assertEquals("", ClassUtils.getName(null));
        int[] a = new int[]{1, 2, 3};
        Assertions.assertEquals("[I", ClassUtils.getName(a));
    }

    @Test
    public void test_getCanonicalName() {
        Assertions.assertEquals("java.lang.String", ClassUtils.getCanonicalName(String.class));
        Assertions.assertEquals("", ClassUtils.getCanonicalName(null));
        int[] a = new int[]{1, 2, 3};
        Assertions.assertEquals("int[]", ClassUtils.getCanonicalName(a));
    }

    @Test
    public void test_getShortName() {
        Assertions.assertEquals("String", ClassUtils.getShortClassName(String.class));
        Assertions.assertEquals("", ClassUtils.getShortClassName((Class<?>) null));

    }

    @Test
    public void test_getPackageName() {
        Assertions.assertEquals("com.shixin", ClassUtils.getPackageName(this.getClass()));
        Assertions.assertEquals("", ClassUtils.getPackageName((Class<?>) null));
    }

    @Test
    public void test_isAssignable() {
        Assertions.assertTrue(ClassUtils.isAssignable(ArrayList.class, List.class));
    }
}

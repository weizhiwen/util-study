package com.shixin;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayUtilsTest {
    @Test
    public void test_isEmpty() {
        int[] a = new int[]{};
        Assertions.assertTrue(ArrayUtils.isEmpty(a));
        Assertions.assertTrue(ArrayUtils.isEmpty((int[]) null));
    }

    @Test
    public void test_toString() {
        int[] a = new int[]{1, 2, 3};
        String s = ArrayUtils.toString(a);
        Assertions.assertEquals("{1,2,3}", s);
        Assertions.assertEquals("{}", ArrayUtils.toString(null));
    }

    @Test
    public void test_reverse() {
        int[] a = new int[]{1, 2, 3};
        ArrayUtils.reverse(a);
        Assertions.assertArrayEquals(new int[]{3, 2, 1}, a);
        int[] b = null;
        ArrayUtils.reverse(b);
        Assertions.assertNull(b);
    }

    @Test
    public void test_add() {
        int[] a = new int[]{1, 2, 3};
        int[] add = ArrayUtils.add(a, 1);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 1}, add);
    }

    @Test
    public void test_addAll() {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{3, 4};
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4}, ArrayUtils.addAll(a, b));
        Assertions.assertArrayEquals(new int[]{1, 2}, ArrayUtils.addAll(a, null));
        Assertions.assertArrayEquals(new int[]{3, 4}, ArrayUtils.addAll(null, b));
    }

    @Test
    public void test_contains() {
        int[] a = new int[]{1, 2, 3};
        boolean contains = ArrayUtils.contains(a, 1);
        Assertions.assertTrue(contains);
        Assertions.assertFalse(ArrayUtils.contains((int[]) null, 1));
    }

    @Test
    public void test_remove() {
        int[] a = new int[]{1, 2, 3};
        int[] remove = ArrayUtils.remove(a, 1);
        Assertions.assertArrayEquals(new int[]{1, 3}, remove);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.remove((int[]) null, 1), "Index: 1, Length: 0");
    }

    @Test
    public void test_removeAll() {
        int[] a = new int[]{1, 2, 3};
        int[] remove = ArrayUtils.removeAll(a, 1, 2);
        Assertions.assertArrayEquals(new int[]{1}, remove);
        Assertions.assertNull(ArrayUtils.removeAll((int[]) null, 1));
    }

    @Test
    public void test_removeElement() {
        int[] a = new int[]{1, 2, 3};
        int[] remove = ArrayUtils.removeElement(a, 1);
        Assertions.assertArrayEquals(new int[]{2, 3}, remove);
        Assertions.assertNull(ArrayUtils.removeElement((int[]) null, 1));
    }

    @Test
    public void test_nullToEmpty() {
        int[] a = null;
        Assertions.assertArrayEquals(new int[]{}, ArrayUtils.nullToEmpty(a));
    }

    @Test
    public void test_nullToNull() {
        Integer[] a = null;
        Integer[] defaultArray = new Integer[]{1, 2, 3};
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3}, ArrayUtils.nullTo(a, defaultArray));
    }

    @Test
    public void test_subarray() {
        int[] a = new int[]{1, 2, 3};
        int[] subarray = ArrayUtils.subarray(a, 0, 2);
        Assertions.assertArrayEquals(new int[]{1, 2}, subarray);
    }

    @Test
    public void test_clone() {
        int[] a = new int[]{1, 2, 3};
        int[] clone = ArrayUtils.clone(a);
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, clone);
        Assertions.assertNotSame(a, clone);
    }
}

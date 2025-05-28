package com.shixin;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberUtilsTest {
    @Test
    public void test_toNumber() {
        Assertions.assertEquals(0, NumberUtils.toInt(null));
        Assertions.assertEquals(1, NumberUtils.toInt(null, 1));
        Assertions.assertEquals(1, NumberUtils.toInt("1"));
        Assertions.assertEquals(0, NumberUtils.toInt("abc"));
    }

    @Test
    public void test_isDigits() {
        Assertions.assertFalse(NumberUtils.isDigits(null));
        Assertions.assertFalse(NumberUtils.isDigits(""));
        Assertions.assertTrue(NumberUtils.isDigits("123"));
        Assertions.assertFalse(NumberUtils.isDigits("-123"));
        Assertions.assertFalse(NumberUtils.isDigits("12.3"));
        Assertions.assertFalse(NumberUtils.isDigits("12.3e10"));
        Assertions.assertFalse(NumberUtils.isDigits("0xFF"));
    }

    @Test
    public void test_isParsable() {
        Assertions.assertFalse(NumberUtils.isParsable(null));
        Assertions.assertFalse(NumberUtils.isParsable(""));
        Assertions.assertTrue(NumberUtils.isParsable("123"));
        Assertions.assertTrue(NumberUtils.isParsable("-123"));
        Assertions.assertTrue(NumberUtils.isParsable("12.3"));
        Assertions.assertFalse(NumberUtils.isParsable("1.23e5"));
        Assertions.assertFalse(NumberUtils.isParsable("0xFF"));
    }

    @Test
    public void test_isCreatable() {
        Assertions.assertFalse(NumberUtils.isCreatable(null));
        Assertions.assertFalse(NumberUtils.isCreatable(""));
        Assertions.assertTrue(NumberUtils.isCreatable("123"));
        Assertions.assertTrue(NumberUtils.isCreatable("-123"));
        Assertions.assertTrue(NumberUtils.isCreatable("12.3"));
        Assertions.assertTrue(NumberUtils.isCreatable("1.23e5"));
        Assertions.assertTrue(NumberUtils.isCreatable("0xFF"));
    }

    @Test
    public void test_min() {
        Assertions.assertEquals(1, NumberUtils.min(2, 1, 3));
    }

    @Test
    public void test_max() {
        Assertions.assertEquals(3, NumberUtils.max(2, 1, 3));
    }
}

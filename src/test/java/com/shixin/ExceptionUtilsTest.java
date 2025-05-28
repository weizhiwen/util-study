package com.shixin;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ExceptionUtilsTest {
    @Test
    public void test_getStackTrace() {
        System.out.println(ExceptionUtils.getStackTrace(new RuntimeException("test")));
        System.out.println(ExceptionUtils.getStackTrace(new RuntimeException("外层", new IOException("内层"))));
    }

    @Test
    public void test_getRootCause() {
        System.out.println(ExceptionUtils.getRootCause(new RuntimeException("外层", new IOException("内层"))));
    }

    @Test
    public void test_isChecked() {
        Assertions.assertTrue(ExceptionUtils.isChecked(new IOException("1")));
        Assertions.assertTrue(ExceptionUtils.isChecked(new Exception("1")));
    }

    @Test
    public void test_isUnchecked() {
        Assertions.assertTrue(ExceptionUtils.isUnchecked(new RuntimeException("1")));
    }
}

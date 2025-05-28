package com.shixin;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringUtilsTest {
    @Test
    public void test_isEmpty() {
        Assertions.assertTrue(StringUtils.isEmpty(null));
        Assertions.assertTrue(StringUtils.isEmpty(""));
    }

    @Test
    public void test_isBlank() {
        Assertions.assertTrue(StringUtils.isBlank(null));
        Assertions.assertTrue(StringUtils.isBlank(""));
        Assertions.assertTrue(StringUtils.isBlank(" "));
    }

    @Test
    public void test_split() {
        String str = "a,b,c";
        String[] split = StringUtils.split(str, ",");
        Assertions.assertArrayEquals(new String[]{"a", "b", "c"}, split);
        Assertions.assertArrayEquals(null, StringUtils.split(null, ","));
    }

    @Test
    public void test_substring() {
        String str = "hello";
        // start <= end，否则为空
        Assertions.assertEquals("ell", StringUtils.substring(str, 1, 4));
        Assertions.assertEquals("", StringUtils.substring(str, -1, 4));
        Assertions.assertEquals("ell", StringUtils.substring(str, -4, -1));
        Assertions.assertEquals("ello", StringUtils.substring(str, 1, 10));
        Assertions.assertNull(StringUtils.substring(null, 1, 2));
    }

    @Test
    public void test_substringBefore() {
        String str = "key=value";
        Assertions.assertEquals("key", StringUtils.substringBefore(str, "="));
        Assertions.assertNull(StringUtils.substringBefore(null, "="));
    }

    @Test
    public void test_substringAfter() {
        String str = "key=value";
        Assertions.assertEquals("value", StringUtils.substringAfter(str, "="));
        Assertions.assertNull(StringUtils.substringAfter(null, "="));
    }

    @Test
    public void test_substringBetween() {
        String str = "key=value";
        Assertions.assertEquals("=", StringUtils.substringBetween(str, "y", "v"));
        Assertions.assertNull(StringUtils.substringBetween(null, "y", "v"));
    }

    @Test
    public void test_trim() {
        String str = "\n app  le \t";
        String trim = StringUtils.trim(str);
        Assertions.assertEquals("app  le", trim);
        String str1 = "\u2003Hello\u2003";
        Assertions.assertEquals(str1, StringUtils.trim(str1));
        Assertions.assertNull(StringUtils.trim(null));
    }

    @Test
    public void test_strip() {
        String str = "\n app  le \t";
        String strip = StringUtils.strip(str);
        Assertions.assertEquals("app  le", strip);
        String str1 = "\u2003Hello\u2003";
        Assertions.assertEquals("Hello", StringUtils.strip(str1));
        Assertions.assertNull(StringUtils.strip(null));
    }

    @Test
    public void test_tripToEmpty() {
        Assertions.assertEquals("", StringUtils.stripToEmpty(null));
    }

    @Test
    public void test_stripAccents() {
        Assertions.assertEquals("eclair", StringUtils.stripAccents("éclair"));
        Assertions.assertNull(StringUtils.stripAccents(null));
    }

    @Test
    public void test_normalizeSpace() {
        String str = "\n app  \tle \t";
        String normalizeSpace = StringUtils.normalizeSpace(str);
        Assertions.assertEquals("app le", normalizeSpace);
        Assertions.assertNull(StringUtils.normalizeSpace(null));
    }

    @Test
    public void test_replace() {
        String str = "aqqleqq";
        String replace = StringUtils.replace(str, "qq", "pp");
        Assertions.assertEquals("applepp", replace);
        Assertions.assertNull(StringUtils.replace(null, "qq", "pp"));
    }

    @Test
    public void test_replaceAll() {
        String str = "\n app  \tle \t";
        String replaceAll = StringUtils.replaceAll(str, "\\s+", "");
        Assertions.assertEquals("apple", replaceAll);
        Assertions.assertEquals("apple", str.replaceAll("\\s+", ""));
        Assertions.assertNull(StringUtils.replaceAll(null, "\\s+", ""));
    }

    @Test
    public void test_replaceEach() {
        String str = "aqqle";
        Assertions.assertEquals("apple", StringUtils.replaceEach(str, new String[]{"qq", "el"}, new String[]{"pp", "le"}));
        Assertions.assertNull(StringUtils.replaceEach(null, new String[]{"qq", "el"}, new String[]{"pp", "le"}));
    }

    @Test
    public void test_join() {
        String a = "apple,";
        String b = "banana";
        Assertions.assertEquals("apple,banana", StringUtils.join(a, b));
        Assertions.assertEquals("apple,", StringUtils.join(a, null));
        Assertions.assertEquals("banana", StringUtils.join((String) null, b));
        Assertions.assertEquals("", StringUtils.join((String) null, null));
    }

    @Test
    public void test_defaultIfEmpty() {
        Assertions.assertEquals("", StringUtils.defaultIfEmpty(null, ""));
    }

    @Test
    public void test_startWith() {
        String a = "apple";
        Assertions.assertTrue(StringUtils.startsWith(a, "ap"));
        Assertions.assertFalse(StringUtils.startsWith(null, "ap"));
    }

    @Test
    public void test_endWith() {
        String a = "apple";
        Assertions.assertTrue(StringUtils.endsWith(a, "le"));
        Assertions.assertFalse(StringUtils.endsWith(null, "le"));
    }

    @Test
    public void test_equals() {
        String str = "apple";
        Assertions.assertTrue(StringUtils.equals(str, "apple"));
        Assertions.assertFalse(StringUtils.equals(str, null));
    }

    @Test
    public void test_equalsAny() {
        String str = "apple";
        Assertions.assertTrue(StringUtils.equalsAny(str, "apple", "banana"));
        Assertions.assertTrue(StringUtils.equalsAny(str, null, "apple"));
        Assertions.assertFalse(StringUtils.equalsAny(str, null, "banana"));
    }

    @Test
    public void test_equalsIgnoreCase() {
        String str = "apple";
        Assertions.assertTrue(StringUtils.equalsIgnoreCase(str, "Apple"));
        Assertions.assertFalse(StringUtils.equalsIgnoreCase(str, null));
    }

    @Test
    public void test_overlay() {
        String str = "14311112222";
        String overlay = StringUtils.overlay(str, "****", 3, 8);
        Assertions.assertEquals("143****222", overlay);
    }

    @Test
    public void test_abbreviate() {
        String str = "apple";
        String abbreviate = StringUtils.abbreviate(str, 4);
        Assertions.assertEquals("a...", abbreviate);
        Assertions.assertNull(StringUtils.abbreviate(null, 4));
    }

    @Test
    public void test_isNumeric() {
        Assertions.assertTrue(StringUtils.isNumeric("143"));
        Assertions.assertFalse(StringUtils.isNumeric("-143"));
        Assertions.assertFalse(StringUtils.isNumeric("1.43"));
        Assertions.assertFalse(StringUtils.isNumeric("143a"));
    }

    @Test
    public void test_split_trim_sort_join() {
        String str = " appLe, cherRy, bAnana ";
        String[] split = StringUtils.split(str, ",");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            String trim = StringUtils.trim(s);
            String lowerCase = StringUtils.lowerCase(trim);
            list.add(lowerCase);
        }
        Collections.sort(list);
        String join = StringUtils.join(list, ",");
        Assertions.assertEquals("apple,banana,cherry", join);
    }
}

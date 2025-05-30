package com.shixin;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagTest {
    @Test
    public void test() {
        Bag<String> bag = new HashBag<>();
        bag.add("apple");
        bag.add("apple");
        bag.add("banana");
        bag.add("orange", 10);
        Assertions.assertTrue(bag.contains("apple"));
        Assertions.assertEquals(2, bag.getCount("apple"));
        Assertions.assertEquals(1, bag.getCount("banana"));
        Assertions.assertEquals(10, bag.getCount("orange"));
    }
}

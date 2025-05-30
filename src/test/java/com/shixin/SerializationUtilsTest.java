package com.shixin;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

public class SerializationUtilsTest {
    private record User(int id, String name) implements Serializable {
    }

    @Test
    public void test_serialize_deserialize() {
        User user = new User(1, "james");
        byte[] serialize = SerializationUtils.serialize(user);
        User deserialize = SerializationUtils.deserialize(serialize);
        Assertions.assertEquals(user, deserialize);
        Assertions.assertNotSame(user, deserialize);
    }

    @Test
    public void test_roundtrip() {
        User user = new User(1, "james");
        User deserialize = SerializationUtils.roundtrip(user);
        // 上面一行等同于下面两行
        // byte[] serialize = SerializationUtils.serialize(user);
        // User deserialize = SerializationUtils.deserialize(serialize);
        Assertions.assertEquals(user, deserialize);
        Assertions.assertNotSame(user, deserialize);
    }

    @Test
    public void test_clone() {
        User user = new User(1, "james");
        User clone = SerializationUtils.clone(user);
        Assertions.assertEquals(user, clone);
        Assertions.assertNotSame(user, clone);
    }
}

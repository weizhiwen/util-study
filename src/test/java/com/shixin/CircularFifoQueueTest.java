package com.shixin;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CircularFifoQueueTest {
    @Test
    public void test() {
        CircularFifoQueue<Integer> queue = new CircularFifoQueue<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        Assertions.assertEquals(3, queue.size());
        Assertions.assertEquals(List.of(3, 4, 5), new ArrayList<>(queue));
    }
}

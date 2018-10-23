package com.tenexperts.array;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PairSummaterTest {

    @Test
    public void testSum() throws ArraySummaterException {
        PairSummater summater = new PairSummater();
        int[] cat = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] dog = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        int[] parrot = {1, 11, 5, 7};
        int[] hamster = {0, 0, 0 ,0};
        int[] kitty = {0, 1, 1, 0};
        assertEquals(summater.sum(cat), 19);
        assertEquals(summater.sum(dog), 11);
        assertEquals(summater.sum(parrot), 12);
        assertEquals(summater.sum(hamster), 0);
        assertEquals(summater.sum(kitty), 1);
    }
}
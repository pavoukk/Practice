package com.tenexperts.array;

/**
 *
 */
public class Main {
    /**
     * @param args args are just args
     * @throws ArraySummaterException
     * throws is
     */
    public static void main(final String[] args) throws ArraySummaterException {
        PairSummater summater = new PairSummater();
        final int size = 10;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        System.out.println(summater.sum(array));


    }
}

package com.tenexperts.array;
/**
 *
 */
public class SimpleSummater implements IArraySummater {
    /**
     * @param arr arr is an array
     * @throws ArraySummaterException ArraySummaterException is a good exception
     */
    public int sum(final int[] arr) throws ArraySummaterException {
        if (arr.length % 2 != 0) {
            throw new ArraySummaterException();
        }
            int result = 0;
        for (int elem : arr) {
            result += elem;
        }
        return result;
    }
}

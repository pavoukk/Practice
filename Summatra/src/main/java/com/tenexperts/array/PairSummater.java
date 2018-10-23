package com.tenexperts.array;
/**
 *
 */
public class PairSummater implements IArraySummater {

    /**
     * This pair summater calculates sum of every arr's pair and returns the biggest value of sum
     *
     * @param arr arr is an array
     * @throws ArraySummaterException
     * ArraySummaterException is an exception
     */
    public int sum(final int[] arr) throws ArraySummaterException {
        if (arr.length % 2 != 0) {
            throw new ArraySummaterException();
        }
        int result = 0;
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] + arr[i + 1] > result) {
                result = arr[i] + arr[i + 1];
            }
        }
        return result;
    }
}

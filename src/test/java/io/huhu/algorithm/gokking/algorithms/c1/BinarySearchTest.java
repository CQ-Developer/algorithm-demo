package io.huhu.algorithm.gokking.algorithms.c1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @Test
    void binarySearch_intArr_1() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(1, BinarySearch.binarySearch(arr, 2));
    }

    @Test
    void binarySearch_intArr_2() {
        int[] arr = {1};
        assertEquals(0, BinarySearch.binarySearch(arr, 1));
    }

    @Test
    void binarySearch_intArr_3() {
        int[] arr = {1};
        assertEquals(-1, BinarySearch.binarySearch(arr, 2));
    }

    @Test
    void binarySearch_intArr_4() {
        int[] arr = {};
        assertEquals(-1, BinarySearch.binarySearch(arr, 0));
    }

    @Test
    void binarySearch_intArr_5() {
        assertEquals(-1, BinarySearch.binarySearch(null, 5));
    }

    @Test
    void binarySearch_intArr_6() {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        assertEquals(999999, BinarySearch.binarySearch(arr, 1000000));
    }

}

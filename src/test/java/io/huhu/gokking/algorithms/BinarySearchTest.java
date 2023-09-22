package io.huhu.gokking.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @Test
    void search_1() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(1, BinarySearch.search(arr, 2));
    }

    @Test
    void search_2() {
        int[] arr = {1};
        assertEquals(0, BinarySearch.search(arr, 1));
    }

    @Test
    void search_3() {
        int[] arr = {1};
        assertEquals(-1, BinarySearch.search(arr, 2));
    }

    @Test
    void search_4() {
        int[] arr = {};
        assertEquals(-1, BinarySearch.search(arr, 0));
    }

    @Test
    void search_5() {
        assertEquals(-1, BinarySearch.search(null, 5));
    }

    @Test
    void search_6() {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        assertEquals(999999, BinarySearch.search(arr, 1000000));
    }

}

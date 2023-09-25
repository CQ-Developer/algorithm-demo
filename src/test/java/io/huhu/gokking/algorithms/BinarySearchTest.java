package io.huhu.gokking.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @Test
    void search_1() {
        assertDoesNotThrow(() -> BinarySearch.search(null, 11));
        assertEquals(-1, BinarySearch.search(null, 11));
    }

    @Test
    void search_2() {
        int[] arr = {};
        assertDoesNotThrow(() -> BinarySearch.search(arr, 23));
        assertEquals(-1, BinarySearch.search(arr, 23));
    }

    @Test
    void search_3() {
        int[] arr = {1};
        assertEquals(-1, BinarySearch.search(arr, 18));
        assertEquals(0, BinarySearch.search(arr, 1));
    }

    @Test
    void search_4() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(-1, BinarySearch.search(arr, 6));
        assertEquals(1, BinarySearch.search(arr, 2));
    }

    @Test
    void search_5() {
        int[] arr = new int[1000];
        var rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10000);
        }
        Arrays.sort(arr);
        assertEquals(-1, BinarySearch.search(arr, 10001));
        assertEquals(555, BinarySearch.search(arr, arr[555]));
    }

}

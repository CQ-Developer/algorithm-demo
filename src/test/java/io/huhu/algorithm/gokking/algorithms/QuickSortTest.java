package io.huhu.algorithm.gokking.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuickSortTest {

    @Test
    void sort_1() {
        assertDoesNotThrow(() -> QuickSort.sort(null));
    }

    @Test
    void sort_2() {
        int[] arr = {};
        assertArrayEquals(arr, QuickSort.sort(arr));
    }

    @Test
    void sort_3() {
        int[] arr = {1};
        assertArrayEquals(arr, QuickSort.sort(arr));
    }

    @Test
    void sort_4() {
        int[] arr = {3, 5, 4, 1, 2};
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, QuickSort.sort(arr));
    }

    @Test
    void sort_5() {
        int n = 10;
        int[] arr = new int[n];
        var rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(n);
        }
        int[] result = QuickSort.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            assertTrue(result[i] <= result[i + 1]);
        }
    }

}

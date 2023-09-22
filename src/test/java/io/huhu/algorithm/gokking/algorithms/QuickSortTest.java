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
        QuickSort.sort(arr);
        assertArrayEquals(new int[0], arr);
    }

    @Test
    void sort_3() {
        int[] arr = {1};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    void sort_4() {
        int[] arr = {3, 5, 4, 1, 2};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void sort_5() {
        int[] arr = new int[100];
        var rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(1000);
        }
        QuickSort.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }

}

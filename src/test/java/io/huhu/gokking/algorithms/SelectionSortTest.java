package io.huhu.gokking.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SelectionSortTest {

    @Test
    void sort_1() {
        assertDoesNotThrow(() -> SelectionSort.sort(null));
    }

    @Test
    void sort_2() {
        int[] arr = {};
        SelectionSort.sort(arr);
        assertArrayEquals(new int[0], arr);
    }

    @Test
    void sort_3() {
        int[] arr = {1};
        SelectionSort.sort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    void sort_4() {
        int[] arr = {5, 3, 1, 2, 4};
        SelectionSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void sort_5() {
        int n = 10000;
        int[] arr = new int[n];
        var random = new Random(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }
        SelectionSort.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }

}

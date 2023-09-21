package io.huhu.algorithm.gokking.algorithms;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BubbleSortTest {

    @Test
    void sort_1() {
        assertDoesNotThrow(() -> BubbleSort.sort(null));
    }

    @Test
    void sort_2() {
        int[] arr = {};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[0], arr);
    }

    @Test
    void sort_3() {
        int[] arr = {1};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    void sort_4() {
        int[] arr = {5, 3, 1, 2, 4, 4};
        BubbleSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 4, 5}, arr);
    }

    @Test
    void sort_5() {
        int n = 100;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        BubbleSort.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    @Test
    void sort_6() throws Exception {
        int n = 1000;
        int[] arr = new int[n];
        var random = SecureRandom.getInstanceStrong();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }
        BubbleSort.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }

}

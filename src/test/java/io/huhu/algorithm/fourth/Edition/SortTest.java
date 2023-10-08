package io.huhu.algorithm.fourth.Edition;

import io.huhu.CommonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortTest {

    int[] arr;

    @BeforeEach
    void beforeEach() {
        arr = CommonUtils.generateArray(10_0000);
    }

    @Test
    void selectionSort() {
        long start = System.currentTimeMillis();
        Sort.selectionSort(arr);
        System.out.printf("cost: %dms%n", System.currentTimeMillis() - start);
        for (int i = 0; i < arr.length - 1; i++) {
            Assertions.assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    @Test
    void insertionSort() {
        long start = System.currentTimeMillis();
        Sort.insertionSort(arr);
        System.out.printf("cost: %dms%n", System.currentTimeMillis() - start);
        for (int i = 0; i < arr.length - 1; i++) {
            Assertions.assertTrue(arr[i] <= arr[i + 1]);
        }
    }

}

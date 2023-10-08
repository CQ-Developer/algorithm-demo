package io.huhu.algorithm.fourth.Edition;

import io.huhu.CommonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {

    int[] arr;

    @BeforeEach
    void beforeEach() {
        arr = CommonUtils.generateArray(100_0000);
    }

    @Test
    void selectionSort() {
        sort(Sort::selectionSort);
    }

    @Test
    void insertionSort() {
        sort(Sort::insertionSort);
    }

    @Test
    void shellSort() {
        sort(Sort::shellSort);
    }

    @Test
    void mergeSort() {
        sort(Sort::mergeSort);
    }

    private void sort(Consumer<int[]> sort) {
        int[] actual = arr;
        int[] expected = arr.clone();
        Arrays.sort(expected);
        long start = System.currentTimeMillis();
        sort.accept(actual);
        System.out.printf("cost: %dms%n", System.currentTimeMillis() - start);
        assertArrayEquals(expected, actual);
    }

}

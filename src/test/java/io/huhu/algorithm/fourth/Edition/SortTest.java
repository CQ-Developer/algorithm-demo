package io.huhu.algorithm.fourth.Edition;

import io.huhu.CommonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.function.Consumer;

class SortTest {

    int[] arr;
    static int[] ARRAY;
    static int[] EXPECTED;

    @BeforeAll
    static void beforeAll() throws NoSuchAlgorithmException {
        ARRAY = CommonUtils.generateArrayUnique(50_0000);
        EXPECTED = ARRAY.clone();
        Sort.selectionSort(EXPECTED);
    }

    @BeforeEach
    void beforeEach() {
        arr = ARRAY.clone();
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

    @Test
    void quickSort() {
        sort(Sort::quickSort);
    }

    private void sort(Consumer<int[]> sort) {
        long start = System.currentTimeMillis();
        sort.accept(arr);
        System.out.printf("cost: %d%n", System.currentTimeMillis() - start);
        Assertions.assertArrayEquals(EXPECTED, arr);
    }

}

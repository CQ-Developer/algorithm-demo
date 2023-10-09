package io.huhu.algorithm.fourth.Edition;

import io.huhu.CommonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {

    static final int LOOP = 20;
    static final int SKIP = 2;

    int[] arr;

    @BeforeEach
    void beforeEach() {
        arr = CommonUtils.generateArray(100000);
    }

    @Test
    void selectionSort() {
        sort(Sort::selectionSort, "selection");
    }

    @Test
    void insertionSort() {
        sort(Sort::insertionSort, "insertion");
    }

    @Test
    void shellSort() {
        sort(Sort::shellSort, "shell");
    }

    @Test
    void mergeSort() {
        sort(Sort::mergeSort, "merge");
    }

    private void sort(Consumer<int[]> sort) {
        int[] expected = arr.clone();
        Arrays.sort(expected);
        long[] costs = new long[LOOP];
        for (int i = 0; i < LOOP; i++) {
            int[] actual = arr.clone();
            long start = System.currentTimeMillis();
            sort.accept(actual);
            long cost = System.currentTimeMillis() - start;
            costs[i] = cost;
            assertArrayEquals(expected, actual);
        }
        double ave = LongStream.of(costs)
                .sorted()
                .skip(SKIP)
                .limit(LOOP - 2 * SKIP)
                .average()
                .orElseThrow();
        System.out.printf("%s cost: %6.3f%n", name, ave);
    }

}

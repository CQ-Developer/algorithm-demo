package io.huhu.algorithm.fourth.Edition;

import io.huhu.CommonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ThreeSumTest {

    int[] arr;

    @BeforeEach
    void beforeEach() {
        arr = CommonUtils.generateArray(10000);
    }

    @Test
    void count() {
        long start = System.currentTimeMillis();
        int count = ThreeSum.count(arr);
        long end = System.currentTimeMillis() - start;
        System.out.printf("count is %d, cost: %dms%n", count, end);
    }

    @Test
    void countFast() {
        long start = System.currentTimeMillis();
        int count = ThreeSum.countFast(arr);
        long end = System.currentTimeMillis() - start;
        System.out.printf("count is %d, cost: %dms%n", count, end);
    }

    @Test
    void countFast2() {
        long start = System.currentTimeMillis();
        int count = ThreeSum.countFast2(arr);
        long end = System.currentTimeMillis() - start;
        System.out.printf("count is %d, cost: %dms%n", count, end);
    }

}

package io.huhu.algorithm.fourth.Edition;

import io.huhu.CommonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

class ThreeSumTest {

    int[] arr;

    @BeforeEach
    void beforeEach() {
        arr = CommonUtils.generateArray(5000);
    }

    @Test
    void count() {
        count(ThreeSum::count);
    }

    @Test
    void countFast() {
        count(ThreeSum::countFast);
    }

    @Test
    void countFast2() {
        count(ThreeSum::countFast2);
    }

    private void count(Function<int[], Integer> threeSum) {
        long start = System.currentTimeMillis();
        int count = threeSum.apply(arr);
        long end = System.currentTimeMillis() - start;
        System.out.printf("count is %d, cost: %dms%n", count, end);
    }

}

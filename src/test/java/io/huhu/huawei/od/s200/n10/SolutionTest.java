package io.huhu.huawei.od.s200.n10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {3, 4, 5, 6, 5, 12, 13};
        Assertions.assertEquals(2, Solution.resolve(nums));
    }

    @Test
    void test2() {
        int[] nums = {3, 1, 3, 4, 4, 5, 3, 6, 5, 6, 8, 7, 10, 3};
        Assertions.assertEquals(3, Solution.resolve(nums));
    }

}

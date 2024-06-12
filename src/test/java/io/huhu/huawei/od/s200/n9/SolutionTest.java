package io.huhu.huawei.od.s200.n9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 1, 2, 2};
        Assertions.assertEquals(2, Solution.resolve(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 1, 1, 1, 1, 9, 8, 3, 7, 10};
        Assertions.assertEquals(3, Solution.resolve(nums));
    }

}

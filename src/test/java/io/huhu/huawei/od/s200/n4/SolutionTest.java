package io.huhu.huawei.od.s200.n4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test1() {
        int[] costs = {5, 14, 30, 100};
        int[] days = {1, 3, 15, 20, 21, 200, 202, 230};
        Assertions.assertEquals(40, Solution.doSolution(costs, days));
    }

}
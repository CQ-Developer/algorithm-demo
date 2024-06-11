package io.huhu.huawei.od.s200.n2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test1() {
        int m = 3;
        int[] requirements = {3, 5, 3, 4};
        Assertions.assertEquals(6, solution.doSolution(m, requirements));
    }

}

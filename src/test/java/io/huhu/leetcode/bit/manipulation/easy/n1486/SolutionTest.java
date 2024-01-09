package io.huhu.leetcode.bit.manipulation.easy.n1486;

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
    void xorOperation_1() {
        Assertions.assertEquals(8, solution.xorOperation(5, 0));
    }

    @Test
    void xorOperation_2() {
        Assertions.assertEquals(8, solution.xorOperation(4, 3));
    }

    @Test
    void xorOperation_3() {
        Assertions.assertEquals(7, solution.xorOperation(1, 7));
    }

    @Test
    void xorOperation_4() {
        Assertions.assertEquals(2, solution.xorOperation(10, 5));
    }

}

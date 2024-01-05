package io.huhu.leetcode.bit.manipulation.easy.n476;

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
    void findComplement1() {
        Assertions.assertEquals(2, solution.findComplement(5));
    }

    @Test
    void findComplement2() {
        Assertions.assertEquals(0, solution.findComplement(1));
    }

    @Test
    void findComplement3() {
        Assertions.assertEquals(0, solution.findComplement(2147483647));
    }

}

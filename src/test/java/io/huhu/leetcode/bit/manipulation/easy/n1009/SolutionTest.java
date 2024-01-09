package io.huhu.leetcode.bit.manipulation.easy.n1009;

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
    void bitwiseComplement_1() {
        Assertions.assertEquals(2, solution.bitwiseComplement(5));
    }

    @Test
    void bitwiseComplement_2() {
        Assertions.assertEquals(0, solution.bitwiseComplement(7));
    }

    @Test
    void bitwiseComplement_3() {
        Assertions.assertEquals(5, solution.bitwiseComplement(10));
    }

    @Test
    void bitwiseComplement_4() {
        Assertions.assertEquals(1, solution.bitwiseComplement(0));
    }

}

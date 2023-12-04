package io.huhu.leetcode.back.trace.n1415;

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
    void case1() {
        Assertions.assertEquals("c", solution.getHappyString(1, 3));
    }

    @Test
    void case2() {
        Assertions.assertEquals("", solution.getHappyString(1, 4));
    }

    @Test
    void case3() {
        Assertions.assertEquals("cab", solution.getHappyString(3, 9));
    }

    @Test
    void case4() {
        Assertions.assertEquals("", solution.getHappyString(2, 7));
    }

    @Test
    void case5() {
        Assertions.assertEquals("abacbabacb", solution.getHappyString(10, 100));
    }

}

package io.huhu.leetcode.binary.search.hard.n878;

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
        Assertions.assertEquals(2, solution.nthMagicalNumber(1, 2, 3));
    }

    @Test
    void test2() {
        Assertions.assertEquals(6, solution.nthMagicalNumber(4, 2, 3));
    }

}

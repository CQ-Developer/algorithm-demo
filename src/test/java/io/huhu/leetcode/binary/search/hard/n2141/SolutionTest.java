package io.huhu.leetcode.binary.search.hard.n2141;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract void setup();

    @Test
    void test1() {
        int[] batteries = {3, 3, 3};
        Assertions.assertEquals(4, solution.maxRunTime(2, batteries));
    }

    @Test
    void test2() {
        int[] batteries = {1, 1, 1, 1};
        Assertions.assertEquals(2, solution.maxRunTime(2, batteries));
    }

}

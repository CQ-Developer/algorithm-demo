package io.huhu.leetcode.topological.sort.n2127;

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
    void test_1() {
        int[] favorite = {2, 2, 1, 2};
        Assertions.assertEquals(3, solution.maximumInvitations(favorite));
    }

    @Test
    void test_2() {
        int[] favorite = {1, 2, 0};
        Assertions.assertEquals(3, solution.maximumInvitations(favorite));
    }

    @Test
    void test_3() {
        int[] favorite = {3, 0, 1, 4, 1};
        Assertions.assertEquals(4, solution.maximumInvitations(favorite));
    }

}

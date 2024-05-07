package io.huhu.leetcode.dynamic.programming.medium.n95;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void case_1() {
        List<TreeNode> expected = List.of(new TreeNode(1));
        Assertions.assertIterableEquals(expected, solution.generateTrees(1));
    }

}

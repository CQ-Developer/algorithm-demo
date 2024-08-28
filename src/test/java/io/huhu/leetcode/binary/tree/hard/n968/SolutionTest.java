package io.huhu.leetcode.binary.tree.hard.n968;

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
        TreeNode root = new TreeNode(0,
                new TreeNode(0,
                        new TreeNode(0),
                        new TreeNode(0)),
                null);
        Assertions.assertEquals(1, solution.minCameraCover(root));
    }

    @Test
    void test_2() {
        TreeNode root = new TreeNode(0,
                new TreeNode(0,
                        new TreeNode(0,
                                new TreeNode(0,
                                        null,
                                        new TreeNode(0)),
                                null),
                        null),
                null);
        Assertions.assertEquals(2, solution.minCameraCover(root));
    }

}

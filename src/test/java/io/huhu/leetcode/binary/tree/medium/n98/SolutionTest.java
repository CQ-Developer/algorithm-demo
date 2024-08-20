package io.huhu.leetcode.binary.tree.medium.n98;

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
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        Assertions.assertTrue(solution.isValidBST(root));
    }

    @Test
    void test_2() {
        TreeNode root = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode(6)));
        Assertions.assertFalse(solution.isValidBST(root));
    }

}

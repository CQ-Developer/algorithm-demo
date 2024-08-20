package io.huhu.leetcode.binary.tree.easy.n110;

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
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        Assertions.assertTrue(solution.isBalanced(root));
    }

    @Test
    void test_2() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4),
                                new TreeNode(4)),
                        new TreeNode(3)),
                new TreeNode(2));
        Assertions.assertFalse(solution.isBalanced(root));
    }

    @Test
    void test_3() {
        Assertions.assertTrue(solution.isBalanced(null));
    }

}

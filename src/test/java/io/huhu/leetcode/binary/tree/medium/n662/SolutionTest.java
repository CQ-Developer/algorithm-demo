package io.huhu.leetcode.binary.tree.medium.n662;

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
        TreeNode root = new TreeNode(1,
                new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(9)));
        Assertions.assertEquals(4, solution.widthOfBinaryTree(root));
    }

    @Test
    void test_2() {
        TreeNode root = new TreeNode(1,
                new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null),
                new TreeNode(2, null, new TreeNode(9, new TreeNode(7), null)));
        Assertions.assertEquals(7, solution.widthOfBinaryTree(root));
    }

    @Test
    void test_3() {
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        Assertions.assertEquals(2, solution.widthOfBinaryTree(root));
    }

}

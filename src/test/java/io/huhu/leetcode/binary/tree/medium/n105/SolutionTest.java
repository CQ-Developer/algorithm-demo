package io.huhu.leetcode.binary.tree.medium.n105;

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
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode actual = solution.buildTree(preorder, inorder);
        TreeNode expected = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Assertions.assertTrue(treeEquals(actual, expected));
    }

    @Test
    void test_2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode actual = solution.buildTree(preorder, inorder);
        TreeNode expected = new TreeNode(-1);
        Assertions.assertTrue(treeEquals(expected, actual));
    }

    boolean treeEquals(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            return t1.val == t2.val && treeEquals(t1.left, t2.left) && treeEquals(t1.right, t2.right);
        }
        return t1 == null && t2 == null;
    }

}

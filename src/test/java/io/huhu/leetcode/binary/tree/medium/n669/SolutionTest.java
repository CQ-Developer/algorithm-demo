package io.huhu.leetcode.binary.tree.medium.n669;

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
        TreeNode root = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        TreeNode actual = solution.trimBST(root, 1, 2);
        TreeNode expected = new TreeNode(1, null, new TreeNode(2));
        Assertions.assertTrue(treeEquals(expected, actual));
    }

    @Test
    void test_2() {
        TreeNode root = new TreeNode(3, new TreeNode(0, null, new TreeNode(2, new TreeNode(1), null)), new TreeNode(4));
        TreeNode actual = solution.trimBST(root, 1, 3);
        TreeNode expected = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null);
        Assertions.assertTrue(treeEquals(expected, actual));
    }

    boolean treeEquals(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            return t1.val == t2.val && treeEquals(t1.left, t2.left) && treeEquals(t1.right, t2.right);
        }
        return t1 == null && t2 == null;
    }

}

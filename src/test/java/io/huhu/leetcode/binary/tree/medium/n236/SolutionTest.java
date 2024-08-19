package io.huhu.leetcode.binary.tree.medium.n236;

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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode actual = solution.lowestCommonAncestor(root, root, root.left);
        Assertions.assertTrue(treeEquals(root, actual));
    }

    boolean treeEquals(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            return t1.val == t2.val && treeEquals(t1.left, t2.left) && treeEquals(t1.right, t2.right);
        }
        return t1 == null && t2 == null;
    }

}

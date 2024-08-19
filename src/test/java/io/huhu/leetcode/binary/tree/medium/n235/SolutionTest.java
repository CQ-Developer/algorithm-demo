package io.huhu.leetcode.binary.tree.medium.n235;

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
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        Assertions.assertEquals(root, solution.lowestCommonAncestor(root, root, root.left));
    }

}

package io.huhu.leetcode.binary.tree.medium.n979;

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
        TreeNode root = new TreeNode(3, new TreeNode(0), new TreeNode(0));
        Assertions.assertEquals(2, solution.distributeCoins(root));
    }

    @Test
    void test_2() {
        TreeNode root = new TreeNode(0, new TreeNode(3), new TreeNode(0));
        Assertions.assertEquals(3, solution.distributeCoins(root));
    }

}

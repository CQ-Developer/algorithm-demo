package io.huhu.leetcode.binary.tree.hard.n1373;

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
                new TreeNode(4,
                        new TreeNode(2),
                        new TreeNode(4)),
                new TreeNode(3,
                        new TreeNode(2),
                        new TreeNode(5,
                                new TreeNode(4),
                                new TreeNode(6))));
        Assertions.assertEquals(20, solution.maxSumBST(root));
    }

    @Test
    void test_2() {
        TreeNode root = new TreeNode(4,
                new TreeNode(3,
                        new TreeNode(1),
                        new TreeNode(2)),
                null);
        Assertions.assertEquals(2, solution.maxSumBST(root));
    }

}

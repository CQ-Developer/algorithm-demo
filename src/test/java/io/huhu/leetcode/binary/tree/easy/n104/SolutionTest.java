package io.huhu.leetcode.binary.tree.easy.n104;

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
                        new TreeNode(15), new TreeNode(7)));
        Assertions.assertEquals(3, solution.maxDepth(root));
    }

    @Test
    void test_2() {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2));
        Assertions.assertEquals(2, solution.maxDepth(root));
    }

}

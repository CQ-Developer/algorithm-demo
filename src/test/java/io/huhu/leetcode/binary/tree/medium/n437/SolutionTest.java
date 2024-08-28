package io.huhu.leetcode.binary.tree.medium.n437;

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
        TreeNode root = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(3),
                                new TreeNode(-2)),
                        new TreeNode(2,
                                null,
                                new TreeNode(1))),
                new TreeNode(-3,
                        null,
                        new TreeNode(11)));
        Assertions.assertEquals(3, solution.pathSum(root, 8));
    }

    @Test
    void test_2() {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1))));
        Assertions.assertEquals(3, solution.pathSum(root, 22));
    }

}

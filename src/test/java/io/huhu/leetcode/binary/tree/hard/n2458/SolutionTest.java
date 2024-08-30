package io.huhu.leetcode.binary.tree.hard.n2458;

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
                new TreeNode(3,
                        new TreeNode(2), null),
                new TreeNode(4,
                        new TreeNode(6),
                        new TreeNode(5,
                                null,
                                new TreeNode(7))));
        int[] queries = {4};
        int[] expected = {2};
        Assertions.assertArrayEquals(expected, solution.treeQueries(root, queries));
    }

    @Test
    void test_2() {
        TreeNode root = new TreeNode(5,
                new TreeNode(8,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(6)),
                        new TreeNode(1)),
                new TreeNode(9,
                        new TreeNode(3),
                        new TreeNode(7)));
        int[] queries = {3, 2, 4, 8};
        int[] expected = {3, 2, 3, 2};
        Assertions.assertArrayEquals(expected, solution.treeQueries(root, queries));
    }

}

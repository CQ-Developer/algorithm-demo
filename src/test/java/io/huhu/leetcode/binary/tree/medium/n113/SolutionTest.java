package io.huhu.leetcode.binary.tree.medium.n113;

import java.util.List;

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
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assertions.assertIterableEquals(List.of(), solution.pathSum(root, 5));
    }

    @Test
    void test_2() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        Assertions.assertIterableEquals(List.of(), solution.pathSum(root, 0));
    }

    @Test
    void test_3() {
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
        List<List<Integer>> actual = solution.pathSum(root, 22);
        List<List<Integer>> expected = List.of(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5));
        Assertions.assertIterableEquals(expected, actual);
    }

}

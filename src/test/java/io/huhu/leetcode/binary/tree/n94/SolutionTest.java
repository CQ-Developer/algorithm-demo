package io.huhu.leetcode.binary.tree.n94;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

abstract class SolutionTest {

    Solution solution;

    abstract Solution getSolution();

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    @Test
    void test_1() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> actual = solution.inorderTraversal(root);
        List<Integer> expected = List.of(1, 3, 2);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void test_2() {
        List<Integer> actual = solution.inorderTraversal(null);
        List<Integer> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void test_3() {
        TreeNode root = new TreeNode(1);
        List<Integer> actual = solution.inorderTraversal(root);
        List<Integer> expected = List.of(1);
        Assertions.assertIterableEquals(expected, actual);
    }

}

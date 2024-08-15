package io.huhu.leetcode.binary.tree.easy.n145;

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
        List<Integer> actual = solution.postorderTraversal(root);
        List<Integer> expected = List.of(3, 2, 1);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void test_2() {
        Assertions.assertIterableEquals(List.of(), solution.postorderTraversal(null));
    }

    @Test
    void test_3() {
        TreeNode root = new TreeNode(1);
        List<Integer> actual = solution.postorderTraversal(root);
        List<Integer> expected = List.of(1);
        Assertions.assertIterableEquals(expected, actual);
    }

}
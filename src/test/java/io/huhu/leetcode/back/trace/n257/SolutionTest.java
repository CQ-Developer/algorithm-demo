package io.huhu.leetcode.back.trace.n257;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void binaryTreePaths1() {
        var root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        var expect = List.of("1->2->5", "1->3");
        Assertions.assertIterableEquals(expect, solution.binaryTreePaths(root));
    }

    @Test
    void binaryTreePaths2() {
        var root = new TreeNode(1);
        var expect = List.of("1");
        Assertions.assertIterableEquals(expect, solution.binaryTreePaths(root));
    }

}

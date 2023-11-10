package io.huhu.leetcode.back.trace.n113;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void pathSum_1() {
        var root = new TreeNode(1, new TreeNode(2), null);
        Assertions.assertIterableEquals(List.of(), solution.pathSum(root, 0));
    }

    @Test
    void pathSum_2() {
        var root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assertions.assertIterableEquals(List.of(), solution.pathSum(root, 5));
    }

    @Test
    void pathSum_3() {
        var root = new TreeNode(5,
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
        var expected = List.of(
                List.of(5, 4, 11, 2),
                List.of(5, 8, 4, 5));
        Assertions.assertIterableEquals(expected, solution.pathSum(root, 22));
    }

}
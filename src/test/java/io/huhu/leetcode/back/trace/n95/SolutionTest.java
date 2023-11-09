package io.huhu.leetcode.back.trace.n95;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void generateTrees_1() {
        var t1 = new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null));
        var t2 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        var t3 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        var t4 = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null);
        var t5 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null);
        Assertions.assertIterableEquals(List.of(t1, t2, t3, t4, t5), solution.generateTrees(3));
    }

    @Test
    void generateTrees_2() {
        var t1 = new TreeNode(1);
        Assertions.assertIterableEquals(List.of(t1), solution.generateTrees(1));
    }

}

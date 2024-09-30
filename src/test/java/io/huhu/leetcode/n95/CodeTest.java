package io.huhu.leetcode.n95;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @Test
    void test_1() {
        List<TreeNode> expected = List.of(
                new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null)),
                new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3))),
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null),
                new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null));
        Assertions.assertIterableEquals(expected, code.generateTrees(3));
    }

    @Test
    void test_2() {
        List<TreeNode> expected = List.of(new TreeNode(1));
        Assertions.assertIterableEquals(expected, code.generateTrees(1));
    }

}

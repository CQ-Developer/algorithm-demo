package io.huhu.leetcode.n95;

import java.util.ArrayList;
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
        var a = toString(expected);
        var b = toString(code.generateTrees(3));
        Assertions.assertIterableEquals(a, b);
    }

    @Test
    void test_2() {
        List<TreeNode> expected = List.of(new TreeNode(1));
        var a = toString(expected);
        var b = toString(code.generateTrees(1));
        Assertions.assertIterableEquals(a, b);
    }

    List<String> toString(List<TreeNode> nodes) {
        List<String> list = new ArrayList<>();
        for (var node : nodes) {
            list.add(toString(node));
        }
        list.sort(String::compareTo);
        return list;
    }

    String toString(TreeNode node) {
        if (node == null) {
            return "null";
        }
        return node.val + toString(node.left) + toString(node.right);
    }

}

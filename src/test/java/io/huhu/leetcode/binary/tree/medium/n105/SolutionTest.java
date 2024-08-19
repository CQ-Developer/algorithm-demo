package io.huhu.leetcode.binary.tree.medium.n105;

import java.util.ArrayList;
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
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode actual = solution.buildTree(preorder, inorder);
        TreeNode expected = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Assertions.assertEquals(serialize(expected), serialize(actual));
    }

    @Test
    void test_2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode actual = solution.buildTree(preorder, inorder);
        TreeNode expected = new TreeNode(-1);
        Assertions.assertEquals(serialize(expected), serialize(actual));
    }

    String serialize(TreeNode root) {
        String s = serialize(root, new ArrayList<>());
        System.out.println(s);
        return s;
    }

    String serialize(TreeNode root, List<String> list) {
        if (root == null) {
            list.add(null);
        } else {
            list.add(String.valueOf(root.val));
            serialize(root.left, list);
            serialize(root.right, list);
        }
        return String.join(",", list);
    }

}

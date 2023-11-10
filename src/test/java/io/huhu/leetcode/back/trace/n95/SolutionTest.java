package io.huhu.leetcode.back.trace.n95;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void generateTrees_1() {
        var t1 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        var t2 = new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null));
        var t3 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        var t4 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null);
        var t5 = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null);
        var expected = List.of(t1, t2, t3, t4, t5);
        var actual = solution.generateTrees(3);
        Assertions.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < 5; i++) {
            Assertions.assertTrue(isSame(expected.get(i), actual.get(i)));
        }
    }

    @Test
    void generateTrees_2() {
        var t1 = new TreeNode(1);
        var expected = List.of(t1);
        var actual = solution.generateTrees(1);
        Assertions.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < 1; i++) {
            Assertions.assertTrue(isSame(expected.get(i), actual.get(i)));
        }
    }

    boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null) {
            return false;
        } else if (node2 == null) {
            return false;
        } else if (node1.val != node2.val) {
            return false;
        } else {
            return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
        }
    }

    @Test
    void test() {
        var tree = treeFromList(List.of(1, 3, 2));
        System.out.println();
    }

    TreeNode treeFromList(List<Integer> list) {
        var root = new TreeNode(0);
        for (int i : list) {
            treeFromList(root, i);
        }
        return root.right;
    }

    void treeFromList(TreeNode pre, int i) {
        if (i < pre.val) {
            if (pre.left == null) {
                pre.left = new TreeNode(i);
            } else {
                treeFromList(pre.left, i);
            }
        } else {
            if (pre.right==null) {
                pre.right = new TreeNode(i);
            } else {
                treeFromList(pre.right, i);
            }
        }
    }

}

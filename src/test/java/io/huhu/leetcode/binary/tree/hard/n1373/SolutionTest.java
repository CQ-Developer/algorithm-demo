package io.huhu.leetcode.binary.tree.hard.n1373;

import java.util.LinkedList;
import java.util.Queue;

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
        TreeNode root = desialize("1,4,3,2,4,2,5,null,null,null,null,null,null,4,6");
        Assertions.assertEquals(20, solution.maxSumBST(root));
    }

    @Test
    void test_2() {
        TreeNode root = desialize("4,3,null,1,2");
        Assertions.assertEquals(2, solution.maxSumBST(root));
    }

    TreeNode desialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        int i = 0;
        String[] nodes = data.split(",");
        TreeNode root = generate(nodes[i++]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode cur = queue.remove();
            cur.left = generate(nodes[i++]);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            cur.right = generate(nodes[i++]);
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return root;
    }

    TreeNode generate(String s) {
        return "null".equals(s) ? null : new TreeNode(Integer.parseInt(s));
    }

}

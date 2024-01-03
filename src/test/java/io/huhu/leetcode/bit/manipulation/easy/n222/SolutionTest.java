package io.huhu.leetcode.bit.manipulation.easy.n222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    /**
     * <img src="https://assets.leetcode.com/uploads/2021/01/14/complete.jpg"/>
     */
    @Test
    void countNodes1() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        Assertions.assertEquals(6, solution.countNodes(root));
    }

    @Test
    void countNodes2() {
        Assertions.assertEquals(0, solution.countNodes(null));
    }

    @Test
    void countNodes3() {
        TreeNode root = new TreeNode(1);
        Assertions.assertEquals(1, solution.countNodes(root));
    }

    @Test
    void countNodes4() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        Assertions.assertEquals(5, solution.countNodes(root));
    }

}

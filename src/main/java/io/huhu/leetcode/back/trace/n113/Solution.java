package io.huhu.leetcode.back.trace.n113;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/path-sum-ii/">113.路径总合II</a>
 * 给你二叉树的根节点root和一个整数目标和targetSum
 * 找出所有从根节点到叶子节点路径总合等于给定目标和的路径
 * 叶子节点是指没有子节点的节点
 */
class Solution {

    /**
     * 树中节点总数在范围[0,5000]内
     * -1000 <= Node.val <= 1000
     * -1000 <= targetSum <= 1000
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            backTrace(root, 0, targetSum, new ArrayDeque<>(), result);
        }
        return result;
    }

    /**
     * 回溯算法
     */
    private void backTrace(TreeNode node, int sum, int targetSum, Deque<Integer> path, List<List<Integer>> result) {
        if (node.left == null && node.right == null) {
            path.addLast(node.val);
            if (node.val + sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        path.addLast(node.val);
        if (node.left != null) {
            backTrace(node.left, sum + node.val, targetSum, path, result);
            path.removeLast();
        }
        if (node.right != null) {
            backTrace(node.right, sum + node.val, targetSum, path, result);
            path.removeLast();
        }
    }

}

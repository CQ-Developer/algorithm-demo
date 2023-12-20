package io.huhu.leetcode.back.trace.lcr.n153;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/description/">二叉树中和为目标值的路径</a>
 * <p>给你二叉树的根节点root和一个整数目标和targetSum, 找出所有从根节点到叶子节点路径总合等于给定目标和的路径
 * <p>叶子节点是指没有子节点的节点
 * <p>提示:
 * <li>树中节点总数在范围[0, 5000]内
 * <li>-1000 <= Node.val <= 1000
 * <li>-1000 <= targetSum <= 1000
 */
class Solution {

    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            backTracing(root, target, new ArrayDeque<>(), res);
        }
        return res;
    }

    private void backTracing(TreeNode root, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                List<Integer> list = new ArrayList<>(path);
                list.add(root.val);
                res.add(list);
            }
            return;
        }
        path.addLast(root.val);
        if (root.left != null) {
            backTracing(root.left, target - root.val, path, res);
        }
        if (root.right != null) {
            backTracing(root.right, target - root.val, path, res);
        }
        path.removeLast();
    }

}

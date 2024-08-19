package io.huhu.leetcode.binary.tree.medium.n113;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/path-sum-ii/description/">
 * Path Sum II
 * </a>
 */
class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            f(root, targetSum, new LinkedList<>(), ans);
        }
        return ans;
    }

    private void f(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> ans) {
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                path.addLast(root.val);
                ans.add(new ArrayList<>(path));
                path.removeLast();
            }
            return;
        }
        path.addLast(root.val);
        if (root.left != null) {
            f(root.left, sum - root.val, path, ans);
        }
        if (root.right != null) {
            f(root.right, sum - root.val, path, ans);
        }
        path.removeLast();
    }

}

package io.huhu.leetcode.dynamic.programming.medium.n95;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees-ii/description/">不同的二叉搜索树II</a>
 */
class Solution {

    public List<TreeNode> generateTrees(int n) {
        List<List<List<TreeNode>>> cache = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            List<List<TreeNode>> sub = new ArrayList<>();
            for (int j = 0; j < n + 1; j++) {
                sub.add(null);
            }
            cache.add(sub);
        }
        return generateTrees(1, n, cache);
    }

    private List<TreeNode> generateTrees(int left, int right, List<List<List<TreeNode>>> cache) {
        List<TreeNode> trees = new ArrayList<>();
        if (left > right) {
            trees.add(null);
            return trees;
        }
        if (left == right) {
            trees.add(new TreeNode(left));
            return trees;
        }
        if (cache.get(left).get(right) != null) {
            return cache.get(left).get(right);
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = generateTrees(left, i - 1, cache);
            List<TreeNode> rightTrees = generateTrees(i + 1, right, cache);
            for (TreeNode leftNode : leftTrees) {
                for (TreeNode rightNode : rightTrees) {
                    trees.add(new TreeNode(i, leftNode, rightNode));
                }
            }
        }
        cache.get(left).set(right, trees);
        return trees;
    }

}

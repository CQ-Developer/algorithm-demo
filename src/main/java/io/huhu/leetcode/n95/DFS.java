package io.huhu.leetcode.n95;

import java.util.ArrayList;
import java.util.List;

class DFS implements Code {

    @Override
    public List<TreeNode> generateTrees(int n) {
        return f(1, n);
    }

    /**
     * f(i,j)表示在i...j范围上所有二叉搜索树
     */
    private List<TreeNode> f(int i, int j) {
        List<TreeNode> trees = new ArrayList<>();
        if (i > j) {
            trees.add(null);
            return trees;
        }
        if (i == j) {
            trees.add(new TreeNode(i));
            return trees;
        }
        for (int val = i; val <= j; val++) {
            var subL = f(i, val - 1);
            var subR = f(val + 1, j);
            for (var left : subL) {
                for (var right : subR) {
                    trees.add(new TreeNode(val, left, right));
                }
            }
        }
        return trees;
    }

}

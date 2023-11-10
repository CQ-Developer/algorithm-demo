package io.huhu.leetcode.back.trace.n95;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees-ii/">95.不同的二叉搜索树II</a>
 * 给你一个整数n, 请你生成并返回所有由n个节点组成且节点值从1到n互不相同的不同二叉搜索树, 可以按任意顺序返回答案.
 */
class Solution {

    /**
     * 1 <= n <= 8
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        backTrace(n, 0, new boolean[n], null, new HashSet<>(), result);
        return result;
    }

    /**
     * 回溯算法
     * todo 改为值转递而不是引用传递, 那么就不用复制树, 也不用对树节点进行回溯
     */
    private void backTrace(int n, int cnt, boolean[] used,
            TreeNode root, Set<List<Integer>> set, List<TreeNode> result) {
        if (cnt == n && canAdd(root, set)) {
            result.add(cloneTree(root));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            var node = new TreeNode(i + 1);
            used[i] = true;
            if (root == null) {
                backTrace(n, cnt + 1, used, node, set, result);
            } else {
                attachTree(root, node);
                backTrace(n, cnt + 1, used, root, set, result);
                detachTree(root, node);
            }
            used[i] = false;
        }
    }

    /**
     * 利用Set进行去重
     */
    private boolean canAdd(TreeNode root, Set<List<Integer>> set) {
        List<Integer> list = new ArrayList<>();
        copyToList(root, list);
        return set.add(list);
    }

    /**
     * 通过二叉树的前序遍历将树转成列表
     */
    private void copyToList(TreeNode node, List<Integer> list) {
        if (node == null) {
            list.add(null);
        } else {
            list.add(node.val);
            copyToList(node.left, list);
            copyToList(node.right, list);
        }
    }

    /**
     * 将节点加入到树的正确位置
     */
    private void attachTree(TreeNode pre, TreeNode node) {
        if (node.val < pre.val) {
            if (pre.left == null) {
                pre.left = node;
            } else {
                attachTree(pre.left, node);
            }
        } else {
            if (pre.right == null) {
                pre.right = node;
            } else {
                attachTree(pre.right, node);
            }
        }
    }

    /**
     * 将节点从树中删除
     */
    private void detachTree(TreeNode pre, TreeNode node) {
        if (node.val < pre.val) {
            if (pre.left != null) {
                if (pre.left.val == node.val) {
                    pre.left = null;
                } else {
                    detachTree(pre.left, node);
                }
            }
        } else {
            if (pre.right != null) {
                if (pre.right.val == node.val) {
                    pre.right = null;
                } else {
                    detachTree(pre.right, node);
                }
            }
        }
    }

    /**
     * 解决引用传递问题
     */
    private TreeNode cloneTree(TreeNode root) {
        var node = new TreeNode(root.val);
        if (root.left != null) {
            node.left = cloneTree(root.left);
        }
        if (root.right != null) {
            node.right = cloneTree(root.right);
        }
        return node;
    }

}

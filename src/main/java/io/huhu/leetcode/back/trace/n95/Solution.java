package io.huhu.leetcode.back.trace.n95;

import java.util.ArrayList;
import java.util.List;

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
        backTrace(n, 0, new boolean[n], null, result);
        return result;
    }

    /**
     * 回溯算法
     */
    private void backTrace(int n, int cnt, boolean[] used, TreeNode root, List<TreeNode> result) {
        if (cnt == n) {
            if (result.isEmpty() || !isSame(result, root)) {
                result.add(cloneTree(root));
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            var node = new TreeNode(i + 1);
            used[i] = true;
            if (root == null) {
                backTrace(n, cnt + 1, used, node, result);
            } else {
                attachTree(root, node);
                backTrace(n, cnt + 1, used, root, result);
                detachTree(root, node);
            }
            used[i] = false;
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
     * 解决重复问题
     */
    private boolean isSame(List<TreeNode> result, TreeNode node2) {
        for (TreeNode node1 : result) {
            if (isSame(node1, node2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解决重复问题
     */
    private boolean isSame(TreeNode node1, TreeNode node2) {
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

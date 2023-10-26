package io.huhu.leetcode.back.trace.n257;

import java.util.ArrayList;
import java.util.List;

/**
 * 257.二叉树的所有路径
 * <br/>
 * 给你一个二叉树的根节点root，按任意顺序，返回所有从根节点到叶子节点的路径
 * 叶子节点是指没有子节点的节点
 * <br/>
 * 树中节点的数组在范围[1,100]内
 * -100 <= Node.val <= 100
 */
class Solution {

    /**
     * 回溯：深度优先遍历
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        backTrace(root, "", result);
        return result;
    }

    private void backTrace(TreeNode root, String path, List<String> result) {
        if (root != null) {
            var builder = new StringBuilder(path);
            builder.append(root.val);
            if (root.left == null && root.right == null) {
                result.add(builder.toString());
            } else {
                path = builder.append("->").toString();
                backTrace(root.left, path, result);
                backTrace(root.right, path, result);
            }
        }
    }

}

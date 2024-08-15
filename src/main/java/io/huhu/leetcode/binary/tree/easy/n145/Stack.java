package io.huhu.leetcode.binary.tree.easy.n145;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Stack implements Solution {

    @Override
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            root = stack.removeFirst();
            ans.addFirst(root.val);
            if (root.left != null) {
                stack.addFirst(root.left);
            }
            if (root.right != null) {
                stack.addFirst(root.right);
            }
        }
        return ans;
    }

}

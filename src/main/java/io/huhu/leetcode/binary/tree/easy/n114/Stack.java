package io.huhu.leetcode.binary.tree.easy.n114;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Stack implements Solution {

    @Override
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.removeFirst();
            ans.add(cur.val);
            if (cur.right != null) {
                stack.addFirst(cur.right);
            }
            if (cur.left != null) {
                stack.addFirst(cur.left);
            }
        }
        return ans;
    }

}

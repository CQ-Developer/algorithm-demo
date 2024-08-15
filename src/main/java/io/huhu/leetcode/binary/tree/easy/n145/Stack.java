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
            TreeNode cur = stack.getFirst();
            if (cur.left != null && cur.left != root && cur.right != root) {
                stack.addFirst(cur.left);
            } else if (cur.right != null && cur.right != root) {
                stack.addFirst(cur.right);
            } else {
                ans.add(cur.val);
                root = stack.removeFirst();
            }
        }
        return ans;
    }

}

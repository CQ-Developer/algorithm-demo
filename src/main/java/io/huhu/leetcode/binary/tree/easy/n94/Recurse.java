package io.huhu.leetcode.binary.tree.easy.n94;

import java.util.ArrayList;
import java.util.List;

class Recurse implements Solution {

    @Override
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recurse(root, ans);
        return ans;
    }

    private void recurse(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        recurse(root.left, ans);
        ans.add(root.val);
        recurse(root.right, ans);
    }

}

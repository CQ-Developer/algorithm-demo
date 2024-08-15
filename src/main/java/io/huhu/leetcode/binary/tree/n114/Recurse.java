package io.huhu.leetcode.binary.tree.n114;

import java.util.ArrayList;
import java.util.List;

class Recurse implements Solution {

    @Override
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recurse(root, ans);
        return ans;
    }

    private void recurse(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        recurse(root.left, ans);
        recurse(root.right, ans);
    }

}

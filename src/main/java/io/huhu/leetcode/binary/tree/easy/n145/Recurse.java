package io.huhu.leetcode.binary.tree.easy.n145;

import java.util.ArrayList;
import java.util.List;

class Recurse implements Solution {

    @Override
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recurse(root, ans);
        return ans;
    }

    private void recurse(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        recurse(root.left, ans);
        recurse(root.right, ans);
        ans.add(root.val);
    }

}

package io.huhu.leetcode.n894;

import java.util.ArrayList;
import java.util.List;

class DivideAndConquer implements Code {

    @Override
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return List.of();
        }
        if (n == 1) {
            return List.of(new TreeNode(0));
        }
        List<TreeNode> ans = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> lefts = allPossibleFBT(i), rights = allPossibleFBT(n - 1 - i);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    ans.add(new TreeNode(0, left, right));
                }
            }
        }
        return ans;
    }

}

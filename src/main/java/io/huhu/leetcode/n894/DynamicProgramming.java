package io.huhu.leetcode.n894;

import java.util.ArrayList;
import java.util.List;

class DynamicProgramming implements Code {

    @Override
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return List.of();
        }
        List<List<TreeNode>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(1).add(new TreeNode(0));
        // 1 3 5 7 9 11 13 ...
        for (int i = 3; i <= n; i += 2) {
            for (int j = 1; j < i; j += 2) {
                // left + right
                for (TreeNode left : dp.get(j)) {
                    for (TreeNode right : dp.get(i - 1 - j)) {
                        dp.get(i).add(new TreeNode(0, left, right));
                    }
                }
            }
        }
        return dp.get(n);
    }

}

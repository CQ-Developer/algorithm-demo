package io.huhu.leetcode.dynamic.programming.hard.n2218;

import java.util.List;

class DFS implements Solution {

    @Override
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        return dfs(piles, k, 0);
    }

    /**
     * TLE
     */
    private int dfs(List<List<Integer>> piles, int k, int i) {
        if (k == 0 || i == piles.size()) {
            return 0;
        }
        int ans = dfs(piles, k, i + 1);
        if (!piles.get(i).isEmpty()) {
            int t = piles.get(i).removeFirst();
            ans = Integer.max(ans, dfs(piles, k - 1, i) + t);
            piles.get(i).addFirst(t);
        }
        return ans;
    }

}

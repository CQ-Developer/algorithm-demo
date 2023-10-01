package io.huhu.leetcode.n77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1>
 * 77.组合
 * </h1>
 *
 * <p>
 * 给定两个整数n和k，返回范围[1,n]中所有可能的k个数的组合。
 * <br/>
 * 你可以按任何顺序返回答案。
 * </p>
 *
 * <p>
 * 示例一：
 * <br/>
 * 输入：n=4, k=2
 * <br/>
 * 输出：[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 * </p>
 *
 * <p>
 * 示例二：
 * <br/>
 * 输入：n=1, k=1
 * <br/>
 * 输出：[[1]]
 * </p>
 *
 * <p>
 * 提示：
 * <br/>
 * 1 <= n <= 20
 * <br/>
 * 1 <= k <= n
 * </p>
 */
class Solution {

    /**
     * 回溯算法，在一棵树上的深度优先遍历
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(n, k, 1, new ArrayDeque<>(), result);
        System.out.println(result);
        return result;
    }

    private void dfs(int n, int k, int i, Deque<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
        } else {
            for (int j = i; j <= n - (k - path.size()) + 1; j++) {
                path.addLast(j);
                dfs(n, k, j + 1, path, result);
                path.removeLast();
            }
        }
    }

}

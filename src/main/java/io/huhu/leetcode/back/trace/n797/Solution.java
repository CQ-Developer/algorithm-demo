package io.huhu.leetcode.back.trace.n797;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/all-paths-from-source-to-target/description/">797.所有可能的路径</a>
 * 给你一个有n个节点的有向无环图, 请你找出所有从节点0到节点n-1的路径并输出(不要求按特定顺序)
 * graph[i]是一个从节点i可以访问的所有节点的列表(即从节点i到节点graph[i][j]存在一条有向边)
 */
class Solution {

    /**
     * n == graph.length
     * 2 <= n <= 15
     * 0 <= graph[i][j] < n
     * graph[i][j] != i (即不存在自环)
     * graph[i] 中的所有元素互不相同
     * 保证输入为有向无环图
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        path.addLast(0);
        dfs(graph, 0, path, result);
        return result;
    }

    /**
     * 回溯算法
     */
    private void dfs(int[][] graph, int i, Deque<Integer> path, List<List<Integer>> result) {
        if (path.getLast() == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < graph[i].length; j++) {
            path.addLast(graph[i][j]);
            dfs(graph, graph[i][j], path, result);
            path.removeLast();
        }
    }

}

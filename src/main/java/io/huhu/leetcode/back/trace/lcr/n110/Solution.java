package io.huhu.leetcode.back.trace.lcr.n110;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/bP4bmD/description/">所有可能的路径</a>
 * <p>给定一个有n个节点的有向无环图, 用二维数组graph表示, 请找到所有从0到n-1的路径并输出(不要求按顺序)
 * <p>graph的第i个数组中的单元都表示有向图中i号节点所能到达的下一个节点(译者注: 有向图是有方向的, 即规定了a->b你就不能从b->a),
 * 若为空, 就是没有下一个节点了
 * <p>提示:
 * <li>n == graph.length
 * <li>2 <= n <= 15
 * <li>0 <= graph[i][j] < n
 * <li>graph[i][j] != i
 * <li>保证输入为有向无环图(GAD)
 */
class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        backTracing(graph, 0, new ArrayDeque<>(), res);
        res.forEach(System.out::println);
        return res;
    }

    private void backTracing(int[][] graph, int j, Deque<Integer> path, List<List<Integer>> res) {
        if (j == graph.length - 1) {
            List<Integer> tmp = new ArrayList<>(path);
            tmp.add(j);
            res.add(tmp);
            return;
        }
        path.addLast(j);
        for (int i = 0; i < graph[j].length; i++) {
            backTracing(graph, graph[j][i], path, res);
        }
        path.removeLast();
    }

}

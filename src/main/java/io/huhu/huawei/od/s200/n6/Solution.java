package io.huhu.huawei.od.s200.n6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] edges = new int[n][2];
        for (int i = 0; i < n; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }
        String res = doSolution(n, edges);
        System.out.println(res);
    }

    public static String doSolution(int n, int[][] edges) {
        Set<Integer> nodes = new HashSet<>();
        // 出入规则
        Set<Integer> in = new HashSet<>();
        Set<Integer> out = new HashSet<>();
        for (int[] edge : edges) {
            in.add(edge[1]);
            out.add(edge[0]);
            nodes.add(edge[0]);
            nodes.add(edge[1]);
        }
        // 检测是否有环
        if (hasCycle(nodes, edges)) {
            return "-1";
        }
        // 找到首尾节点
        StringBuilder sb = new StringBuilder();
        for (int node : nodes) {
            if (!in.contains(node)) {
                sb.append(node);
            }
            if (!out.contains(node)) {
                sb.append(" ").append(node);
            }
        }
        return sb.toString();
    }

    private static boolean hasCycle(Set<Integer> nodes, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] g : edges) {
            List<Integer> neighbors = graph.getOrDefault(g[0], new ArrayList<>());
            neighbors.add(g[1]);
            graph.put(g[0], neighbors);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> stack = new HashSet<>();
        for (int node : nodes) {
            if (detectCycle(graph, node, visited, stack)) {
                return true;
            }
        }
        return false;
    }

    /**
     * dfs + back trace
     */
    private static boolean detectCycle(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited, Set<Integer> stack) {
        // 在本轮递归中, 能访问到之前的节点, 说明存在环
        // 这里的dfs是从当前节点的邻居节点开始, 所以可以理解为从邻居节点回到当前节点
        if (stack.contains(node)) {
            return true;
        }
        // 节点之前已经被访问过, 那么再次访问到该节点, 也不可能形成环
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        // change status
        stack.add(node);
        // dfs
        List<Integer> neighbors = graph.get(node);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (detectCycle(graph, neighbor, visited, stack)) {
                    return true;
                }
            }
        }
        // rollback status
        stack.remove(node);
        return false;
    }

}

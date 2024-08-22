package io.huhu.leetcode.graph.n210;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/course-schedule-ii/description/">
 * Course Schedule II
 * </a>
 */
class Solution {

    public int[] findOrder(int numCourses, int[][] prerequistites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegress = new int[numCourses];
        for (int[] edge : prerequistites) {
            graph.get(edge[1]).add(edge[0]);
            indegress[edge[0]]++;
        }
        int l = 0, r = 0;
        int[] queue = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (indegress[i] == 0) {
                queue[r++] = i;
            }
        }
        int cnt = 0;
        while (l < r) {
            int cur = queue[l++];
            cnt++;
            for (int next : graph.get(cur)) {
                if (--indegress[next] == 0) {
                    queue[r++] = next;
                }
            }
        }
        return cnt == numCourses ? queue : new int[0];
    }

}

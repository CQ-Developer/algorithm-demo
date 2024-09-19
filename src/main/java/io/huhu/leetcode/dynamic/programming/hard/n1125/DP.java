package io.huhu.leetcode.dynamic.programming.hard.n1125;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DP implements Solution {

    @Override
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int m = req_skills.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(req_skills[i], i);
        }
        int n = people.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            for (String skill : people.get(i)) {
                if (map.containsKey(skill)) {
                    arr[i] |= 1 << map.get(skill);
                }
            }
        }
        int[][] dp = new int[n][1 << m];
        for (var a : dp) {
            Arrays.fill(a, -1);
        }
        int len = f(m, arr, 0, 0, dp);
        int[] ans = new int[len];
        for (int i = 0, j = 0, s = 0; s != (1 << m) - 1; i++) {
            if (i + 1 == n || dp[i][s] != dp[i + 1][s]) {
                ans[j++] = i;
                s |= arr[i];
            }
        }
        return ans;
    }

    private int f(int n, int[] people, int i, int status, int[][] dp) {
        if (status == (1 << n) - 1) {
            return 0;
        }
        if (i == people.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][status] != -1) {
            return dp[i][status];
        }
        int a = f(n, people, i + 1, status, dp);
        int b = Integer.MAX_VALUE;
        int next = f(n, people, i + 1, status | people[i], dp);
        if (next != Integer.MAX_VALUE) {
            b = next + 1;
        }
        return dp[i][status] = Math.min(a, b);
    }

}

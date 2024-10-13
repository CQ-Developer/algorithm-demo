package io.huhu.leetcode.greedy.n1029;

import java.util.Arrays;

class Greedy implements Code {

    @Override
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            sum += costs[i][0];
            arr[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(arr);
        int m = n >> 1;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        return sum;
    }

}

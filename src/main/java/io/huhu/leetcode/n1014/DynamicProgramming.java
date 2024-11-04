package io.huhu.leetcode.n1014;

class DynamicProgramming implements Code {

    @Override
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, max = values[0];
        for (int j = 1; j < values.length; j++) {
            ans = Math.max(ans, max + values[j] - j);
            max = Math.max(max, values[j] + j);
        }
        return ans;
    }

}

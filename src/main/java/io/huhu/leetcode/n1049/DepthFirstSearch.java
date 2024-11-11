package io.huhu.leetcode.n1049;

class DepthFirstSearch implements Code {

    @Override
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int weight = f(stones, sum >> 1, 0, 0);
        return sum - weight - weight;
    }

    private int f(int[] stones, int weight, int i, int w) {
        if (i == stones.length) {
            return w;
        }
        int ans = f(stones, weight, i + 1, w);
        if (w + stones[i] <= weight) {
            ans = Math.max(ans, f(stones, weight, i + 1, w + stones[i]));
        }
        return ans;
    }

}

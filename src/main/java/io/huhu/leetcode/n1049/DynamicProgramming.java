package io.huhu.leetcode.n1049;

class DynamicProgramming implements Code {

    @Override
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int n = sum >> 1;
        int[] f = new int[n + 1];
        for (int stone : stones) {
            for (int i = n; i >= 0; i--) {
                if (i - stone >= 0) {
                    f[i] = Math.max(f[i], f[i - stone] + stone);
                }
            }
        }
        return sum - (f[n] << 1);
    }

}

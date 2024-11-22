package io.huhu.leetcode.n1524;

class DynamicProgrammingBit implements Code {

    private static final int M = 1_000_000_007;

    @Override
    public int numOfSubarrays(int[] arr) {
        long ans = 0;
        /*
         * f[0]表示偶数前缀和的数量
         * f[1]表示奇数前缀和的数量
         */
        int[] f = {1, 0};
        for (int i = 0, sum = 0; i < arr.length; i++) {
            sum += arr[i];
            /*
             * 前缀和sum为偶数则和为偶数的子数组数量+1
             * 反之和为奇数的子数组数量+1
             */
            f[sum & 1]++;
            /*
             * [0...i]范围上前缀和sum为偶数
             * 假设存在位置j, j的位置为[0...j...i], [0...j]范围上的前缀和为奇数
             * 那么[j+1...i]范围上的前缀和为奇数: 奇数 + 奇数 = 偶数
             * 因此【0...i]范围上和为奇数的子数组数量就是奇数前缀和的数量f[1]
             *
             * [0...i]范围上前缀和sum为奇数
             * 假设存在位置j, j的位置为[0...j...i], [0...j]范围上的前缀和为偶数
             * 那么[j+1...i]范围上的前缀和为奇数: 偶数 + 奇数 = 奇数
             * 因此[0...i]范围上和为奇数的子数组数量就是偶数前缀和的数量f[0]
             *
             * 位运算可以帮助快速访问下标
             */
            ans += f[(sum & 1) ^ 1];
        }
        return (int) (ans % M);
    }

}

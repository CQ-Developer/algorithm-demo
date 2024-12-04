package io.huhu.leetcode.n1884;

import io.huhu.AC;

@AC
class Memoization implements Code {

    @Override
    public int twoEggDrop(int n) {
        return f(n, new int[n + 1]);
    }

    private int f(int n, int[] mem) {
        if (n == 0) {
            return 0;
        }
        if (mem[n] != 0) {
            return mem[n];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            /*
             * 假设在第i层抛下鸡蛋
             *
             * 1.鸡蛋没碎
             * 那么需要从1...i层每层进行尝试
             *
             * 2.鸡蛋碎了
             * 那么需要在余下的n-i层进行尝试并付出一个鸡蛋的代价
             *
             * 由于要确保一定能尝试出结果, 所以要取最大值
             */
            ans = Math.min(ans, Math.max(i, f(n - i, mem) + 1));
        }
        return mem[n] = ans;
    }

}

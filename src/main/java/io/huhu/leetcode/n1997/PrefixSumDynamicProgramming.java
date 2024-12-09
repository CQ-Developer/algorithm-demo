package io.huhu.leetcode.n1997;

/**
 * <a href="https://leetcode.cn/problems/first-day-where-you-have-been-in-all-the-rooms/solutions/979221/qian-zhui-he-you-hua-dp-by-endlesscheng-j10b/">
 * review
 * </a>
 */
class PrefixSumDynamicProgramming implements Code {

    private static final int M = 1_000_000_007;

    @Override
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        /*
         * f[i]表示首次走到第i号房间需要的天数.
         *
         * 那么从0好房间走到i+1号房间的转移为:
         *
         * 1.从0号房间走到i号房间需要f[i]天.
         * 2.回到next[i]号房间需要1天.
         * 3.从next[i]号房间再次走到i号房间需要f[i]-f[next[i]]天
         * 4.从i号房间走到i+1号房间需要1天.
         *
         * 综上所述:
         * f[i+1] = f[i] + 1 + f[i] - f[next[i]] + 1
         * f[i+1] = 2f[i] + 2 - f[next[i]]
         *
         * 放回第n号房间的达到天数f[n-1]
         */
        long[] f = new long[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = (((f[i] + 1) << 1) - f[nextVisit[i]] + M) % M;
        }
        return (int) f[n - 1];
    }

}

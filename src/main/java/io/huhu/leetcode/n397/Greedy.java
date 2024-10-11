package io.huhu.leetcode.n397;

class Greedy implements Code {

    @Override
    public int integerReplacement(int n) {
        long m = n;
        int ans = 0;
        while (m > 1) {
            if ((m & 1) == 0) {
                m >>= 1;
            } else {
                // 次低位是1加1可以消除连续一段的1
                // 3属于边界情况
                m += m != 3 && ((m >> 1) & 1) == 1 ? 1 : -1;
            }
            ans++;
        }
        return ans;
    }

}

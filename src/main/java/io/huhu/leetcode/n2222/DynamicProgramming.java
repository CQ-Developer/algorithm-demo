package io.huhu.leetcode.n2222;

class DynamicProgramming implements Solution {

    @Override
    public long numberOfWays(String s) {
        long res = 0;
        long n0 = 0, n1 = 0;
        long n10 = 0, n01 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                // 1的数量
                n1++;
                // 当前是1
                // 统计01的数量, 要形成01, 要加上前面0的数量
                n01 += n0;
                // 当前是1
                // 加上之前的10, 形成101
                res += n10;
            } else {
                // 0的数量
                n0++;
                // 当前是0
                // 统计10的数量, 要形成10, 要加上前面1的数量
                n10 += n1;
                // 当前是0
                // 加上之前的01, 形成010
                res += n01;
            }
        }
        return res;
    }

}

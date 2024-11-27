package io.huhu.leetcode.n1653;

class DynamicProgramming implements Code {

    /**
     * f[i]表示0...i范围上使字符串平衡需要删除的最少删除次数
     * 1. 如果当前字符是'b', 那么不需要删除
     * f[i] = f[i-1]
     * 2. 如果当前字符是'a', 那么:
     * 删除'a'使得字符串平衡, 删除'a'前面的所有'b'使得字符串平衡
     * f[i] = min(f[i-1] + 1, b)
     */
    @Override
    public int minimumDeletions(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] f = new int[n + 1];
        for (int i = 0, b = 0; i < n; i++) {
            if (c[i] == 'b') {
                f[i + 1] = f[i];
                b++;
            } else {
                f[i + 1] = Math.min(b, f[i] + 1);
            }
        }
        return f[n];
    }

}

package io.huhu.other;

/**
 * 删除至少几个字符可以变成另一个字符串的子串?
 * 给定两个字符串s1和s2
 * 返回s1至少删除多少字符串可以变成s2的子串
 * 对数器验证
 */
class Code01 {

    public int code(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int m = c1.length, n = c2.length;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            f[i][0] = i;
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = f[i - 1][j] + 1;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= n; j++) {
            ans = Math.min(ans, f[m][j]);
        }
        return ans;
    }

}

package io.huhu.leetcode.bit.manipulation.easy.n67;

/**
 * <a href="https://leetcode.cn/problems/add-binary/description/">二进制求和</a>
 */
class Solution {

    public String addBinary(String a, String b) {
        char[] res = new char[Math.max(a.length(), b.length()) + 1];
        int k = res.length - 1, i = a.length() - 1, j = b.length() - 1, tmp = 0;
        while (i >= 0 || j >= 0) {
            char ac = i >= 0 ? a.charAt(i--) : '0', bc = j >= 0 ? b.charAt(j--) : '0';
            char tc;
            if (ac == '0' && bc == '0') {
                tc = tmp == 1 ? '1' : '0';
                tmp = 0;
            } else if (ac == '1' && bc == '1') {
                tc = tmp == 1 ? '1' : '0';
                tmp = 1;
            } else {
                tc = tmp == 1 ? '0' : '1';
            }
            res[k--] = tc;
        }
        if (tmp == 1) {
            res[k] = '1';
            return String.valueOf(res);
        }
        return String.valueOf(res, 1, res.length - 1);
    }

}

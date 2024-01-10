package io.huhu.leetcode.bit.manipulation.easy.lcr.n002;

/**
 * <a href="https://leetcode.cn/problems/JFETK5/description/">二进制求和</a>
 */
class Solution {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, p = 0;
        while (i >= 0 || j >= 0) {
            p += i >= 0 ? a.charAt(i--) - '0' : 0;
            p += j >= 0 ? b.charAt(j--) - '0' : 0;
            sb.append(p % 2);
            p /= 2;
        }
        if (p == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

}

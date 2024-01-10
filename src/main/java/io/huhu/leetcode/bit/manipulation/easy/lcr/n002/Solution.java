package io.huhu.leetcode.bit.manipulation.easy.lcr.n002;

/**
 * <a href="https://leetcode.cn/problems/JFETK5/description/">二进制求和</a>
 */
class Solution {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, p = 0;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            if (x == 1 && y == 1) {
                sb.append(p);
                p = 1;
            } else if (x == 0 && y == 0) {
                sb.append(p);
                p = 0;
            } else {
                sb.append(p ^ 1);
            }
            i--;
            j--;
        }
        if (p == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

}

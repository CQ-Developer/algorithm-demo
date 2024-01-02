package io.huhu.leetcode.bit.manipulation.easy.n67;

/**
 * <a href="https://leetcode.cn/problems/add-binary/description/">二进制求和</a>
 */
class Solution {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, tmp = 0;
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
            sb.append(tc);
        }
        if (tmp == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

}

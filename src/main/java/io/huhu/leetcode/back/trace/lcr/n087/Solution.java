package io.huhu.leetcode.back.trace.lcr.n087;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/0on3uN/description/">复原IP地址</a>
 * <p>给定一个只包含数字的字符串s, 用以表示一个IP地址, 返回所有可能从s获得的有效IP地址. 你可以按任意顺序返回答案.
 * <p>有效IP地址正好有四个整数(每个整数位于0到255之间组成, 且不能含有前导0), 整数之间用'.'分隔.
 * <p>例如: "0.1.2.201"和"192.168.1.1"是有效IP地址, 但是"0.011.255.245"、"192.168.1.312"和"192.168@1.1"是无效IP地址.
 * <p>提示:
 * <li>0 <= s.length <= 3000
 * <li>s仅由数字组成
 */
class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backTracing(s.toCharArray(), 0, new int[4], 0, res);
        return res;
    }

    private void backTracing(char[] s, int j, int[] path, int k, List<String> res) {
        if (k == 4) {
            if (j == s.length) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < k; i++) {
                    sb.append(path[i]);
                    if (i != k - 1) {
                        sb.append('.');
                    }
                }
                res.add(sb.toString());
            }
            return;
        }
        if (k > 4 || j == s.length) {
            return;
        }
        if (s[j] == '0') {
            backTracing(s, j + 1, path, k + 1, res);
            return;
        }
        int part = 0;
        for (int i = j; i < s.length; i++) {
            part = 10 * part + s[i] - '0';
            if (part > 255) {
                break;
            }
            path[k] = part;
            backTracing(s, i + 1, path, k + 1, res);
            path[k] = 0;
        }
    }

}

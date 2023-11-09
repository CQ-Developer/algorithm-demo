package io.huhu.leetcode.back.trace.n93;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/restore-ip-addresses/">93.复原IP地址</a>
 * 有效IP地址正好有四个整数(每个整数位于0~255之间, 且不能含有前导0), 整数之间用'.'分割
 * 例如: "0.1.2.201"和"192.168.1.1"是有效IP地址, 但是"0.011.255.245"、"192.168.1.312"和"192.168@1.1"是无效IP地址
 * 给定一个只包含数字的字符串s, 用以表示一个IP地址, 返回所有可能的有效IP地址, 这些地址可以通过在s中插入'.'来形成
 * 你不能重新排序或删除s中的任何数字, 你可以按任何顺序返回答案
 */
class Solution {

    /**
     * 1 <= s.length <= 20
     * s仅由数字组成
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        backTrace(s, 0, new ArrayDeque<>(), result);
        return result;
    }

    /**
     * 回溯算法
     */
    private void backTrace(String s, int i, Deque<String> path, List<String> result) {
        if (path.size() == 4) {
            result.add(String.join(".", path));
            return;
        }
        for (int j = 1; j <= 3; j++) {
            if (i + j > s.length()) {
                return;
            }
            boolean isLast = path.size() == 3;
            var ip = isLast ? s.substring(i) : s.substring(i, i + j);
            if (ip.length() == 3 && ip.compareTo("255") > 0) {
                continue;
            }
            if (ip.length() > 1 && ip.charAt(0) == '0') {
                continue;
            }
            int len = s.length() - i - ip.length();
            int seg = 4 - path.size() - 1;
            if (len < seg || len > seg * 3) {
                continue;
            }
            path.addLast(ip);
            backTrace(s, i + ip.length(), path, result);
            path.removeLast();
            if (isLast) {
                return;
            }
        }
    }

}

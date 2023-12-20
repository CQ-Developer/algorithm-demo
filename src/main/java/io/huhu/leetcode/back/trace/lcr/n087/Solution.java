package io.huhu.leetcode.back.trace.lcr.n087;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
        backTracing(s.toCharArray(), 0, new ArrayDeque<>(), res);
        res.forEach(System.out::println);
        return res;
    }

    private void backTracing(char[] s, int j, Deque<String> path, List<String> res) {
        if (path.size() == 4) {
            if (j == s.length) {
                res.add(String.join(".", path));
            }
            return;
        }
        int part = 0;
        for (int i = j; i < s.length; i++) {
            if (i == j && s[i] == '0') {
                path.addLast("0");
                backTracing(s, i + 1, path, res);
                path.removeLast();
                break;
            }
            part = 10 * part + s[i] - '0';
            if (part > 255) {
                break;
            }
            if (path.size() == 3 && i != s.length - 1) {
                continue;
            }
            path.addLast(String.valueOf(part));
            backTracing(s, i + 1, path, res);
            path.removeLast();
        }
    }

}

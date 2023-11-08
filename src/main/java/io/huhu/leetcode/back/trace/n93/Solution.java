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
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backTrace(s, 0, new ArrayDeque<>(), result);
        System.out.println(result);
        return result;
    }

    // todo 考虑剪枝、补全回溯图
    private void backTrace(String s, int i, Deque<String> path, List<String> result) {
        if (i == s.length() && path.size() == 4) {
            result.add(String.join(".", path));
            return;
        }
        if (path.size() > 4) {
            return;
        }
        for (int j = 1; j <= 3; j++) {
            if (i + j > s.length()) {
                return;
            }
            var ip = s.substring(i, i + j);
            if (j > 1 && ip.startsWith("0")) {
                continue;
            }
            if (Integer.parseInt(ip) > 255) {
                continue;
            }
            path.addLast(ip);
            backTrace(s, i + j, path, result);
            path.removeLast();
        }
    }

    // private void backTrace(String s, int i, Deque<String> path, int len, List<String> result) {
    //     if (path.size() == 4) {
    //         result.add(String.join(".", path));
    //         return;
    //     }
    //     int rest = s.length() - len;
    //     int min = 4 - path.size();
    //     int max = 3 * min;
    //     // 如果剩余字符串长度不够组成一个边界
    //     if (rest < min || rest > max) {
    //         return;
    //     }
    //     // 如果剩字符串长度正好在剩余段的边界上
    //     int x = rest == min ? 1 : rest == max ? 3 : 0;
    //     if (x != 0) {
    //         for (int j = 0; j < 4; j++) {
    //             String a = s.substring(i + x, i * x + x);
    //         }
    //     }
    // }

}

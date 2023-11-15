package io.huhu.leetcode.back.n306;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/additive-number/">306.累加和</a>
 * 累加数是一个字符串, 组成它的数字可以形成累加序列.
 * 一个有效的累加序列必须至少包含3个数字. 除了最开始的两个数字以外, 序列中的每个后续数字必须是它之前两个数字之和.
 * 给你一个只包含数字0~9的字符串, 编写一个算法来判断给定输入是否是累加数. 如果是, 返回true; 否则, 返回false.
 * 说明: 累加序列里的数字, 除数字0之外, 不会以0开头, 所以不会出现1,2,03或者1,02,3的情况.
 */
class Solution {

    /**
     * 1 <= num.length <= 35
     * num仅由数字0~9组成
     */
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        if (num.startsWith("0")) {
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) != '0') {
                    return false;
                }
            }
            return true;
        }
        boolean[] result = {false};
        backTrace(num, 0, new ArrayList<>(), result);
        return result[0];
    }

    /**
     * 回溯算法
     * todo 算法错误
     */
    private void backTrace(String num, int i, List<Integer> path, boolean[] result) {
        if (i == num.length() && path.size() == 3) {
            result[0] = true;
            return;
        }
        for (int j = i; j < num.length(); j++) {
            if (result[0]) {
                return;
            }
            int n = Integer.parseInt(num, i, j + 1, 10);
            if (n == 0) {
                return;
            }
            if (path.size() == 2) {
                int sum = path.get(0) + path.get(1);
                if (sum > n) {
                    continue;
                } else if (sum < n) {
                    return;
                }
                path.remove(0);
            }
            path.add(n);
            backTrace(num, j + 1, path, result);
            if (!path.isEmpty()) {
                path.remove(path.size() - 1);
            }
        }
    }

}

package io.huhu.leetcode.back.trace.n301;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/remove-invalid-parentheses/description/">删除无效的括号</a>
 * <p>给你一个由若干括号和字母组成的字符串s, 删除最小数量的无效括号, 使得输入的字符串有效.
 * <p>返回所有可能的结果. 答案可以按任意顺序返回.
 * <p>提示:
 * <ul>
 * <li>1 <= s.length <= 25
 * <li>s 由小写英文字母以及括号 '(' 和 ')' 组成
 * <li>s 中至多含20个括号
 * </ul>
 */
class Solution {

    /**
     * 入口
     */
    public List<String> removeInvalidParentheses(String s) {
        // 计算出需要删除的左括号和右括号的数量
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        // 回溯
        List<String> res = new ArrayList<>();
        dfs(new StringBuilder(s), 0, l, r, res);
        return res;
    }

    /**
     * 深度优先遍历 + 回溯
     *
     * @param s   字符串
     * @param j   遍历的起始位置
     * @param l   左括号剩余数量
     * @param r   右括号剩余数量
     * @param res 结果
     */
    private void dfs(StringBuilder s, int j, int l, int r, List<String> res) {
        if (l == 0 && r == 0) {
            if (check(s)) {
                res.add(s.toString());
            }
            return;
        }
        for (int i = j; i < s.length(); i++) {
            // 重复的字符访问以此即可
            if (i > j && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            // 剩余字符不够
            if (l + r > s.length() - i) {
                return;
            }
            // 尝试删除左括号
            if (l > 0 && s.charAt(i) == '(') {
                s.deleteCharAt(i);
                dfs(s, i, l - 1, r, res);
                s.insert(i, '(');
            }
            // 删除右括号
            if (r > 0 && s.charAt(i) == ')') {
                s.deleteCharAt(i);
                dfs(s, i, l, r - 1, res);
                s.insert(i, ')');
            }
        }
    }

    /**
     * 检查字符串是否合法
     */
    private boolean check(CharSequence s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }

}

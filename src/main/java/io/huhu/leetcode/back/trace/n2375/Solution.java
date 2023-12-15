package io.huhu.leetcode.back.trace.n2375;

/**
 * <a href="https://leetcode.cn/problems/construct-smallest-number-from-di-string/description/">根据模式串构造最小数字</a>
 * <p>给你下标从0开始、长度为n的字符串pattern, 它包含两种字符, 'I'表示上升, 'D'表示下降.
 * <p>你需要构造一个下标从0开始长度为n+1的字符串, 且它要满足以下条件:
 * <ul>
 * <li>num包含数字'1'到'9', 其中每个数字至多使用一次
 * <li>如果pattern[i] == 'I', 那么num[i] < num[i + 1]
 * <li>如果pattern[i] == 'D', 那么num[i] > num[i + 1]
 * </ul>
 * <p>请你返回满足上述条件字典序最小的字符串num.
 */
class Solution {

    private String res;
    private char[] pattern;
    private final boolean[] used = new boolean[10];

    /**
     * 提示:
     * <ul>
     * <li>1 <= pattern.length <= 8
     * <li>pattern只包含字符'I'和'D'
     * </ul>
     */
    public String smallestNumber(String pattern) {
        this.pattern = pattern.toCharArray();
        for (int i = 1; i < 10 && res == null; i++) {
            used[i] = true;
            dfs(0, used, new StringBuilder().append(i));
            used[i] = false;
        }
        return res;
    }

    /**
     * 深度有优先遍历 + 回溯
     */
    private void dfs(int i, boolean[] used, StringBuilder sb) {
        if (sb.length() == pattern.length + 1) {
            res = sb.toString();
            return;
        }
        for (int k = 1; k < used.length && res == null; k++) {
            if (used[k]) {
                continue;
            }
            int pre = sb.charAt(sb.length() - 1) - '0';
            if (pattern[i] == 'I' && k <= pre) {
                continue;
            }
            if (pattern[i] == 'D' && k >= pre) {
                break;
            }
            used[k] = true;
            sb.append(k);
            dfs(i + 1, used, sb);
            used[k] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

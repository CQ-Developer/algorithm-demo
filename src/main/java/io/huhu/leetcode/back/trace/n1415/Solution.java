package io.huhu.leetcode.back.trace.n1415;

/**
 * <p><a href="https://leetcode.cn/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/">1415.长度为n的开心字符串中字典顺序第k小的字符串</a>
 * <p>一个开心字符串定义为:
 * <ul>
 * <li>仅包含小写字母['a', 'b', 'c']
 * <li>对所有在1到s.length-1之间的i, 满足s[i]!=s[i+1]
 * </ul>
 * <p>比方说, 字符串"abc", "ac", "b"和"abcbabcbcbc"都是开心字符串, 但"aa", "baa"和"ababbc"都不是开心字符串
 * <p>给你两个整数n和k, 你需要将长度为n的所有开心字符串按字典顺序排序
 * <p>请你返回排序后的第k个开心字符串, 如果长度为n的开心字符串少于k个, 那么请你返回空字符串
 */
class Solution {

    private static final char[] CHARS = {'a', 'b', 'c'};

    private int k;

    /**
     * 1 <= n <= 10
     * 1 <= k <= 100
     */
    public String getHappyString(int n, int k) {
        this.k = k;
        StringBuilder sb = new StringBuilder();
        dfs(n, sb);
        return sb.toString();
    }

    private void dfs(int n, StringBuilder sb) {
        if (n == 0) {
            k--;
            return;
        }
        for (int i = 0; i < 3 && k > 0; i++) {
            if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == CHARS[i]) {
                continue;
            }
            sb.append(CHARS[i]);
            dfs(n - 1, sb);
            if (k == 0) {
                break;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

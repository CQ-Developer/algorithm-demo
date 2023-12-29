package io.huhu.leetcode.back.trace.n691;

/**
 * <a href="https://leetcode.cn/problems/stickers-to-spell-word/description/">
 * 贴纸拼词
 * </a>
 * <p>
 * 我们有 n 中不同的贴纸. 每个贴纸上都有一个小写的英文单词.
 * </p>
 * <p>
 * 你想要拼写出给定的字符穿 target, 方法是从收集的贴纸中切割单个字母并重新排列它们.
 * 如果你愿意, 你可以多次使用每个贴纸, 每个贴纸的数量是无限的.
 * </p>
 * <p>
 * 返回你需要拼出 target 的最小贴纸数量. 如果任务不可能, 则返回 -1.
 * </p>
 * <p>
 * 注意: 在所有测试用例中, 所有的单词都是从 1000 个最常见的美国英语单词中随机选择的,
 * 并且 target 被选择为两个随机单词的连接.
 * </p>
 * <p>
 * 提示:
 * </p>
 * <ul>
 * <li>
 * n == stickers.length
 * </li>
 * <li>
 * 1 <= n <= 50
 * </li>
 * <li>
 * 1 <= stickers[i].length <= 10
 * </li>
 * <li>
 * 1 <= target.length <= 15
 * </li>
 * <li>
 * stickers[i] 和 target 由小写英文单词组成
 * </li>
 * </ul>
 */
class Solution {

    private int res = -1;

    public int minStickers(String[] stickers, String target) {
        int[] letters = new int[26];
        int i = 0;
        for (; i < target.length(); i++) {
            letters[target.charAt(i) - 'a']++;
        }
        dfs(stickers, 0, 0, letters, i);
        return res;
    }

    private void dfs(String[] stickers, int i, int cnt, int[] letters, int total) {
        if (total == 0) {
            res = res == -1 ? cnt : Math.min(res, cnt);
            return;
        }
        for (int j = i; j < stickers.length; j++) {
            int found = 0;
            int[] clone = letters.clone();
            char[] sticker = stickers[j].toCharArray();
            for (char c : sticker) {
                if (clone[c - 'a'] > 0) {
                    clone[c - 'a']--;
                    found++;
                }
            }
            dfs(stickers, found == 0 ? i + 1 : i, found == 0 ? cnt : cnt + 1, clone, total - found);
        }
    }

}

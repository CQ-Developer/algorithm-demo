package io.huhu.leetcode.back.trace.n1079;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/letter-tile-possibilities/description/">1079.活字印刷</a>
 * 你有一套活字字模tiles, 其中每个字模上都刻着一个字母tiles[i].
 * 返回你可以印出的飞控字母序列的数目.
 * 注意: 本题中, 每个活字字模只能使用一次.
 */
class Solution {

    /**
     * 1 <= tiles.length <= 7
     * tiles由大写英文字母组成
     */
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        int result = 0;
        for (int i = 1; i <= chars.length; i++) {
            result += dfs(chars, new boolean[chars.length], i);
        }
        return result;
    }

    /**
     * 回溯算法
     */
    private int dfs(char[] tiles, boolean[] used, int len) {
        if (len == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < tiles.length; i++) {
            // 剪枝: 上一层已经使用过当前字符
            if (used[i]) {
                continue;
            }
            // 剪枝: 上一层相同的字符没有使用, 当前也不使用
            if (i > 0 && tiles[i] == tiles[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            result += dfs(tiles, used, len - 1);
            used[i] = false;
        }
        return result;
    }

}

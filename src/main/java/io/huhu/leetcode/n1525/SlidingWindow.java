package io.huhu.leetcode.n1525;

import io.huhu.AC;

@AC
class SlidingWindow implements Code {

    @Override
    public int numSplits(String s) {
        char[] cs = s.toCharArray();
        // right window
        int rightCnt = 0;
        int[] rights = new int[26];
        for (char c : cs) {
            if (rights[c - 'a']++ == 0) {
                rightCnt++;
            }
        }
        int ans = 0;
        // calculate left window while sliding window
        int leftCnt = 0;
        int[] lefts = new int[26];
        for (char c : cs) {
            int i = c - 'a';
            if (lefts[i]++ == 0) {
                leftCnt++;
            }
            if (rights[i]-- == 1) {
                rightCnt--;
            }
            if (leftCnt == rightCnt) {
                ans++;
            }
        }
        return ans;
    }

}

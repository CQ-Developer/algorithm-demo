package io.huhu.leetcode.n792;

import java.util.HashSet;
import java.util.Set;

class StringSearch implements Code {

    @Override
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        Set<String> sub = new HashSet<>();
        Set<String> notSub = new HashSet<>();
        for (String word : words) {
            if (sub.contains(word)) {
                ans++;
                continue;
            }
            if (notSub.contains(word)) {
                continue;
            }
            if (isSub(s, word)) {
                sub.add(word);
                ans++;
            } else {
                notSub.add(word);
            }
        }
        return ans;
    }

    private boolean isSub(String s, String word) {
        int i = 0;
        for (char c : word.toCharArray()) {
            int j = s.indexOf(c, i);
            if (j < 0) {
                return false;
            }
            i = j + 1;
        }
        return true;
    }

}

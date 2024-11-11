package io.huhu.leetcode.n1048;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class DynamicProgramming implements Code {

    @Override
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> map = HashMap.newHashMap(words.length);
        int ans = 0;
        for (String word : words) {
            int max = 0;
            for (int i = 0; i < word.length(); i++) {
                String p = word.substring(0, i) + word.substring(i + 1);
                max = Math.max(max, map.getOrDefault(p, 0));
            }
            map.put(word, max + 1);
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }

}

package io.huhu.leetcode.n792;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BS implements Code {

    @Override
    public int numMatchingSubseq(String s, String[] words) {
        // 相同字符出现的位置严格递增
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        int ans = 0;
        for (String word : words) {
            int j = -1;
            boolean ok = true;
            for (int i = 0; i < word.length() && ok; i++) {
                List<Integer> list = map.getOrDefault(word.charAt(i), List.of());
                // 二分查找当前字符出现的最早位置
                int l = 0, r = list.size() - 1;
                while (l < r) {
                    int m = (l + r) / 2;
                    if (list.get(m) > j) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                // 没有找到或找到的更早的位置
                if (r < 0 || list.get(r) <= j) {
                    ok = false;
                } else {
                    j = list.get(r);
                }
            }
            if (ok) {
                ans++;
            }
        }
        return ans;
    }

}

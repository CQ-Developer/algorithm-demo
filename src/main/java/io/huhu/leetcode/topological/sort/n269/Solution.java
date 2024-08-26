package io.huhu.leetcode.topological.sort.n269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/alien-dictionary/description/">
 * Alien Dictionary
 * </a>
 */
class Solution {

    public String alienOrder(String[] words) {
        // indegress
        int[] indegress = new int[26];
        Arrays.fill(indegress, -1);
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                indegress[word.charAt(i) - 'a'] = 0;
            }
        }
        // graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        // init
        for (int i = 0; i + 1 < words.length; i++) {
            String cur = words[i], next = words[i + 1];
            int len = Math.min(cur.length(), next.length());
            int j = 0;
            for (; j < len; j++) {
                char f = cur.charAt(j), t = next.charAt(j);
                if (f != t) {
                    graph.get(f - 'a').add(t - 'a');
                    indegress[t - 'a']++;
                    break;
                }
            }
            if (j < cur.length() && j == next.length()) {
                return "";
            }
        }
        // topological sort
        int cnt = 0;
        int[] queue = new int[26];
        int l = 0, r = 0;
        for (int i = 0; i < 26; i++) {
            if (indegress[i] != -1) {
                cnt++;
            }
            if (indegress[i] == 0) {
                queue[r++] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (l < r) {
            int cur = queue[l++];
            sb.append((char) (cur + 'a'));
            for (int next : graph.get(cur)) {
                if (--indegress[next] == 0) {
                    queue[r++] = next;
                }
            }
        }
        return cnt == sb.length() ? sb.toString() : "";
    }

}

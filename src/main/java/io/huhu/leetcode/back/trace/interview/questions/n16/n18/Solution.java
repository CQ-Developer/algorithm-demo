package io.huhu.leetcode.back.trace.interview.questions.n16.n18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/pattern-matching-lcci/description/">模式匹配</a>
 * <p>你有两个字符串, 即pattern和value. pattern字符串由字母"a"和"b"组成, 用于描述字符串中的模式.
 * 例如, 字符串"catcatgocatgo"匹配模式"aabab"(其中"cat"是"a", "go"是"b"), 该字符串也匹配像"a"、"ab"和"b"这样的模式.
 * 但需注意"a"和"b"不能同时表示相同的字符串. 编写一个方法判断value字符串是否匹配pattern字符串.
 * <p>提示:
 * <li>1 <= len(pattern) <= 1000
 * <li>0 <= len(value) <= 1000
 * <li>你可以假设pattern只包含字母"a"和"b", value仅包含小写字母
 */
class Solution {

    public boolean patternMatching(String pattern, String value) {
        return backTracing(pattern, new HashSet<>(), value, new HashMap<>());
    }

    private boolean backTracing(String pattern, Set<String> used, String value, Map<Character, String> map) {
        if (pattern.isEmpty()) {
            return value.isEmpty();
        }
        char p = pattern.charAt(0);
        if (map.containsKey(p)) {
            String w = map.get(p);
            if (!value.startsWith(w)) {
                return false;
            }
            return backTracing(pattern.substring(1), used, value.substring(w.length()), map);
        }
        for (int i = 0; i <= value.length(); i++) {
            String w = value.substring(0, i);
            if (used.contains(w)) {
                continue;
            }
            used.add(w);
            map.put(p, w);
            if (backTracing(pattern.substring(1), used, value.substring(w.length()), map)) {
                return true;
            }
            used.remove(w);
            map.remove(p);
        }
        return false;
    }

}

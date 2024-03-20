package io.huhu.leetcode.dynamic.programming.medium.n22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/generate-parentheses/description/">括号生成</a>
 */
class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        res.add("()");
        // 使用HashSet缓存中间状态并去重
        Set<String> cache = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        // 执行 n -1 轮
        for (int i = 1; i < n; i++) {
            // 将上一轮所有字符串拿出来判断
            int size = res.size();
            while (size-- > 0) {
                sb.append(res.remove(0));
                // 找到出入位置
                for (int l = 0; l < sb.length(); l++) {
                    if (sb.charAt(l) == ')') {
                        continue;
                    }
                    // 注意l为左括号的情况下r一定不会溢出
                    int r = l + 1;
                    if (sb.charAt(r) != ')') {
                        continue;
                    }
                    // 在中间插入
                    sb.insert(r, "()");
                    cache.add(sb.toString());
                    sb.delete(r, r + 2);
                    // 在右边插入
                    sb.insert(r + 1, "()");
                    cache.add(sb.toString());
                    sb.delete(r + 1, r + 3);
                }
                // 重置StringBuilder
                sb.setLength(0);
            }
            // 保存结果并清空缓存
            res.addAll(cache);
            cache.clear();
        }
        return res;
    }

}

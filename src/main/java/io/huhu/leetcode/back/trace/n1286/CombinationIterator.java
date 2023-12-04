package io.huhu.leetcode.back.trace.n1286;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p><a href="https://leetcode.cn/problems/iterator-for-combination/description/">1286.字母组合迭代器</a>
 * <p>请你设计一个迭代器类CombinationIterator, 包括以下内容
 * <ul>
 * <li>CombinationIterator(String characters, int combinationLength)一个构造器函数,
 * 输入参数包括: 用一个有序且字符唯一的字符串characters和一个数字combinationLength
 * <li>函数next(), 按字典顺序返回长度为combinationLength的下一个字母组合
 * <li>函数hasNext(), 只有存在长度为combinationLength的下一个字母组合时, 才返回true
 * </ul>
 * <p>提示:
 * <ul>
 * <li>i <= combinationLength <= characters.length <= 15
 * <li>characters中每个字符都不同
 * <li>每组测试数据最多对next和hasNext调用10<sup>4</sup>次
 * <li>题目保证每次调用函数next时都存在下一个字母组合
 * </ul>
 */
class CombinationIterator {

    private final Iterator<String> iterator;

    public CombinationIterator(String characters, int combinationLength) {
        List<String> result = new ArrayList<>();
        dfs(characters, 0, combinationLength, new StringBuilder(), result);
        this.iterator = result.iterator();
    }

    public String next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    /**
     * 深度优先遍历
     */
    private void dfs(String s, int j, int len, StringBuilder sb, List<String> res) {
        if (sb.length() == len) {
            res.add(sb.toString());
            return;
        }
        for (int i = j; i < s.length() && i < s.length() + sb.length() - len + 1; i++) {
            sb.append(s.charAt(i));
            dfs(s, i + 1, len, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

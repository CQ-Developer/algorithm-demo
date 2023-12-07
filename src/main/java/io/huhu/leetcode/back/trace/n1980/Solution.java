package io.huhu.leetcode.back.trace.n1980;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-unique-binary-string/description/">找出不同的二进制字符串</a>
 * <p>给你一个字符串数组nums, 该数组由n个互不相同的二进制字符串组成, 且每个字符串长度都是n.
 * 请你找出并返回一个长度为n且没有出现在nums中的二进制字符串. 如果存在多种答案, 只需要返回任意一个即可.
 */
class Solution {

    /**
     * <ul>
     * <li>n == nums.length
     * <li>1 <= n <= 16
     * <li>nums[i].length == n
     * <li>nums[i]为'0'或'1'
     * <li>nums中所有字符串互不相同
     * </ul>
     */
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder("0".repeat(nums.length));
        dfs(Arrays.asList(nums), sb, 0);
        return sb.toString();
    }

    /**
     * 深度优先遍历 + 回溯算法
     */
    private boolean dfs(List<String> nums, StringBuilder sb, int j) {
        if (!nums.contains(sb.toString())) {
            return true;
        }
        for (int i = j; i < sb.length(); i++) {
            sb.setCharAt(i, '1');
            if (dfs(nums, sb, i + 1)) {
                return false;
            }
            sb.setCharAt(i, '0');
        }
        return true;
    }

}

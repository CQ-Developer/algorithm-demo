package io.huhu.leetcode.bit.manipulation.easy.n1356;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/sort-integers-by-the-number-of-1-bits/description/">根据数字二进制下1的数目排序</a>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= arr.length <= 500</li>
     * <li>0 <= arr[i] <= 10<sup>4</sup></li>
     * </ul>
     */
    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> table = new HashMap<>();
        for (int n : arr) {
            int cnt = countBit(n);
            List<Integer> list = table.getOrDefault(cnt, new ArrayList<>());
            list.add(n);
            table.put(cnt, list);
        }
        Arrays.sort(arr);
        int i = 0;
        for (int j = 0; j < 15; j++) {
            List<Integer> list = table.get(j);
            if (list == null) {
                continue;
            }
            for (int n : list) {
                arr[i++] = n;
            }
        }
        return arr;
    }

    private int countBit(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }

}

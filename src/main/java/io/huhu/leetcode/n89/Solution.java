package io.huhu.leetcode.n89;

import java.util.ArrayList;
import java.util.List;

/**
 * 89.格雷编码
 * <br/>
 * n位格雷码序列是一个由2<sup>n</sup>个整数组成的序列，其中：
 * <br/>
 * 1.每个整数都在范围[0, 2<sup>n</sup>-1]内(含0和2<sup>n</sup>-1)
 * <br/>
 * 2.第一个整数是0
 * <br/>
 * 3.一个整数在序列中出现不超过一次
 * <br/>
 * 4.每对相邻整数的二进制表示恰好一位不同，且
 * <br/>
 * 5.第一个和最后一个整数的二进制表示恰好一位不同
 * <br/>
 * 给你一个整数n，返回任一有效的n位格雷码序列
 */
class Solution {

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                System.out.println(list);
                list.add(head + list.get(j));
            }
            head *= 2;
        }
        System.out.println(list);
        return list;
    }

}

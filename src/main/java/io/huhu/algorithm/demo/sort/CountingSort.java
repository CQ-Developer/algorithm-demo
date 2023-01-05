package io.huhu.algorithm.demo.sort;

import java.util.Arrays;

/**
 * 计数排序算法
 * <p>
 * 时间复杂度O(n+k)
 * <p>
 * 技术排序只能给非负整数排序
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] a = {2, 5, 3, 0, 2, 3, 0, 3};
        countingSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    public static void countingSort(int[] a, int n) {
        // 数组长度为1不需要排序
        if (n <= 1) return;
        // 查找给定数组中的数据范围
        int max = a[0];
        for (int i = 0; i < n; i++) if (max < a[i]) max = a[i];
        // 创建一个计数用的数组
        // 下标范围[0, max]
        int[] c = new int[max + 1];
        for (int i = 0; i <= max; i++) c[i] = 0;
        // 计算每个元素的个数放入c中
        for (int i = 0; i < n; i++) c[a[i]]++;
        // 累加c中的元素
        for (int i = 1; i <= max; i++) c[i] += c[i - 1];
        // 数组r存放排序后的结果
        int[] r = new int[n];
        // 执行排序
        for (int i = n - 1; i >= 0; i--) {
            r[c[a[i]] - 1] = a[i];
            c[a[i]]--;
        }
        // 将排序结果压入原始数组
        System.arraycopy(r, 0, a, 0, n);
    }

}

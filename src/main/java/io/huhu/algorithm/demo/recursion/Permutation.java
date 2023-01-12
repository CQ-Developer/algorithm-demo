package io.huhu.algorithm.demo.recursion;

/**
 * 数组的全排序
 */
public class Permutation {

    public static void printPermutation(int[] a, int n, int k) {
        // k表示要处理的子数组的个数
        // k=1表示没有子数组需要处理了
        if (k == 1) {
            for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
            System.out.println();
        }
        for (int i = 0; i < k; i++) {
            int t = a[i];
            a[i] = a[k - 1];
            a[k - 1] = t;
            printPermutation(a, n, k - 1);
            t = a[i];
            a[i] = a[k - 1];
            a[k - 1] = t;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        printPermutation(a, 3, 3);
    }

}

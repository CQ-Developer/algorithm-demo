package io.huhu.huawei.od.s100.n2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * CPU算力分配
 */
class Solution {

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        int L1 = sc.nextInt();
        int L2 = sc.nextInt();
        int sumA = 0;
        int[] A = new int[L1];
        for (int i = 0; i < L1; i++) {
            sumA += A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int sumB = 0;
        int[] B = new int[L2];
        for (int i = 0; i < L2; i++) {
            sumB += B[i] = sc.nextInt();
        }
        Arrays.sort(B);
        // do
        int avg = (sumA + sumB) >> 1;
        int i = 0, j = 0;
        while (i < L1) {
            j = Arrays.binarySearch(B, sumB + A[i] - avg);
            if (j >= 0) {
                break;
            }
            i++;
        }
        // output
        System.out.println(A[i] + " " + B[j]);
    }

}

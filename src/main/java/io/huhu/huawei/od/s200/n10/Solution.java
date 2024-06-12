package io.huhu.huawei.od.s200.n10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://blog.csdn.net/shangyanaf/article/details/135139253">最多几个直角三角形</a>
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] nums = new int[N];
            for (int j = 0; j < N; j++) {
                nums[j] = scanner.nextInt();
            }
            int result = resolve(nums);
            System.out.println(result);
        }
    }

    public static int resolve(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] == 0) {
                    continue;
                }
                int k = Arrays.binarySearch(nums, j + 1, nums.length, nums[i] + nums[j]);
                if (k >= 0) {
                    ans++;
                    nums[i] = nums[j] = nums[k] = 0;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return ans;
    }

}

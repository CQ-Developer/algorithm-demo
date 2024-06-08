package io.huhu.huawei.od.s100.n6;

import java.util.*;

class Solution {

    /**
     * input:
     * 10
     * 1 2 1 2 1 2 1 2 1 2
     * 5
     *
     * output:
     * 2
     * 1
     * 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int t = sc.nextInt();
        Set<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int c = map.getOrDefault(num, 0);
            map.put(num, ++c);
            if (c >= t) {
                set.add(num);
            }
        }
        System.out.println(set.size());
        for (int i : set) {
            System.out.println(i);
        }
    }

}

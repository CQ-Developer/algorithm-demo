package io.huhu.huawei.od.s100.n9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 剩余银饰的重量
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> nums = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextInt());
        }
        nums.sort(Integer::compareTo);

        while (nums.size() >= 3) {
            int z = nums.removeLast();
            int y = nums.removeLast();
            int x = nums.removeLast();
            int rest = 0;
            if (x == y && y != z) {
                rest = y - z;
            }
            if (x != y && y == z) {
                rest = y - x;
            }
            if (x != y && y != z) {
                int a = Math.abs((z - y) - (y - x));
                if (a != 0) {
                    rest = a;
                }
            }
            if (rest != 0) {
                nums.add(rest);
                nums.sort(Integer::compareTo);
            }
        }

        if (nums.isEmpty()) {
            System.out.println(0);
        }
        if (nums.size() == 1) {
            System.out.println(nums.getFirst());
        }
        if (nums.size() == 2) {
            System.out.println(Math.max(nums.get(0), nums.get(1)));
        }

    }

}

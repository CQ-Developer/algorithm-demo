package io.huhu.leetcode.dynamic.programming.hard.n902;

class DFS implements Solution {

    @Override
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int tmp = n / 10, len = 1, offset = 1;
        while (tmp > 0) {
            tmp /= 10;
            offset *= 10;
            len++;
        }
        int[] nums = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            nums[i] = Integer.parseInt(digits[i]);
        }
        return f(nums, n, offset, len, 0, 0);
    }

    private int f(int[] digits, int num, int i, int n, int used, int free) {
        if (n == 0) {
            return used == 0 ? 0 : 1;
        }
        int ans = 0, cur = (num / i) % 10;
        if (used == 0) {
            ans += f(digits, num, i / 10, n - 1, 0, 1);
        }
        if (free == 0) {
            for (int digit : digits) {
                if (digit < cur) {
                    ans += f(digits, num, i / 10, n - 1, 1, 1);
                } else if (digit == cur) {
                    ans += f(digits, num, i / 10, n - 1, 1, 0);
                } else {
                    break;
                }
            }
        } else {
            ans += digits.length * f(digits, num, i/10, n-1,1,1); 
        }
        return ans;
    }

}

package io.huhu.leetcode.dynamic.programming.hard.n902;

class DFSWithTable implements Solution {

    @Override
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int m = digits.length;
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(digits[i]);
        }
        int tmp = n / 10, len = 1, mask = 1;
        while (tmp > 0) {
            tmp /= 10;
            mask *= 10;
            len++;
        }
        int ans = 0;
        int[] cnt = new int[len];
        cnt[0] = 1;
        for (int i = 1, pow = m; i < len; i++, pow *= m) {
            cnt[i] = pow;
            ans += pow;
        }
        return ans + f(nums, cnt, n, mask, len);
    }

    private int f(int[] digits, int[] cnt, int num, int mask, int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 0, cur = (num / mask) % 10;
        for (int digit:digits) {
            if (digit < cur) {
                ans += cnt[n - 1];
            } else if (digit == cur) {
                ans += f(digits, cnt, num, mask / 10, n - 1);
            } else {
                break;
            }
        }
        return ans;
    }

}

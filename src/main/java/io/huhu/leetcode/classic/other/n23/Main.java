package io.huhu.leetcode.classic.other.n23;

/**
 * 1-n取k个数字组成集合A, 余下数字组成集合B.
 * 要求集合A和集合B的累加和相差不超过1.
 * 返回任意一种可能的集合A, 否则返回空数组.
 * 2 <= n <= 10^6
 * 1 <= k <= n
 */
class Main {

    public int[] collection(int n, int k) {
        long sum = ((1 + n) * n) >> 1;
        int[] ans = compute(sum, n, k);
        if (ans.length == 0 && (sum & 1) == 1) {
            ans = compute((sum >> 1) + 1, n, k);
        }
        return ans;
    }

    private int[] compute(long sum, int n, int k) {
        long minKSum = ((1 + k) * k) >> 1;
        int range = n - k;
        if (sum < minKSum || sum > minKSum + (long) range * k) {
            return new int[0];
        }
        long need = sum - minKSum;
        int rightSize = (int) (need / range);
        int midIndex = (k - rightSize) + (int) (need % range);
        int leftSize = k - rightSize - (need % range == 0 ? 0 : 1);
        int[] ans = new int[k];
        for (int i = 0; i < leftSize; i++) {
            ans[i] = i + 1;
        }
        if (need % range == 0) {
            ans[leftSize] = midIndex;
        }
        for (int i = k - 1, j = 0; j < rightSize; i--, j++) {
            ans[i] = n - j;
        }
        return ans;
    }

}

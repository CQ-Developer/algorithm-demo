package io.huhu.leetcode.n1524;

class DynamicProgramming implements Code {

    private static final int M = 1_000_000_007;

    @Override
    public int numOfSubarrays(int[] arr) {
        long ans = 0;
        /*
         * odd表示子数组和为奇数的数量
         * even表示子数组和为偶数的数量
         */
        int odd = 0, even = 0;
        for (int num : arr) {
            if ((num & 1) == 1) {
                /*
                 * num是奇数
                 *
                 * 子数组的和 + num = 奇数
                 * 那么之前字数和 = 偶数 (num自身也能构成1个奇数子数组)
                 *
                 * 子数组和 + num = 偶数
                 * 那么之前子数组和 = 奇数
                 */
                int _odd = odd;
                odd = even + 1;
                even = _odd;
            } else {
                /*
                 * num是偶数
                 *
                 * 子数组和 + num = 奇数
                 * 那么之前子数组和 = 奇数 (不需要做任何改变)
                 *
                 * 子数组和 + num = 偶数
                 * 那么之前子数组和 = 偶数 (num自身也能构成1个偶数子数组)
                 */
                even++;
            }
            ans += odd;
        }
        return (int) (ans % M);
    }

}

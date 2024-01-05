package io.huhu.leetcode.bit.manipulation.easy.n645;

/**
 * <a href="https://leetcode.cn/problems/set-mismatch/description/">错误的集合</a>
 */
class Solution {

    /**
     * <p>
     * 方法一: 使用字典进行计数.<br/>
     * 丢失的数字计数为0，重复的数字计数为2
     * </p>
     * <pre>
     * {@code
     * public int[] findErrorNums(int[] nums) {
     *     int[] dict = new int[nums.length + 1];
     *     for (int i : nums) {
     *         dict[i]++;
     *     }
     *     int[] res = new int[2];
     *     for (int i = 1; i < dict.length; i++) {
     *         if (dict[i] == 2) {
     *             res[0] = i;
     *         }
     *         if (dict[i] == 0) {
     *             res[1] = i;
     *         }
     *     }
     *     return res;
     * }
     * }
     * </pre>
     * <br/>
     * <p>
     * 方法二: 使用数学方法.<br/>
     * 重复数字 = sum(nums) - sum(去重nums);<br/>
     * 丢失数字 = sum(1~n) - sum(去重nums)
     * </p>
     * <pre>
     * {@code
     * // 使用lambda表达式
     * public int[] findErrorNums(int[] nums) {
     *     int a = IntStream.of(nums).sum() - IntStream.of(nums).distinct().sum();
     *     int b = IntStream.rangeClosed(1, nums.length).sum() - IntStream.of(nums).distinct().sum();
     *     return new int[]{a, b};
     * }
     * // 不使用lambda表达式
     * public int[] findErrorNums(int[] nums) {
     *     Arrays.sort(nums);
     *     int sum = 0;
     *     for (int i = 0; i < nums.length; i++) {
     *         if (i > 0 && nums[i] == nums[i - 1]) {
     *             continue;
     *         }
     *         sum += nums[i];
     *     }
     *     int a = 0;
     *     for (int num : nums) {
     *         a += num;
     *     }
     *     int b = 0;
     *     for (int num = 1; num <= nums.length; num++) {
     *         b += num;
     *     }
     *     return new int[]{a - sum, b - sum};
     * }
     * }
     * </pre>
     * <br/>
     * <p>
     * 方法三: 位运算
     * </p>
     * <p>
     * 前提:<br/>
     * x ^ x = 0<br/>
     * 0 ^ y = y
     * </p>
     * <ol>
     * <li>
     * 设重复数字为a, 丢失数字位b.<br/>
     * 则在nums中有2个a和0个b, 其余每个数字有1个.<br/>
     * 若加上1到n中每个数字存在1个, 一共有3个a, 1个b, 其余数字各2个.<br/>
     * 将其全部进行异或操作后得到 {@code x = a ^ a ^ a ^ b; x = a ^ b}
     * </li>
     * <li>
     * 分解出a和b.<br/>
     * 首先, {@code -x & x = low} 可以求出a和b最低不同位,
     * 可以理解为a在这一位上是0, b在这一位上是1.<br/>
     * 下面通过与运算对所有数字(nums和1~n的所有数字)进行分组,
     * 如果最低位不同(即{@code num & low == 0})则分入g1组进行异或,
     * 否则({@code num & low != 0})分入g2组进行异或.<br/>
     * 由于其他数字都有2个, 所以它们分在哪组无所谓, 因为 {x ^ x = 0}.<br/>
     * g1组中存在3个a, 异或完得到a; g2组中存在1个b异或完得到b.<br/>
     * 通过这种方式将a和b分解出来
     * </li>
     * <li>
     * 判断a和b哪个是重复数字, 哪个是缺失数字.<br/>
     * 这一步很简单, 如果a存在nums中, 则a是重复数字, b是缺失数字.<br/>
     * 否则, a是缺失数字, b是重复数字.
     * </li>
     * </ol>
     * <p>代码如下:</p>
     */
    public int[] findErrorNums(int[] nums) {
        // 1 求出 x = a ^ b
        int x = 0;
        for (int n : nums) {
            x ^= n;
        }
        for (int n = 1; n <= nums.length; n++) {
            x ^= n;
        }
        // 2 分解出 a 和 b
        int a = 0, b = 0, low = -x & x;
        for (int n : nums) {
            if ((low & n) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        for (int n = 1; n <= nums.length; n++) {
            if ((low & n) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        // 3 判断 a 和 b 哪一个是重复数字
        for (int n : nums) {
            if (n == a) {
                return new int[]{a, b};
            }
        }
        return new int[]{b, a};
    }

}

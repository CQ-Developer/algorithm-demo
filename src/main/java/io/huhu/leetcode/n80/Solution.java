package io.huhu.leetcode.n80;

/**
 * <h1>
 * 80.删除有序数组中的重复项II
 * </h1>
 *
 * <p>
 * 给你一个有序数组numns，请你原地删除重复出现的元素，使得出现次数超过两次的元素只出现两次，返回删除后数组的新长度。
 * <br/>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用O(1)额外空间的条件下完成。
 * </p>
 *
 * <p>
 * 说明：
 * <br/>
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * <br/>
 * 请注意，输入数组是以[引用]方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <br/>
 * 你可以想象内部操作如下：
 * <pre>{@code
 * // nums是以应用方式传递的，也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的
 * // 根据你的函数返回的长度，它会打印出数组中该长度返回内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * }</pre>
 * </p>
 *
 * <p>
 * 示例一：
 * <br/>
 * 输入：nums = [1,1,1,2,2,3]
 * <br/>
 * 输出：5, nums = [1,1,2,2,3]
 * <br/>
 * 解释：函数应返回新长度length=5，并且原数组的前五个元素被修改为1,1,2,2,3。不需要考虑数组中超出新长度后面的元素。
 * </p>
 *
 * <p>
 * 示例二：
 * <br/>
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * <br/>
 * 解释：函数应返回新长度length=7，并且原数组的前五个元素被修改为0,0,1,1,2,3,3。不需要考虑数组中超过新长度后面的元素。
 * </p>
 *
 * <p>
 * 提示：
 * <br/>
 * 1 <= nums.length <= 3 * 10<sup>4</sup>
 * <br/>
 * -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup>
 * <br/>
 * nums已按升序排列
 * </p>
 */
class Solution {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                if (++count > 2) {
                    for (int j = i + 1; j < len; j++) {
                        int t = nums[j - 1];
                        nums[j - 1] = nums[j];
                        nums[j] = t;
                    }
                    len--;
                    i--;
                }
            } else {
                count = 1;
            }
        }
        return len;
    }

}

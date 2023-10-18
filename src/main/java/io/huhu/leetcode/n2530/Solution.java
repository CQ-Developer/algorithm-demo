package io.huhu.leetcode.n2530;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <h1>
 * 执行K次操作后的最大分数
 * </h1>
 *
 * <p>
 * 给你一个下标从0开始的整数数组nums和一个整数k，你的起始分数为0。
 * <br/>
 * 在一步操作中：
 * <br/>
 * 1.选出一个满足0 <= i < nums.length的下标i，
 * <br/>
 * 2.将你的分数增加nums[i]，并且
 * <br/>
 * 3.将nums[i]替换为cell(nums[i] / 3)。
 * <br/>
 * 返回在恰好执行k次操作后，你可能获得的最大分数。
 * <br/>
 * 向上取整函数cell(val)的结果是大于或等于val的最小整数。
 * </p>
 *
 * <p>
 * 示例一：
 * 输入：nums=[10,10,10,10,10], k=5
 * <br/>
 * 输出：50
 * <br/>
 * 解释：对数组中每个元素执行一次操作，最后分数是10+10+10+10+10=50。
 * </p>
 *
 * <p>
 * 示例二：
 * <br/>
 * 输入：nums=[1,10,3,3,3]，k=3
 * <br/>
 * 输出：17
 * <br/>
 * 解释：可执行下述操作：
 * <br/>
 * 第一步操作：选中i=1，nums变为[1,4,3,3,3]，分数增加10。
 * <br/>
 * 第二步操作：选中i=1，nums变为[1,2,3,3,3]，分数增加4。
 * <br/>
 * 第三步操作：选中i=2，nums变为[1,1,1,3,3]，分数增加3。
 * <br/>
 * 最后分数是10+4+3=17。
 * </p>
 *
 * <p>
 * 提示：
 * <br/>
 * 1 <= nums.length, k <= 10<sup>5</sup>
 * <br/>
 * 1 <= nums[i] <= 10<sup>5</sup>
 * </p>
 */
class Solution {

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.offer(num);
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int v = queue.poll();
            sum += v;
            queue.offer((v + 2) / 3);
        }
        return sum;
    }

}

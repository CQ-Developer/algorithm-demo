package io.huhu.leetcode.back.trace.n679;

/**
 * <a href="https://leetcode.cn/problems/24-game/description/">24点游戏</a>
 * <p>
 *     给你一个长度为4的整数数组cards. 你有4张卡片, 每张卡片上都包含一个范围在[1,9]的数字.
 *     你应该使用运算符 ['+', '-', '*', '/'] 和括号 '(' 和 ')' 将这些卡片上的数字排列成数学表达式, 以获得值24.
 * </p>
 * <p>
 *     你必须遵守以下规则:
 * </p>
 * <ul>
 *     <li>
 *         除法运算符 '/' 表示实数除法, 而不是整数除法
 *         <li>例如, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12</li>
 *     </li>
 *     <li>
 *         每个运算都在两个数字之间. 特别是, 不能使用 '-' 作为一元运算符
 *         <li>例如, 如果 cards = [1, 1, 1, 1], 则表达式 "-1-1-1-1" 是不允许的</li>
 *     </li>
 *     <li>
 *         你不能把数字串在一起
 *         <li>例如, 如果 cards = [1, 2, 1, 2], 则表达式 "12+12" 无效</li>
 *     </li>
 * </ul>
 * <p>
 *     如果可以得到这样的表达式, 其计算结果为24, 则返回 true, 否则返回 false.
 * </p>
 * <p>
 *     提示:
 * </p>
 * <ul>
 *     <li>cards.length == 4</li>
 *     <li>1 <= cards[i] <= 9</li>
 * </ul>
 */
class Solution {

    /**
     * 入口
     */
    public boolean judgePoint24(int[] cards) {
        return false;
    }

}

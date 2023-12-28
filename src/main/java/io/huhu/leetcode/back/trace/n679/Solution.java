package io.huhu.leetcode.back.trace.n679;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/24-game/description/">24点游戏</a>
 * <p>
 * 给你一个长度为4的整数数组cards. 你有4张卡片, 每张卡片上都包含一个范围在[1,9]的数字.
 * 你应该使用运算符 ['+', '-', '*', '/'] 和括号 '(' 和 ')' 将这些卡片上的数字排列成数学表达式, 以获得值24.
 * </p>
 * <p>
 * 你必须遵守以下规则:
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
        List<Fraction> list = new ArrayList<>();
        for (int card : cards) {
            list.add(new Fraction(card));
        }
        return dfs(list);
    }

    private boolean dfs(List<Fraction> cards) {
        if (cards.size() == 1) {
            return cards.get(0).value() == 24;
        }
        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                if (i == j) {
                    continue;
                }
                // 拷贝不参与计算的剩余数字
                List<Fraction> list = copyCards(cards, i, j);
                // 当前参与计算的2个数字
                Fraction f1 = cards.get(i);
                Fraction f2 = cards.get(j);
                // 进行加法运算
                list.add(0, f1.plus(f2));
                if (i < j && dfs(list)) {
                    return true;
                }
                // 进行减法运算
                list.set(0, f1.minus(f2));
                if (dfs(list)) {
                    return true;
                }
                // 进行乘法运算
                list.set(0, f1.multi(f2));
                if (i < j && dfs(list)) {
                    return true;
                }
                // 进行除法运算
                if (f2.value() != 0) {
                    list.set(0, f1.divide(f2));
                    if (dfs(list)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private List<Fraction> copyCards(List<Fraction> cards, int i, int j) {
        List<Fraction> list = new ArrayList<>();
        for (int k = 0; k < cards.size(); k++) {
            if (k != i && k != j) {
                list.add(cards.get(k));
            }
        }
        return list;
    }

    /**
     * 分数, 整数可以理解为分母为1的分数
     */
    static class Fraction {

        /** 分子 */
        int n;

        /** 分母 */
        int m;

        Fraction(int n) {
            this(n, 1);
        }

        Fraction(int n, int m) {
            this.n = n;
            this.m = m;
        }

        /** 加法 */
        Fraction plus(Fraction f) {
            if (this.m == f.m) {
                return new Fraction(this.n + f.n);
            }
            int n = this.n * f.m + f.n * this.m;
            int m = this.m * f.m;
            return new Fraction(n, m);
        }

        /** 乘法 */
        Fraction multi(Fraction f) {
            int n = this.n * f.n;
            int m = this.m * f.m;
            return new Fraction(n, m);
        }

        /** 减法 */
        Fraction minus(Fraction f) {
            if (this.m == f.m) {
                return new Fraction(this.n - f.n, this.m);
            }
            int n = this.n * f.m - f.n * this.m;
            int m = this.m * f.m;
            return new Fraction(n, m);
        }

        /** 除法 */
        Fraction divide(Fraction f) {
            int n = this.n * f.m;
            int m = this.m * f.n;
            return new Fraction(n, m);
        }

        /** 分数的最终结果 */
        double value() {
            return 1.0 * n / m;
        }

    }

}

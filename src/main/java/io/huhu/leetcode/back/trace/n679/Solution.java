package io.huhu.leetcode.back.trace.n679;

/**
 * <a href="https://leetcode.cn/problems/24-game/description/">
 * 24点游戏
 * </a>
 * <p>
 * 给你一个长度为4的整数数组cards. 你有4张卡片, 每张卡片上都包含一个范围在[1,9]的数字.
 * 你应该使用运算符 ['+', '-', '*', '/'] 和括号 '(' 和 ')' 将这些卡片上的数字排列成数学表达式, 以获得值24.
 * </p>
 * <p>
 * 你必须遵守以下规则:
 * </p>
 * <ul>
 * <li>
 * 除法运算符 '/' 表示实数除法, 而不是整数除法
 * <li>
 * 例如, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12
 * </li>
 * </li>
 * <li>
 * 每个运算都在两个数字之间. 特别是, 不能使用 '-' 作为一元运算符
 * <li>
 * 例如, 如果 cards = [1, 1, 1, 1], 则表达式 "-1-1-1-1" 是不允许的
 * </li>
 * </li>
 * <li>
 * 你不能把数字串在一起
 * <li>
 * 例如, 如果 cards = [1, 2, 1, 2], 则表达式 "12+12" 无效
 * </li>
 * </li>
 * </ul>
 * <p>
 * 如果可以得到这样的表达式, 其计算结果为24, 则返回 true, 否则返回 false.
 * </p>
 * <p>
 * 提示:
 * </p>
 * <ul>
 * <li>
 * cards.length == 4
 * </li>
 * <li>
 * 1 <= cards[i] <= 9
 * </li>
 * </ul>
 */
class Solution {

    /**
     * 入口
     */
    public boolean judgePoint24(int[] cards) {
        Fraction[] arr = new Fraction[cards.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Fraction(cards[i]);
        }
        return dfs(arr);
    }

    /**
     * 深度优先遍历 + 回溯
     */
    private boolean dfs(Fraction[] cards) {
        if (cards.length == 1) {
            return cards[0].value() == 24;
        }
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards.length; j++) {
                if (i == j) {
                    continue;
                }
                Fraction[] arr = copyCards(cards, i, j);
                if (i < j) {
                    arr[0] = cards[i].plus(cards[j]);
                    if (dfs(arr)) {
                        return true;
                    }
                    arr[0] = cards[i].multi(cards[j]);
                    if (dfs(arr)) {
                        return true;
                    }
                }
                if (cards[j].n != 0) {
                    arr[0] = cards[i].divide(cards[j]);
                    if (dfs(arr)) {
                        return true;
                    }
                }
                arr[0] = cards[i].minus(cards[j]);
                if (dfs(arr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Fraction[] copyCards(Fraction[] cards, int i, int j) {
        int l = 1;
        Fraction[] res = new Fraction[cards.length - 1];
        for (int k = 0; k < cards.length; k++) {
            if (k != i && k != j) {
                res[l++] = cards[k];
            }
        }
        return res;
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

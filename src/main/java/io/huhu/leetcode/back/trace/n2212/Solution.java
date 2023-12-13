package io.huhu.leetcode.back.trace.n2212;

/**
 * <a href="https://leetcode.cn/problems/maximum-points-in-an-archery-competition/description/">射箭比赛中的最大得分</a>
 * <p>Alice和Bob是一场射箭比赛中的对手. 比赛规则如下:
 * <ol>
 * <li>Alice先射numArrows支箭, 然后Bob也射numArrows支箭.
 * <li>
 * 分数按下述规则计算:
 * <ol>
 * <li>箭靶有若干整数计分区域, 范围从0到11(含0和11)
 * <li>箭靶上每个区域都对应一个得分k(范围是0到11), Alice和Bob分别在得分k区域射中a<sub>k</sub>和b<sub>k</sub>支箭.
 * 如果a<sub>k</sub>&gt;=b<sub>k</sub>, 那么Alice得k分. 如果a<sub>k</sub>&lt;b<sub>k</sub>, 则Bob得k分.
 * <li>如果a<sub>k</sub> == b<sub>k</sub> == 0, 那么无人得到k分.
 * </ol>
 * </li>
 * </ol>
 * <ul>
 * <li>例如, Alice和Bob都向计分为11的区域射2支箭, 那么Alice得11分.
 * 如果Alice向计分为11的区域射0支箭, 但Bob向同一个区域射2支箭, 那么Bob得11分.
 * </ul>
 * <p>给你整数numArrows和一个长度为12得整数数组aliceArrows, 该数组表示Alice射中0到11每个计分区域得箭数量.
 * 现在, Bob想要尽可能最大化他所能获得的总分.
 * <p>返回数组bobArrows, 该数组表示Bob射中0到11每个计分区域的箭数量.
 * 且bobArrows的总和应当等于numArrows.
 * <p>如果存在多种方法都可以使Bob获得最大总分, 返回其中任意一种即可.
 */
class Solution {

    /**
     * 提示:
     * <ul>
     * <li>1 <= numArrows <= 10<sup>5</sup>
     * <li>aliceArrows.length == bobArrows.length == 12
     * <li>0 <= aliceArrows[i], bobArrows[i] <= numArrows
     * <li>sum(aliceArrows[i]) == numArrows
     * </ul>
     */
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] bobArrows = new int[12];
        dfs(numArrows, aliceArrows, 11, new int[12], 0, bobArrows);
        return bobArrows;
    }

    /**
     * 深度优先遍历 + 回溯算法
     */
    private void dfs(int numArrows, int[] aliceArrows, int i, int[] path, int score, int[] bobArrows) {
        if (numArrows == 0 && score > countTotal(bobArrows)) {
            System.arraycopy(path, 0, bobArrows, 0, 12);
            return;
        }
        for (int j = i; j >= 0; j--) {
            boolean isLast = j == 0;
            if (!isLast && numArrows - (aliceArrows[j] + 1) < 0) {
                continue;
            }
            path[j] = isLast ? numArrows : aliceArrows[j] + 1;
            dfs(numArrows - path[j], aliceArrows, j - 1, path, score + j, bobArrows);
            path[j] = 0;
        }
    }

    /**
     * 统计Bob的射箭总分
     */
    private int countTotal(int[] bobArrows) {
        int total = 0;
        for (int i = 0; i < bobArrows.length; i++) {
            if (bobArrows[i] > 0) {
                total += i;
            }
        }
        return total;
    }

}

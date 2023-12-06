package io.huhu.leetcode.back.trace.n1947;

/**
 * <a href="https://leetcode.cn/problems/maximum-compatibility-score-sum/description/">最大兼容性评分和</a>
 * <p>有一份由n个问题组成的调查问卷, 每个问题的答案要么是0(no, 否), 要么是1(yes, 是).
 * <p>这份调查问卷被分发给m名学生和m名导师, 学生和导师的编号都是从0到m-1.
 * 学生的答案用一个二维整数数组students表示, 其中students[i]是一个整数数组, 包含第i名学生对调查问卷给出的答案(下标从0开始).
 * 导师的答案用一个二维整数数组mentors表示, 其中mentors[j]是一个整数数组, 包含第j名导师对调查问卷给出的答案(下标从0开始).
 * <p>每个学生都会被分配给一名导师, 而每位导师也会被分配到一名学生. 配对的学生与导师之间的兼容性评分等于学生和导师答案相同的次数.
 * <ul>
 * <li>例如, 学生答案为[1, 0, 1]而导师答案为[0, 0, 1], 那么他们的兼容性评分为2, 因为只有第二个和第三个答案相同.
 * </ul>
 * <p>请你找出最优的学生与导师的配对方案, 以最大程度上提高兼容习评分和.
 * <p>给你students和mentors, 返回可以得到的最大兼容性评分和.
 */
class Solution {

    /**
     * <p>提示:
     * <ul>
     * <li>m == students.length == mentors.length
     * <li>n == students[i].length == mentors[j].length
     * <li>1 <= m, n <= 8
     * <li>students[i][k]为0或1
     * <li>mentors[j][k]为0或1
     * </ul>
     */
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return 0;
    }

}

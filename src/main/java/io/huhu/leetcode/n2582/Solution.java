package io.huhu.leetcode.n2582;

/**
 * <h1>2582.递枕头</h1>
 * <p>n个人站成一排，按从1到n编号。<br>
 * 最初，排在队首的第一个人拿着一个枕头。<br>
 * 每秒钟，拿着枕头的人会将枕头的人会将枕头传递给队伍中的下一个人。<br>
 * 一旦枕头到达队首或队尾，传递方向就会改变，队伍会继续沿相反方向传递枕头。</p>
 * <p>例如，当枕头到达第n个人时，他会将枕头传递给第n-1个人，然后传递给第n-2个人，以此类推。</p>
 * <p>给你两个正整数n和time，返回time秒后拿着枕头的人的编号。</p>
 * <p>示例1：<br>
 * 输入：n=4, time=5<br>
 * 输出：2<br>
 * 解释：队伍中正投传递情况为1->2->3->4->3->2。<br>
 * 5s后，正投传递到第2个人手中。</p>
 * <p>示例2：<br>
 * 输入：n=3, time=2<br>
 * 输出：3<br>
 * 解释：队伍中枕头的传递情况为：1->2->3。<br>
 * 2s后，枕头传递到第3个人手中。</p>
 * <p>提示：<br>
 * 2 <= n <= 1000<br>
 * 1 <= time <= 1000</p>
 */
class Solution {

    public int passThePillow(int n, int time) {
        int r = 1;
        int f = -1;
        for (int i = 0; i < time; i++) {
            if (r == n || r == 1) {
                f = -f;
            }
            r += f;
        }
        return r;
    }

}

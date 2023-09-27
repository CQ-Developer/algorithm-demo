package io.huhu.leetcode.n59;

/**
 * <h1>59.螺旋矩阵II</h1>
 * <p>给你一个正整数n，生一个包含1到n<sup>2</sup>所有元素，且元素按顺时针顺序螺旋排列的n*n正方形矩阵matrix。</p>
 * <p>示例1：<br>
 * <img src="https://assets.leetcode.com/uploads/2020/11/13/spiraln.jpg"><br>
 * 输入：n=3<br>
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]</p>
 * <p>提示：<br>
 * <b>1 <= n <= 20</b></p>
 */
class Solution {

    /**
     * 螺旋遍历参考第54题
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 1) {
            result[0][0] = n;
            return result;
        }
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = n - 1;
        int x = 1;
        while (true) {
            for (int i = l; i <= r; i++) {
                result[t][i] = x++;
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                result[i][r] = x++;
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                result[b][i] = x++;
            }
            if (--b < t) {
                break;
            }
            for (int i = b; i >= t ; i--) {
                result[i][l] = x++;
            }
            if (++l > r) {
                break;
            }
        }
        return result;
    }

}

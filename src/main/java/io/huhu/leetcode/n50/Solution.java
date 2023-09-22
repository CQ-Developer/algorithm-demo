package io.huhu.leetcode.n50;

/**
 * <h1>50.Pow(x,n)</h1>
 * <p>实现pow(x,n)，即计算x的整数n次幂函数，即x<sup>n</sup></p>
 * <br>
 *
 * <p>
 * <b>示例1：</b>
 * <br>
 * 输入：x = 2.00000，n = 10
 * <br>
 * 输出：1024.00000
 * </p>
 * <br>
 *
 * <p>
 * <b>示例2：</b>
 * <br>
 * 输入：x = 2.10000，n = 3
 * <br>
 * 输出：9.26100
 * </p>
 * <br>
 *
 * <p>
 * <b>示例3：</b>
 * <br>
 * 输入：x = 2.00000，n = -2
 * <br>
 * 输出：0.25000
 * </p>
 * <br>
 *
 * <p>
 * <b>提示：</b>
 * <br>
 * -100.0 < x < 100.0
 * <br>
 * -2<sup>31</sup> <= n <= 2<sup>31</sup>-1
 * <br>
 * n是一个整数
 * <br>
 * 要么x不为0，要么n > 0
 * <br>
 * -10<sup>4</sup> <= x<sup>n</sup> <= 10<sup>4</sup>
 * </p>
 */
class Solution {

    /**
     * <h2>递归+二分</h2>
     * <p>
     * 2<sup>6</sup> = 2<sup>3</sup> * 2<sup>3</sup> * 2<sup>0</sup>
     * <br>
     * 2<sup>5</sup> = 2<sup>2</sup> * 2<sup>2</sup> * 2<sup>1</sup>
     * <br>
     * 2<sup>3</sup> = 2<sup>1</sup> * 2<sup>1</sup> * 2<sup>1</sup>
     * <br>
     * 2<sup>2</sup> = 2<sup>1</sup> * 2<sup>1</sup> * 2<sup>0</sup>
     * </p>
     * <p>
     * <b>总结：</b>
     * <br>
     * x<sup>n</sup> = x<sup>n/2</sup> * x<sup>n/2</sup> * x<sup>n%2</sup>
     * </p>
     */
    public double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return half * half * rest;
    }

    public double myPow1(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

}

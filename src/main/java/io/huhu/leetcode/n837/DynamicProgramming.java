package io.huhu.leetcode.n837;

class DynamicProgramming implements Code {

    /**
     * 假设此时牌面大小来到k-1, 能选择的牌面范围1...maxPts,
     * 则选择完成后排面大小来到k...k+maxPts-1.
     * 此时牌面大小已经超过k, 不能继续选择, 此时的获胜的概率要么是100%, 要么是0%.
     * 假设f(i)表示排面大小为i时的胜率.
     * 当 k <= i < k + maxPts 时:
     * f(i) = i <= n ? 1 : 0
     * 当 i < k 时:
     * 由于每次抽到每张牌的概率相同, 都为 1/maxPts=x, 可以任意在1...maxPts中进行抽牌,
     * f(i) = x*f(i+1) + x*f(i+2) + ... + x*f(i+maxPts)
     * f(i) = x * ( f(i+1)+f(i+2)+...+f(i+maxPts) )
     * f(i) = 1/maxPts * ( f(i+1)+f(i+2)+...+f(i+maxPts) )
     * 求和部分可以通过一个整数滚动更新
     */
    @Override
    public double new21Game(int n, int k, int maxPts) {
        double sum = 0;
        double[] f = new double[k + maxPts];
        for (int i = k; i < f.length; i++) {
            f[i] = i <= n ? 1 : 0;
            sum += f[i];
        }
        for (int i = k - 1; i >= 0; i--) {
            f[i] = sum / maxPts;
            sum = sum - f[i + maxPts] + f[i];
        }
        return f[0];
    }

}

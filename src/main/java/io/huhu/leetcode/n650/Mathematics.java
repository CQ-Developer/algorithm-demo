package io.huhu.leetcode.n650;

class Mathematics implements Code {

    /**
     * 举例
     * 4 -> 2 + f(2) 复制1次 粘贴1次
     * 5
     * 6 -> 2 + f(3) 复制1次 粘贴1次
     * 7
     * 8 -> 2 + f(4) 复制1次 粘贴1次
     * 9 -> 3 + f(3) 复制1次 粘贴2次
     * 本质就是质因数分解
     */
    @Override
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return i + minSteps(n / i);
            }
        }
        return n;
    }

}

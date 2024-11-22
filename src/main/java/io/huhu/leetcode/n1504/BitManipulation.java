package io.huhu.leetcode.n1504;

class BitManipulation implements Code {

    @Override
    public int numSubmat(int[][] mat) {
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            // 求行的矩形数量
            ans += row(mat[i]);
            // 将i+1...n-1行全部压缩到第i行
            // https://leetcode.cn/problems/count-submatrices-with-all-ones/solutions/316595/shi-yong-yu-yun-suan-fu-javashuang-bai-by-mp1256/
            for (int _i = i + 1; _i < mat.length; _i++) {
                for (int j = 0; j < mat[_i].length; j++) {
                    mat[i][j] &= mat[_i][j];
                }
                // 求压缩后的矩形数量
                ans += row(mat[i]);
            }
        }
        return ans;
    }

    /**
     * 通过等差数列求和公式计算矩形的数量
     */
    private static int row(int[] nums) {
        int ans = 0, cnt = 0;
        for (int num : nums) {
            if (num == 0) {
                // 等差数列求和
                ans += cnt * (cnt + 1) / 2;
                cnt = 0;
            } else {
                cnt++;
            }
        }
        return ans + cnt * (cnt + 1) / 2;
    }

}

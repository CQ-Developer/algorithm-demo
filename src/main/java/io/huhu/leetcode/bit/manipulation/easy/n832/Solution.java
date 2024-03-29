package io.huhu.leetcode.bit.manipulation.easy.n832;

/**
 * <a href="https://leetcode.cn/problems/flipping-an-image/description/">反转图像</a>
 */
class Solution {

    /**
     * <ul>
     * <li>n == image.length</li>
     * <li>n == image[i].length</li>
     * <li>1 <= n <= 20</li>
     * <li>image[i][j] == 0 或 1</li>
     * </ul>
     */
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int l = 0, r = image.length - 1;
            while (l < r) {
                if (image[i][l] == image[i][r]) {
                    image[i][l] ^= 1;
                    image[i][r] ^= 1;
                }
                l++;
                r--;
            }
            if (l == r) {
                image[i][l] ^= 1;
            }
        }
        return image;
    }

}

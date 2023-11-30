package io.huhu;

/**
 * 位运算工具类
 */
public final class BitUtil {

    private BitUtil() {}

    /**
     * 将arr[i]和arr[j]交换
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    /**
     * 判断是否是偶数
     */
    public static boolean isEven(int i) {
        return 0 == (i & 1);
    }

    /**
     * 返回绝对值
     */
    public static int abs(int i) {
        int j = i >> 31;
        return j == 0 ? i : (~i + 1);
    }

    /**
     * 统计二进制表示中1的个数
     */
    public static int count1(int i) {
        int cnt = 0;
        while (i != 0) {
            i &= (i - 1);
            cnt++;
        }
        return cnt;
    }


    /**
     * 判断一个数是否为2的n次方
     */
    public static boolean is2n(int i) {
        return (i & (i - 1)) == 0;
    }

}

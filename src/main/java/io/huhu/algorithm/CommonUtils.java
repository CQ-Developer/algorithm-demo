package io.huhu.algorithm;

public final class CommonUtils {

    private CommonUtils() {}

    /**
     * 生成小写字符a到z的数组
     *
     * @return a-z字符数组
     */
    public static char[] sequence_az() {
        char[] az = new char['z' - 'a' + 1];
        for (char c = 'a', i = 0; c <= 'z'; c++) {
            az[i++] = c;
        }
        return az;
    }

    /**
     * 生成大写字符A到Z的数组
     *
     * @return A-Z字符数组
     */
    public static char[] sequenceAZ() {
        char[] AZ = new char['Z' - 'A' + 1];
        for (char c = 'A', i = 0; c <= 'Z'; c++) {
            AZ[i++] = c;
        }
        return AZ;
    }

    /**
     * 生成数组0到9的数组
     *
     * @return 0-9整数数组
     */
    public static int[] sequence09() {
        int[] arr = new int[10];
        for (int i = 1; i < 10; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 使用递归计算阶乘的结果
     *
     * @param x 阶乘数
     * @return 阶乘结果
     */
    public static int recursionFactorial(int x) {
        return x == 1 ? 1 : x * recursionFactorial(x - 1);
    }

}

package io.huhu;

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

    /**
     * 使用递归计算数组元素的和
     *
     * @param arr 数组
     * @return 数组元素的和
     */
    public static int recursionSum(int[] arr) {
        return arr == null || arr.length == 0 ? 0 : recursionSum(arr, 0);
    }

    private static int recursionSum(int[] arr, int i) {
        return i == arr.length - 1 ? arr[i] : arr[i] + recursionSum(arr, i + 1);
    }

    /**
     * 使用递归统计元素的个数
     *
     * @param arr 数组
     * @return 数的元素个数
     */
    public static int recursionCount(int[] arr) {
        return arr == null || arr.length == 0 ? 0 : recursionCount(0, arr.length);
    }

    private static int recursionCount(int i, int n) {
        return i == n - 1 ? 1 : 1 + recursionCount(i + 1, n);
    }

    /**
     * 使用递归找出数组元素的最大值下标
     *
     * @param arr 数组
     * @return 数组元素的最大值下标
     */
    public static int recursionFindMax(int[] arr) {
        return arr == null || arr.length == 0 ? -1 : recursionFindMax(arr, 0);
    }

    private static int recursionFindMax(int[] arr, int m) {
        if (m < arr.length - 1) {
            int n = recursionFindMax(arr, m + 1);
            return arr[m] > arr[n] ? m : n;
        }
        return m;
    }

}

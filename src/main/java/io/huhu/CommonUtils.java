package io.huhu;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    /**
     * 比较集合的大小
     */
    public static <T extends Comparable<? super T>> int deepSort(List<T> list1, List<T> list2) {
        if (list1.size() > list2.size()) {
            return 1;
        }
        if (list1.size() < list2.size()) {
            return -1;
        }
        Collections.sort(list1);
        Collections.sort(list2);
        for (int i = 0; i < list1.size(); i++) {
            T x = list1.get(i);
            T y = list2.get(i);
            if (x.compareTo(y) > 0) {
                return 1;
            }
            if (x.compareTo(y) < 0) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * 生成一个不包含重复元素的无序整数数组
     */
    public static int[] generateArrayUnique(int len) throws NoSuchAlgorithmException {
        var rdm = SecureRandom.getInstanceStrong();
        rdm.setSeed(System.currentTimeMillis());
        Set<Integer> set = new HashSet<>(len);
        int range = len * 10;
        while (set.size() < len) {
            set.add(rdm.nextInt(-range, range));
        }
        int i = 0;
        int[] arr = new int[len];
        for (int j : set) {
            arr[i++] = j;
        }
        System.out.println("数组生成完成");
        for (int j = 0; j < 3; j++) {
            shuffle(arr, rdm);
        }
        System.out.println("数组打乱完成");
        return arr;
    }

    /**
     * 生成一个包含重复元素的无序整数数组
     */
    public static int[] generateArrayRepeated(int len) throws NoSuchAlgorithmException {
        var rdm = SecureRandom.getInstanceStrong();
        rdm.setSeed(System.currentTimeMillis());
        int range = len * 10;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = rdm.nextInt(-range, range);
        }
        return arr;
    }

    /**
     * 打乱数组顺序
     */
    public static void shuffle(int[] a, SecureRandom rdm) {
        for (int i = 0; i < a.length; i++) {
            int j = rdm.nextInt(a.length);
            if (i != j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
    }

}

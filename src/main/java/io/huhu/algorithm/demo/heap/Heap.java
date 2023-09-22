package io.huhu.algorithm.demo.heap;

/**
 * 堆
 */
public class Heap {

    // 存储堆中的数据
    private final int[] a;

    // 堆可以存储的最大数据个数
    private final int n;

    // 堆中已存储的数据个数
    private int count;

    public Heap(int capacity) {
        a = new int[capacity];
        n = capacity;
        count = 0;
    }

    /**
     * 向堆中插入数据
     */
    public void insert(int data) {
        // 堆满了
        if (count >= n) return;
        ++count;
        a[count] = data;
        int i = count;
        // 自下而上堆化
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            // 交换下标为i和i/2的两个元素
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 删除堆中最大数据
     */
    public void removeMax() {
        if (count == 0) return;
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    /**
     * 自上而下堆化
     */
    private void heapify(int[] a, int count, int i) {
        while (true) {
            int maxPos = 1;
            if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}

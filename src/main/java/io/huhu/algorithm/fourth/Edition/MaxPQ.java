package io.huhu.algorithm.fourth.Edition;

/**
 * 使用一个基于堆的完全二叉树实现的优先队列
 */
class MaxPQ<T extends Comparable<T>> {

    private T[] pq;
    private int N = 0;

    /**
     * 创建一个优先队列
     */
    public MaxPQ() {}

    /**
     * 创建一个初始容量为max的优先队列
     */
    public MaxPQ(int maxN) {
        pq = (T[]) new Comparable[maxN + 1];
    }

    /**
     * 用a中的元素创建一个优先级队列
     */
    public MaxPQ(T[] a) {}

    /**
     * 向优先队列中插入一个元素
     * 1.将元素加入到堆底
     * 2.将元素上浮到合适位置
     */
    public void insert(T t) {
        pq[++N] = t;
        swim(N);
    }

    /**
     * 返回最大元素
     */
    public T max() {
        return null;
    }

    /**
     * 删除并返回最大元素
     * 1.将堆顶元素和堆底元素交换位置
     * 2.将队尾元素删除
     * 3.将堆顶元素下沉到合适位置
     * 4.返回删除前的堆顶元素
     */
    public T delMax() {
        T max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    /**
     * 返回队列是否为空
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 返回优先队列中的元素个数
     */
    public int size() {
        return N;
    }

    /**
     * 比较
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * 交换
     */
    private void exch(int i, int j) {
        T t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /**
     * 上浮：由下至上的堆有序化
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    /**
     * 下沉：由上至下的堆有序化
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j = j + 1;
            }
            if (less(k, j)) {
                exch(k, j);
                k = j;
            }
        }
    }

}

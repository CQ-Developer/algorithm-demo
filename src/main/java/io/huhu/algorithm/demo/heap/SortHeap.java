package io.huhu.algorithm.demo.heap;

/**
 * 堆排序
 */
public class SortHeap {

    /**
     * 堆排序:
     * 数组中第一个元素是堆顶元素, 也就是最大元素.
     * 将它与最后一个元素交换, 那么最大元素就放到了下标为n的位置.
     * 交换后的堆顶元素需要自上而下堆化, 将其放到适合的位置.
     * 再将堆顶元素与n-1位置的元素进行交换, 重复如上步骤完成堆的排序.
     */
    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, n, 1);
        }
    }

    /**
     * 建堆.
     * 从后向前处理数组, 堆每个树执行自上而下的堆化.
     * 对于完全二叉树, 下标 n/2+1 的节点都是叶子节点,
     * 所以只需要对下标 n/2 ~ 1 的数据进行自上而下的堆化.
     */
    public void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(a, n, i);
        }
    }

    private void heapify(int[] a, int n, int i) {
        while (true) {
            int max = i;
            if (i * 2 <= n && a[i] < a[i * 2]) max = i * 2;
            if (i * 2 + 1 <= n && a[max] < a[i * 2 + 1]) max = i * 2 + 1;
            if (max == i) break;
            swap(a, i, max);
            i = max;
        }
    }

    private void swap(int[] a, int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

}

package io.huhu.algorithm.demo.tree;

/**
 * 线段树
 */
public class SegmentTree {

    private final int m;

    private final Segment[] segments;

    public SegmentTree(int m) {
        this.m = m;
        this.segments = new Segment[m * 4];
        buildSegmentTreeInternal(1, m, 1);
    }

    /**
     * 线段树更新操作: 向集合中插入数据
     */
    public void insert(int data) {
        int left = 1;
        int right = m;
        // 从根节点开始
        int i = 1;
        while (left != right) {
            segments[i].count++;
            int mid = (left + right) / 2;
            if (data <= mid) {
                right = mid;
                i = 2 * i;
            } else {
                left = mid;
                i = 2 * i + 1;
            }
        }
        // 叶子节点
        segments[i].count++;
    }

    /**
     * 线段树更新操作: 从集合中删除树
     */
    public void delete(int data) {
        int left = 1;
        int right = m;
        // 从根节点开始
        int i = 1;
        while (left != right) {
            segments[i].count--;
            int mid = (left + right) / 2;
            if (data <= mid) {
                right = mid + 1;
                i = 2 * i;
            } else {
                left = mid;
                i = 2 * i + 1;
            }
        }
        // 叶子节点
        segments[i].count--;
    }

    /**
     * 查询区间统计数据
     */
    public int count(int left, int right) {
        return countInternal(left, right, 1);
    }

    /**
     * 查询区间的第K大值
     */
    public int getKth(int left, int right, int k) {
        return getKthInternal(left, right, 1, k);
    }

    private int getKthInternal(int left, int right, int i, int k) {
        if (segments[i].left == left && segments[i].right == right) {
            if (k != -1) {
                return -1;
            } else {
                return segments[i].left;
            }
        }
        int mid = (left + right) / 2;
        int rightSegmentCount = countInternal(left, right, i * 2 + 1);
        if (rightSegmentCount >= k) {
            return getKthInternal(mid + 1, right, i * 2 + 1, k);
        } else {
            return getKthInternal(left, mid, i * 2, k - rightSegmentCount);
        }
    }

    private int countInternal(int left, int right, int i) {
        if (segments[i].left == left && segments[i].right == right) {
            return segments[i].count;
        }
        int mid = (left + right) / 2;
        if (left > mid) {
            return countInternal(left, right, 2 * i + 1);
        } else if (right <= mid) {
            return countInternal(left, right, 2 * i);
        } else {
            return countInternal(left, mid, 2 * i) + countInternal(mid + 1, right, 2 * i + 1);
        }
    }

    private void buildSegmentTreeInternal(int left, int right, int i) {
        // 设置当前节点的区间
        segments[i] = new Segment();
        segments[i].left = left;
        segments[i].right = right;
        segments[i].count = 0;
        // 递归的终止条件
        // 区间不可再分
        if (left == right) {
            return;
        }
        // 递归的设置左子树和右子树
        int mid = (left + right) / 2;
        buildSegmentTreeInternal(left, mid, 2 * i);
        buildSegmentTreeInternal(mid + 1, right, 2 * i + 1);
    }

    /**
     * 定义区间
     */
    public static class Segment {
        public int left;
        public int right;
        public int count;
    }

}

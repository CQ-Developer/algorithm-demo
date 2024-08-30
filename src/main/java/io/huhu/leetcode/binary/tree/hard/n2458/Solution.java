package io.huhu.leetcode.binary.tree.hard.n2458;

/**
 * <a href="https://leetcode.cn/problems/height-of-binary-tree-after-subtree-removal-queries/description/">
 * Height of Binary Tree After Subtree Removal Queries
 * </a>
 */
class Solution {

    private static final int MAXN = 100001;
    private static final int[] dfn = new int[MAXN];
    private static final int[] size = new int[MAXN];
    private static final int[] deep = new int[MAXN];

    private int dfnCnt;

    public int[] treeQueries(TreeNode root, int[] queries) {
        f(root, 0);
        int[] maxL = new int[dfnCnt + 1];
        for (int i = 1; i <= dfnCnt; i++) {
            maxL[i] = Math.max(maxL[i - 1], deep[i]);
        }
        int[] maxR = new int[dfnCnt + 2];
        for (int i = dfnCnt; i > 0; i--) {
            maxR[i] = Math.max(maxR[i + 1], deep[i]);
        }
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = maxL[dfn[queries[i]] - 1];
            int r = maxR[dfn[queries[i]] + size[dfn[queries[i]]]];
            ans[i] = Math.max(l, r);
        }
        return ans;
    }

    private void f(TreeNode root, int k) {
        int i = ++dfnCnt;
        dfn[root.val] = i;
        deep[i] = k;
        size[i] = 1;
        if (root.left != null) {
            f(root.left, k + 1);
            size[i] += size[dfn[root.left.val]];
        }
        if (root.right != null) {
            f(root.right, k + 1);
            size[i] += size[dfn[root.right.val]];
        }
    }

}

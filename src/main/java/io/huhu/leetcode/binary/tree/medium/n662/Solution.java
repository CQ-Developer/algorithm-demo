package io.huhu.leetcode.binary.tree.medium.n662;

/**
 * <a href="https://leetcode.cn/problems/maximum-width-of-binary-tree/description/">
 * Maximum Width of Binary Tree
 * </a>
 */
class Solution {

    static final int MAXN = 3001;
    static final TreeNode[] NODE_QUEUE = new TreeNode[MAXN];
    static final int[] ID_QUEUE = new int[MAXN];

    public int widthOfBinaryTree(TreeNode root) {
        int ans = 1,l = 0, r = 0;
        NODE_QUEUE[r] = root;
        ID_QUEUE[r++] = 1;
        while (l < r) {
            int n = r - l;
            ans = Math.max(ans, ID_QUEUE[r - 1] - ID_QUEUE[l] + 1);
            for (int i = 0; i < n; i++) {
                TreeNode cur = NODE_QUEUE[l];
                int id = ID_QUEUE[l++];
                if (cur.left != null) {
                    NODE_QUEUE[r] = cur.left;
                    ID_QUEUE[r++] = id << 1;
                }
                if (cur.right != null) {
                    NODE_QUEUE[r] = cur.right;
                    ID_QUEUE[r++] = (id << 1) + 1;
                }
            }
        }
        return ans;
    }

}

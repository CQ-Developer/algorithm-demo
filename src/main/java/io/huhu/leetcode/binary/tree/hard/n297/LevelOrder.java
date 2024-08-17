package io.huhu.leetcode.binary.tree.hard.n297;

import java.util.LinkedList;
import java.util.Queue;

class LevelOrder implements Codec {

    @Override
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val).append(',');
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur.left != null) {
                queue.add(cur.left);
                sb.append(cur.left.val).append(',');
            } else {
                sb.append("#,");
            }
            if (cur.right != null) {
                queue.add(cur.right);
                sb.append(cur.right.val).append(',');
            } else {
                sb.append("#,");
            }
        }
        return sb.toString();
    }

    @Override
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        int i = 0;
        String[] nodes = data.split(",");
        TreeNode root = generate(nodes[i++]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            cur.left = generate(nodes[i++]);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            cur.right = generate(nodes[i++]);
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return root;
    }

    private TreeNode generate(String s) {
        return "#".equals(s) ? null : new TreeNode(Integer.parseInt(s));
    }

}

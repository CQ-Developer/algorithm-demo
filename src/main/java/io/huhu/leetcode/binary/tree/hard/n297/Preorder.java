package io.huhu.leetcode.binary.tree.hard.n297;

import java.util.LinkedList;
import java.util.Queue;

class Preorder implements Codec {

    static final String NULL = "#";
    static final String DELEMITER = ",";

    @Override
    public String serialize(TreeNode root) {
        return serialize(root, new StringBuilder());
    }

    private String serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(DELEMITER);
        } else {
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
        return sb.toString();
    }

    @Override
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String s : arr) {
            queue.add(s);
        }
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        String cur = queue.remove();
        if (NULL.equals(cur)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }

}

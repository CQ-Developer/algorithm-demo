package io.huhu.leetcode.binary.tree.hard.n297;

/**
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/description/">Serialize and Deserialize Binary Tree</a>
 */
class Codec {

    final static String NULL = "#";
    final static String DELEMITER = ",";

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

    int i = 0;

    public TreeNode deserialize(String data) {
        return deserialize(data.split(DELEMITER));
    }

    private TreeNode deserialize(String[] s) {
        String cur = s[i++];
        if (NULL.equals(cur)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserialize(s);
        root.right = deserialize(s);
        return root;
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

}

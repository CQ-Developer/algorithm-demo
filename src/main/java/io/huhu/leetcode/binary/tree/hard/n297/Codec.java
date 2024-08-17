package io.huhu.leetcode.binary.tree.hard.n297;

/**
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/description/">
 * Serialize and Deserialize Binary Tree
 * </a>
 */
interface Codec {

    String serialize(TreeNode root);

    TreeNode deserialize(String data);

}

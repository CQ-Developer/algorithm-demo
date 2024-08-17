package io.huhu.leetcode.binary.tree.hard.n297;
 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Codec codec;

    @BeforeEach
    void setup() {
        codec = new Codec();
    }

    @Test
    void test_1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String s = codec.serialize(root);
        Assertions.assertEquals(s, codec.serialize(codec.deserialize(s)));
    }

}
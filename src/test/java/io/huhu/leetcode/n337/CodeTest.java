package io.huhu.leetcode.n337;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @Test
    void test_1() {
        var root = new TreeNode(3,
                new TreeNode(2,
                        null,
                        new TreeNode(3)),
                new TreeNode(3,
                        null,
                        new TreeNode(1)));
        Assertions.assertEquals(7, code.rob(root));
    }

    @Test
    void test_2() {
        var root = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(5,
                        null,
                        new TreeNode(1)));
        Assertions.assertEquals(9, code.rob(root));
    }

}

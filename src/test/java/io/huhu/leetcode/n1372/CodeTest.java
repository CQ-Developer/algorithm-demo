package io.huhu.leetcode.n1372;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @ParameterizedTest
    @MethodSource("params")
    void test(TreeNode root, int ans) {
        assertEquals(ans, code.longestZigZag(root));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new TreeNode(1, null, new TreeNode(1, new TreeNode(1), new TreeNode(1, new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1))), new TreeNode(1)))), 3),
                arguments(new TreeNode(1, new TreeNode(1, null, new TreeNode(1, new TreeNode(1, null, new TreeNode(1)), new TreeNode(1))), new TreeNode(1)), 4),
                arguments(new TreeNode(1), 0));
    }

}
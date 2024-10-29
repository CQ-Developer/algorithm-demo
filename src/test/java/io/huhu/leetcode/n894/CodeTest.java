package io.huhu.leetcode.n894;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @ParameterizedTest
    @MethodSource("examples")
    void test(int n, List<TreeNode> expected) {
        Assertions.assertIterableEquals(expected, code.allPossibleFBT(n));
    }

    static Stream<Arguments> examples() {
        return Stream.of(Arguments.arguments(3, List.of(new TreeNode(0, new TreeNode(0), new TreeNode(0)))));
    }

}
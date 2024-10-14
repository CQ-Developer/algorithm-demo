package io.huhu.leetcode.n474;

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
        String[] strs = {"10", "0001", "111001", "1", "0"};
        Assertions.assertEquals(4, code.findMaxForm(strs, 5, 3));
    }

    @Test
    void test_2() {
        String[] strs = {"10", "0", "1"};
        Assertions.assertEquals(2, code.findMaxForm(strs, 1, 1));
    }

}
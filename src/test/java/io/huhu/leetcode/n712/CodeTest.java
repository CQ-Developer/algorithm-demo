package io.huhu.leetcode.n712;

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
        Assertions.assertEquals(231, code.minimumDeleteSum("sea", "eat"));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(403, code.minimumDeleteSum("delete", "leet"));
    }

}

package io.huhu.other;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Code01Test {

    Code01 code;

    @BeforeEach
    void setup() {
        code = new Code01();
    }

    @Test
    void test1() {
        Assertions.assertEquals(1, code.code("axbc", "abcde"));
    }

}

package io.huhu.leetcode.n638;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @Test
    void test_1() {
        Assertions.assertEquals(14, code.shoppingOffers(
                new ArrayList<>(List.of(2, 5)),
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(3, 0, 5)),
                        new ArrayList<>(List.of(1, 2, 10)))),
                new ArrayList<>(List.of(3, 2))));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(11, code.shoppingOffers(
                new ArrayList<>(List.of(2, 3, 4)),
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(1, 1, 0, 4)),
                        new ArrayList<>(List.of(2, 2, 1, 9)))),
                new ArrayList<>(List.of(1, 2, 1))));
    }

}

package io.huhu.leetcode.greedy.n253;

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
        int[][] meeting = {{1, 2}, {2, 3}, {1, 3}};
        Assertions.assertEquals(2, code.minMeetingRooms(meeting));
    }

}

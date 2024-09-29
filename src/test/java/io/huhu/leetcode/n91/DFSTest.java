package io.huhu.leetcode.n91;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DFSTest extends CodeTest {

    @Override
    Code getCode() {
        return new DFS();
    }

    @Test
    void test_4() {
        Assertions.assertEquals(4, code.numDecodings("2611055971756562"));
    }

}

package io.huhu.huawei.od.s200.n14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test1() {
        char[][] grid = {
                {'A', 'C', 'C', 'F'},
                {'C', 'D', 'E', 'D'},
                {'B', 'E', 'S', 'S'},
                {'F', 'E', 'C', 'A'}};
        String word = "ACCESS";
        Assertions.assertEquals("0,0,0,1,0,2,1,2,2,2,2,3", Solution.findWord(grid, word));
    }

}

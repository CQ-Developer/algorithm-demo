package io.huhu.leetcode.n71;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void simplifyPath_1() {
        assertEquals("/home", solution.simplifyPath("/home/"));
    }

    @Test
    void simplifyPath_2() {
        assertEquals("/", solution.simplifyPath("/../"));
    }

    @Test
    void simplifyPath_3() {
        assertEquals("/home/foo", solution.simplifyPath("/home//foo/"));
    }

    @Test
    void simplifyPath_4() {
        assertEquals("/c", solution.simplifyPath("/a/./b/../../c/"));
    }

}

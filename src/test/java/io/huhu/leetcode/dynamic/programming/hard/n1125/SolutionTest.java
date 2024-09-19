package io.huhu.leetcode.dynamic.programming.hard.n1125;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract Solution getSolution();

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    @Test
    void test_1() {
        String[] req_skills = {"java", "nodejs", "reactjs"};
        List<List<String>> people = List.of(List.of("java"), List.of("nodejs"), List.of("nodejs", "reactjs"));
        int[] expected = {0, 2};
        Assertions.assertArrayEquals(expected, solution.smallestSufficientTeam(req_skills, people));
    }

    @Test
    void test_2() {
        String[] req_skills = {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
        List<List<String>> people = List.of(List.of("algorithms", "math", "java"), List.of("algorithms", "math", "reactjs"), List.of("java", "csharp", "aws"), List.of("reactjs", "csharp"), List.of("csharp", "math"), List.of("aws", "java"));
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution.smallestSufficientTeam(req_skills, people));
    }

}

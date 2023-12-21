package io.huhu.leetcode.back.trace.interview.questions.n08.n08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void case_1() {
        String[] actual = solution.permutation("qqe");
        String[] expected = {"eqq", "qeq", "qqe"};
        Arrays.sort(actual, CharSequence::compare);
        Arrays.sort(expected, CharSequence::compare);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void case_2() {
        String[] actual = solution.permutation("ab");
        String[] expected = {"ab", "ba"};
        Arrays.sort(actual, CharSequence::compare);
        Arrays.sort(expected, CharSequence::compare);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void case_3() {
        String[] actual = solution.permutation("jawaLR");
        String[] expected = {"LRaajw", "LRaawj", "LRajaw", "LRajwa", "LRawaj", "LRawja", "LRjaaw", "LRjawa", "LRjwaa", "LRwaaj",
                             "LRwaja", "LRwjaa", "LaRajw", "LaRawj", "LaRjaw", "LaRjwa", "LaRwaj", "LaRwja", "LaaRjw", "LaaRwj",
                             "LaajRw", "LaajwR", "LaawRj", "LaawjR", "LajRaw", "LajRwa", "LajaRw", "LajawR", "LajwRa", "LajwaR",
                             "LawRaj", "LawRja", "LawaRj", "LawajR", "LawjRa", "LawjaR", "LjRaaw", "LjRawa", "LjRwaa", "LjaRaw",
                             "LjaRwa", "LjaaRw", "LjaawR", "LjawRa", "LjawaR", "LjwRaa", "LjwaRa", "LjwaaR", "LwRaaj", "LwRaja",
                             "LwRjaa", "LwaRaj", "LwaRja", "LwaaRj", "LwaajR", "LwajRa", "LwajaR", "LwjRaa", "LwjaRa", "LwjaaR",
                             "RLaajw", "RLaawj", "RLajaw", "RLajwa", "RLawaj", "RLawja", "RLjaaw", "RLjawa", "RLjwaa", "RLwaaj",
                             "RLwaja", "RLwjaa", "RaLajw", "RaLawj", "RaLjaw", "RaLjwa", "RaLwaj", "RaLwja", "RaaLjw", "RaaLwj",
                             "RaajLw", "RaajwL", "RaawLj", "RaawjL", "RajLaw", "RajLwa", "RajaLw", "RajawL", "RajwLa", "RajwaL",
                             "RawLaj", "RawLja", "RawaLj", "RawajL", "RawjLa", "RawjaL", "RjLaaw", "RjLawa", "RjLwaa", "RjaLaw",
                             "RjaLwa", "RjaaLw", "RjaawL", "RjawLa", "RjawaL", "RjwLaa", "RjwaLa", "RjwaaL", "RwLaaj", "RwLaja",
                             "RwLjaa", "RwaLaj", "RwaLja", "RwaaLj", "RwaajL", "RwajLa", "RwajaL", "RwjLaa", "RwjaLa", "RwjaaL",
                             "aLRajw", "aLRawj", "aLRjaw", "aLRjwa", "aLRwaj", "aLRwja", "aLaRjw", "aLaRwj", "aLajRw", "aLajwR",
                             "aLawRj", "aLawjR", "aLjRaw", "aLjRwa", "aLjaRw", "aLjawR", "aLjwRa", "aLjwaR", "aLwRaj", "aLwRja",
                             "aLwaRj", "aLwajR", "aLwjRa", "aLwjaR", "aRLajw", "aRLawj", "aRLjaw", "aRLjwa", "aRLwaj", "aRLwja",
                             "aRaLjw", "aRaLwj", "aRajLw", "aRajwL", "aRawLj", "aRawjL", "aRjLaw", "aRjLwa", "aRjaLw", "aRjawL",
                             "aRjwLa", "aRjwaL", "aRwLaj", "aRwLja", "aRwaLj", "aRwajL", "aRwjLa", "aRwjaL", "aaLRjw", "aaLRwj",
                             "aaLjRw", "aaLjwR", "aaLwRj", "aaLwjR", "aaRLjw", "aaRLwj", "aaRjLw", "aaRjwL", "aaRwLj", "aaRwjL",
                             "aajLRw", "aajLwR", "aajRLw", "aajRwL", "aajwLR", "aajwRL", "aawLRj", "aawLjR", "aawRLj", "aawRjL",
                             "aawjLR", "aawjRL", "ajLRaw", "ajLRwa", "ajLaRw", "ajLawR", "ajLwRa", "ajLwaR", "ajRLaw", "ajRLwa",
                             "ajRaLw", "ajRawL", "ajRwLa", "ajRwaL", "ajaLRw", "ajaLwR", "ajaRLw", "ajaRwL", "ajawLR", "ajawRL",
                             "ajwLRa", "ajwLaR", "ajwRLa", "ajwRaL", "ajwaLR", "ajwaRL", "awLRaj", "awLRja", "awLaRj", "awLajR",
                             "awLjRa", "awLjaR", "awRLaj", "awRLja", "awRaLj", "awRajL", "awRjLa", "awRjaL", "awaLRj", "awaLjR",
                             "awaRLj", "awaRjL", "awajLR", "awajRL", "awjLRa", "awjLaR", "awjRLa", "awjRaL", "awjaLR", "awjaRL",
                             "jLRaaw", "jLRawa", "jLRwaa", "jLaRaw", "jLaRwa", "jLaaRw", "jLaawR", "jLawRa", "jLawaR", "jLwRaa",
                             "jLwaRa", "jLwaaR", "jRLaaw", "jRLawa", "jRLwaa", "jRaLaw", "jRaLwa", "jRaaLw", "jRaawL", "jRawLa",
                             "jRawaL", "jRwLaa", "jRwaLa", "jRwaaL", "jaLRaw", "jaLRwa", "jaLaRw", "jaLawR", "jaLwRa", "jaLwaR",
                             "jaRLaw", "jaRLwa", "jaRaLw", "jaRawL", "jaRwLa", "jaRwaL", "jaaLRw", "jaaLwR", "jaaRLw", "jaaRwL",
                             "jaawLR", "jaawRL", "jawLRa", "jawLaR", "jawRLa", "jawRaL", "jawaLR", "jawaRL", "jwLRaa", "jwLaRa",
                             "jwLaaR", "jwRLaa", "jwRaLa", "jwRaaL", "jwaLRa", "jwaLaR", "jwaRLa", "jwaRaL", "jwaaLR", "jwaaRL",
                             "wLRaaj", "wLRaja", "wLRjaa", "wLaRaj", "wLaRja", "wLaaRj", "wLaajR", "wLajRa", "wLajaR", "wLjRaa",
                             "wLjaRa", "wLjaaR", "wRLaaj", "wRLaja", "wRLjaa", "wRaLaj", "wRaLja", "wRaaLj", "wRaajL", "wRajLa",
                             "wRajaL", "wRjLaa", "wRjaLa", "wRjaaL", "waLRaj", "waLRja", "waLaRj", "waLajR", "waLjRa", "waLjaR",
                             "waRLaj", "waRLja", "waRaLj", "waRajL", "waRjLa", "waRjaL", "waaLRj", "waaLjR", "waaRLj", "waaRjL",
                             "waajLR", "waajRL", "wajLRa", "wajLaR", "wajRLa", "wajRaL", "wajaLR", "wajaRL", "wjLRaa", "wjLaRa",
                             "wjLaaR", "wjRLaa", "wjRaLa", "wjRaaL", "wjaLRa", "wjaLaR", "wjaRLa", "wjaRaL", "wjaaLR", "wjaaRL"};
        Arrays.sort(actual, CharSequence::compare);
        Arrays.sort(expected, CharSequence::compare);
        Assertions.assertArrayEquals(expected, actual);
    }

}

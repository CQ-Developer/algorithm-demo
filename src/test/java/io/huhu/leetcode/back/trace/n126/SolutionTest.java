package io.huhu.leetcode.back.trace.n126;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void case_1() {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> actual = solution.findLadders(beginWord, endWord, new ArrayList<>(wordList));
        List<List<String>> expected = List.of(
                List.of("hit", "hot", "dot", "dog", "cog"),
                List.of("hit", "hot", "lot", "log", "cog"));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_2() {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log");
        List<List<String>> actual = solution.findLadders(beginWord, endWord, new ArrayList<>(wordList));
        List<List<String>> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_3() {
        String beginWord = "hot", endWord = "dog";
        List<String> wordList = List.of("hot", "dog", "dot");
        List<List<String>> actual = solution.findLadders(beginWord, endWord, new ArrayList<>(wordList));
        List<List<String>> expected = List.of(List.of("hot", "dot", "dog"));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_4() {
        String beginWord = "qa", endWord = "sq";
        List<String> wordList = List.of(
                "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb",
                "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br",
                "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr",
                "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh",
                "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb",
                "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz",
                "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an",
                "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi",
                "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr",
                "pa", "he", "lr", "sq", "ye");
        List<List<String>> actual = solution.findLadders(beginWord, endWord, new ArrayList<>(wordList));
        List<List<String>> expected = List.of(
                List.of("qa", "ca", "cm", "sm", "sq"),
                List.of("qa", "ca", "ci", "si", "sq"),
                List.of("qa", "ca", "cr", "sr", "sq"),
                List.of("qa", "ca", "co", "so", "sq"),
                List.of("qa", "ba", "br", "sr", "sq"),
                List.of("qa", "ba", "bi", "si", "sq"),
                List.of("qa", "ba", "be", "se", "sq"),
                List.of("qa", "ra", "re", "se", "sq"),
                List.of("qa", "ra", "rn", "sn", "sq"),
                List.of("qa", "ra", "rh", "sh", "sq"),
                List.of("qa", "ra", "rb", "sb", "sq"),
                List.of("qa", "fa", "fe", "se", "sq"),
                List.of("qa", "fa", "fr", "sr", "sq"),
                List.of("qa", "fa", "fm", "sm", "sq"),
                List.of("qa", "ya", "yo", "so", "sq"),
                List.of("qa", "ya", "yb", "sb", "sq"),
                List.of("qa", "ya", "ye", "se", "sq"),
                List.of("qa", "ma", "mt", "st", "sq"),
                List.of("qa", "ma", "mb", "sb", "sq"),
                List.of("qa", "ma", "me", "se", "sq"),
                List.of("qa", "ma", "mo", "so", "sq"),
                List.of("qa", "ma", "mn", "sn", "sq"),
                List.of("qa", "ma", "mi", "si", "sq"),
                List.of("qa", "ma", "mr", "sr", "sq"),
                List.of("qa", "ga", "go", "so", "sq"),
                List.of("qa", "ga", "ge", "se", "sq"),
                List.of("qa", "ha", "ho", "so", "sq"),
                List.of("qa", "ha", "hi", "si", "sq"),
                List.of("qa", "ha", "he", "se", "sq"),
                List.of("qa", "na", "nb", "sb", "sq"),
                List.of("qa", "na", "no", "so", "sq"),
                List.of("qa", "na", "ne", "se", "sq"),
                List.of("qa", "na", "ni", "si", "sq"),
                List.of("qa", "la", "ln", "sn", "sq"),
                List.of("qa", "la", "le", "se", "sq"),
                List.of("qa", "la", "lt", "st", "sq"),
                List.of("qa", "la", "lo", "so", "sq"),
                List.of("qa", "la", "li", "si", "sq"),
                List.of("qa", "la", "lr", "sr", "sq"),
                List.of("qa", "ta", "tm", "sm", "sq"),
                List.of("qa", "ta", "ti", "si", "sq"),
                List.of("qa", "ta", "to", "so", "sq"),
                List.of("qa", "ta", "tc", "sc", "sq"),
                List.of("qa", "ta", "th", "sh", "sq"),
                List.of("qa", "ta", "tb", "sb", "sq"),
                List.of("qa", "pa", "ph", "sh", "sq"),
                List.of("qa", "pa", "po", "so", "sq"),
                List.of("qa", "pa", "pb", "sb", "sq"),
                List.of("qa", "pa", "pm", "sm", "sq"),
                List.of("qa", "pa", "pi", "si", "sq"),
                List.of("qa", "pa", "pt", "st", "sq"));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_5() {
        String beginWord = "cet", endWord = "ism";
        List<String> wordList = List.of(
                "kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay",
                "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal",
                "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit",
                "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row",
                "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has",
                "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu",
                "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy",
                "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply",
                "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan",
                "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye",
                "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot",
                "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib",
                "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm",
                "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk",
                "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag",
                "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic",
                "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his",
                "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod",
                "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib",
                "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr",
                "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap",
                "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx",
                "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set",
                "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao",
                "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap",
                "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky",
                "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo",
                "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva",
                "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep",
                "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed",
                "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum",
                "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem",
                "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen",
                "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit",
                "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken",
                "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin",
                "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui",
                "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo",
                "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas",
                "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio",
                "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit",
                "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix",
                "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid",
                "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil",
                "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig",
                "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty",
                "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug",
                "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot",
                "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism",
                "err", "him", "all", "pad", "hah", "hie", "aim");
        List<List<String>> actual = solution.findLadders(beginWord, endWord, new ArrayList<>(wordList));
        actual.forEach(System.out::println);

    }

}
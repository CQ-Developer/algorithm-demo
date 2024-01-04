package io.huhu.leetcode.bit.manipulation.easy.n389;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void findTheDifference1() {
        Assertions.assertEquals('e', solution.findTheDifference("abcd", "abcde"));
    }

    @Test
    void findTheDifference2() {
        Assertions.assertEquals('y', solution.findTheDifference("", "y"));
    }

    @Test
    void findTheDifference3() {
        String s = """
                ymbgaraibkfmvocpizdydugvalagaivdbfsfbepeyccqfepzv\
                tpyxtbadkhmwmoswrcxnargtlswqemafandgkmydtimuzvjwx\
                vlfwlhvkrgcsithaqlcvrihrwqkpjdhgfgreqoxzfvhjzojhg\
                hfwbvpfzectwwhexthbsndovxejsntmjihchaotbgcysfdaoj\
                kjldprwyrnischrgmtvjcorypvopfmegizfkvudubnejzfqff\
                vgdoxohuinkyygbdzmshvyqyhsozwvlhevfepdvafgkqpkmcs\
                ikfyxczcovrmwqxxbnhfzcjjcpgzjjfateajnnvlbwhyppdle\
                ahgaypxidkpwmfqwqyofwdqgxhjaxvyrzupfwesmxbjszolgw\
                qvfiozofncbohduqgiswuiyddmwlwubetyaummenkdfptjczx\
                emryuotrrymrfdxtrebpbjtpnuhsbnovhectpjhfhahbqrfby\
                xggobsweefcwxpqsspyssrmdhuelkkvyjxswjwofngpwfxvkn\
                kjviiavorwyfzlnktmfwxkvwkrwdcxjfzikdyswsuxegmhtnx\
                jraqrdchaauazfhtklxsksbhwgjphgbasfnlwqwukprgvihnt\
                syymdrfovaszjywuqygpvjtvlsvvqbvzsmgweiayhlubnbsit\
                vfxawhfmfiatxvqrcwjshvovxknnxnyyfexqycrlyksderlqa\
                rqhkxyaqwlwoqcribumrqjtelhwdvaiysgjlvksrfvjlcaiwr\
                irtkkxbwgicyhvakxgdjwnwmubkiazdjkfmotglclqndqjxet\
                houtvjchjbkoasnnfbgrnycucfpeovruguzumgmgddqwjgdva\
                ujhyqsqtoexmnfuluaqbxoofvotvfoiexbnprrxptchmlctzg\
                qtkivsilwgwgvpidpvasurraqfkcmxhdapjrlrnkbklwkrvoa\
                ziznlpor\
                """;
        String t = """
                qhxepbshlrhoecdaodgpousbzfcqjxulatciapuftffahhlmx\
                bufgjuxstfjvljybfxnenlacmjqoymvamphpxnolwijwcecgw\
                bcjhgdybfffwoygikvoecdggplfohemfypxfsvdrseyhmvkoo\
                vxhdvoavsqqbrsqrkqhbtmgwaurgisloqjixfwfvwtszcxwkt\
                kwesaxsmhsvlitegrlzkvfqoiiwxbzskzoewbkxtphapavbyv\
                hzvgrrfriddnsrftfowhdanvhjvurhljmpxvpddxmzfgwwpkj\
                rfgqptrmumoemhfpojnxzwlrxkcafvbhlwrapubhveattfifs\
                miounhqusvhywnxhwrgamgnesxmzliyzisqrwvkiyderyotxh\
                wspqrrkeczjysfujvovsfcfouykcqyjoobfdgnlswfzjmyuca\
                xuaslzwfnetekymrwbvponiaojdqnbmboldvvitamntwnyaep\
                pjaohwkrisrlrgwcjqqgxeqerjrbapfzurcwxhcwzugcgnirk\
                krxdthtbmdqgvqxilllrsbwjhwqszrjtzyetwubdrlyakzxcv\
                eufvhqugyawvkivwonvmrgnchkzdysngqdibhkyboyftxcvvj\
                oggecjsajbuqkjjxfvynrjsnvtfvgpgveycxidhhfauvjovmn\
                bqgoxsafknluyimkczykwdgvqwlvvgdmufxdypwnajkncoynq\
                ticfetcdafvtqszuwfmrdggifokwmkgzuxnhncmnsstffqpqb\
                plypapctctfhqpihavligbrutxmmygiyaklqtakdidvnvrjft\
                eazeqmbgklrgrorudayokxptswwkcircwuhcavhdparjfkjyp\
                kyxhbgwxbkvpvrtzjaetahmxevmkhdfyidhrdeejapfbafwmd\
                qjqszwnwzgclitdhlnkaiyldwkwwzvhyorgbysyjbxsspnjde\
                wjxbhpsvj\
                """;
        Assertions.assertEquals('t', solution.findTheDifference(s, t));
    }

}

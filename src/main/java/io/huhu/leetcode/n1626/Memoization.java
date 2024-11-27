package io.huhu.leetcode.n1626;

import io.huhu.MLE;

import java.util.Arrays;

@MLE
class Memoization implements Code {

    private record Member(int age, int score) implements Comparable<Member> {

        @Override
        public int compareTo(Member o) {
            if (this.age == o.age) {
                return this.score - o.score;
            }
            return this.age - o.age;
        }

    }

    @Override
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length, maxAge = 0, maxScore = 0;
        Member[] members = new Member[n];
        for (int i = 0; i < n; i++) {
            maxAge = Math.max(maxAge, ages[i]);
            maxScore = Math.max(maxScore, scores[i]);
            members[i] = new Member(ages[i], scores[i]);
        }
        Arrays.sort(members);
        int[][][] mem = new int[n][maxScore + 1][maxAge + 1];
        for (int[][] a : mem) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return f(members, mem, 0, 0, 0);
    }

    private int f(Member[] members, int[][][] mem, int i, int preMaxScore, int preMaxAge) {
        if (i == members.length) {
            return 0;
        }
        if (mem[i][preMaxScore][preMaxAge] != -1) {
            return mem[i][preMaxScore][preMaxAge];
        }
        int ans = f(members, mem, i + 1, preMaxScore, preMaxAge);
        if (members[i].age() == preMaxAge) {
            ans = Math.max(ans, f(members, mem, i + 1, members[i].score, preMaxAge) + members[i].score);
        }
        if (members[i].age > preMaxAge && members[i].score >= preMaxScore) {
            ans = Math.max(ans, f(members, mem, i + 1, members[i].score, members[i].age) + members[i].score);
        }
        return mem[i][preMaxScore][preMaxAge] = ans;
    }

}

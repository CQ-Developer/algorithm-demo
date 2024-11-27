package io.huhu.leetcode.n1626;

import io.huhu.TLE;

import java.util.Arrays;

@TLE
class DepthFirstSearch implements Code {

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
        int n = scores.length;
        Member[] members = new Member[n];
        for (int i = 0; i < n; i++) {
            members[i] = new Member(ages[i], scores[i]);
        }
        Arrays.sort(members);
        return f(members, 0, 0, 0);
    }

    private int f(Member[] members, int i, int preMaxScore, int preMaxAge) {
        if (i == members.length) {
            return 0;
        }
        int ans = f(members, i + 1, preMaxScore, preMaxAge);
        if (members[i].age() == preMaxAge) {
            ans = Math.max(ans, f(members, i + 1, members[i].score, preMaxAge) + members[i].score);
        }
        if (members[i].age > preMaxAge && members[i].score >= preMaxScore) {
            ans = Math.max(ans, f(members, i + 1, members[i].score, members[i].age) + members[i].score);
        }
        return ans;
    }

}

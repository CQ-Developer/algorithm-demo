package io.huhu.leetcode.n1626;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DynamicProgramming implements Code {

    private record Info(int age, int score) implements Comparable<Info> {

        @Override
        public int compareTo(Info o) {
            if (score == o.score) {
                return age - o.age;
            }
            return score - o.score;
        }

    }

    @Override
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Info[] info = new Info[n];
        for (int i = 0; i < n; i++) {
            info[i] = new Info(ages[i], scores[i]);
        }
        Arrays.sort(info);
        int ans = 0;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (info[j].age <= info[i].age) {
                    f[i] = Math.max(f[i], f[j]);
                }
            }
            f[i] += info[i].score;
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

}

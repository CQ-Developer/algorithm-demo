package io.huhu.other.n2;

class DynamicProgramming implements Code {

    @Override
    public int max(int[][] meetings) {
        int c = -1, ans = 0;
        for (int[] meeting : meetings) {
            if (meeting[0] >= c) {
                c = meeting[1];
                ans++;
            }
        }
        return ans;
    }

}

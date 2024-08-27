package io.huhu.leetcode.topological.sort.n2127;

/**
 * <a href="https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/description/">
 * Maximum Employees to Be Invited to a Meeting
 * </a>
 */
class Solution {

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegress = new int[n];
        for (int i = 0; i < n; i++) {
            indegress[favorite[i]]++;
        }
        int l = 0, r = 0;
        int[] queue = new int[n];
        for (int i = 0; i < n; i++) {
            if (indegress[i] == 0) {
                queue[r++] = i;
            }
        }
        int[] deep = new int[n];
        while (l < r) {
            int f = queue[l++], t = favorite[f];
            deep[t] = Math.max(deep[t], deep[f] + 1);
            if (--indegress[t] == 0) {
                queue[r++] = t;
            }
        }
        int ringA = 0, ringB = 0;
        for (int i = 0; i < n; i++) {
            if (indegress[i] > 0) {
                int size = 1;
                indegress[i] = 0;
                for (int j = favorite[i]; i != j; j = favorite[j]) {
                    size++;
                    indegress[j] = 0;
                }
                if (size == 2) {
                    ringA += 2 + deep[i] + deep[favorite[i]];
                } else {
                    ringB = Math.max(ringB, size);
                }
            }
        }
        return Math.max(ringA, ringB);
    }

}

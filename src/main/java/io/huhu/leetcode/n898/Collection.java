package io.huhu.leetcode.n898;

import java.util.HashSet;
import java.util.Set;

class Collection implements Code {

    @Override
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            ans.add(arr[i]);
            for (int j = i - 1; j >= 0; j--) {
                // arr[i] 是 arr[j] 的子集
                if ((arr[i] | arr[j]) == arr[j]) {
                    // 因为j是从右向左更新的, 所有右侧一定是左侧的子集
                    // 右侧的集合一定包含了左侧的集合, 没有继续更新下去的必要
                    break;
                }
                arr[j] |= arr[i];
                ans.add(arr[j]);
            }
        }
        return ans.size();
    }

}

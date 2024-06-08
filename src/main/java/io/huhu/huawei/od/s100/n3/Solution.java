package io.huhu.huawei.od.s100.n3;

import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }
        String chars = sc.next();

        int ans = 0;
        for (String word : words) {
            if (canSpell(word.toCharArray(), chars.toCharArray())) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static boolean canSpell(char[] word, char[] chars) {
        Arrays.sort(chars);
        int n = 0;
        for (char v : word) {
            int j;
            if ((j = Arrays.binarySearch(chars, v)) >= 0 || (j = Arrays.binarySearch(chars, '?')) >= 0) {
                chars[j] = '.';
                n++;
            }
        }
        return n == word.length;
    }

}

package boj;

import java.util.Scanner;

public class Q1439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] cnt = new int[2];

        cnt[s.charAt(0) - '0']++;
        for(int i = 0; i < s.length(); i++) {
            if(i != 0 && s.charAt(i) != s.charAt(i - 1))
                cnt[s.charAt(i) - '0']++;
        }

        System.out.println(Math.min(cnt[0], cnt[1]));
    }
}

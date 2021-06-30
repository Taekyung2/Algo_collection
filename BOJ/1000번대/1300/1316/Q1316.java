package boj;

import java.util.Scanner;

public class Q1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ret = N;
        while(N-- > 0) {
            String s = sc.next();
            boolean[] chk = new boolean[26];
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(i == 0 || s.charAt(i - 1) != c) {
                    if(chk[c - 'a']) {
                        ret--;
                        break;
                    }
                    chk[c - 'a'] = true;
                }
            }
        }
        System.out.println(ret);
    }
}

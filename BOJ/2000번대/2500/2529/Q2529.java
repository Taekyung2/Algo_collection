package boj;

/**
 * 10! 다 만들어서 해본다..?
 */

import java.util.Scanner;

public class Q2529 {
    static int k;
    static long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
    static char[] sign;
    static int[] pick;
    static boolean[] chk;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        sign = new char[k];
        pick = new int[k + 1];
        chk = new boolean[10];
        for(int i = 0; i < k; i++)
            sign[i] = sc.next().charAt(0);
        perm(0);

        System.out.println(max);
        System.out.println(String.format("%0" + (k + 1) + "d", min));
    }

    public static void perm(int cnt) {
        if(cnt == k + 1) {
            String num = "";
            for(int i = 0; i < k; i++) {
                if((sign[i] == '<' && pick[i] >= pick[i + 1])
                        || (sign[i] == '>' && pick[i] <= pick[i + 1]))
                    return;
                num += pick[i];
            }
            max = Math.max(max, Long.parseLong(num + pick[k]));
            min = Math.min(min, Long.parseLong(num + pick[k]));
            return;
        }

        for(int i = 0; i < 10; i++) {
            if(!chk[i]) {
                chk[i] = true;
                pick[cnt] = i;
                perm(cnt + 1);
                chk[i] = false;
            }
        }
    }
}

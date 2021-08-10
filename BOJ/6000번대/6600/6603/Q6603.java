package boj;

import java.util.Scanner;

public class Q6603 {
    static int k;
    static int[] num, pick;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true) {
            k = sc.nextInt();
            if(k == 0)
                break;

            num = new int[k];
            pick = new int[6];
            for(int i = 0; i < k; i++)
                num[i] = sc.nextInt();
            comb(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void comb(int idx, int cnt) {
        if(cnt == 6) {
            for(int n : pick)
                sb.append(n).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = idx; i < k; i++) {
            pick[cnt] = num[i];
            comb(i + 1, cnt + 1);
        }
    }
}

package boj;

import java.util.Scanner;

public class Q2447 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                star(i, j, N);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void star(int y, int x, int len) {
        if((y / len) % 3 == 1 && (x / len) % 3 == 1)
            sb.append(" ");
        else {
            if(len / 3 == 0)
                sb.append("*");
            else
                star(y, x, len / 3);
        }
    }
}

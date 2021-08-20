package boj;

import java.util.Scanner;

public class Q1074 {
    static int N, R, C, ret = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        C = sc.nextInt();
        divide((int)Math.pow(2, N), 0, 0);
    }

    public static void divide(int len, int y, int x) {
        if(y == R && x == C) {
            System.out.println(ret);
            return;
        }

        if(R >= y && R < y + len && C >= x && C < x + len) {
            len /= 2;
            divide(len, y, x);
            divide(len, y, x + len);
            divide(len, y + len, x);
            divide(len, y + len, x + len);
        } else {
            ret += (len * len);
        }
    }
}
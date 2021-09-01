package boj;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Q9663 {
    static int N, ret = 0;
    static int[] queen;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        queen = new int[N];
        backtrack(0);
        System.out.println(ret);
    }

    public static void backtrack(int n) {
        if(n == N) {
            ret++;
            return;
        }

        for(int x = 0; x < N; x++) {
            if(isPossible(n, x)) {
                queen[n] = x;
                backtrack(n + 1);
            }
        }
    }

    public static boolean isPossible(int y, int x) {
        for(int i = 0; i < y; i++) {
            if(queen[i] == x)
                return false;
            if(Math.abs(x - queen[i]) == Math.abs(y - i))
                return false;
        }
        return true;
    }
}

/**
 * queen[y] = x -> y행 x열에 퀸을 놓았다
 * 행과 열 대각선 모두 만나지 않게 하면서, 마지막 행까지 놓을 수 있는 경우의 수를 다 찾아본다
 */
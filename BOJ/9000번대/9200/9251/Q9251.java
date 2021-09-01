package boj;

import java.io.*;
import java.util.*;

public class Q9251 {
    static char[] A, B;
    static int[][] cache;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        A = sc.next().toCharArray();
        B = sc.next().toCharArray();
        cache = new int[A.length + 1][B.length + 1];
        for(int i = 0; i <= A.length; i++)
            Arrays.fill(cache[i], -1);
        System.out.println(LCS(0, 0));
    }

    public static int LCS(int a, int b) {
        if(a == A.length || b == B.length)
            return 0;
        int ret = cache[a][b];
        if(ret != -1)
            return ret;
        ret = 0;
        if(A[a] == B[b]) {
            ret = Math.max(ret, LCS(a + 1, b + 1) + 1);
        } else {
            ret = Math.max(ret,  LCS(a + 1, b));
            ret = Math.max(ret , LCS(a, b + 1));
        }
        return cache[a][b] = ret;
    }
}

/**
 *  A와 B의 위치를 하나씩 옮겨가면서 전부 비교해본다
 *  서로 값이 같았다면 공통 부분이기 때문에 + 1
 *  같지 않다면 다음 위치로 넘어가자
 */
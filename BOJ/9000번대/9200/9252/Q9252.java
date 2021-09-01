package boj;

import java.io.*;
import java.util.*;

public class Q9252 {
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
        StringBuilder ret = new StringBuilder();
        reconstruct(0, 0, ret);
        System.out.println(ret);
    }

    // 실제 최장 공통 부분 수열 생성하기
    public static void reconstruct(int a, int b, StringBuilder sb) {
        if(a == A.length || b == B.length)
            return;
        if(A[a] == B[b]) {
            reconstruct(a + 1, b + 1, sb.append(A[a]));
        } else if(LCS(a, b + 1) >= LCS(a + 1, b)){
            reconstruct(a, b + 1, sb);
        } else
            reconstruct(a + 1, b, sb);
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
 *  앞서 만들었던 LCS 메소드를 이용해서 실제 최장공통부분수열을 구합니다.
 *  1. A[a]와 B[b]가 같다면 선택합니다
 *  2. 다음 위치로 넘어갈 때 최장 공통 부분 수열의 길이가 긴 쪽을 선택해서 만듭니다
 */
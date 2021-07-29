package boj;

/**
 * # 계획
 * A 행렬을 B 행렬로 바꾸기
 * toggle 형태이기 때문에 뒤집지 않은 거랑 2번 뒤집은거랑 같음
 * 행렬을 순회하면서 A행렬과 B행렬이 다르면 뒤집는다
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q1080 {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[][] A, B;

    public static void main(String[] args){
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n][m];
        B = new int[n][m];
        int ret = 0;

        input(A);
        input(B);


        for(int i = 0; i < n - 2; i++) {
            for(int j = 0; j < m - 2; j++) {
                if(A[i][j] != B[i][j]) {
                    for(int ii = 0; ii < 3; ii++)
                        for(int jj = 0; jj < 3; jj++)
                            A[i + ii][j + jj] = (A[i + ii][j + jj] + 1) % 2;
                    ret++;
                }
            }
        }

        if(Arrays.deepEquals(A, B))
            System.out.println(ret);
        else
            System.out.println(-1);
    }

    public static void input(int[][] arr) {
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++)
                arr[i][j] = s.charAt(j) - '0';
        }
    }
}

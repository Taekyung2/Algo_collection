package boj;

import java.util.Scanner;

public class Q8979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] arr = new int[N][4];
        int[] rank = new int[N + 1];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < 4; j++)
                arr[i][j] = sc.nextInt();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][1] < arr[j][1]
                    || (arr[i][1] == arr[j][1] && arr[i][2] < arr[j][2])
                    || (arr[i][1] == arr[j][1] && arr[i][2] == arr[j][2] && arr[i][3] < arr[j][3]))
                    rank[arr[i][0]]++;
            }
        }

        System.out.println(rank[K] + 1);
    }
}

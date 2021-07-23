package boj;

import java.util.Arrays;
import java.util.Scanner;

// 정리
public class Q1463 {
    static int ret = Integer.MAX_VALUE;
    static int[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        visited = new int[N + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        dfs(N, 0);

        System.out.println(ret);
    }

    public static void dfs(int n, int cnt) {
        if(n == 1) {
            ret = Math.min(ret, cnt);
            return;
        }
        if(visited[n] < cnt)
            return;
        visited[n] = cnt;
        if(n % 3 == 0)
            dfs(n / 3, cnt + 1);
        if(n % 2 == 0)
            dfs(n / 2, cnt + 1);
        dfs(n - 1, cnt + 1);
    }
}

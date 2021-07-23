package boj;

import java.util.Scanner;

public class Q14889 {
    static int n, ret = Integer.MAX_VALUE;
    static int[][] team;
    static boolean[] divide;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        team = new int[n][n];
        divide = new boolean[n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                team[i][j] = sc.nextInt();
        pick(0, 0);
        System.out.println(ret);
    }

    public static void pick(int cnt, int idx) {
        if(cnt == n / 2) {
            int sum = 0;
            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    if(divide[i] && divide[j])
                        sum += (team[i][j] + team[j][i]);
                    else if(!divide[i] && !divide[j])
                        sum -= (team[i][j] + team[j][i]);
                }
            }
            ret = Math.min(ret, Math.abs(sum));
            return;
        }

        for(int i = idx + 1; i < n; i++) {
            if(!divide[i]) {
                divide[i] = true;
                pick(cnt + 1, i);
                divide[i] = false;
            }
        }
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Q1010 {
    static int n, m;
    static int[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            n = sc.nextInt();
            m = sc.nextInt();
            cache = new int[m + 1][n + 1];
            for(int i = 0; i <= m; i++)
                Arrays.fill(cache[i], -1);
            System.out.println(solve(m, n));
        }
    }

    public static int solve(int n, int r) {
        if(n == r || r == 0) return 1;
        int ret = cache[n][r];
        if(ret != -1) return ret;
        return cache[n][r] = solve(n - 1, r - 1) + solve(n - 1, r);
    }
}
import java.util.Scanner;

public class Q9084 {
    static int N, M;
    static int[] coin;
    static int[][] cache;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            N = sc.nextInt();
            coin = new int[N];
            for(int i = 0; i < N; i++)
                coin[i] = sc.nextInt();
            M = sc.nextInt();
            cache = new int[N + 1][M + 1];
            System.out.println(dp(0, M));
        }
    }


    public static int dp(int c, int price) {
        if(price < 0) return 0;
        if(price == 0) return 1;
        int ret = cache[c][price];
        if(ret != 0)
            return ret;

        for(int i = c; i < N; i++) {
            ret += dp(i, price - coin[i]);
        }

        return cache[c][price] = ret;
    }
}

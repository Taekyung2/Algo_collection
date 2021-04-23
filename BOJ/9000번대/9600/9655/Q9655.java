import java.util.Scanner;

public class Q9655 {
    static int[][] winner = new int[1001][3];
    static int SK = 2;
    static int CY = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (whoIsWinner(N, SK) == SK)
            System.out.println("SK");
        else
            System.out.println("CY");
    }

    private static int whoIsWinner(int n, int turn) {
        int opponent = turn == SK ? CY : SK;
        if (n < 1) return 0;
        if (n == 1) winner[n][turn] = turn;
        if (n == 2) winner[n][turn] = opponent;
        if (n == 3) winner[n][turn] = turn;
        if (winner[n][turn] == 0)
            winner[n][turn] = Math.max(whoIsWinner(n-1, opponent), whoIsWinner(n-3, opponent));

        return winner[n][turn];
    }
}
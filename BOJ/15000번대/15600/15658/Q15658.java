package boj;

import java.util.Scanner;

public class Q15658 {
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        int[] op = new int[4];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        for(int i = 0; i < 4; i++)
            op[i] = sc.nextInt();

        sol(1, arr[0], op);
        System.out.println(max + "\n" + min);
    }

    public static void sol(int cnt, int ans, int[] op) {
        if(cnt == N) {
            min = Math.min(min, ans);
            max = Math.max(max, ans);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(op[i] > 0) {
                op[i]--;
                sol(cnt + 1, calc(ans, arr[cnt], i), op);
                op[i]++;
            }
        }
    }

    public static int calc(int a, int b, int op) {
        return switch (op) {
            case 0 -> a + b;
            case 1 -> a - b;
            case 2 -> a * b;
            case 3 -> a / b;
            default -> -1;
        };
    }
}

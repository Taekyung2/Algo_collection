import java.util.Scanner;

public class Q9934 {
    static int K;
    static int[] order;
    static StringBuilder[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        order = new int[(int)Math.pow(2, K) - 1];
        for(int i = 0; i < order.length; i++)
            order[i] = sc.nextInt();
        ans = new StringBuilder[K];
        for(int i = 0; i < K; i++)
            ans[i] = new StringBuilder();

        construct(0, order.length - 1, 0);
        for(StringBuilder sb : ans)
            System.out.println(sb);
    }

    public static void construct(int s, int e, int depth) {
        if(depth == K) return;
        int mid = (s + e) / 2;
        ans[depth].append(order[mid]).append(" ");

        construct(s, mid - 1, depth + 1);
        construct(mid + 1, e, depth + 1);
    }
}

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] weight = new int[N];
        int[] height = new int[N];
        int[] rank = new int[N];
        Arrays.fill(rank, 1);


        for(int i = 0; i < N; i++) {
            weight[i] = sc.nextInt();
            height[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                if(weight[i] < weight[j] && height[i] < height[j])
                    rank[i]++;

        for(int n : rank)
            System.out.print(n + " ");
    }
}

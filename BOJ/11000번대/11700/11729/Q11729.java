package boj;

import java.util.Scanner;

public class Q11729 {
    static int ret = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        hanoi(N, 1, 2, 3);
        System.out.println(ret);
        System.out.println(sb);
    }

    public static void hanoi(int size, int from, int other, int to) {
        if(size == 0)
            return;

        hanoi(size - 1, from, to, other);
        sb.append(from).append(" ").append(to).append("\n");
        ret++;
        hanoi(size - 1, other, from, to);
    }
}

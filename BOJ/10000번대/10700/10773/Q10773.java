package boj;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q10773 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        for(int i = 0; i < K; i++) {
            int n = sc.nextInt();
            if(n == 0)
                stk.pop();
            else
                stk.push(n);
        }

        System.out.println(stk.stream().reduce(0, Integer::sum));
    }
}

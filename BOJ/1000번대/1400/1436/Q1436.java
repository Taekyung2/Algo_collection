package boj;

import java.util.Scanner;

public class Q1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), i;
        for(i = 666; N > 0; i++) {
            if(Integer.toString(i).contains("666"))
                N--;
        }
        System.out.println(i - 1);
    }
}

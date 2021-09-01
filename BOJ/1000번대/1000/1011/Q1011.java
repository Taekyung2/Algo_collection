package boj;

import java.util.Scanner;

public class Q1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            long distance = 0, cur = 1;
            while(distance < y - x) {
                distance += (cur + 1) / 2;
                cur++;
            }
            System.out.println(cur - 1);
        }
    }
}
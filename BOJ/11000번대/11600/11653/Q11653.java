package boj;

import java.util.Scanner;

public class Q11653 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int num = 2;
        while(N != 1) {
            if(N % num == 0) {
                System.out.println(num);
                N /= num;
            } else {
                num++;
            }
        }
    }
}

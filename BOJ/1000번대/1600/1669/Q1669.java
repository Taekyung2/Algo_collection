package boj;

import java.util.Scanner;

/**
 *  #계획
 *  원숭이 X, 멍멍이 Y
 *  첫 째날과 마지막 날은 무조건 1cm
 *  1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1 -> (1, 1), (2, 2), (3, 3) ... 더해가면서 멍멍이 키가 되면 종료
 */

public class Q1669 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        long d = 0;
        int day = 1;
        while(d < Y - X) {
            d += (day + 1) / 2;
            day++;
        }
        System.out.println(day - 1);
    }
}
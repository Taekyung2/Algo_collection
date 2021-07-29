package boj;

/**
 * # 계획
 * -가 나왔을 때 뒤의 숫자를 최대한 크게 만들면 최소가 될 것 같음
 * -가 나오고 다음 -가 나올 때까지 괄호로 묶자
 */

import java.util.Scanner;

public class Q1541 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        boolean chk = false;

        int n = 0, ret = 0;
        for(char c : s) {
            if (Character.isDigit(c)) {
                n = (n * 10) + (c - '0');
            } else {
                if(chk) ret -= n;
                else    ret += n;
                n = 0;
            }

            if(c == '-')
                chk = true;
        }

        if(chk) ret -= n;
        else    ret += n;
        System.out.println(ret);
    }
}

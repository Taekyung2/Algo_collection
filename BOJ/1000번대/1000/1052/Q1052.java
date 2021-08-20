package boj;

/**
 *  # 계획
 *  1. K개를 넘지 않는 비어있지 않은 물병을 만들기
 *  2. ex) 3은 2리터 물병 1개 1리터 물병 1개, 여기에 1리터 물병 하나 더 있으면 4리터 물병 1개로 만들기 가능 -> 비트 카운트
 */

import java.util.Scanner;

public class Q1052 {
    public static void main(String[] args){
        var sc = new Scanner(System.in);
        var N = sc.nextInt();
        var K = sc.nextInt();
        var ret = 0;
        while(Integer.bitCount(N++) > K)
            ret++;
        System.out.println(ret);
    }
}

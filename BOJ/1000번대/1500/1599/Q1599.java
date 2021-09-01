package boj;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Q1599 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        IntStream.range(0, N)
                .mapToObj(i -> sc.next().replace("k", "c").replace("ng", "n~"))
                .sorted()
                .map(s -> s.replace("c", "k").replace("n~", "ng"))
                .forEach(System.out::println);
    }
}

/**
 *  # 계획
 *  1. k를 c로 바꾸고 시작한다
 *  2. ng를 'n~'로 바꾼다
 *  3. 알파벳 순서대로 정렬
 *  4. 바꾼 문자를 원래대로 복구
 */

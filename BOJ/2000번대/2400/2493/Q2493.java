package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Q2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = stoi(br.readLine());
        Top[] tops = Arrays.stream(br.readLine().split(" "))
                .map(s -> new Top(Integer.parseInt(s)))
                .toArray(Top[]::new);
        int[] ret = new int[N];
        ArrayDeque<Top> stk = new ArrayDeque<>();
        for(int i = N - 1; i >= 0; i--) {
            Top cur = tops[i];

            while(!stk.isEmpty() && stk.peek().height <= cur.height)
                ret[stk.pop().idx - 1] = cur.idx;

            stk.push(cur);
        }
        for(int n : ret)
            sb.append(n).append(" ");
        System.out.println(sb);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Top {
        static int cnt = 1;
        int idx, height;

        Top(int height) {
            this.idx = cnt++;
            this.height = height;
        }
    }
}

/**
 *  #계획
 *  1. N = 500000 -> BufferedReader 사용
 *  2. (6, 9, 5, 7, 4)
 *      - 스택 생성
 *      - 배열 맨 뒤부터 시작, 4를 스택에 넣는다
 *      - 그 다음 7이 들어오면, 스택의 맨 위 숫자가 7보다 작은지 확인
 *      - 7보다 작다면 4는 7의 탑에서 수신가능
 *      - 배열 첫번째까지 반복
 */
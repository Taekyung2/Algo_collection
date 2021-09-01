package boj;

import java.util.Scanner;

public class Q3495 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(), w = sc.nextInt();
        double cnt = 0;
        for(int i = 0; i < h; i++) {
            String s = sc.next();
            int chk = 0;
            for (int j = 0; j < w; j++) {
                char c = s.charAt(j);
                if (c == '/' || c == '\\') {
                    cnt += 0.5;
                    chk++;
                }
                if (chk % 2 == 1 && c == '.')
                    cnt++;
            }
        }
        System.out.println((int)cnt);
    }
}

/**
 *   1. '/'가 나오면 0.5, 그 다음 대각선이 나올 때까지 점의 개수마다 + 1
 *   2. 모든 높이별로 값을 구하자
 */
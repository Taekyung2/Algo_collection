package boj;

import java.io.*;
import java.util.*;

public class Q5430 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            StringBuilder sb = new StringBuilder();
            char[] func = sc.next().toCharArray();
            int n = sc.nextInt();
            int f = 0, b = n - 1;
            boolean chk = true;
            String s = sc.next();
            String[] arr = s.substring(1, s.length() - 1).split(",");
            for(char c : func) {
                if(c == 'R')
                    chk = !chk;
                else {
                    if(chk) f++;
                    else b--;
                }
            }

            if(f > b + 1) {
                sb.append("error");
                System.out.println(sb);
                continue;
            }

            sb.append("[");
            if(chk)
                for(int i = f; i <= b; i++)
                    sb.append(arr[i]).append(",");
            else
                for(int i = b; i >= f; i--)
                    sb.append(arr[i]).append(",");

            if(f - b != 1)
                sb.delete(sb.length() - 1, sb.length());
            sb.append("]");
            System.out.println(sb);
        }
    }
}

/**
 *  R = 뒤집기, D = 첫 번째 숫자 버리기
 *  첫 번째 숫자를 버리는 것은, 시간이 걸리지 않지만, R이 나올 때마다 뒤집는 것은 시간이 매우 오래걸릴 것
 *  R이 나오면, 오른쪽 방향에서 왼쪽 방향으로 바꾸고 커서를 뒤로 옮기면 뒤집는 형태가 되겠다.
 *  D가 나오면, 커서를 한 칸 옮긴다
 *  다 끝나면, 마지막에 설정된 방향으로, 양 방향 커서 사이에 수를 출력하자
 */
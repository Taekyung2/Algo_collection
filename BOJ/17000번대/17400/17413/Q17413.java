package boj;

/**
 * # 계획
 *  1. <가 나오면 >가 나올 때까지 stringbuilder에 그대로 넣는다
 *  2. 공백이 나오기 전까지 스택에 입력하고 공백이 나오면 stringbuilder에 pop()
 *
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q17413 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] s = sc.nextLine().toCharArray();
        ArrayDeque<Character> stk = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        boolean chk = false;

        for(char c : s) {
            if(c == '<') {
                chk = true;
                while(!stk.isEmpty())
                    sb.append(stk.pop());
                sb.append(c);
            } else if(c == '>') {
                chk = false;
                sb.append(c);
            } else if(chk) {
                sb.append(c);
            } else if(!chk) {
                if(c == ' ') {
                    while(!stk.isEmpty())
                        sb.append(stk.pop());
                    sb.append(c);
                } else
                    stk.push(c);
            }
        }
        while(!stk.isEmpty())
            sb.append(stk.pop());

        System.out.println(sb);
    }
}

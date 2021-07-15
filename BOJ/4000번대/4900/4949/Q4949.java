package boj;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q4949 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true) {
            String s = sc.nextLine();
            if(s.equals("."))
                break;

            ArrayDeque<Character> stk = new ArrayDeque<>();
            boolean chk = true;
            loop:
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '(' || c == '[') {
                    stk.push(c);
                } else if(c == ')') {
                    if(stk.isEmpty() || stk.pop() != '(') {
                        chk = false;
                        break loop;
                    }
                } else if(c == ']') {
                    if (stk.isEmpty() || stk.pop() != '[') {
                        chk = false;
                        break loop;
                    }
                }
            }
            if(!stk.isEmpty())
                chk = false;

            if(chk) sb.append("yes");
            else sb.append("no");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

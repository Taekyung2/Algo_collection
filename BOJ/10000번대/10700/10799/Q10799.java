package boj;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q10799 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        ArrayDeque<Character> stk = new ArrayDeque<>();

        char prev = ' ';
        int ret = 0;
        for(char c : s) {
            if(c == '(') {
                stk.push(c);
            } else if(c == ')' && prev == ')') {
                stk.pop();
                ret++;
            } else {
                stk.pop();
                ret += stk.size();
            }
            prev = c;
        }

        System.out.println(ret);
    }
}

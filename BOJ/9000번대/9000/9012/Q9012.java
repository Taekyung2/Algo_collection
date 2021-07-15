package boj;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q9012 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            String s = sc.next();
            if(check(s))    System.out.println("YES");
            else            System.out.println("NO");
        }
    }

    public static boolean check(String s) {
        ArrayDeque<Character> stk = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(')
                stk.push(c);
            else {
                if(stk.isEmpty())
                    return false;
                stk.pop();
            }
        }

        return stk.isEmpty();
    }
}

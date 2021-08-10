package boj;

/**
 * # 계획
 * - 괄호 안에 괄호가 있다면 곱 처리, 같은 레벨로 있다면 합 처리
 * - (()[[]])([])
 *      ( -> tmp = 2, ret = 0
 *      ( -> tmp = 4, ret = 0
 *      ) -> tmp = 2, ret = 4
 *      [ -> tmp = 6, ret = 4
 *      [ -> tmp = 18, ret = 4
 *      ] -> tmp = 6, ret = 22
 *      ] -> tmp = 2, ret = 22
 *      ) -> tmp = 1, ret = 22
 *      .....
 *
 *
 *
 */

import java.util.*;

public class Q2504 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] blank = sc.next().toCharArray();
        ArrayDeque<Character> opStack = new ArrayDeque<>();

        int ret = 0, tmp = 1;
        char prev = ' ';
        for(Character c : blank) {
            if(c == '(') {
                opStack.push(c);
                tmp *= 2;
            } else if(c == '[') {
                opStack.push(c);
                tmp *= 3;
            } else if(c == ')') {
                if(prev == '(') {
                    ret += tmp;
                }
                if(opStack.isEmpty() || opStack.peek() != '(') {
                    ret = 0;
                    break;
                }
                tmp /= 2;
                opStack.pop();
            } else if(c == ']') {
                if(prev == '[')
                    ret += tmp;
                if(opStack.isEmpty() || opStack.peek() != '[') {
                    ret = 0;
                    break;
                }
                tmp /= 3;
                opStack.pop();
            }
            prev = c;
        }

        System.out.println(opStack.isEmpty() ? ret : 0);
    }
}

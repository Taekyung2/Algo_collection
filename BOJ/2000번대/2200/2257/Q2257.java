package boj;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q2257 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] expression = sc.next().toCharArray();
        ArrayDeque<Integer> stk = new ArrayDeque<>();

        for(char c : expression) {
            if(c == ')') {
                int sum = 0;
                while(stk.peek() != 0)
                    sum += stk.pop();
                stk.pop();
                stk.push(sum);
            } else if(Character.isDigit(c)){
                stk.push(stk.pop() * (c - '0'));
            } else
                stk.push(getWeight(c));
        }

        System.out.println(stk.stream().mapToInt(Integer::intValue).sum());
    }

    public static int getWeight(char c) {
        if(c == 'H') return 1;
        else if(c == 'C') return 12;
        else if(c == 'O') return 16;
        else return 0;
    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        boolean chk = true;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stk = new ArrayDeque<>();

        int cur = 1;
        while(N-- > 0) {
            int n = stoi(br.readLine());
            while(stk.isEmpty() || n > stk.peek()) {
                stk.push(cur++);
                sb.append("+").append("\n");
            }

            if(stk.peek() == n) {
                stk.pop();
                sb.append("-").append("\n");
            } else if(n < stk.peek()) {
                chk = false;
                break;
            }
        }

        if(chk)
            System.out.println(sb);
        else
            System.out.println("NO");
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

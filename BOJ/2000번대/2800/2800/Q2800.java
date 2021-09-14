package boj;

import java.io.*;
import java.util.*;

public class Q2800 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Deque<Integer> stk = new ArrayDeque<>();
        List<int[]> pair = new ArrayList<>();
        List<String> ret = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == '(') {
                stk.push(i);
            } else if(c == ')') {
                int s = stk.pop();
                pair.add(new int[]{s, i});
            }
        }

        int len = pair.size();
        // 괄호 쌍의 개수의 부분집합만큼 괄호 삭제
        for(int i = 1; i < (1 << len); i++) {
            List<Integer> chk = new ArrayList<>();
            StringBuilder tmp = new StringBuilder(str);
            for(int j = 0; j < len; j++) {
                if((i & (1 << j)) != 0) {
                    chk.add(pair.get(j)[0]);
                    chk.add(pair.get(j)[1]);
                }
            }

            chk.sort(Comparator.reverseOrder());
            for(int n : chk)
                tmp.deleteCharAt(n);

            ret.add(tmp.toString());
        }

        ret.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }
}
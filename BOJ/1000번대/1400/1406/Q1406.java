package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//정리
public class Q1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        List<Character> list = new LinkedList<>();
        for(char c : s)
            list.add(c);

        int M = stoi(br.readLine());
        ListIterator<Character> li = list.listIterator(list.size());
        for(int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");
            switch(command[0]) {
                case "L":
                    if(li.hasPrevious())
                        li.previous();
                    break;
                case "D":
                    if(li.hasNext())
                        li.next();
                    break;
                case "B":
                    if(li.hasPrevious()) {
                        li.previous();
                        li.remove();
                    }
                    break;
                case "P":
                    li.add(command[1].charAt(0));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : list)
            sb.append(c);
        System.out.println(sb);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

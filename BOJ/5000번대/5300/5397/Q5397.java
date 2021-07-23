package boj;

import java.io.*;
import java.util.*;

public class Q5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            char[] s = br.readLine().toCharArray();
            List<Character> list = new LinkedList<>();
            ListIterator<Character> li = list.listIterator();
            for(char c : s) {
                switch (c) {
                    case '<' -> {
                        if (li.hasPrevious())
                            li.previous();
                    }

                    case '>' -> {
                        if (li.hasNext())
                            li.next();
                    }
                    case '-' -> {
                        if (li.hasPrevious()) {
                            li.previous();
                            li.remove();
                        }
                    }
                    default -> li.add(c);
                }
            }
            list.forEach(sb::append);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

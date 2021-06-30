package boj;

import java.util.*;

public class Q1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> s = new HashSet<>();
        int N = sc.nextInt();
        for(int i = 0; i < N; i++)
            s.add(sc.next());

        List<String> list = new ArrayList<>(s);
        list.sort((s1, s2) -> {
            if(s1.length() == s2.length())
                return s1.compareTo(s2);
            return s1.length() - s2.length();
        });

        for(String str : list)
            System.out.println(str);
    }
}


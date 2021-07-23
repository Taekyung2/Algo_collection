package boj;

import java.util.*;

public class Q14425 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++)
            set.add(sc.next());

        List<String> list = new ArrayList<>();
        for(int i = 0; i < m; i++)
            list.add(sc.next());
        System.out.println(list.stream().filter(s -> set.contains(s)).count());
    }
}

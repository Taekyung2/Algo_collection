package boj;

import java.util.*;

public class Q9375 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while(tc-- > 0) {
            HashMap<String, List<String>> hm = new HashMap<>();
            int n = sc.nextInt();
            int ans = 1;
            for(int i = 0; i < n; i++) {
                String a = sc.next(), b = sc.next();
                hm.putIfAbsent(b, new ArrayList<>());
                hm.get(b).add(a);
            }

            for(List<String> l : hm.values())
                ans *= (l.size() + 1);
            System.out.println(ans - 1);
        }
    }
}

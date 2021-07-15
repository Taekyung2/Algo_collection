package boj;

import java.util.HashMap;
import java.util.Scanner;

public class Q1620 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        HashMap<String, String> name = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            String s = sc.next();
            name.put(s, Integer.toString(i));
            name.put(Integer.toString(i), s);
        }

        for(int i = 0; i < M; i++)
            System.out.println(name.get(sc.next()));
    }
}

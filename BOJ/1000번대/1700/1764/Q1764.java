package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = stoi(in[0]);
        int M = stoi(in[1]);

        HashSet<String> hs1 = new HashSet<>();
        HashSet<String> hs2 = new HashSet<>();

        for(int i = 0; i < N; i++)
            hs1.add(br.readLine());

        for(int i = 0; i < M; i++)
            hs2.add(br.readLine());

        hs1.retainAll(hs2);
        System.out.println(hs1.size());
        hs1.stream().sorted().forEach(System.out::println);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

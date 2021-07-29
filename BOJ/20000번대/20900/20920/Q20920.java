package boj;

/**
 * # 계획
 *  1. 자주 나오는 단어 순
 *  2. 단어 길이가 길수록 앞
 *  3. 알파벳 사전순으로
 *  4. M길이 이상 단어만 출력
 *  -> Stream, Comparator 사용
 */

import java.io.*;
import java.util.*;

public class Q20920 {
    static int N, M;
    static HashMap<String, Integer> dict = new HashMap<>();
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() < M) continue;
            dict.put(s, dict.getOrDefault(s, 0) + 1);
            if(dict.get(s) == 1) list.add(s);
        }
        list.sort((s1, s2) -> {
            if (dict.get(s1) == dict.get(s2))
                if (s1.length() == s2.length()) return s1.compareTo(s2);
                else return s2.length() - s1.length();
            else return dict.get(s2) - dict.get(s1);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : list)
            sb.append(s).append("\n");
        System.out.println(sb);
    }
}

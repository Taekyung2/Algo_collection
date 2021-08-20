package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = stoi(br.readLine());
        while(tc-- > 0) {
            int N = stoi(br.readLine());
            Score[] arr = new Score[N];
            for(int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                arr[i] = new Score(stoi(input[0]), stoi(input[1]));
            }

            Arrays.sort(arr, (s1, s2) -> {
                if(s1.document == s2.document)
                    return s2.interview - s1.interview;
                return s1.document - s2.document;
            });

            int ret = 0, cur = N + 1;

            for(var s : arr) {
                if(s.interview < cur) {
                    ret++;
                    cur = s.interview;
                }
            }

            System.out.println(ret);
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Score {
        int document, interview;

        Score(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
    }
}

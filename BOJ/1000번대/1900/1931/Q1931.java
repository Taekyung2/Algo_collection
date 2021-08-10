package boj;

/**
 *   - 끝나는 시간이 빠른 순서대로, 시작 시간이 빠른 순서대로 정렬
 *   - 현재 진행 중인 회의가 끝났을 때, 끝나는 시간보다 시작시간이 크거나 같고 끝나는 시간이 가장 작은 회의를 고른다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for(int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            meetings[i] = new Meeting(stoi(s[0]), stoi(s[1]));
        }

        Arrays.sort(meetings, (m1, m2) -> {
            if(m1.e == m2.e)
                return m1.s - m2.s;
            return m1.e - m2.e;
        });

        int meetingTime = 0, cnt = 0;
        for(Meeting m : meetings) {
            if(m.s >= meetingTime) {
                cnt++;
                meetingTime = m.e;
            }
        }

        System.out.println(cnt);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Meeting {
        int s, e;

        Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}

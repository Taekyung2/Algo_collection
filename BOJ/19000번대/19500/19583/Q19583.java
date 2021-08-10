package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * # 계획
 * 1.  ~ 개강 총회 시작 ~ 개강 총회 종료 ~ 스트리밍 종료
 * 2. 개강 총회 시작 전 채팅친 닉네임을 맵에 넣는다
 * 3. 개강 총회 종료후 ~ 스트리밍 종료까지 채팅을 친 닉네임 중 맵에 입장 기록이 있다면 카운
 */

public class Q19583 {
    static int stoi(String s) { return Integer.parseInt(s); }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int[] time = new int[3];
        for(int i = 0; i < 3; i++)
            time[i] = getMinute(tmp[i]);
        HashMap<String, Boolean> check = new HashMap<>();
        int ret = 0;
        String input;
        while((input = br.readLine()) != null) {
            String[] log = input.split(" ");
            int t = getMinute(log[0]);
            String name = log[1];
            if(t <= time[0]) {
                check.put(name, false);
            } else if(t >= time[1] && t <= time[2]) {
                if(!check.getOrDefault(name, true)) {
                    check.put(name, true);
                    ret++;
                }
            }
        }
        System.out.println(ret);
    }

    static int getMinute(String s) {
        String[] tmp = s.split(":");
        return stoi(tmp[0]) * 60 + stoi(tmp[1]);
    }
}

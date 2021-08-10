package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q18870 {
    static int N;
    static List<Integer> arr, sortedArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");

        arr = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(tmp[i]);
            arr.add(n);
        }

        sortedArr = arr.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        arr.stream()
                .map(Q18870::lower_bound)
                .forEach(n -> sb.append(n).append(" "));

        System.out.println(sb);
    }

    public static int lower_bound(int target){
        int lo = 0, hi = sortedArr.size() - 1;

        while(lo < hi){
            int mid = (lo + hi ) / 2;
            if(sortedArr.get(mid) >= target)
                hi = mid;
            else
                lo = mid + 1;
        }

        return hi;
    }
}

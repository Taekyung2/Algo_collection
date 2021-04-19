import java.util.*;

public class _1208 {
    static int N, S;
    static List<Integer> a_sum = new ArrayList<>();
    static List<Integer> b_sum = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            if(i < N / 2)
                a.add(tmp);
            else
                b.add(tmp);
        }

        for(int i = 0; i < (1 << a.size()); i++)
            check(a, i, true);
        for(int i = 0; i < (1 << b.size()); i++)
            check(b, i, false);

        Collections.sort(b_sum);
        long ret = 0;
        for(int num : a_sum) {
            int target = S - num;
            ret += upperBound(b_sum, target) - lowerBound(b_sum, target);
        }
        System.out.println((S == 0) ? ret - 1 : ret);
    }

    static void check(List<Integer> li, int set, boolean type) {
        int sum = 0;
        for(int i = 0; i < li.size(); i++) {
            if((set & (1 << i)) != 0)
                sum += li.get(i);
        }

        if(type) a_sum.add(sum);
        else b_sum.add(sum);
    }

    static int lowerBound(List<Integer> li, int n) {
        int lo = 0, hi = li.size();
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(li.get(mid) >= n) hi = mid;
            else lo = mid + 1;
        }
        return hi;
    }

    static int upperBound(List<Integer> li, long n) {
        int lo = 0, hi = li.size();
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(li.get(mid) <= n) lo = mid + 1;
            else hi = mid;
        }
        return hi;
    }
}

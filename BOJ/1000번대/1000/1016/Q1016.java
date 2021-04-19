import java.util.*;

public class Q1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        long count = max - min + 1;
        boolean[] chk = new boolean[(int)count];
        int n = 2;
        while(Math.pow(n, 2) <= max) {
            long square = (long)Math.pow(n, 2);
            long i = min / square;

            while(square * i <= max) {
                long idx = square * i - min;
                if(idx >= 0 && !chk[(int)idx]) {
                    count--;
                    chk[(int)idx] = true;
                }
                i++;
            }
            n++;
        }
        System.out.println(count);
    }
}
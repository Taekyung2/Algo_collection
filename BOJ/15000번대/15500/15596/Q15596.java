package boj_algorithm._15500;

public class Q15596 {
    long sum(int[] a) {
        long ret = 0;
        for(int n : a)
            ret += n;
        return ret;
    }
}
import java.util.HashSet;
import java.util.Scanner;

public class Q14425 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int ret = 0;

        for(int i = 0; i < N; i++)
            hs.add(sc.next());

        for(int iter = 0; iter < M; iter++) {
            if(hs.contains(sc.next()))
                ret++;
        }
        System.out.println(ret);
    }
}

import java.util.Scanner;

public class Q5618 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        int min = (int)1e9;
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            min = Math.min(min, arr[i]);
        }

        for(int i = 1; i <= min; i++) {
            boolean chk = true;
            for(int j = 0; j < N; j++) {
                if (arr[j] % i != 0) {
                    chk = false;
                    break;
                }
            }
            if(chk)
                System.out.println(i);
        }
    }
}

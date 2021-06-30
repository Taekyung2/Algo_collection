import java.util.Scanner;

public class Q5875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] bracket = sc.next().toCharArray();
        int open = 0, close = 0, cnt = 0, ret = 0;
        for(char c : bracket) {
            if(c == '('){
                cnt++;
                open++;
            } else {
                cnt--;
                close++;
            }

            if(cnt == -1) {
                ret = close;
                break;
            } else if(cnt <= 1)
                open = 0;
        }
        if(cnt > 0) ret = open;
        System.out.println(ret);
    }
}

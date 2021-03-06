package boj_algorithm._2800;

import java.util.Scanner;

public class Q2869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		int ret = 0;
		int hi = v, lo = 0, mid = v / 2, day = a - b;
		while(true) {
			ret = mid / day;
			if(v - (day * ret) > a)
				lo = mid;
			else if(v - (day * ret) == a)
				break;
			else {
				if(mid + a - v >= day)
					hi = mid;
				else
					break;
			}
			mid = (hi + lo) / 2;
		}
		System.out.println(ret + 1);
		sc.close();
	}
}

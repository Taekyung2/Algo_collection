package boj_algorithm._2400;

import java.util.Scanner;

public class Q2475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ret = 0;
		for(int i = 0; i < 5; i++) {
			int a = sc.nextInt();
			ret += (a * a) % 10;
		}
		System.out.println(ret % 10);
	}
}

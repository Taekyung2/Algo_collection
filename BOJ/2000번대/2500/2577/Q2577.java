package boj_algorithm._2500;

import java.util.Scanner;

public class Q2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextInt() * sc.nextInt() * sc.nextInt() + "";
		int[] arr = new int[10];
		for(int i = 0; i < str.length(); i++) 
			arr[str.charAt(i) - '0']++;
		for(int i = 0; i < 10; i++)
			System.out.println(arr[i]);
		sc.close();
	}
}

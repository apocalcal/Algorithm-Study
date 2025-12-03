/*
 * 문제: SWEA 2058. 자릿수 더하기 (D1)
 * 내용: 각 자릿수의 합을 계산하는 문제
 */

package SWEA.D1.p2058;

import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = 0;
		N = sc.nextInt();
		int num = 0;
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			num = N % 10;
			sum += num;
			N = N / 10;
		}
		sum = sum + N;
		System.out.println(sum);
		sc.close();
	}
	
}

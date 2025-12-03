/*
 * 문제: SWEA 2063. 중간값 찾기 (D1)
 * 내용: 배열 중앙에 위치한 수치를 찾는 문제
 */

package SWEA.D1.p2063;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = 0;
		N = sc.nextInt();

		int[] res = new int[N];
		for (int i = 0; i < N; i++) {
			res[i] = sc.nextInt();
		}
		Arrays.sort(res);
		int answer = res[N / 2];
		System.out.println(answer);
		sc.close();
	}
	
}

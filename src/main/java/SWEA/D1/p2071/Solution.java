/*
 * 문제: SWEA 2071. 평균값 구하기 (D1)
 * 내용: 평균값을 출력하는 문제
 */

package SWEA.D1.p2071;

import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int num = 0;
		int sum = 0;
		double avg = 0;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			sum = 0;
			for (int i = 0; i <= 9; i++ ) {
				num = sc.nextInt();
				sum += num;
			}
			avg = Math.round(sum / 10.0);
			System.out.println("#" + test_case + " " + avg);
			}
		} 
	}
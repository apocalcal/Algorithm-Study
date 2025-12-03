/*
 * 문제: SWEA 2070. 큰 놈, 작은 놈, 같은 놈 (D1)
 * 내용: 크기를 비교하여 등호 또는 부등호를 출력하는 프로그램
 */

package SWEA.D1.p2070;

import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int num1 = 0;
		int num2 = 0;
		String result;
	
		for(int test_case = 1; test_case <= T; test_case++) {
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			result = (num1 > num2) ? ">" : (num1 == num2 ? "=" : "<");
			System.out.println("#" + test_case + " " + result);
			}
		sc.close();
		} 
	}

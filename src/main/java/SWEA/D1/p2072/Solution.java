/*
 * 문제: SWEA 2072. 홀수만 더하기 (D1)
 * 내용: 홀수만 골라서 더하는 문제
 */

package SWEA.D1.p2072;

import java.util.Scanner;

class Solution
{
public static void main(String args[]) throws Exception
{
Scanner sc = new Scanner(System.in);
int T;
T=sc.nextInt();
int num = 0;
int sum = 0;

for(int test_case = 1; test_case <= T; test_case++) {
			sum = 0;
			for (int i = 0; i <= 9; i++) {
				num = sc.nextInt();
				if (num % 2 != 0) {
					sum += num;
				}
			}
			System.out.println("#" + test_case + " " + sum);
		} 
	}
}
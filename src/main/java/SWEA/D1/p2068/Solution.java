/*
 * 문제: SWEA 2068. 최대수 구하기 (D1)
 * 내용: 가장 큰 수를 출력하는 프로그램
 */

package SWEA.D1.p2068;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int[] num = new int[10];
			int max = 0;
			for (int i = 0; i <= 9; i++) {
				num[i] = sc.nextInt();
				if (max < num[i]) {
					max = num[i];
				} else {
					continue;
				}
			}
			
			System.out.println("#" + test_case + " " + max);
			}
		sc.close();
		} 
	}
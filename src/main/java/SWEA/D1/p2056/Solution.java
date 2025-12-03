/*
 * 문제: SWEA 2056. 연월일 달력 (D1)
 * 내용: 날짜가 유효하다면 ”YYYY/MM/DD”형식으로 출력하고, 유효하지 않을 경우, -1 을 출력하는 프로그램
 */

package SWEA.D1.p2056;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		int[] maxDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int T;
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {

			String date = sc.next();

			String year = date.substring(0, 4);
			String month = date.substring(4, 6);
			String day = date.substring(6, 8);

			int monthInt = Integer.parseInt(month);
			int dayInt = Integer.parseInt(day);
			String result = "";

			if (monthInt < 1 || monthInt > 12) {
				result = "-1";
			}

			else {

				int maxDay = maxDays[monthInt];
				if (dayInt > maxDay || dayInt < 1) {
					result = "-1";
				} else {
					result = year + "/" + month + "/" + day;
				}
			}
			System.out.println("#" + test_case + " " + result);
			}
		sc.close();
		} 
	}
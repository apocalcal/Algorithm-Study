package SWEA.D3.p2805;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] grid = new int[N][N];
			for (int i = 0; i <= N-1; i++) {
				String row = sc.next(); // 한 줄을 통째로 문자열로 받음
				for (int j = 0; j <= N-1; j++) {
					grid[i][j] = row.charAt(j) - '0'; // 문자를 숫자로 변환
				}
			}
			// 변수 선언
			int sum = 0;
			int mid = N / 2;
			int start = mid;
			int end = mid; // 처음은 가운데만 해당되므로 start, end 모두 mid
			// 농작물 범위 구하기
			for (int i = 0; i <= N-1; i++) {
				for (int j = start; j <= end; j++) { // start부터 end까지 누적해야 정확
					sum += grid[i][j];
				}
				// 규칙 적용 - i가 mid를 넘어가기 전까진 end가 늘어나고, 넘어가면 start가 늘어남
				if (i < mid) {
					start--;
					end++;
				} else {
					start++;
					end--;
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
		sc.close();
	}
}		
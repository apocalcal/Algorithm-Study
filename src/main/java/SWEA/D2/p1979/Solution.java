/*
 * 1. 문제 분석
 * - 문제: SWEA 1979. 어디에 단어가 들어갈 수 있을까
 * - 입력:
 *   T개의 테스트 케이스, 정수 N(가로·세로 길이)과 K(단어 길이), N x N 크기의 0/1 퍼즐
 * - 출력: 가로 또는 세로 방향으로 정확히 K칸 연속된 1이 형성된 자리의 개수
 * - 핵심:
 *   (1) 연속된 1의 길이가 정확히 K일 때만 카운트한다.
 *   (2) 가로 검사 → 세로 검사 순서로 처리.
 *   (3) 1이 끊기는 순간(count != K) 여부를 판별하고 count 초기화.
 *
 * 2. 접근 방법
 * - 행마다 연속된 1의 개수를 count로 누적.
 *   0을 만나면 count == K인지 확인 후 count reset.
 *   한 행이 끝났을 때도 마지막 연속된 1 구간이 K인지 체크.
 * - 열도 동일한 방식으로 검사하되, grid[j][i]로 접근.
 *
 * 3. 핵심 로직
 * - count는 현재 연속된 1의 길이.
 * - if (grid[i][j] == 1) → count++
 * - else(또는 줄 마지막) → if (count == K) ans++ 후 count = 0
 */

package SWEA.D2.p1979;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] grid = new int[N][N];

			// 퍼즐 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			int ans = 0;
			// 1. 가로 방향 검사
			for (int i = 0; i < N; i++) {
				int count = 0;

				for (int j = 0; j < N; j++) {

					if (grid[i][j] == 1) {
						count++;
					} else {
						// 0을 만나면 현재 연속된 구간이 정확히 K인지 확인
						if (count == K) ans++;
						count = 0;
					}
				}
				// 행이 끝났을 때 마지막 구간 체크
				if (count == K) ans++;
			}
			// 2. 세로 방향 검사
			for (int i = 0; i < N; i++) {
				int count = 0;

				for (int j = 0; j < N; j++) {

					if (grid[j][i] == 1) {
						count++;
					} else {
						if (count == K) ans++;
						count = 0;
					}
				}
				if (count == K) ans++;
			}
			System.out.println("#" + test_case + " " + ans);
		}
		sc.close();
	}
}

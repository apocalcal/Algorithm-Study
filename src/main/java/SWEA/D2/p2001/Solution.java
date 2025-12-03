/*
 * 1. 문제 분석
 * - 문제: SWEA 2001. 파리 퇴치
 * - 입력: T개의 테스트 케이스, N(격자 크기), M(파리채 크기), N x N 파리 수
 * - 출력:
 *   M x M 크기의 파리채로 한번에 잡을 수 있는 파리의 최대 마릿수
 * - 핵심:
 *   (1) 모든 (a, b)를 시작점으로 하는 M x M 영역의 합을 계산한다.
 *   (2) 합의 최대값을 찾는 단순 브루트포스 문제.
 *   (3) 시작점 a, b는 각각 0부터 N-M까지 가능.
 *
 * 2. 접근 방법
 * - grid[][] 입력 후,
 *   a(행 시작), b(열 시작) 모든 조합을 탐색.
 * - 각 (a, b)에서 내부 M x M 영역을 순회하며 합을 구한다.
 * - currentSum을 구할 때마다 기존 maxFlies와 비교하여 갱신.
 *
 * 3. 핵심 로직
 * - 시작점 루프: a = 0 ~ N-M, b = 0 ~ N-M
 * - 내부 루프: i = a ~ a+M-1, j = b ~ b+M-1
 * - currentSum 누적 → maxFlies 갱신
 */

package SWEA.D2.p2001;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			// 격자 생성 및 파리 마릿수 입력
			int[][] grid = new int[N][N];
			for (int a_input = 0; a_input <= N-1; a_input++) {
				for (int b_input = 0; b_input <= N-1; b_input++) {
					grid[a_input][b_input] = sc.nextInt();
				}
			}
			// 최댓값 변수 선언
			int maxFlies = 0;
			// 1. 좌상단 행(a) 결정
			for (int a = 0; a <= N - M; a++) {
				// 2. 좌상단 열(b) 결정
				for(int b = 0; b <= N - M; b++) {
					// 3. (a, b) 위치에서 잡은 파리 합계 선언 및 초기화
					int currentSum = 0;
					// 4. 파리채 내부 순회하면서 최대값 구하기 (행부터)
					for(int i = a; i <= a + M - 1; i++) {
						// 5. 열 반복
						for(int j = b; j <= b + M - 1; j++) {
							currentSum += grid[i][j];
						}
					}
					// 6.  현재 합계와 최댓값 비교후 갱신
					if(currentSum > maxFlies) {
						maxFlies = currentSum;
					}
				}
			}
			// 출력 형식 만들기
			sb.append("#" + test_case + " " + maxFlies).append("\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}
}

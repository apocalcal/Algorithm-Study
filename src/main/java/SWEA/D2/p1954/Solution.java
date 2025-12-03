package SWEA.D2.p1954;

import java.io.FileInputStream;
import java.util.Scanner;

/*
 * 1. 문제 분석
 * - 문제: SWEA 1954. 달팽이 숫자 (D2)
 * - 입력: 테스트 케이스 개수 T, 달팽이 크기 N (1 ≤ N ≤ 10)
 * - 출력: 달팽이 숫자
 * - 핵심: 현재 방향으로 이동하다가 “격자 밖” 또는 “이미 값이 채워진 칸”을 만나면 방향 전환
 *
 * 2. 접근 방법
 * - 델타 배열(dr, dc)을 이용해 우(0), 하(1), 좌(2), 상(3) 방향을 순환하며 이동
 * - 현재 칸에 숫자를 채운 뒤, 다음 칸(nr, nc)을 미리 계산
 * - 다음 칸이 범위를 벗어나거나 값이 이미 존재하면 방향을 바꾼 뒤 다시 이동
 * - N*N번 반복하며 grid를 채우기
 *
 * 3. 핵심 로직
 * - dr/dc = {우, 하, 좌, 상} 순서로 이동 방향을 표현.
 * - dir = (dir + 1) % 4 로 방향 전환.
 * - “벽 또는 방문 여부 검사”가 핵심 조건: grid[nr][nc] != 0 이면 회전.
 * - 매 반복마다 r, c를 갱신하여 다음 숫자를 배치.
 */

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] grid = new int[N][N];
			// 우 - 하 - 좌 - 상 델타 배열 생성
			int[] dr = {0, 1, 0, -1};
			int[] dc = {1, 0, -1, 0};
			int r = 0; // 시작 좌표
			int c = 0;
			int dir = 0; // 시작 방향

			for (int num = 1; num <= N * N; num++) {
				grid[r][c] = num; // 현재 위치에 숫자 기록
				// 다음 위치 미리 계산
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				// 다음 위치가 벽이거나 이미 채워진 곳인지 검사
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || grid[nr][nc] != 0) {
					// 조건을 만나면 방향 전환 (0 - 1 - 2 - 3 - 0)
					dir = (dir + 1) % 4;
					// 다시 다음 위치 계산
					nr = r + dr[dir];
					nc = c + dc[dir];
				}
				// 좌표 이동 (다음 숫자 기록 위함)
				r = nr;
				c = nc;
			}
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
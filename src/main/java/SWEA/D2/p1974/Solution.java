/*
 * 1. 문제 분석
 * - 문제: SWEA 1974. 스도쿠 검증
 * - 입력: T개의 테스트 케이스, 9 X 9스도쿠 판
 * - 출력: 스도쿠 규칙에 맞으면 1, 틀리면 0
 * - 핵심: 각 행, 각 열, 3x3 격자(총 9개)에서 1~9가 중복 없이 등장해야 한다.
 *
 * 2. 접근 방법
 * - 중복 검사를 위해 길이 10의 boolean 배열(check[])을 사용하여,
 *   숫자가 이미 등장했는지 여부를 기록한다.
 * - 행 검사 → 열 검사 → 3x3 소격자 순으로 진행하며
 *   하나라도 위반되면 즉시 isValid = false 처리 후 종료.
 * - isValid가 true라면 정답 1, 아니면 0 출력.
 *
 * 3. 핵심 로직
 * - 행(i 고정, j 반복): grid[i][j] 중복 검사
 * - 열(i 고정, j 반복): grid[j][i] 중복 검사
 * - 3x3 격자는 (0,3,6)을 시작점으로 삼아 내부 이중 반복문에서 검사
 * - 중복 발견 시 break로 즉시 빠져나와 전체 검사 효율화
 */

package SWEA.D2.p1974;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int[][] grid = new int[9][9];
			// 스도쿠 배열 입력받기
			for (int i = 0; i <= 8; i++) {
				for (int j = 0; j <= 8; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			int num = 0;
			boolean isValid = true; // 일단 맞다고 가정
			int answer = 0;
			// 1. 가로 검사
			for(int i = 0; i <= 8; i++) {
				boolean[] check = new boolean[10];  // check 배열 초기화
				for(int j = 0; j <= 8; j++) {
					num = grid[i][j];
					if(check[num] == true) { // 이미 나온 숫자면
						isValid = false;
						break;
					}
					check[num] = true;
				}
				if(isValid == false) {
					break; // 가로 검사 중 틀렸으면 전체 중단
				}
			}
			// 2. 세로 검사
			for(int i = 0; i <= 8; i++) {
				boolean[] check = new boolean[10];
				for(int j = 0; j <= 8; j++) {
					num = grid[j][i];  // 세로 검사는 가로와 반대!
					if(check[num] == true) {
						isValid = false;
						break;
					}
					check[num] = true;
				}
				if(isValid == false) {
					break; // 세로 검사 중 틀렸으면 전체 중단
				}
			}
			// 3. 3x3 격자 검사 - isValid가 true일 때만 진행
			// 격자의 시작점을 건너뛰며 이동
			if (isValid == true) {
				for(int x = 0; x <= 6; x+=3) { // 3씩 건너뛰며 검사
					for(int y = 0; y <= 6; y+=3) {
						boolean[] check = new boolean[10];
						// 내부에서도 이중 for문을 통해 숫자 검사
						for(int i = x; i <= x + 2; i++) {
							for(int j = y; j <= y + 2; j++) {
								num = grid[i][j];
								if(check[num] == true) {
									isValid = false;
									break;
								}
								check[num] = true;
							}
							if(isValid == false) break;
						}
						if(isValid == false) break;
					}
					if(isValid == false) break;
				}
			}
			if (isValid == true) {
				answer = 1;
			} else {
				answer = 0;
			}
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
}		

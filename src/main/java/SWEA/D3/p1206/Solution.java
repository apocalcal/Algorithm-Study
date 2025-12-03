package SWEA.D3.p1206;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt(); // 건물의 개수
			int[] buildings = new int[N];
			for (int i = 0; i <= N - 1; i++) {
				buildings[i] = sc.nextInt();
			}
			int answer = 0;
			// 맨 앞 2칸 및 맨 뒤 2칸은 0이기에 제외하고 반복
			for (int k = 2; k <= N - 3; k++) {
				int myHeight = buildings[k];
				// 주변 4개 건물 대장 구하기
				int leftMax = Math.max(buildings[k - 2], buildings[k - 1]);
				int rightMax = Math.max(buildings[k + 1], buildings[k + 2]);
				int maxNeighbor = Math.max(leftMax, rightMax); // max 함수는 2개씩 비교 가능하므로 이렇게 끊어서 하기
				// 조망권 구하기
				if (myHeight > maxNeighbor) {
					answer = answer + (myHeight - maxNeighbor);
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
}	
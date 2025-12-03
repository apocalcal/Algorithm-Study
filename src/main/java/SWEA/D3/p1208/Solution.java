package SWEA.D3.p1208;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++) {
			int dump = sc.nextInt(); // 덤프 횟수
			// 배열 입력받기
			int[] boxes = new int[100];
			for (int i = 0; i <= 99; i++) {
				boxes[i] = sc.nextInt();
			}
			// 덤프 평탄화 실행
			for (int k = 1; k <= dump; k++) {
				// 매번 정렬해서 최소, 최대 쉽게 찾기
				Arrays.sort(boxes);
				// 평탄화 완료 시 즉시 종료
				if (boxes[99] - boxes[0] <= 1) {
					break;
				}
				// 평탄화 진행 - 최소 + 1, 최대 - 1
				boxes[0]++;
				boxes[99]--;
			}
			Arrays.sort(boxes); // 마지막 덤프 후 순서가 꼬일 수도 있으니 한번 더 정렬
			// 정답 구하기 - 최대 - 최소
			int answer = boxes[99] - boxes[0];
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
}	
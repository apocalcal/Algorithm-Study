package SWEA.D3.p1860;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 손님 수
			int M = sc.nextInt(); // 붕어빵 하나 당 걸리는 시간
			int K = sc.nextInt(); // 붕어빵 개수
			// 도착 시간 배열 생성
			int[] arrivals = new int[N];
			// 배열 입력받기
			for (int i = 0; i <= N-1; i++) {
				arrivals[i] = sc.nextInt();
			}
			// 1. 시간 흐름대로 정렬
			Arrays.sort(arrivals);
			String result = "Possible" ; // 일단 가능하다고 가정
			// 2. 붕어빵 만드는 데 걸리는 총 시간 계산
			for (int i = 0; i <= N-1; i++) {
				int arrivals_time = arrivals[i];
				// 총 시간 = (도착 시간 / 만드는 시간 ) * 개수
				int bread_time = (arrivals_time / M) * K;
				// 필요한 붕어빵 수 (i+1)
				// 만든 빵이 필요한 개수보다 적을 때
				if(bread_time < i+1) {
					result = "Impossible";
					break; // 더 검사할 필요 없음
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
		sc.close();
	}
}	
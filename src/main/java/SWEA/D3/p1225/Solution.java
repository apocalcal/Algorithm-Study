/*
 * 1. 문제 분석
 * - 문제: SWEA 1225. 암호생성기 (D3)
 * - 입력:
 *   총 10개의 테스트 케이스, 각 테스트마다 테스트케이스 번호(t_num, 사용하지 않음)와 8개의 숫자
 * - 출력:
 *   규칙에 따라 생성된 최종 8자리 암호를 출력
 * - 핵심 규칙:
 *   (1) 큐에서 맨 앞 숫자를 꺼내 1~5까지 순서대로 감소시킨 뒤 맨 뒤에 삽입.
 *   (2) 감소 결과가 0 이하가 되는 순간, 그 값을 0으로 만들고 큐에 넣은 뒤 사이클 즉시 종료.
 *   (3) 이때 큐에 남은 8개의 숫자가 암호가 된다.
 *
 * 2. 접근 방법
 * - 입력받은 8개의 숫자를 Queue에 저장.
 * - 무한 루프 실행:
 *       for i = 1 ~ 5:
 *           x = q.poll() - i
 *           x <= 0 → 0으로 설정 후 offer, 완료 플래그 ON → 전체 루프 종료
 *           아니면 그냥 offer
 * - 종료 플래그가 true가 되면 암호 생성 종료.
 *
 * 3. 핵심 로직
 * - FIFO 구조이므로 Queue 사용이 적합.
 * - 감소 규칙: 1→2→3→4→5 반복.
 * - 종료 조건이 명확하므로 boolean 플래그로 제어.
 */

package SWEA.D3.p1225;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++) {
			int t_num = sc.nextInt(); // 입력되는 테스트케이스 번호는 사용할 필요 x (자피 순서대로)
			// 큐 생성
			Queue<Integer> q = new LinkedList<>();
			int num = 0;
			// 8개 숫자 입력
			for (int i = 0; i <= 7; i++) {
				num = sc.nextInt();
				q.offer(num); // 뒤에 넣어야 앞에서부터 채워짐
			}
			// 암호 생성 (무한루프)
			boolean isFinished = false; // 종료 플래그
			while(true) {
				// 1부터 5까지 감소하는 1사이클
				for(int i = 1; i <= 5; i++) {
					num = q.poll(); // 큐에서 꺼내서
					num = num - i; // 감소시키고
					// 종료 조건이면 암호 만들고 감소 반복 끝내기
					if (num <= 0) {
						num = 0;
						q.offer(num);
						isFinished = true;
						break;
					}
					q.offer(num); // 종료조건 아니면 그냥 큐 맨 뒤에 넣기
				}
				if(isFinished == true) {
					break; //조건 달성으로 무한루프 종료
				}
			}
			sb.append("#" + test_case);
			for (int result : q) {
				sb.append(" " + result);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}	

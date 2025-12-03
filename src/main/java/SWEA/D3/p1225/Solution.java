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

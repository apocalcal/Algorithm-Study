/*
 * 1. 문제 분석
 * - 문제: BOJ 2018. 수들의 합 5
 * - 입력: 자연수 N (1 ≤ N ≤ 10,000,000)
 * - 출력: 연속된 자연수들의 합으로 N을 만들 수 있는 경우의 수
 *
 * - 핵심 규칙:
 *   (1) 연속된 자연수(start ~ end)의 합을 투 포인터 방식으로 관리.
 *   (2) sum == N → 경우의 수 증가, end를 증가시켜 다음 구간 탐색.
 *   (3) sum <  N → end++ 하여 더 큰 합 시도.
 *   (4) sum >  N → start++ 하여 더 작은 합 시도.
 *   (5) end가 N이 되면 더 이상 확장할 수 없으므로 반복 종료.
 *   (6) 자기 자신 하나로 이루어진 경우(start == end == N)도 포함.
 *
 * 2. 접근 방법
 * - 초기 상태:
 *       start = 1
 *       end   = 1
 *       sum   = 1
 *       count = 1   (N 자체를 포함한 1개는 기본적으로 존재)
 *
 * - while (end != N):
 *       if (sum == N):
 *           count++
 *           end++; sum += end
 *
 *       else if (sum < N):
 *           end++; sum += end
 *
 *       else (sum > N):
 *           sum -= start
 *           start++
 *
 * - 반복 종료 후 count 출력.
 *
 * 3. 핵심 로직
 * - “양쪽 포인터(start, end)를 증가시키며 비교”
 * - sum을 동적으로 유지하며 N과 비교
 * - sum == N 조건에서 반드시 end를 증가시켜 다음 구간 탐색
 */

package BOJ.chap03.p2018;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int start = 1;
        int end = 1;
        int sum = 1;
        while (end != N) {
            if(sum == N) {
                count++;
                end++;
                sum += end;
            } else if (sum > N) {
                sum -= start;
                start++;
            } else if (sum < N) {
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}
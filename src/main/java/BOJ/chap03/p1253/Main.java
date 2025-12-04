/*
 * 1. 문제 분석
 * - 문제: BOJ 1253. 좋다
 * - 입력: N (1 ≤ N ≤ 2,000), N개의 정수 A[]
 * - 출력: '좋은 수'의 개수
 * - 핵심 조건:
 *   (1) A[k] = A[i] + A[j] (단, i != k, j != k)
 *   (2) 투 포인터(two-pointer)를 이용하면 O(N^2)으로 해결 가능.
 *   (3) 정렬 후 i는 왼쪽, j는 오른쪽에서 시작해 합을 조절하며 탐색.
 *
 * 2. 접근 방법
 * - 배열을 정렬하여 투 포인터 적용.
 * - 각 k에 대해:
 *     목표값 find = A[k]
 *     i = 0, j = N-1 두 포인터 설정.
 *
 *     while (i < j):
 *         sum = A[i] + A[j]
 *
 *         sum == find 이면:
 *             i, j 둘 다 k가 아닌 경우 → A[k]는 좋은 수 → result++ 후 break
 *             만약 한 포인터가 k와 같으면 포인터를 옮겨 탐색 지속
 *
 *         sum < find  → i++ (합을 키움)
 *         sum > find  → j-- (합을 줄임)
 *
 * - 모든 k에 대해 탐색 후 result 출력.
 *
 * 3. 핵심 로직
 * - 정렬 + 투 포인터를 k마다 반복.
 * - (i != k && j != k) 조건을 반드시 체크.
 * - 한 수를 다른 두 수의 합으로 만들 수 있는지 검사
 */

package BOJ.chap03.p1253;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);
        for (int k = 0; k < N; k++) {
            long find = A[k];
            int i = 0;
            int j = N - 1;
            while (i < j) {
                if (A[i] + A[j] == find) {
                    if (i != k && j != k) {
                        result++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (A[i] + A[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(result);
        br.close();
    }
}
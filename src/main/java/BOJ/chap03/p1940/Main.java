/*
 * 1. 문제 분석
 * - 문제: BOJ 1940. 주몽
 * - 입력: N = 재료의 개수, M = 만들고자 하는 갑옷의 번호(필요한 합), N개의 재료 배열 A[]
 * - 출력: 두 재료의 수치 합이 정확히 M이 되는 조합의 개수
 *
 * - 핵심 규칙:
 *   (1) A[i] + A[j] == M인 (i < j) 조합의 개수를 구한다.
 *   (2) N ≤ 15,000이므로 투 포인터(two-pointer)로 O(N log N + N) 해결.
 *   (3) 정렬 후 i는 왼쪽, j는 오른쪽에서 이동하며 합을 조절한다.
 *
 * 2. 접근 방법
 * - A를 오름차순으로 정렬한다.
 * - left(i)=0, right(j)=N-1 포인터 두 개를 사용.
 * - while(i < j):
 *       sum = A[i] + A[j]
 *
 *       sum == M → count++; i++; j--  (정확히 M이므로 둘 다 이동)
 *       sum <  M → i++   (합을 키움)
 *       sum >  M → j--   (합을 줄임)
 *
 * - 최종 count 출력.
 *
 * 3. 핵심 로직
 * - 투 포인터 정석 패턴(A[i] + A[j] 비교)
 * - 정렬 필수
 * - 조건에 맞는 쌍 발견하면 양쪽 포인터 동시에 이동
 */

package BOJ.chap03.p1940;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;
        int i = 0;
        int j = N - 1;
        while (i < j) {
            if (A[i] + A[j] < M) {
                i++;
            } else if (A[i] + A[j] > M) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        bf.close();
    }
}
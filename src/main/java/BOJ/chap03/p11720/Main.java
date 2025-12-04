/*
 * 1. 문제 분석
 * - 문제: BOJ 11720. 숫자의 합
 * - 입력: N (자리수), 공백 없이 이어진 N자리 숫자 문자열
 *
 * - 출력: 주어진 N자리 숫자의 각 자리값의 총합
 *
 * - 핵심 내용:
 *     (1) 문자열로 입력된 숫자를 한 글자씩 읽어서 정수로 변환해야 한다.
 *     (2) 문자 '0'을 빼면 char → int 변환이 가능하다.
 *         예: '3' - '0' = 3
 *
 * 2. 접근 방법
 * - 숫자 문자열을 입력받아 char 배열로 변환한다.
 * - 각 문자를 순회하면서 해당 숫자를 sum에 누적한다.
 * - sum을 출력한다.
 *
 * 3. 핵심 로직
 * - char 배열로 처리하는 것이 빠르고 직관적.
 * - sum += cNum[i] - '0';
 */


package BOJ.chap03.p11720;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0';
        }
        System.out.println(sum);
    }
}
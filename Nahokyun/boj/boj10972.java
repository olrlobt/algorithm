package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10972{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        } // 입력 종료

        for (int i = n - 1; i > 0; i--) {
            if (input[i] < input[i - 1])
                continue;
            // 내림차순이 시작된 숫자
            int cur = input[i - 1];
            // cur과 교체할 숫자 탐색
            int curj = -1;// 교체될 숫자의 인덱스 저장
            int min_big = 1000000;
            for (int j = i; j < n; j++) {// 가장 차이 적은 큰 수 탐색
                if (input[j] > cur) {
                    if (min_big > input[j]) {
                        min_big = input[j];
                        curj = j;
                    }
                }
            }

            input[curj] = input[i - 1];
            input[i - 1] = min_big;

            Arrays.sort(input, i, n);
            for (int j = 0; j < n; j++)
                sb.append(input[j]).append(" ");
            System.out.println(sb.toString());
            return;

        } // 탐색 종료
        System.out.println(-1);// 교체할 수 를 찾아내지 못했으면 -1 리턴
    }
}

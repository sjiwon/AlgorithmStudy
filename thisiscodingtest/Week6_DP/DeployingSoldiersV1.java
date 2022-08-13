package thisiscodingtest.Week6_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
DP
 */

public class DeployingSoldiersV1 {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N + 1];
        list[0] = Integer.MIN_VALUE; // Sentinel

        st = new StringTokenizer(br.readLine());
        for (int i = N; i >= 1; i--) { // 역으로 입력받아서 LIS 구현
            list[i] = Integer.parseInt(st.nextToken());
        }

        // Solution(i, j) : [0, i]까지의 LIS에 대해서 [j]의 숫자를 포함할지 말지
        int[][] dp = new int[list.length][list.length + 1];

        // Logic
        for (int j = N; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                int with = dp[j][j + 1] + 1;
                int wout = dp[i][j + 1];

                if (list[i] >= list[j]) {
                    dp[i][j] = wout;
                } else {
                    dp[i][j] = Math.max(with, wout);
                }
            }
        }

        System.out.println(N - dp[0][1]); // N - [LIS 길이]
    }
}

/*
7
15 11 4 8 5 2 4
>> 2

6
1 2 1 2 1 2
>> 4

1
1
>> 0

5
15 8 8 8 2
>> 2
 */
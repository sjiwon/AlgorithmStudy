package thisiscodingtest.Week6_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FloorConstruction {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        /*
        가로 = N, 세로 = 2
            - (1 * 2)
            - (2 * 1)
            - (2 * 2)
         */
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        /*
        가로 최대 길이 = 2 >> [i - 2] & [i - 1] 관계

        1. [i - 2]까지 공사 완료 :: 가로2/세로2 >> 3가지
        2. [i - 1]까지 공사 완료 :: 가로1/세로2 >> 1가지
            -> (1), (2) 중복 = 가로1/세로2 사용해서 채워넣기
                >> 따라서 (1 : i - 2) = 2가지 / (2 : i - 1) = 1가지
         */
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 796796;
        }

        System.out.println(dp[N]);
    }
}

/*
3
>> 5

4
>> 11

5
>> 21
 */
package thisiscodingtest.Week6_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UglyNumber {

    static int MULTIPLE_OF_TWO = 2;
    static int MULTIPLE_OF_THREE = 3;
    static int MULTIPLE_OF_FIVE = 5;

    // MULTIPLE_OF_XXX에 그대로 곱하면 중간에 비는 숫자 발생 -> [TWO, THREE, FIVE] 고른 횟수 따로 저장해서 여기다가 곱해서 update
    static int indexTwo = 1;
    static int indexThree = 1;
    static int indexFive = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1]; // dp[i] = i번째 못생긴 수
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = getMinValue();
            if(dp[i] == MULTIPLE_OF_TWO){
                indexTwo += 1;
                MULTIPLE_OF_TWO = dp[indexTwo] * 2;
            }

            if (dp[i] == MULTIPLE_OF_THREE) {
                indexThree += 1;
                MULTIPLE_OF_THREE = dp[indexThree] * 3;
            }

            if (dp[i] == MULTIPLE_OF_FIVE) {
                indexFive += 1;
                MULTIPLE_OF_FIVE = dp[indexFive] * 5;
            }
        }

        System.out.println(dp[N]);
    }

    static int getMinValue() {
        return Math.min(MULTIPLE_OF_TWO, Math.min(MULTIPLE_OF_THREE, MULTIPLE_OF_FIVE));
    }
}

/*
4
>> 4

10
>> 12

11
>> 15
 */
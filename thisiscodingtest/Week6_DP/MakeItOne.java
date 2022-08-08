package thisiscodingtest.Week6_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeItOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int[] dp = new int[X + 1];
        dp[0] = 0;
        dp[1] = 0;

        /*
        2 3 5 -> 30
        3 5 -> 15
        2 5 -> 10
        5
        3
        2
         */

        for (int i = 2; i <= X; i++) {
            if (i % 30 == 0) {
                dp[i] = Math.min(dp[i / 5], Math.min(dp[i / 3], Math.min(dp[i / 2], dp[i - 1]))) + 1;
            } else if (i % 15 == 0) {
                dp[i] = Math.min(dp[i / 5], Math.min(dp[i / 3], dp[i - 1])) + 1;
            } else if (i % 10 == 0) {
                dp[i] = Math.min(dp[i / 5], Math.min(dp[i / 2], dp[i - 1])) + 1;
            } else if (i % 5 == 0) {
                dp[i] = Math.min(dp[i / 5], dp[i - 1]) + 1;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        System.out.println(dp[X]);
    }
}
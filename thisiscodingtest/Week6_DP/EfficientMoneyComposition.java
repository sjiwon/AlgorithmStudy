package thisiscodingtest.Week6_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EfficientMoneyComposition {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[M + 1]; // dp[i] = i원을 만들기 위한 최소의 화폐 개수
        dp[0] = 0;

        // Base
        for (int money : list) {
            for (int i = 1; i <= M; i++) {
                int value = money * i;
                if (value <= M) {
                    dp[value] = i;
                }
            }
        }

        // Logic
        for (int i = 1; i <= M; i++) {
            // i원
            for (int money : list) {
                if (i < money) {
                    continue;
                }

                int count = i / money; // money로 i를 얼마나 커버할 수 있는지
                dp[i] = Math.min(dp[i], count + dp[i - money * count]);
            }
        }

        if (dp[M] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(dp[M]);
        }
    }
}

/*
2 15
2
3
>> 5

3 4
3
5
7
>> -1
 */
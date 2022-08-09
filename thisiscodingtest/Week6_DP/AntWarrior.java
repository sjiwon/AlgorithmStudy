package thisiscodingtest.Week6_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AntWarrior {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N + 1];
        list[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // Solution(i) = i번째 창고에서 최대한 약탈할 수 있는 식량의 개수
        int[] dp = new int[list.length];
        dp[0] = 0;
        dp[1] = Math.max(list[0], list[1]);

        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + list[i]);
            /*
            dp[i - 1] = [i - 1]창고까지 약탈한 식량의 최적의 개수
            dp[i - 2] + list[i] = 현재 창고 식량 + [i - 2]창고까지 약탈한 식량의 최적의 개수
                >> 최소 1칸 이상 떨어진 창고에서 약탈해야 하기 때문에
             */
        }
        System.out.println(dp[N]);
    }
}
/*
4
1 3 1 5
>> 8

5
1 3 5 7 9
>> 15

5
11 13 17 19 5
>> 33

7
100 101 102 103 104 105 106
>> 412
 */
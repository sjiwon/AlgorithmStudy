package thisiscodingtest.Week6_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Leave {
    static StringTokenizer st;
    static int[] time;
    static int[] pay;
    static int[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        time = new int[N + 1];
        pay = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        // Base
        dp = new int[N + 6];

        // Logic
        int result = 0;
        for (int i = N; i >= 1; i--) {
            int finishTime = i + time[i] - 1;

            if (finishTime > N) {
                dp[i] = 0;
            } else if (finishTime == N) {
                dp[i] = pay[i];
            } else {
                dp[i] = pay[i] + selectNextConsulting(finishTime + 1);
            }

            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }

    static int selectNextConsulting(int nextTime) {
        int result = 0;

        for (int i = nextTime; i <= N; i++) {
            int processTime = i + time[i] - 1;
            if (processTime <= N) {
                result = Math.max(result, dp[i]);
            }
        }

        return result;
    }
}

/*
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
>> 45

10
1 1
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
>> 55

10
5 10
5 9
5 8
5 7
5 6
5 10
5 9
5 8
5 7
5 6
>> 20

10
5 50
4 40
3 30
2 20
1 10
1 10
2 20
3 30
4 40
5 50
>> 90
 */
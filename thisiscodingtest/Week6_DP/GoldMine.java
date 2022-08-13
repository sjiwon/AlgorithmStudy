package thisiscodingtest.Week6_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoldMine {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(); // 테스트 케이스별 결과 저장

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] list = new int[N][M];

            st = new StringTokenizer(br.readLine());
            int row = 0;
            int column = 0;
            while(st.hasMoreTokens()){
                if (column == M) {
                    row++;
                    column = 0;
                }
                list[row][column] = Integer.parseInt(st.nextToken());
                column++;
            }

            // Basic
            int[][] dp = new int[N + 2][M + 1];
            for (int i = 0; i < list.length; i++) {
                System.arraycopy(list[i], 0, dp[i + 1], 1, list[i].length);
            }

            // Logic
            for (int j = 1; j <= M; j++) {
                for (int i = 1; i < N + 1; i++) {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i + 1][j - 1]));
                }
            }

            sb.append(Math.max(dp[1][M], Math.max(dp[2][M], dp[3][M]))).append("\n");
        }

        System.out.println(sb);
    }
}

/*
3
3 3
1 3 3 2 1 4 0 6 4
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
>> 12 19 16
 */

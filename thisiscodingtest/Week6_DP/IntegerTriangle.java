package thisiscodingtest.Week6_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerTriangle {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][];

        // 비정방형 배열
        for (int i = 0; i < N; i++) {
            list[i] = new int[i + 1];
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < list[i].length; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < list[i].length; j++) {
                list[i][j] += Math.max(list[i + 1][j], list[i + 1][j + 1]);
            }
        }

        System.out.println(list[0][0]);
    }
}

/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
>> 30
 */
package thisiscodingtest.Week7_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1 ~ K, K ~ X

public class FutureCityFloydWarshall {

    static StringTokenizer st;
    static int[][] matrix;
    static final int MAX = 987654321;
    static int N;
    static int M;
    static int X;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(matrix[i], MAX);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            matrix[start - 1][end - 1] = matrix[end - 1][start - 1] = 1;
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        floydWarshall();
        System.out.println(getResult());
    }

    static void floydWarshall() {
        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
    }

    static int getResult() {
        // 1 ~ K, k ~ X
        int toCompany = matrix[0][K - 1];
        int toMeeting = matrix[K - 1][X - 1];

        if(toCompany == MAX || toMeeting == MAX){
            return -1;
        }
        return toCompany + toMeeting;
    }
}

/*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
>> 3

4 2
1 3
2 4
3 4
>> -1
 */
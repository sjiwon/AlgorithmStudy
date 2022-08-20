package thisiscodingtest.Week7_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExactRanking {

    static StringTokenizer st;
    static final int MAX = 987654321;
    static int N;
    static int M;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(matrix[i], MAX);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            matrix[start - 1][end - 1] = 1;
        }

        floydWarshall();
        System.out.println(getResult());
    }

    static void floydWarshall() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
    }

    static int getResult() {
        int result = 0;

        for (int i = 0; i < N; i++) {
            int validationCount = 0; // 학생 i에 대해서 나머지 학생들 중 몇명을 정확하게 판별할 수 있는지
            for (int j = 0; j < N; j++) {
                if (validation(i, j) || validation(j, i)) { // 한쪽으로라도 갈 수 있으면 대소 판별 가능
                    validationCount++;
                }
            }

            if (validationCount == N - 1) { // 본인빼고 다 판별할 수 있으면 본인도 판별 가능
                result++;
            }
        }

        return result;
    }

    static boolean validation(int x, int y) {
        return matrix[x][y] != 0 && matrix[x][y] != MAX;
    }
}

/*
6 6
1 5
3 4
4 2
4 6
5 2
5 4
>> 1
 */
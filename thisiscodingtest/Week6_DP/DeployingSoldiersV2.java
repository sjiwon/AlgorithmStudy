package thisiscodingtest.Week6_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Recursion
 */

public class DeployingSoldiersV2 {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = N - 1; i >= 0; i--) { // 역으로 입력받아서 LIS 구현
            list[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(N - LIS(list, 0, Integer.MIN_VALUE));
    }

    static int LIS(int[] list, int index, int preValue) {
        if (index == list.length) {
            return 0;
        }

        if (preValue >= list[index]) {
            return LIS(list, index + 1, preValue);
        } else {
            int with = LIS(list, index + 1, list[index]) + 1;
            int wout = LIS(list, index + 1, preValue);
            return Math.max(with, wout);
        }
    }
}

/*
7
15 11 4 8 5 2 4
>> 2

6
1 2 1 2 1 2
>> 4

1
1
>> 0

5
15 8 8 8 2
>> 2
 */
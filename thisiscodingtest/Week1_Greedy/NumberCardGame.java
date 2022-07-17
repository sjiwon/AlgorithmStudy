package thisiscodingtest.Week1_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NumberCardGame {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> values = new ArrayList<>(); // 각 행마다 가장 작은 값을 저장하는 List
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            values.add(findMinValueInRow(st));
        }

        System.out.println(Collections.max(values)); // 각 행마다 가장 작은 값 중에서 '가장 큰 값'
    }

    static int findMinValueInRow(StringTokenizer st){ // 각 행마다 가장 작은 값을 return하는 method
        int min = Integer.MAX_VALUE;

        while(st.hasMoreTokens()){
            min = Math.min(min, Integer.parseInt(st.nextToken()));
        }

        return min;
    }
}

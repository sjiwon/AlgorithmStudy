package thisiscodingtest.Week1_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BowlingBall {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> ballCount = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int ballNum = Integer.parseInt(st.nextToken());
            if(ballCount.containsKey(ballNum)){
                ballCount.put(ballNum, ballCount.get(ballNum) + 1);
            } else {
                ballCount.put(ballNum, 1);
            }
        }

        int result = 0;
        for(Integer n : ballCount.keySet()){
            result += ballCount.get(n) * (N - ballCount.get(n));
            N -= ballCount.get(n);
        }

        System.out.println(result);
    }
}

/*
A가 고른 볼링공의 무게와 동일한 볼링공이 여러개있어도 B는 무게가 같은 볼링공을 고를 수 없다
-> ballCount.get(n) = A가 선택한 볼링공 무게와 동일한 볼링공 개수
-> N - ballCount.get(n) = B가 선택할 수 있는 볼링공 개수
>> 경우의 수이므로 그냥 곱하기

동일한 경우의 중복을 제거 & 어차피 동일 무게를 B는 고르지 못하니까 전체 경우의 수 -> N에서 ballCount.get(n) 빼기
 */

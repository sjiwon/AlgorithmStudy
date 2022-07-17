package thisiscodingtest.Week1_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RuleOfLargeNumberV1 {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        } // O(n)
        Arrays.sort(nums);

        int count = K; // 큰 수를 연속해서 K번까지만 더하기
        int result = 0;
        while (M > 0) {
            if(count == 0){ // 큰 수를 K번 더하면 그 다음 큰 수를 1번 더해주기 & count != 0이면 계속 큰 수 더하기
                result += nums[nums.length - 2];
                count = K;
            } else{
                result += nums[nums.length - 1];
                count -= 1;
            }

            M--;
        } // O(m)

        System.out.println(result);

        /*
        2 <= N <= 1000
        1 <= M <= 10000
        -> Time Complexity : O(m)
        
        만약 M이 1억이 넘어간다면 시간 초과가 발생
         */
    }
}

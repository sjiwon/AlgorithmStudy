package thisiscodingtest.Week1_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RuleOfLargeNumberV2 {
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

        /*
        결국 문제에 필요한 수는 {가장 큰 수 & 그 다음으로 큰 수}
        가장 큰 수를 K번 더한다면 그 다음으로 큰 수를 1번 더해주고, 다시 가장 큰수를 K번 더하고 그 다음으로 큰 수를 1번 더하고, .....
        >> 하나의 cycle은 "K + 1"번으로 구성되어 있다
         */

        int maxNum = nums[nums.length - 1];
        int nextMaxNum = nums[nums.length - 2];

        int cycleCount = M / (K + 1);
        /*
        가장 큰 수(maxNum) -> maxNum * (cycleCount * K + (M % (K + 1)))
        그 다음으로 큰 수(nextMaxNum) -> nextMaxNum * cycleCount
         */

        int result = maxNum * (cycleCount * K + (M % (K + 1))) + nextMaxNum * cycleCount;

        System.out.println(result);
        
        /*
        Time Complexity : O(N)

        >> M이 몇이든 상관없이 오직 input으로 주어지는 숫자의 개수 : N에 의해서 시간복잡도가 결정된다
         */
    }
}

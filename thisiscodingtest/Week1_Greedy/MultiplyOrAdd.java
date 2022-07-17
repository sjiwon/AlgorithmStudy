package thisiscodingtest.Week1_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplyOrAdd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] nums = br.readLine().strip().split("");

        System.out.println(getMaxSum(nums));
    }

    static int getMaxSum(String [] nums){
        int result = Integer.parseInt(nums[0]); // 이전단계에서의 연산결과이자 최종 결과

        for(int i=1; i<nums.length; i++){
            // result or nums[i]가 1보다 작으면 더하기
            int nextNum = Integer.parseInt(nums[i]);

            if(result <= 1 || nextNum <= 1){
                result += nextNum;
            } else{
                result *= nextNum;
            }
        }

        return result;
    }
}

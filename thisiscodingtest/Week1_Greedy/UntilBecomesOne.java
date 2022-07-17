package thisiscodingtest.Week1_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UntilBecomesOne {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 0;
        while(N != 1){
            if(N % K == 0){
                N /= K;
            } else{
                N -= 1;
            }
            result++;
        }

        System.out.println(result);
    }
}

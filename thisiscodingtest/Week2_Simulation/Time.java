package thisiscodingtest.Week2_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Time {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(check(N));
    }

    static int check(int N){
        int result = 0;

        for(int i=0; i<=N; i++){
            for(int j=0; j<60; j++){
                for(int k=0; k<60; k++){
                    if(includeThree(i) || includeThree(j) || includeThree(k)){
                        result++;
                    }
                }
            }
        }

        return result;
    }

    static boolean includeThree(int i){
        return String.valueOf(i).contains("3");
    }
}

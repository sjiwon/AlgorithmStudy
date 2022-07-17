package thisiscodingtest.Week2_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyStraight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        String left = N.substring(0, N.length()/2);
        String right = N.substring(N.length()/2);

        if(halfSum(left) == halfSum(right)){
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }

    static int halfSum(String line){
        int result = 0;
        String [] list = line.split("");

        for(String s : list){
            result += Integer.parseInt(s);
        }

        return result;
    }
}

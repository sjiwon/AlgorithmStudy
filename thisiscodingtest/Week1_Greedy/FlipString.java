package thisiscodingtest.Week1_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlipString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().strip();

        int oneToZero = 0; // 1 -> 0로 변경
        int zeroToOne = 0; // 0 -> 1으로 변경

        if(line.charAt(0) == '0'){
            // 0 -> 1로 변경하는 케이스에서 첫번째 숫자가 0이면
            zeroToOne++;
        } else {
            // 1 -> 0으로 변경하는 케이스에서 첫번째 숫자가 1이면
            oneToZero++;
        }

        for(int i=0; i<line.length() - 1; i++){
            if(line.charAt(i) != line.charAt(i + 1)){ // 연속되는 같은 숫자를 하나의 그룹으로 보고, 그룹과 nextValue가 다른 경우 count++
                if(line.charAt(i + 1) == '0'){
                    // {1, 1, ...} 그룹이 연속되다가 nextValue가 0일 경우 0을 1로 변경
                    zeroToOne++;
                } else {
                    // {0, 0, ...} 그룹이 연속되다가 nextValue가 1일 경우 1을 0으로 변경
                    oneToZero++;
                }
            }
        }

        System.out.println(Math.min(oneToZero, zeroToOne));
    }
}

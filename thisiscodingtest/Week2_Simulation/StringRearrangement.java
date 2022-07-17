package thisiscodingtest.Week2_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringRearrangement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] line = br.readLine().strip().toCharArray();

        List<Character> stringList = new ArrayList<>();

        int numberSum = 0;
        for(char c : line){
            if(Character.isAlphabetic(c)){
                // 영문자이면
                stringList.add(c);
            } else {
                // 숫자면
                numberSum += Integer.parseInt(String.valueOf(c));
            }
        }

        Collections.sort(stringList);

        StringBuilder sb = new StringBuilder();
        for(char c : stringList){
            sb.append(c);
        }
        sb.append(numberSum);

        System.out.println(sb);
    }
}

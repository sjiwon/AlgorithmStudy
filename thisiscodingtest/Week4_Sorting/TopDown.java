package thisiscodingtest.Week4_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopDown {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            list.add(Integer.valueOf(br.readLine()));
        }

        list.sort(Collections.reverseOrder());
        list.forEach(n -> System.out.print(n + " "));
    }
}

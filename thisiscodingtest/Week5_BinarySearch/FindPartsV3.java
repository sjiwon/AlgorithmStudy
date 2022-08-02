package thisiscodingtest.Week5_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// HashMap

public class FindPartsV3 {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> parts = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            parts.put(Integer.parseInt(st.nextToken()), 1);
        }

        int M = Integer.parseInt(br.readLine());
        int[] requests = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            requests[i] = Integer.parseInt(st.nextToken());
        }

        for (int request : requests) {
            if(parts.containsKey(request)){
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}

package thisiscodingtest.Week5_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// HashSet

public class FindPartsV2 {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<Integer> parts = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            parts.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        int[] requests = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            requests[i] = Integer.parseInt(st.nextToken());
        }

        for (int request : requests) {
            if(parts.contains(request)){
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}

package thisiscodingtest.Week5_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BinarySearch

public class FindPartsV1 {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] parts = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            parts[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] requests = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            requests[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(parts); // BinarySearch는 SortedArray에서만 가능

        for (int request : requests) {
            if(isExistParts(parts, 0, parts.length - 1, request)){
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }

    static boolean isExistParts(int[] parts, int left, int right, int idx){
        if(left > right){
            return false;
        }

        int mid = (left + right) / 2;

        if(parts[mid] == idx){
            return true;
        } else if (parts[mid] < idx){
            return isExistParts(parts, mid + 1, right, idx);
        } else {
            return isExistParts(parts, left, mid - 1, idx);
        }
    }
}

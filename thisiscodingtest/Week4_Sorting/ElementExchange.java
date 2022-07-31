package thisiscodingtest.Week4_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ElementExchange {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            B[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int count = 0;
        for(int i=0; i<A.length; i++){
            if(count == K){
                break;
            }

            if(A[i] < B[i]){
                A[i] = B[i];
                count++;
            }
        }

        int result = 0;
        for (Integer num : A) {
            result += num;
        }
        System.out.println(result);
    }
}

package thisiscodingtest.Week5_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindFixedPoint {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findFixedPoint(list, 0, list.length - 1));
    }

    static int findFixedPoint(int[] list, int left, int right){
        if(left > right){
            return -1;
        }

        int mid = (left + right) / 2;

        if(list[mid] < mid) {
            return findFixedPoint(list, mid + 1, right);
        } else if (list[mid] > mid) {
            return findFixedPoint(list, left, mid - 1);
        } else {
            return mid;
        }
    }
}

/*
5
-15 -6 1 3 7
>> 3

7
-15 -4 2 8 9 13 15
>> 2

7
-15 -4 3 8 9 13 15
>> -1
 */
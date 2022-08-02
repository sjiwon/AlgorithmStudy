package thisiscodingtest.Week5_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SpecificNumCountInSortedArray {

    static StringTokenizer st;
    static int lowBound = Integer.MAX_VALUE;
    static int highBound = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] list = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        getRangeLow(list, 0, list.length - 1, x);
        getRangeHigh(list, 0, list.length - 1, x);

        if(lowBound == Integer.MAX_VALUE){
            System.out.println("-1");
        } else{
            System.out.println(highBound - lowBound + 1);
        }
    }

    static void getRangeLow(int[] list, int left, int right, int numX){
        if(left > right){
            return;
        }

        int mid = (left + right) / 2;

        if(list[mid] == numX){
            lowBound = Math.min(lowBound, mid);
            getRangeLow(list, left, mid - 1, numX);
        } else if(list[mid] > numX){
            getRangeLow(list, left, mid - 1, numX);
        } else{
            getRangeLow(list, mid + 1, right, numX);
        }
    }

    static void getRangeHigh(int[] list, int left, int right, int numX){
        if(left > right){
            return;
        }

        int mid = (left + right) / 2;

        if(list[mid] == numX){
            highBound = Math.max(highBound, mid);
            getRangeHigh(list, mid + 1, right, numX);
        } else if(list[mid] > numX){
            getRangeHigh(list, left, mid - 1, numX);
        } else{
            getRangeHigh(list, mid + 1, right, numX);
        }
    }
}

/*
7 2
1 1 2 2 2 2 3
>> 4

7 3
1 1 2 2 2 2 3
>> 1

7 4
1 1 2 2 2 2 3
>> -1
 */
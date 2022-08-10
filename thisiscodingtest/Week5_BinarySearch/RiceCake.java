package thisiscodingtest.Week5_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class RiceCake {

    static StringTokenizer st;
    static int maxHeight = 0; // 절단기 설정 최대 높이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> cake = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cake.add(Integer.parseInt(st.nextToken()));
        }

        cutRiceCake(cake, 0, Collections.max(cake), M);
        System.out.println(maxHeight);
    }

    static void cutRiceCake(List<Integer> cake, int left, int right, int M){
        if(left > right){
            return;
        }

        int cut = (left + right) / 2;

        if(getTotalLength(cake, cut) < M){ // 떡 부족
            cutRiceCake(cake, left, cut - 1, M);
        } else { // 떡 충분하거나 넘침
            maxHeight = cut;
            cutRiceCake(cake, cut + 1, right, M);
        }
    }

    static int getTotalLength(List<Integer> cake, int H){
        int result = 0;
        for (int length : cake) {
            result += (Math.max(length - H, 0));
        }
        return result;
    }
}

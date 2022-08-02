package thisiscodingtest.Week5_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RouterInstallation {

    static StringTokenizer st;
    static int maxDistance = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] point = new int[N];

        for(int i=0; i<N; i++){
            point[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(point);

        int minimumDistance = 1;
        int maximumDistance = point[point.length - 1] - point[0] + 1;
        install(point, minimumDistance, maximumDistance, C);
        System.out.println(maxDistance);
    }

    static void install(int[] point, int left, int right, int C){
        if(left > right){
            return;
        }

        int mid = (left + right) / 2; // 공유기 간에 거리 = mid

        if(routerCount(point, mid) >= C){
            /*
            1. C개 이상으로 설치했으면 일단 공유기 간 거리 저장
            2. 공유기간 거리 더 넓혀서 설치해보기 (저장된 거리보다 더 넓은 거리로 설치할 수 있는지)
             */
            maxDistance = mid;
            install(point, mid + 1, right, C);
        } else { // C개를 설치하지 못함 = 공유기 간 거리가 너무 멀다 -> 공유기간 거리 좁혀서 설치
            install(point, left, mid - 1, C);
        }
    }

    static int routerCount(int[] point, int distance){
        int count = 1; // 가정 : 첫번째 집 무조건 설치
        int lastInstallIndex = point[0]; // 첫번째 집 index (설치했으니까)

        for(int i=1; i<point.length; i++){
            if(point[i] - lastInstallIndex >= distance){
                count += 1;
                lastInstallIndex = point[i];
            }
        }

        return count;
    }
}

/*
5 3
1
2
8
4
9
>> 3

10 5
74
28
46
59
85
14
57
83
32
41
>> 13

4 3
1
4
7
10
>> 3

5 2
1
2
8
4
9
>> 8

5 3
1
7
8
9
10
>> 3
 */
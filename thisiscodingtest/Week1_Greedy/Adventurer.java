package thisiscodingtest.Week1_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Adventurer {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] users = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            users[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(users);

        int result = 0; // 총 그룹 수
        int groupMembers = 0; // 한 그룹 내부에 속한 모험가들 (추가될때마다 update)

        for(int fear : users){
            groupMembers++; // 그룹에 모험가 추가

            if(fear == groupMembers){
                // 그룹수가 공포도를 충족했으면 거기서 하나의 그룹 만들고 초기화
                result++;
                groupMembers = 0;
            }
        }

        System.out.println(result);
    }
}
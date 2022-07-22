package thisiscodingtest.Week3_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InterleaveOperator {

    static StringTokenizer st;
    static int N;
    static int[] list;
    static int[] operator; // 덧셈(+) 뺄셈(-) 곱셈(X) 나눗셈(/) 순서대로

    static int minResult = Integer.MAX_VALUE;
    static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new int[N];
        operator = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<operator.length; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        operation(list[0], 0); // 선택한 연산자 개수
        System.out.print(maxResult + "\n" + minResult);
    }

    static void operation(int calcResult, int selectOperator){
        if(selectOperator == N-1){
            minResult = Math.min(minResult, calcResult);
            maxResult = Math.max(maxResult, calcResult);
            return;
        }

        for(int i=0; i<operator.length; i++){
            if(operator[i] > 0){ // 연산자 개수가 아직 남아있으면
                operator[i] -= 1; // 골라주기
                
                if(i == 0){
                    operation(calcResult + list[selectOperator + 1], selectOperator + 1);
                } else if(i == 1){
                    operation(calcResult - list[selectOperator + 1], selectOperator + 1);
                } else if(i == 2){
                    operation(calcResult * list[selectOperator + 1], selectOperator + 1);
                } else{
                    operation(calcResult / list[selectOperator + 1], selectOperator + 1);
                }
                
                operator[i] += 1; // 고른거 다시 롤백
            }
        }
    }
}

/*
2
5 6
0 0 1 0
>> 30, 30

3
3 4 5
1 0 1 0
>> 35, 17

6
1 2 3 4 5 6
2 1 1 1
>> 54, -24
 */
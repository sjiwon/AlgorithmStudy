package thisiscodingtest.Week4_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortingCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (pq.size() >= 2) {
            // 2개씩 꺼내서 더하고 더한값 집어넣기
            Integer firstNum = pq.poll();
            Integer secondNum = pq.poll();

            assert secondNum != null;
            result += firstNum + secondNum; // 2개씩 꺼내서 더한값 누적
            pq.offer(firstNum + secondNum);
        }

        System.out.println(result);
    }
}

/*
3
10
20
40
>> 100

4
30
40
50
100
>> 410

4
30
40
50
60
>> 360

8
30
40
50
20
10
100
60
120
>> 1160

8
30
40
50
20
10
100
60
10
>> 860

4
120
40
100
20
>> 500
 */

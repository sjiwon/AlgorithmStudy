package thisiscodingtest.Week4_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class OrderOfLowerGrades {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> list = new HashMap<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            list.put(name, score);
        }

        LinkedList<Map.Entry<String, Integer>> entries = new LinkedList<>(list.entrySet());
        entries.sort((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.print(entry.getKey() + " ");
        }
    }
}

package thisiscodingtest.Week2_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UDLR {

    static StringTokenizer st;
    static int N;
    static int X = 1;
    static int Y = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<String> direction = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            direction.add(st.nextToken());
        }

        for(String d : direction){
            move(d);
        }

        System.out.println(X + " " + Y);
    }

    static boolean isRange(int x, int y){
        return 1 <= x && x <= N && 1 <= y && y <= N;
    }

    static int [] xyFromDirection(String d){
        switch (d){
            case "L" -> {
                return new int[] {0, -1};
            }
            case "R" -> {
                return new int[] {0, 1};
            }
            case "U" -> {
                return new int[] {-1, 0};
            }
            case "D" -> {
                return new int[] {1, 0};
            }
        }

        return new int[] {0, 0};
    }

    static void move(String d){
        int [] newD = xyFromDirection(d);

        if(isRange(X + newD[0], Y + newD[1])){
            X += newD[0];
            Y += newD[1];
        }
    }
}

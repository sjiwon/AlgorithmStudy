package thisiscodingtest.Week2_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoyalWarrior {

    /*
    UUR UUL DDR DDL / RRU RRD LLU LLD
     */
    static final int MAP_SIZE = 8;
    static int [] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
    static int [] dy = {1, -1, 1, -1, 2, 2, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] xy = br.readLine().strip().split("");

        int currentX = charToInt(xy[0]);
        int currentY = Integer.parseInt(xy[1]);
        // 왼쪽 상단 좌표 = (1, 1)로 설정

        System.out.println(move(currentX, currentY));
    }

    static int charToInt(String s){
        // 'a'의 아스키 코드 = 97
        return s.charAt(0) - 96;
    }

    static boolean isRange(int x, int y){
        return 1 <= x && x <= MAP_SIZE && 1 <= y && y <= MAP_SIZE;
    }

    static int move(int x, int y){
        int count = 0;

        for(int i=0; i<dx.length; i++){
            if(isRange(x + dx[i], y + dy[i])){
                count++;
            }
        }

        return count;
    }
}

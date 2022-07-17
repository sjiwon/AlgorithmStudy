package thisiscodingtest.Week2_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DevelopGame {

    static StringTokenizer st;
    static int N;
    static int M;
    static int [][] map;
    static boolean [][] visited;

    static int X; // Player 초기 좌표 (x)
    static int Y; // Plyaer 초기 좌표 (y)
    static int d; // Player 초기 바라보는 방향

    // 북 동 남 서
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, 1, 0, -1};

    static int count = 0; // 캐릭터가 방문한 칸의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine()); // 맵 크기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine()); // 플레이어 초기 좌표 & 바라보는 방향
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken()); // [0=U / 1=R / 2=D / 3=L]

        for(int i=0; i<map.length; i++){
            st = new StringTokenizer(br.readLine()); // 0=육지, 1=바다
            for(int j=0; j<map[i].length; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        gameTest();
        System.out.println(count);
    }

    static void gameTest(){
        int currentX = X;
        int currentY = Y;
        int currentD = d;
        visited[currentX][currentY] = true;

        while(true){
            boolean flag = false; // 이동한지 여부
            
            for(int i=0; i<dx.length; i++){
                currentD = turnLeft(currentD); // 고개 왼쪽으로 돌리기

                int nextX = currentX + dx[currentD];
                int nextY = currentY + dy[currentD];

                if(isPossibleLeftPosition(nextX, nextY)){
                    flag = true;
                    currentX = nextX;
                    currentY = nextY;
                    visited[currentX][currentY] = true;
                    count++; // 이동했으니까 count 증가
                    break;
                }
            }

            if(!flag){
                // 현재 방향 기준 아무데나 못 갈 경우
                int backX = currentX + dx[goBack(currentD)];
                int backY = currentY + dy[goBack(currentD)];

                if(isImpossibleBackPosition(backX, backY)){
                    // 바다는 못감 -> 캐릭터 이동 중지 & 게임 종료
                    break;
                } else {
                    currentX = backX;
                    currentY = backY;
                    visited[currentX][currentY] = true; // 뒤로 간 곳이 이미 갔을 수도 있지만 처음 가는 곳일수도 있기 때문에
                    count++; // 뒤로 간 것도 이동한거니까 count 증가
                }
            }
        }
    }

    static boolean isPossibleLeftPosition(int x, int y){
        // 왼쪽 방향 갈 수 있는지
        return isRange(x, y) && !visited[x][y] && map[x][y] != 1;
    }

    static boolean isImpossibleBackPosition(int x, int y){
        // 뒤로 갈 수 있는지
        return !isRange(x, y) || map[x][y] == 1;
    }

    static boolean isRange(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static int turnLeft(int d){
        /*
        0 -> 3
        1 -> 0
        2 -> 1
        3 -> 2
         */
        return (d - 1 < 0) ? 3 : d-1;
    }

    static int goBack(int d){
        /*
        0 -> 2
        1 -> 3
        2 -> 0
        3 -> 1
         */
        return (d + 2 >= 4) ? (d - 2) : d + 2;
    }
}

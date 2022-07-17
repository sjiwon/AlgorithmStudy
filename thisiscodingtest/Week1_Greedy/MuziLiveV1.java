package thisiscodingtest.Week1_Greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class Solution {

    static class Food{
        private int idx;
        private int time;

        public Food(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        public int getIdx() {
            return idx;
        }

        public int getTime() {
            return time;
        }
    }

    public int solution(int[] food_times, long k) {
        Queue<Food> table = new LinkedList<>();

        for(int i=0; i<food_times.length; i++){
            table.offer(new Food((i + 1), food_times[i]));
        }

        long time = 0; // while문 내부에서 Muzi가 먹을때마다 증가
        while(!table.isEmpty()){
            if(time == k){
                break;
            }
            eatingLive(table);
            time++;
        }

        if(table.isEmpty()){
            return -1;
        } else {
            return table.peek().getIdx();
        }
    }

    static void eatingLive(Queue<Food> table){
        // table에서 순차적으로 음식 꺼내서 먹기
        if(!table.isEmpty()){
            Food ate = table.poll();

            if(ate.getTime() > 1){
                // 음식 먹을 시간이 아직 남아있다면 다시 table에 넣어주기
                table.offer(new Food(ate.getIdx(), ate.getTime() - 1));
            }
        }
    }
}

public class MuziLiveV1 {
    static void start(int [] food_times, int k, int expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("food_times = " + Arrays.toString(food_times) + " / k = " + k);
        int solution = new Solution().solution(food_times, k);
        System.out.println("expect = " + expect + " -> actual = " + solution + "\n");
        Assert.assertEquals(solution, expect);
    }
    @Test
    public void 테스트케이스1(){
        start(new int[]{3, 1, 2}, 5, 1);
    }

    @Test
    public void 테스트케이스2(){
        start(new int[]{1, 1, 1, 1}, 4, -1);
    }

    @Test
    public void 테스트케이스3(){
        start(new int[]{1, 3, 3, 5, 6, 6}, 20, 5);
    }

    @Test
    public void 테스트케이스4(){
        start(new int[]{2, 4, 6, 1, 3, 5}, 14, 6);
    }

    @Test
    public void 테스트케이스5(){
        start(new int[]{2, 20, 11, 17}, 35, 2);
    }

    @Test
    public void 테스트케이스6(){
        start(new int[]{15, 11, 13, 3, 3, 17, 16, 13, 7, 7, 13, 15, 16}, 8, 9);
    }

    @Test
    public void 테스트케이스7(){
        start(new int[]{9, 10, 17, 16, 2, 13, 5, 12, 3, 3}, 9, 10);
    }

    @Test
    public void 테스트케이스8(){
        start(new int[]{5, 19, 3, 3, 16, 11, 13, 6, 13, 2}, 5, 6);
    }
    @Test
    public void 테스트케이스9(){
        start(new int[]{16, 10, 18, 10, 10, 16, 6}, 6, 7);
    }
}

/*
정확성 통과 but 효율성 전부 시간초과
>> 시간복잡도가 O(k)이니까
 */
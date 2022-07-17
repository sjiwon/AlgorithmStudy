package thisiscodingtest.Week1_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MoneyThatCannotBeMade {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] money = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            money[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(money);

        int expectMoney = 1; // 초기 start (양의 정수 금액)
        for(int m : money){
            if(expectMoney < m){
                break;
            }

            expectMoney += m;
        }

        System.out.println(expectMoney);
    }
}

/*
expectMoney = 매 loop때마다 들어오기를 기대하는 금액 (initialize 1)
-> loop를 돌면서 부여되는 금액을 확인

예를 들어서 eM이 1부터 시작하고, 다음 들어오는 금액이 1이라면 -> 1, "2(1+1)"을 만들 수 있다
-> expectMoney += <부여된 금액>으로 update하고 이 expectMoney가 이제 다음 loop때 부여되기를 희망하는 금액

여기서 {1}을 보유하고 있을 때 "3"이라는 금액이 들어온다면 -> 1, "3", "4(1+3)"을 만들 수 있다
-> 그러나 여기서 "2"는 만들 수 없기 떄문에 2가 답이 되고 return

따라서 다음에 부여되기를 기대하는 금액(expectMoney)보다 부여되는 금액이 크다면 expectMoney를 만들지 못하고 expectMoney를 그대로 return
 */

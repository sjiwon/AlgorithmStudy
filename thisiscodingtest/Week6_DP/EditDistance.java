package thisiscodingtest.Week6_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        // Base
        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = 0; i <= A.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= B.length; i++) {
            dp[0][i] = i;
        }

        // Logic
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1] + 1; // A[i]에 문자 Insert
                    int remove = dp[i - 1][j] + 1; // A[i]의 문자 Remove
                    int replace = dp[i - 1][j - 1] + 1; // A[i], B[j] Replace

                    dp[i][j] = Math.min(insert, Math.min(remove, replace));
                }
            }
        }

        System.out.println(dp[A.length][B.length]);
    }
}

/*
cat
cut
>> 1

sunday
saturday
>> 3

ALTRUISTIC
ALGORITHM
>> 6

FOOD
MONEY
>> 4

VOLDEMORT
DUMBLEDORE
>> 7

a
ccccc
>> 5

atcgccg
acgctgc
>> 3
 */
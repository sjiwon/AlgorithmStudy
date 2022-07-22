package thisiscodingtest.Week3_DFS_BFS;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

class Solution {
    public String solution(String p) {
        return recursionString(p);
    }

    static String recursionString(String p){
        if(p.length() == 0){
            return ""; // [1]
        }

        String[] splitP = getSplitP(p); // [2]
        if(isCorrectString(splitP[0])){ // [3]
            return splitP[0] + recursionString(splitP[1]); // 3-1
        } else { // [4]
            return "(" // 4-1
                    + recursionString(splitP[1]) + // 4-2
                    ")" // 4-3
                    + getReverseParenthesis(splitP[0].substring(1, splitP[0].length() - 1)); // 4-4
        }
    }

    static String[] getSplitP(String p){
        // 2단계 - 문자열 p를 u/v로 분리 (u=균형잡힌 괄호 문자열, v=빈 문자열 가능)
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        int leftCount = 0; // "("
        int rightCount = 0; // ")"

        int index = 0;
        for(char c : p.toCharArray()){
            if(c == '('){
                index++;
                leftCount++;
                u.append(c);
            } else {
                index++;
                rightCount++;
                u.append(c);
            }

            if(leftCount == rightCount){
                break;
            }
        }

        v.append(p.substring(index));

        return new String[]{u.toString(), v.toString()};
    }

    static boolean isCorrectString(String p){
        Stack<Character> stack = new Stack<>();

        for(char c : p.toCharArray()){
            if(c == '('){
                stack.push(c);
            } else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    static String getReverseParenthesis(String s){
        /*
        단순히 sb.reverse()를 통해서 문자열 역순으로 하는거랑 괄호 하나하나 방향 뒤집는거랑 결과가 다름
        -> 괄호 하나하나 방향 뒤집기
         */
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == '('){
                sb.append(")");
            } else{
                sb.append("(");
            }
        }

        return sb.toString();
    }
}

public class ParenthesisConversion {
    static void start(String p, String expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<주어진괄호 p>");
        System.out.println(p);

        String solution = new Solution().solution(p);
        System.out.println("\n<Result>");
        System.out.println(solution + "\n");
        System.out.println("expect(도출한 답) = " + solution + " -> actual(실제 도출되어야 하는 답) = " + expect);
        Assert.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start("(()())()", "(()())()");
    }

    @Test
    public void 테스트케이스2(){
        start(")(", "()");
    }

    @Test
    public void 테스트케이스3(){
        start("()))((()", "()(())()");
    }

    // "))))(((("
    @Test
    public void 테스트케이스4(){
        start("))))((((", "()((()))");
    }
}

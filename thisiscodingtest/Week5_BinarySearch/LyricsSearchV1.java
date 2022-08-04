package thisiscodingtest.Week5_BinarySearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int queryLength = query.length();
            int matchCount = 0; // match되는 단어 개수

            boolean isPrefix = isPrefixCheck(query); // "?"가 접두사로 존재하는지
            query = query.replaceAll("\\?", ""); // "?" 제거
            int updateQueryLength = query.length(); // "?"를 제거한 검색 키워드 길이

            for (String word : words) {
                if(word.length() != queryLength){
                    continue; // 단어 길이 자체가 다르면 비교 불가
                }

                if (isPrefix) {
                    word = word.substring(word.length() - updateQueryLength, word.length());
                } else {
                    word = word.substring(0, updateQueryLength);
                }

                if (word.equals(query)) {
                    matchCount += 1;
                }
            }

            result[i] = matchCount;
        }

        return result;
    }

    static boolean isPrefixCheck(String query){
        return query.startsWith("?");
    }
}

public class LyricsSearchV1 {
    static void start(String[] words, String[] queries, int[] expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<Words>");
        System.out.println(Arrays.toString(words) + "\n");
        System.out.println("<Queries>");
        System.out.println(Arrays.toString(queries) + "\n");

        int[] solution = new Solution().solution(words, queries);
        System.out.println("<Result>");
        System.out.println(Arrays.toString(solution) + "\n");
        System.out.println("expect(도출한 답) = " + Arrays.toString(solution) + " -> actual(실제 도출되어야 하는 답) = " + Arrays.toString(expect));

        Assert.assertArrayEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(
                new String[] {
                        "frodo",
                        "front",
                        "frost",
                        "frozen",
                        "frame",
                        "kakao"
                },
                new String[] {
                        "fro??",
                        "????o",
                        "fr???",
                        "fro???",
                        "pro?"
                },
                new int[] {3, 2, 4, 1, 0}
        );
    }
}

/*
정확성 테스트
테스트 1 〉	통과 (2.25ms, 83MB)
테스트 2 〉	통과 (1.07ms, 69MB)
테스트 3 〉	통과 (1.48ms, 77.8MB)
테스트 4 〉	통과 (1.94ms, 78.6MB)
테스트 5 〉	통과 (1.19ms, 75.6MB)
테스트 6 〉	통과 (2.13ms, 77.7MB)
테스트 7 〉	통과 (11.52ms, 81MB)
테스트 8 〉	통과 (8.36ms, 83.4MB)
테스트 9 〉	통과 (12.84ms, 80MB)
테스트 10 〉	통과 (9.05ms, 82.1MB)
테스트 11 〉	통과 (7.14ms, 81.5MB)
테스트 12 〉	통과 (12.29ms, 80.8MB)
테스트 13 〉	통과 (45.04ms, 104MB)
테스트 14 〉	통과 (34.52ms, 91.9MB)
테스트 15 〉	통과 (72.24ms, 96.6MB)
테스트 16 〉	통과 (33.75ms, 97.9MB)
테스트 17 〉	통과 (40.36ms, 97.6MB)
테스트 18 〉	통과 (30.21ms, 96.4MB)

효율성 테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	통과 (126.62ms, 76.9MB)
테스트 5 〉	통과 (119.02ms, 75.1MB)
 */
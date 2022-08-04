package thisiscodingtest.Week5_BinarySearch;

import org.junit.Assert;
import org.junit.Test;

/*
접두사 -> 그냥 그대로 BinarySearch 문자열 검색 (compareTo?)
접미사 -> 뒤집고 나서 BinarySearch

aa??? -> aa"aaa" ~ aa"zzz"
???aa -> 동일하게 "aaa"aa ~ "zzz"aa하면 끝에가 aa가 아닌 다른 문자열이 나올 수 있음
    >> 뒤집어서 aa"aaa" ~ aa"zzz"로 판별해야 한다
 */

import java.util.*;

class Solution2 {

    static class QueryInfo{
        private int queryLength;
        private int matchCount;

        public QueryInfo(int queryLength) {
            this.queryLength = queryLength;
            matchCount = 0;
        }

        public int getQueryLength() {
            return queryLength;
        }

        public int getMatchCount(){
            return matchCount;
        }

        public void setMatchCount(int matchCount){
            this.matchCount = matchCount;
        }

        @Override
        public String toString() {
            return "QueryInfo{" +
                    "queryLength=" + queryLength +
                    ", matchCount=" + matchCount +
                    '}';
        }
    }

    static Map<String, QueryInfo> queryMap; // [key = 쿼리, value = {쿼리 쿼리, 쿼리와 매칭되는 word 개수}]
    static List<List<String>> list; // 그대로 저장 (접두사)
    static List<List<String>> reverseList; // 뒤집어서 저장 (접미사)
    static final int MAX_WORDS_LENGTH = 10000;

    public int[] solution(String[] words, String[] queries) {
        queryMap = new HashMap<>(); // [key = 쿼리, value = {쿼리 쿼리, 쿼리와 매칭되는 word 개수}]
        list = new ArrayList<>(); // 그대로 저장 (접두사)
        reverseList= new ArrayList<>(); // 뒤집어서 저장 (접미사)

        for (int i = 0; i <= MAX_WORDS_LENGTH; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        for (String word : words) {
            list.get(word.length()).add(word); // 그대로 저장
            reverseList.get(word.length()).add(new StringBuffer(word).reverse().toString()); // 뒤집어서 저장
        }

        for (int i = 1; i <= MAX_WORDS_LENGTH; i++) {
            // BinarySearch를 위해서 내부 element 정렬
            Collections.sort(list.get(i));
            Collections.sort(reverseList.get(i));
        }

        for (String query : queries) {
            if (!queryMap.containsKey(query)) { // 동일한 검색 키워드 중복 제거
                queryMap.put(query, new QueryInfo(query.length()));
            }
        }

        for (String query : queryMap.keySet()) {
            QueryInfo queryInfo = queryMap.get(query);

            List<String> subList;
            String queryA;
            String queryZ;
            if(isPrefix(query)) {
                // 뒤집은 후 a ~ z까지 탐색
                subList = reverseList.get(queryInfo.getQueryLength());
                queryA = new StringBuilder(query).reverse().toString().replaceAll("\\?", "a");
                queryZ = new StringBuilder(query).reverse().toString().replaceAll("\\?", "z");
            } else {
                // 그대로 a ~ z까지 탐색
                subList = list.get(queryInfo.getQueryLength());
                queryA = query.replaceAll("\\?", "a");
                queryZ = query.replaceAll("\\?", "z");
            }

            if (subList.isEmpty()) { // 비어있으면 매칭되는 단어 X
                queryInfo.setMatchCount(0);
            } else {
                queryInfo.setMatchCount(getMatchCount(subList, queryA, queryZ));
            }
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            result[i] = queryMap.get(queries[i]).getMatchCount();
        }

        return result;
    }

    static boolean isPrefix(String query){
        return query.charAt(0) == '?';
    }

    /*
    a.compareTo(b)
    -> a가 b보다 사전 순 앞에 있으면 음수가 나온다
    -> a가 b보다 사전 순 동일하면 0이 나온다
    -> a가 b보다 사전 순 뒤에 있으면 양수가 나온다
     */

    static int getLowerBound(List<String> words, String lowerString, int left, int right, int lowerBound) {
        if (left > right) {
            return lowerBound;
        }

        int mid = (left + right) / 2;
        int compareTo = words.get(mid).compareTo(lowerString);
        /*
        compareTo가 0 이상이여야 lowerString의 lowerBound 후보가 된다 (lowerString Range 안에 들어오기 때문에)
         */

        if (compareTo >= 0) {
            lowerBound = Math.min(lowerBound, mid);
            return getLowerBound(words, lowerString, left, mid - 1, lowerBound);
        } else {
            return getLowerBound(words, lowerString, mid + 1, right, lowerBound);
        }
    }

    static int getUpperBound(List<String> words, String upperString, int left, int right, int upperBound){
        if(left > right){
            return upperBound;
        }

        int mid = (left + right) / 2;
        int compareTo = words.get(mid).compareTo(upperString);
        /*
        compareTo가 0 이하여야 upperString의 upperBound 후보가 된다 (upperString Range 안에 들어오기 때문에)
         */

        if(compareTo <= 0) {
            upperBound = Math.max(upperBound, mid);
            return getUpperBound(words, upperString, mid + 1, right, upperBound);
        } else {
            return getUpperBound(words, upperString, left, mid - 1, upperBound);
        }
    }

    static int getMatchCount(List<String> words, String lowerString, String upperString){
        int lowerBound = getLowerBound(words, lowerString, 0, words.size() - 1, Integer.MAX_VALUE);
        int upperBound = getUpperBound(words, upperString, 0, words.size() - 1, Integer.MIN_VALUE);

        if (lowerBound == Integer.MAX_VALUE) { // lowerBound가 초기 설정값 그대로면 해당 List에 query와 매칭될 word가 없다는 의미
            return 0;
        } else {
            return upperBound - lowerBound + 1; // 구간 안의 요소 개수
        }
    }
}

public class LyricsSearchV2 {
    static void start(String[] words, String[] queries, int[] expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<Words>");
        System.out.println(Arrays.toString(words) + "\n");
        System.out.println("<Queries>");
        System.out.println(Arrays.toString(queries) + "\n");

        int[] solution = new Solution2().solution(words, queries);
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

    @Test
    public void 테스트케이스2(){
        start(
                new String[] {
                        "aa",
                        "ac",
                        "az"
                },
                new String[] {
                        "a?"
                },
                new int[] {3}
        );
    }

    @Test
    public void 테스트케이스3(){
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
                        "?????"
                },
                new int[] {5}
        );
    }
}

/*
정확성 테스트
테스트 1 〉	통과 (7.10ms, 79.2MB)
테스트 2 〉	통과 (6.14ms, 76.7MB)
테스트 3 〉	통과 (6.47ms, 79.9MB)
테스트 4 〉	통과 (6.97ms, 74.9MB)
테스트 5 〉	통과 (7.02ms, 83.9MB)
테스트 6 〉	통과 (7.68ms, 80.2MB)
테스트 7 〉	통과 (18.70ms, 87.3MB)
테스트 8 〉	통과 (19.30ms, 91.5MB)
테스트 9 〉	통과 (16.52ms, 80.1MB)
테스트 10 〉	통과 (12.43ms, 86.3MB)
테스트 11 〉	통과 (11.94ms, 83MB)
테스트 12 〉	통과 (13.54ms, 87.2MB)
테스트 13 〉	통과 (26.10ms, 85.6MB)
테스트 14 〉	통과 (20.93ms, 81.1MB)
테스트 15 〉	통과 (27.80ms, 87.4MB)
테스트 16 〉	통과 (29.57ms, 102MB)
테스트 17 〉	통과 (25.65ms, 89.3MB)
테스트 18 〉	통과 (23.91ms, 87.6MB)

효율성 테스트
테스트 1 〉	실패 (229.57ms, 88MB)
테스트 2 〉	통과 (546.22ms, 136MB)
테스트 3 〉	통과 (227.61ms, 95.6MB)
테스트 4 〉	통과 (208.17ms, 80.9MB)
테스트 5 〉	통과 (295.17ms, 88.3MB)
 */
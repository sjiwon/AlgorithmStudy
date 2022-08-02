# 알고리듬 스터디
> 코딩 테스트 준비를 위한 스터디
* 기간 : 2022/07/07 ~
* 피드백 : 매주 수요일 오후 8시
* 언어 : Java / Python
<hr>

# Commit Rule
- commit 메시지 : [문제 출처] 문제 이름 / 문제 유형 / 문제 난이도<br>
- description : 문제에 대한 덧붙일 설명 (<> 내부에 작성)
    - [TCT] : 이것이 코딩 테스트다 with 파이썬
        - <code>[문제 출처] 문제 이름 / 문제 유형</code>
    - [PGS] : 프로그래머스
        - <code>[문제 출처] 문제 이름 / 문제 난이도</code>
    - [BOJ] : 백준
        - <code>[문제 출저] 문제 이름 / 문제 유형 / 문제 난이도</code>
    - [SEA] : 삼성 SW Expert Academy
    - [ETC] : 그외
> ex 1) [TCT] 큰 수의 법칙 / Greedy<br>
> ex 2) [TCT] 큰 수의 법칙 / Greedy <시간복잡도 O(1)으로 구현><br>
> ex 3) [PGS] 로또의 최고 순위와 최저 순위 / Level 1<br>
> ex 4) [BOJ] 리모컨 / 브루트포스 알고리즘 / Gold 5

<hr>

# 1. 이것이 코딩 테스트다 with 파이썬 [TCT]
### Week 1 -> 그리디
- 실전
    - 큰수의 법칙
        - Version 1 <시간복잡도 O(M)> : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week1_Greedy/RuleOfLargeNumberV1.java)
        - Version 2 <시간복잡도 O(N)> : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week1_Greedy/RuleOfLargeNumberV2.java)
    - 숫자 카드 게임 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week1_Greedy/NumberCardGame.java)
    - 1이 될 때까지 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week1_Greedy/UntilBecomesOne.java)
- 기출
    - 모험가 길드 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week1_Greedy/Adventurer.java)
    - 곱하기 혹은 더하기 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week1_Greedy/MultiplyOrAdd.java)
    - 문자열 뒤집기 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week1_Greedy/FlipString.java)
    - 만들 수 없는 금액 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week1_Greedy/MoneyThatCannotBeMade.java)
    - 볼링공 고르기 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week1_Greedy/BowlingBall.java)
    - 무지의 먹방 라이브 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week1_Greedy/MuziLiveV2.java)

<hr>

### Week 2 -> 구현
- 예제
    - 상하좌우 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week2_Simulation/UDLR.java)
    - 시각 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week2_Simulation/Time.java)
- 실전
    - 왕실의 나이트 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week2_Simulation/RoyalWarrior.java)
    - 게임 개발 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week2_Simulation/DevelopGame.java)
- 기출
    - 럭키 스트레이트 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week2_Simulation/LuckyStraight.java)
    - 문자열 재정렬 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week2_Simulation/StringRearrangement.java)
    - 문자열 압축 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week2_Simulation/StringPress.java)
    - 자물쇠와 열쇠 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week2_Simulation/LockAndKey.java)
    - 뱀 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week2_Simulation/Snake.java)
    - 기둥과 보 설치 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week2_Simulation/Installation.java)
    - 치킨 배달 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week2_Simulation/DeliveryChicken.java)
    - 외벽 점검 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week2_Simulation/Inspection.java)
<hr>

### Week 3 -> DFS/BFS
- 예제
    - DFS
        - 인접 행렬 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/DFS_Matrix.java)
        - 인접 리스트 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/DFS_List.java)
    - BFS
        - 인접 행렬 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/BFS_Matrix.java)
        - 인접 리스트 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/BFS_List.java)
- 실전
    - 음료수 얼려 먹기 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/FreezeDrinks.java)
    - 미로 탈출 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/MazeEscape.java)
- 기출
    - 특정 거리의 도시 찾기
      - BFS 풀이 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/FindCityOnSpecificStreetV1.java)
      - Dijkstra 풀이 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/FindCityOnSpecificStreetV2.java)
    - 연구소 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/Laboratory.java)
    - 경쟁적 전염 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/CompetitiveContagion.java)
    - 괄호 변환 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/ParenthesisConversion.java)
    - 연산자 끼워 넣기 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/InterleaveOperator.java)
    - 감시 피하기 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/AvoidSurveillance.java)
    - 인구 이동 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/PopulationMovement.java)
    - 블록 이동하기 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week3_DFS_BFS/MoveBlocks.java)
<hr>

### Week 4 -> 정렬
- 예제
    - Bubble Sort : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week4_Sorting/BubbleSort.java)
    - Selection Sort : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week4_Sorting/SelectionSort.java)
    - Insertion Sort : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week4_Sorting/InsertionSort.java)
    - Merge Sort : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week4_Sorting/MergeSort.java)
    - Quick Sort : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week4_Sorting/QuickSort.java)
- 실전
    - 위에서 아래로 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week4_Sorting/TopDown.java)
    - 성적이 낮은 순서로 학생 출력하기 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week4_Sorting/OrderByGradeASC.java)
    - 두 배열의 원소 교체 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week4_Sorting/ElementExchange.java)
- 기출
    - 국영수 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week4_Sorting/KorEngMath.java)
    - 안테나 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week4_Sorting/Antenna.java)
    - 실패율 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week4_Sorting/FailureRate.java)
    - 카드 정렬하기 : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week4_Sorting/SortingCard.java)
<hr>

### Week 5 -> 이진탐색
- 실전
    - 부품 찾기
      - Version 1(BinarySearch) : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week5_BinarySearch/FindPartsV1.java)
      - Version 2(HashSet) : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week5_BinarySearch/FindPartsV2.java)
      - Version 3(HashMap) : [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week5_BinarySearch/FindPartsV3.java)
    - 떡볶이 떡 만들기: [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week5_BinarySearch/RiceCake.java)
- 기출
    - 정렬된 배열에서 특정 수의 개수 구하기: [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week5_BinarySearch/SpecificNumCountInSortedArray.java)
    - 고정점 찾기: [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week5_BinarySearch/FindFixedPoint.java)
    - 공유기 설치: [바로가기](https://github.com/sjiwon/AlgorithmStudy/blob/master/thisiscodingtest/Week5_BinarySearch/RouterInstallation.java)
    - 가사 검색
<hr>

### Week 6 -> DP (Dynamic Programming)
- 실전
    - 1로 만들기
    - 개미 전사
    - 바닥 공사
    - 효율적인 화폐 구성
- 기출
    - 금광
    - 정수 삼각형
    - 퇴사
    - 병사 배치하기
    - 못생긴 수
    - 편집 거리
<hr>

### Week 7 -> 최단경로
- 예제
    - 다익스트라
    - 플로이드-와샬
- 실전
    - 미래 도시
    - 전보
- 기출
    - 플로이드
    - 정확한 순위
    - 화성 탐사
    - 숨바꼭질
<hr>

### Week 8 -> 그래프
- 예제
    - 크루스칼 (with Union-Find)
    - 프림
    - 위상정렬
- 실전
    - 팀 결성
    - 도시 분할 계획
    - 커리큘럼
- 기출
    - 여행 계획
    - 탑승구
    - 어두운 길
    - 행성 터널
    - 최종 순위
<hr>

# 2. 프로그래머스 문제풀이
> ?

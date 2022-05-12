보물
---

date : 2022-02-11   
url : https://www.acmicpc.net/problem/1026   
difficulty : Silver 4   
status : success

문제
---

옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.

길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.

S = A[0] × B[0] + ... + A[N-1] × B[N-1]

S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.

S의 최솟값을 출력하는 프로그램을 작성하시오.

입력
---
첫째 줄에 N이 주어진다. 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 셋째 줄에는 B에 있는 수가 순서대로 주어진다. N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.

출력
---
첫째 줄에 S의 최솟값을 출력한다.

예제
--

### 1)
- input
```
5
1 1 1 6 0
2 7 8 3 1
```

- output
```
18
```

### 2)

- input
```
3
1 1 3
10 30 20
```

- output
```
80
```

### 3)

- input
```
9
5 15 100 31 39 0 0 3 26
11 12 13 2 3 4 5 9 1
```

- output
```
528
```

풀이
---

```
첫 번째 행을 오름차순으로 정렬하고 두 번째 행에서 값이 큰 값 부터 차례로 첫번째 행과 곱하여 결과값에 저장합니다. 
```
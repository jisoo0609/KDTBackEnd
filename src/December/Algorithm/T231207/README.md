# Queue

- 대기열처럼 작동하는 자료구조
- 자료가 일렬로 놓인 선형 자료구조
- 제일 먼저 추가된 자료가 먼저 나오는 선입선출(First In First Out) 자료구조

## Queue의 기능

### 배열을 이용한  큐

- queue에 데이터 추가
    - enQueue()

    ```java
    public void enQueue(int x) {
            // 넣어줄 공간을 설정하고
            rear++;
            // 해당 위치에 넣어준다
            arr[rear] = x;
        }
    ```

    - 원형 큐

    ```java
    public void enQueue(int x) {
            arr[rear] = x;
            // 위치 재설정
            rear = (rear + 1) % offset;
        }
    ```

- queue에서 데이터 회수
    - deQueue()

    ```java
    public int deQueue() {
            // 데이터를 가져올 공간을 설정하고
            front++;
            // 해당 위치에서 가져온다
            return arr[front];
        }
    ```

    - 원형 큐

    ```java
    public int deQueue() {
            // 현재 위치의 값을 회수
            int value = arr[front];
            // 위치 재설정
            front = (front + 1) % offset;
            return value;
        }
    ```

- 큐가 비어있는지 확인
    - isEmpty()

    ```java
    public boolean isEmpty() {
            return front == rear;
        }
    ```

    - 원형 큐

    ```java
    public boolean isEmpty() {
            return front == rear;
        }
    ```

- 큐가 채워져있는지 확인
    - isFull()

    ```java
    public boolean isFull() {
            // front가 이동한 상황은 고려되지 않는다
            return rear == arr.length - 1;
        }
    ```

    - 원형 큐

    ```java
    public boolean isFull() {
            // 다음에 넣을곳이 front라면 가득 차있는 상태이다
            return (rear + 1) % offset == front;
        }
    ```


### ArrayList와 LinkedList 큐의 시간 비교

- 10000개의 데이터를 넣는다고 가

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/d2152b7f-cc08-4868-88c2-80db2f3750de/e6785d1e-24b8-4ce7-bbcf-ae65ff9aef95/Untitled.png)

- 데이터의 추가 제거가 빈번한 경우 → LinkedList 사용
- 데이터의 위치에 기반한 조회가 빈번한 경우 → ArrayList 사용

---

# Linked List

- 여러 자료를 저장하기 위한 자료구조의 일종
- 배열과 다르게 메모리상의 물리적 순서 보장되지 않음
- Node → data, link 로 구성
- 데이터 추가
    - 새로운 노드 생성
    - 마지막 노드의 link에 해당 노드 할당
- 데이터 중간에 추가하는 경우
    - 새로운 노드 생성
    - 삽입할 위치의 전의 노드의 link에 새로운 노드를 할당
    - 새로운 노드의 link에 본래 link에 있던 노드를 할당
- 데이터 중간에 제거하는 경우
    - 제거할 노드 앞쪽의 link에 뒤쪽의 노드를 할당

---

# BFS (Breadth First Search)

1. 제일 먼저 방문할 곳을 정함

    ```java
    toVisit.offer(1);
    ```

2. 큐가 빌때까지( 더 이상 방문할 곳이 없을때까지 반복

    ```java
    while (!toVisit.isEmpty())
    ```

3. 다음 방문할 곳을 poll

    ```java
    int next = toVisit.poll();
    ```

4. 방문 여부를 visited 바탕으로 파악
    1. 만약 방문했다면 다음 곳으로 넘어간다

        ```java
        if (visited[next]) continue;
        ```


    b. 미방문이면 방문을 표시
    
    ```java
    visited[next] = true;
    ```

5. 방문 순서를 기록

    ```java
    visitOrder.add(next);
    ```

6. 다음 방문 대상을 큐에 offer한다
    1. 만약 방문했다면 (visited[i]) 추가하지 않고

        ```java
        if (visited[i]) continue;
        ```

    2. 도달할 수 있다면 추가

        ```java
        if (adjMap[next][i] == 1) {
              toVisit.offer(i);
        }
        ```


### BFS 전문

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        String[] edges = {
                "1 2",
                "1 3",
                "2 4",
                "2 5",
                "3 7",
                "4 6",
                "5 6",
                "6 7"
        };
        // 총 점의 갯수
        int nodeCount = 7;
        // 각 점이 연결되었는지를 판단하기 위한 배열
        int[][] adjMap = new int[nodeCount + 1][nodeCount + 1];

        // 주어진 연결 정보를 바탕으로 adjMap을 채워넣는다. 연결 되어 있다면 1
        // 1. 주어진 선의 갯수만큼 반복
        for (int i = 0; i < edges.length; i++) {
            // 2. 하나의 정보를 나누어서 출발 종점을 구분해 각각 변수에 할당
            String[] edgeInfo = edges[i].split(" ");
            int leftNode = Integer.parseInt(edgeInfo[0]);
            int rightNode = Integer.parseInt(edgeInfo[1]);
            // 3. 각각의 정점의 adjMap[left][right] = 1
            adjMap[leftNode][rightNode] = 1;
            adjMap[rightNode][leftNode] = 1;
        }

        // 1번에서 출발해서, 모든 점들을 방문할 때, 어떤 순서로 방문하는지
        // 다음 방문할 곳을 기록하기 위한 큐 하나
        Queue<Integer> toVisit = new LinkedList<>();
        // 방문한 순서를 살펴보기 위한 리스트 하나
        List<Integer> visitOrder = new ArrayList<>();
        // 내가 방문했는지를 파악하기 위한 배열 하나
        boolean[] visited = new boolean[nodeCount + 1];

        // BFS 시작
        // 1. 제일 먼저 방문할 곳을 넣어준다
        toVisit.offer(1);
        // 2. 큐가 빌때까지(더 이상 방문할 곳이 없을 때까지) 반복한다
        while (!toVisit.isEmpty()) {
            // 3. 다음 방문할 곳을 poll 한다
            int next = toVisit.poll();
            // 4. 방문했는지를 visited를 바탕으로 파악해서
            // 만약 방문했다면 다음 곳으로 넘어간다
            if (visited[next]) continue;
            // 미방문이면 이제 표시한다
            visited[next] = true;
            
            // 5. 방문 순서를 기록해준다
            visitOrder.add(next);
            
            // 6. 다음 방문 대상을 큐에 offergksek
            for (int i = 0; i < nodeCount; i++) {
                // 만약 방문했다면(visited[i]) 추가하지 않고
                if (visited[i]) continue;   // 바로 옆의 for를 스킵한다
                // 도달할 수 있다면 추가한다
                if (adjMap[next][i] == 1) {
                    toVisit.offer(i);
                }
            }
        }

        // 방문 순서 확인
        System.out.println(visitOrder);
    }
}
```
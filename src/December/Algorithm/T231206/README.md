# Stack

- 물건을 쌓아올린 형태의 자료구조
- 선형 자료구조
- LIFO (Last In First Out)
    - 마지막에 추가된 자료가 가장 먼저 나옴

### Stack 구성요소

- push()
    - stack에 원소 추가
    - 데이터를 스택의 제일 위에 넣음

    ```java
       public void push(int x) {
            if (top == arr.length - 1) {
                throw new RuntimeException("Stack is Full");
            }
            top++;
            arr[top] = x;
        }
    ```

- pop()
    - stack에서 원소 빼옴
    - 스택의 제일 위의 데이터를 꺼냄

    ```java
       public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is Empty");
            }
            // 제일 위에 있는 데이터
            int value = arr[top];
            top--;
            return value;
        }
    ```

- isEmpty()
    - stack이 비어있는지 확인

    ```java
        public boolean isEmpty() {
            return top == -1;
        }
    ```


### Call Stack

- 프로그래밍 언어의 함수 호출 및 복귀 순서 관리
    - 함수 메서드의 호출 시 마지막 수행 위치를 stack에 저장
    - 호출된 함수가 종료되면 마지막 수행 위치로 복귀하기 위해 stack에서 pop한다

### StackOverflow

- 재귀적 함수 호출로 인해 Call Stack의 최상단이 JVM의 Heap에 도달할 때 발생하는 에러

---

# DFS (Depth First Search)

- 한쪽 갈림길을 택하면서 갈 수 있는 최대한 깊이 들어가면서 그래프를 탐색하는 방법
1. 시작지점을 결정하고 스택에 넣음

    ```java
    toVisit.push(1);
    ```

2. 스택에서 pop하고 pop한 node 방문했음을 표시

    ```java
            // 2. 스택이 빌때까지(더이상 방문할 곳이 없을 때까지) 반복한다
            while (!toVisit.empty()) {
                // 3. 다음 방문할 곳을 pop한다
                int next = toVisit.pop();
                // 4. 방문했는지를 visited를 바탕으로 파악해서
                // 만약 방문했다면 다음으로 넘어간다
                if (visited[next]) continue;
                // 미방문이면 이제 표시한다
                visited[next] = true;
    ```

3. pop한 node의 인접 node들을 스택에 push

    ```java
                // 6. 다음 방문 대상을 스택에 push 한다
                for (int i = nodeCount; i > 0; i--) {
                    // 만약 방문했다면 vistied[i] 추가하지 않고
                    if (visited[i]) continue;
                    // 도달할 수 있다면 추가한다
                    if (adjMap[next][i] == 1) {
                        toVisit.push(i);
                    }
                }
    ```

   ### DFS 전문

    ```java
    import java.util.ArrayList;
    import java.util.List;
    import java.util.SplittableRandom;
    import java.util.Stack;
    
    public class DepthFirstSearch {
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
            // 총 노드의 개수
            int nodeCount = 7;
            // 각 노드가 연결되었는지를 판단하기 위한 배열
            int[][] adjMap = new int[nodeCount + 1][nodeCount + 1];
    
            // 주어진 연결 정보를 바탕으로 adjMap을 채워넣는다.
            // 연결되어 있다면 1
            // 1. 주어진 선의 갯수만큼 반복
            for (int i = 0; i <edges.length; i++) {
                // 하나의 정보를 나누어서 출발 종점을 구분해 각각 변수에 할당
                String[] edgeInfo = edges[i].split(" ");
                int leftNode = Integer.parseInt(edgeInfo[0]);
                int rightNode = Integer.parseInt(edgeInfo[1]);
                // 각각의 정점의 adjMap[left][right] = 1
                adjMap[leftNode][rightNode] = 1;
                adjMap[rightNode][leftNode] = 1;
            }
    
            // 다음 방문할 곳을 기록하기 위한 스택
            Stack<Integer> toVisit = new Stack<>();
            // 방문한 순서를 살펴보기 위한 리스트 하나
            List<Integer> visitOrder = new ArrayList<>();
            // 방문했는지를 파악하기 위한 배열 하나
            boolean[] visited = new boolean[nodeCount +1];
    
            // DFS
            // 1. 가장 먼저 방문할 곳을 넣어준다
            toVisit.push(1);
            // 2. 스택이 빌때까지(더이상 방문할 곳이 없을 때까지) 반복한다
            while (!toVisit.empty()) {
                // 3. 다음 방문할 곳을 pop한다
                int next = toVisit.pop();
                // 4. 방문했는지를 visited를 바탕으로 파악해서
                // 만약 방문했다면 다음으로 넘어간다
                if (visited[next]) continue;
                // 미방문이면 이제 표시한다
                visited[next] = true;
    
                // 5. 방문 순서를 기록해준다
                visitOrder.add(next);
    
                // 6. 다음 방문 대상을 스택에 push 한다
                for (int i = nodeCount; i > 0; i--) {
                    // 만약 방문했다면 vistied[i] 추가하지 않고
                    if (visited[i]) continue;
                    // 도달할 수 있다면 추가한다
                    if (adjMap[next][i] == 1) {
                        toVisit.push(i);
                    }
                }
            }
            // 방문 순서 확인
            System.out.println(visitOrder);
        }
    }
    ```
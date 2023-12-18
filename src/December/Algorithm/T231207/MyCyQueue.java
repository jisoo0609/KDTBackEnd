package December.Algorithm.T231207;

public class MyCyQueue {
    // 크기를 4로 가정하여 만듦
    private final int size = 4;
    // 실제로 만듦 배열의 크기는 size + 1
    // 한 칸을 비워둬야 정확하게 비어있고 가득찬 상태를 파악할 수 있다
    private int offset = size + 1;

    // 데이터를 담기 위한 배열
    private int[] arr = new int[offset];
    // 앞쪽과 뒷쪽 데이터를 구분하기 위한 front와 rear
    private int front = 0;
    private int rear = 0;

    // 데이터를 넣기 위한 enQueue
    public void enQueue(int x) {
        arr[rear] = x;
        // 위치 재설정
        rear = (rear + 1) % offset;
    }

    // 데이터를 빼기 위한 deQueue()
    public int deQueue() {
        // 현재 위치의 값을 회수
        int value = arr[front];
        // 위치 재설정
        front = (front + 1) % offset;
        return value;
    }

    // 큐가 비어있는지 확인하기 위한 ifEmpty()'
    public boolean isEmpty() {
        return front == rear;
    }

    // 큐가 가득 차있는지 확인하기 위한 isFull
    public boolean isFull() {
        // 다음에 넣을곳이 front라면 가득 차있는 상태이다
        return (rear + 1) % offset == front;
    }

}


package T231207;
// 큐의 형태로 데이터를 관리하는 클래스
public class MyQueue {
    // 데이터를 담기위한 배열
    private final int[] arr = new int[16];
    // 제일 앞의 데이터가 어딘지 front (데이터를 뺄 때 어디의 데이터를 뺄지를 결정)
    private int front = -1;
    // 제일 뒤의 데이터가 어딘지 나타내는 rear (데이터를 넣을 때 어디에 데이터를 넣을지를 결정)
    private int rear = -1;

    // 데이터를 큐에 담기위한 enQueue
    public void enQueue(int x) {
        // 넣어줄 공간을 설정하고
        rear++;
        // 해당 위치에 넣어준다
        arr[rear] = x;
    }

    // 데이터를 큐에서 꺼내기 위한 deQueue
    public int deQueue() {
        // 데이터를 가져올 공간을 설정하고
        front++;
        // 해당 위치에서 가져온다
        return arr[front];
    }

    // 큐가 비어이쓴지 확인하기 위한 isEmpty()
    public boolean isEmpty() {
        return front == rear;
    }

    // 큐가 채워져있는지 확인하기 위한 isFull()
    public boolean isFull() {
        // front가 이동한 상황은 고려되지 않는다
        return rear == arr.length - 1;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enQueue(10);
        myQueue.enQueue(11);
        myQueue.enQueue(12);
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        // 들어있는 데이터는 0개
        System.out.println(myQueue.isEmpty());

        for (int i = 0; i < 13; i++) {
            myQueue.enQueue(i);
        }
        // 들어있는 데이터는 12개
        System.out.println(myQueue.deQueue());
        // 남은공간이 4여도 가득찼다고 인식
        System.out.println(myQueue.isFull());
        // myQueue.enQueue(10); 이면 오류
    }
}

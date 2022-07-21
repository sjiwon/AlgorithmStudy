package thisiscodingtest.Week3_DFS_BFS;

class MyQueue<T> implements QueueInterface<T>{

    private int front;
    private int rear;
    private int size;
    private Object [] queue;

    MyQueue(int size){
        front = 0;
        rear = 0;
        this.size = size + 1;
        queue = new Object[size + 1];
    }

    @Override
    public void insert(T item) {
        if(isFull()){
            System.out.println("Error : Queue is full...");
            return;
        }

        System.out.println("insert... (" + item + ")");
        rear = (rear + 1) % size;
        queue[rear] = item;
    }

    @Override
    public T remove() {
        if(isEmpty()){
            System.out.println("Error : Queue is empty...");
            return null;
        }

        front = (front + 1) % size;
        T remove = (T) queue[front];
        System.out.println("remove... (" + remove + ")");
        return remove;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            System.out.println("Error : Queue is empty...");
            return null;
        }

        T peek = (T) queue[((front + 1) % size)];
        System.out.println("peek... (" + peek + ")");
        return peek;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public boolean isFull() {
        return front == (rear + 1) % size;
    }
}

public class Queue {
    public static void main(String[] args) {
        MyQueue<Integer> integerQueue = new MyQueue<>(5);
        for(int i=0; i<6; i++){
            integerQueue.insert(i);
        }
        System.out.println();
        integerQueue.peek();
        System.out.println();
        for(int i=0; i<6; i++){
            integerQueue.remove();
        }

        System.out.println("------------------------------------------");

        MyQueue<String> stringQueue = new MyQueue<>(5);
        for(int i=0; i<6; i++){
            stringQueue.insert(String.valueOf((char)(i + 65)));
        }
        System.out.println();
        stringQueue.peek();
        System.out.println();
        for(int i=0; i<6; i++){
            stringQueue.remove();
        }
    }
}

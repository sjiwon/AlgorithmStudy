package thisiscodingtest.Week3_DFS_BFS;

public interface StackInterface<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    boolean isFull();
}

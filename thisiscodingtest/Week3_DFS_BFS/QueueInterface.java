package thisiscodingtest.Week3_DFS_BFS;

public interface QueueInterface<T> {
    void insert(T item);
    T remove();
    T peek();
    boolean isEmpty();
    boolean isFull();
}

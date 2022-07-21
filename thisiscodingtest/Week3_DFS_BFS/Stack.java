package thisiscodingtest.Week3_DFS_BFS;

class MyStack<T> implements StackInterface<T>{
    private int top;
    private int size;
    private Object [] stack;

    MyStack(int size){
        top = -1;
        this.size = size;
        stack = new Object[size];
    }

    @Override
    public void push(T item) {
        if(isFull()) {
            System.out.println("Error : Stack is full...");
            return;
        }

        System.out.println("push... (" + item + ")");
        stack[++top] = item;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("Error : Stack is empty...");
            return null;
        }

        T pop = (T) stack[top--];
        System.out.println("pop... (" + pop + ")");
        return pop;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            System.out.println("Error : Stack is empty...");
            return null;
        }

        T peek = (T) stack[top];
        System.out.println("peek... (" + peek + ")");
        return peek;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == size - 1;
    }
}

public class Stack {
    public static void main(String[] args) {
        MyStack<Integer> integerStack = new MyStack<>(5);
        for(int i=0; i<6; i++){
            integerStack.push(i);
        }
        System.out.println();
        integerStack.peek();
        System.out.println();
        for(int i=0; i<6; i++){
            integerStack.pop();
        }

        System.out.println("------------------------------------------");

        MyStack<String> stringStack = new MyStack<>(5);
        for(int i=0; i<6; i++){
            stringStack.push(String.valueOf((char)(i + 65)));
        }
        System.out.println();
        stringStack.peek();
        System.out.println();
        for(int i=0; i<6; i++){
            stringStack.pop();
        }
    }
}

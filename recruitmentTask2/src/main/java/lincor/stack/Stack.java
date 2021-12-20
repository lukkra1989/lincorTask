package lincor.stack;


public class Stack {
    private int array[];
    private int top;
    private int size;

    private int minValue=array[size];

    public Stack(int size) {
        this.array = new int[size];
        this.top = -1;
        this.size = size;
    }

    public void push(int item) {
        if (isFull()) {
            throw new RuntimeException("Stack is FULL!");
        }
        item = array[++top];
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is EMPTY!");
        }
        return array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is EMPTY!");
        }
        return array[top];
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

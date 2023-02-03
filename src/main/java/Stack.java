public class Stack {

    private static final int EMPTY_STACK = 0;
    private final int[] elements;
    private final int capacity;
    private int size;

    public Stack(int capacity) {
        if(capacity < 0)
            throw new InvalidCapacityException();
        this.capacity = capacity;
        elements = new int[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == EMPTY_STACK;
    }

    public void push(int element) {
        if(size == capacity)
            throw new OverflowException();
        elements[size++] = element;
    }

    public int pop() {
        throwUnderFlowExceptionIfEmptyStack();
        return elements[--size];
    }

    public int peek() {
        throwUnderFlowExceptionIfEmptyStack();
        return elements[size - 1];
    }

    private void throwUnderFlowExceptionIfEmptyStack() {
        if(isEmpty())
            throw new UnderflowException();
    }
}
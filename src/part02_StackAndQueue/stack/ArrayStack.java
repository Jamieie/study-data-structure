package part02_StackAndQueue.stack;

import java.util.EmptyStackException;

public class ArrayStack<E> {
    private E[] s;
    private int top;
    public ArrayStack() {
        s = (E[]) new Object[1];
        top = -1;
    }
    public int size() { return top + 1; }
    public boolean isEmpty() { return top == -1; }

    // peek(), push(), pop(), resize()
    public E peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return s[top];
    }

    public void push(E item) {
        if (size() == s.length)
            resize(s.length * 2);
        s[++top] = item;
    }

    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();
        E item = s[top];
        s[top--] = null;
        if (size() > 0 && size() == s.length / 4)
            resize(s.length / 2);
        return item;
    }

    private void resize(int size) {
        E[] n = (E[]) new Object[size];
        for (int i = 0; i <= top; i++) {
            n[i] = s[i];
        }
        s = n;
    }
}

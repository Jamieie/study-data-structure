package part02_StackAndQueue.stack;

import list.singlyLinkedList.Node;

import java.util.NoSuchElementException;

public class ListStack<E extends Comparable> {
    private Node<E> top;
    private int size;

    public ListStack() {
        top = null;
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public E peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return top.getItem();
    }

    public void push(E item) {
        // 1. newNode next에 top 저장 (리스트의 앞 부분에 삽입)
        Node<E> newNode = new Node<>(item, top);

        // 2. top을 newNode로 바꾸고 size++
        top = newNode;
        size++;
    }

    public E pop() {
        // 1. 빈 스택이면 예외 발생
        if (isEmpty()) throw new NoSuchElementException();

        // 2. 반환할 topNode의 item 값 별도 저장
        E item = top.getItem();

        // 3. top을 topNode의 next로 바꿈
        top = top.getNext();

        // 4. size 감소 후 item 반환
        size--;
        return item;
    }
}

package list.singlyLinkedList;

import java.util.NoSuchElementException;

public class SList<E extends Comparable> {
    protected Node<E> head;
    private int size;

    public SList() {
        head = null;
        size = 0;
    }

    public int search(E target) {
        Node p = head;
        for (int k = 0; k < size; k++) {
            // 왜 equals()가 아닌 compareTo()를 사용할까?
            if (p.getItem().compareTo(target) == 0)
                return k;
            p = p.getNext();
        }
        return -1;      // 탐색 실패한 경우 -1 반환
    }

    public void insertFront(E newItem) {    // 연결 리스트 맨 앞에 새 노드 삽입
        head = new Node(newItem, head);
        size++;
    }

    public void insertAfter(E newItem, Node p) {    // p 노드 바로 다음에 새 노드 삽입
        p.setNext(new Node(newItem, p.getNext()));
        size++;
    }

    public void deleteFront() {     // 리스트의 첫 노드 삭제
        if (isEmpty()) throw new NoSuchElementException();
        head = head.getNext();
        size--;
    }

    public void deleteAfter(Node p) {   // p가 가리키는 노드의 다음 노드를 삭제
        if (p == null) throw new NoSuchElementException();
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

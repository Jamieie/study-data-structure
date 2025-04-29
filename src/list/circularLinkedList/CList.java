package list.circularLinkedList;

import list.singlyLinkedList.Node;

import java.util.NoSuchElementException;

public class CList <E extends Comparable<E>> {
    private Node<E> last;
    private int size;

    public CList() {
        last = null;
        size = 0;
    }

    // last가 가리키는 노드의 다음에 새 노드 삽입
    public void insert(E newItem) {
        Node<E> newNode = new Node<E>(newItem, null);
        if (last == null) {     // 리스트가 empty일 떄
            newNode.setNext(newNode);
            last = newNode;
        } else {
            newNode.setNext(last.getNext());
            last.setNext(newNode);
        }
        size++;
    }

    // last가 가리키는 노드의 다음 노드를 제거
    public Node<E> delete() {
        if (last == null) throw new NoSuchElementException();

        Node<E> x = last.getNext();
        if (x == last) {        // 리스트에 1개의 노드만 있는 경우
            last = null;
        } else {
            last.setNext(x.getNext());
            x.setNext(null);
        }
        size--;
        return x;
    }
}

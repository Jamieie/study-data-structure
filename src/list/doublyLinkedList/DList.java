package list.doublyLinkedList;

import java.util.NoSuchElementException;

public class DList<E> {
    protected DNode<E> head;
    protected DNode<E> tail;
    protected int size;

    public DList() {
        this.head = new DNode<>(null, null, null);
        this.tail = new DNode<>(null, null, null);
        this.size = 0;
    }

    // insertBefore
    public void insertBefore(E item, DNode<E> p) {
        // 1. 입력된 데이터로 새 노드 만들기 newNode
        // 2. newNode의 next에 p 설정 / newNode의 previous에 p의 previous (t) 설정
        // 3. t의 next와 p의 previous에 newNode 설정
        // 4. 사이즈 +1
        DNode<E> t = p.getPrevious();
        DNode<E> newNode = new DNode<>(item, t, p);
        t.setNext(newNode);
        p.setPrevious(newNode);
        size++;
    }

    // insertAfter
    public void insertAfter(E item, DNode<E> p) {
        // 1. 입력된 데이터로 새 노드 만들기 newNode
        // 2. newNode의 previous -> p / newNode의 next -> p의 next (t) 설정
        // 3. p의 next -> newNode / t의 previous -> newNode 설정
        // 4. 사이즈 +1
        DNode<E> t = p.getNext();
        DNode<E> newNode = new DNode<>(item, p, t);
        t.setPrevious(newNode);
        p.setNext(newNode);
        size++;
    }

    // delete
    public void delete(DNode x) {
        // x가 null이면 예외 발생
        // x.previous의 next -> x.next
        // x.next의 previous -> x.previous
        if (x == null) {
            throw new NoSuchElementException();
        }
        DNode f = x.getPrevious();
        DNode r = x.getNext();
        f.setNext(r);
        r.setPrevious(f);
    }
}

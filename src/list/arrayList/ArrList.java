package list.arrayList;

import java.util.NoSuchElementException;

public class ArrList <E> {
    private E a[];      // 리스트의 항목을 저장할 배열
    private int size;   // 리스트의 항목 수

    public ArrList() {
        a = (E[]) new Object[1];
        size = 0;
    }

    public E peek(int k) {  // k번째 항목 반환
        // 예외 발생 : size == 0, k < 0, k가 size와 같거나 클 때
        if(size == 0 || k < 0 || k >= size)
            throw new NoSuchElementException();

        return a[k];
    }

    public void insertLast(E newItem) {     // 가장 뒤에 새 항목 삽입
        // 배열에 빈 공간 없으면 배열 크기 2배로 확장
        if (size == a.length)
            resize(2 * a.length);

        a[size++] = newItem;
    }

    public void insert(E newItem, int k) {      // 새 항목을 k-1번째 항목 다음에 삽입
        // 배열에 빈 공간 없으면 배열 크기 2배로 확장
        if (size == a.length)
            resize(2 * a.length);

        // 마지막 항목부터 k번째 항목까지 뒤로 한 칸씩 이동
        for (int i = size - 1; i >= k; i--)
            a[i+1] = a[i];

        a[k] = newItem;
        size++;
    }

    private void resize(int newSize) {      // 배열 크기 조절
        // newSize 크기의 새로운 배열 생성
        Object[] t = new Object[newSize];

        // 기존 배열 복사
        for (int i = 0; i < size; i++)
            t[i] = a[i];

        // 참조 변경
        a = (E[]) t;
    }

    public E delete(int k) {        // k번째 항목 삭제
        // 예외 발생 : size == 0, k < 0, k가 size와 같거나 클 때
        if(size == 0 || k < 0 || k >= size)
            throw new NoSuchElementException();
        E item = a[k];

        // k+1번째부터 마지막 항목까지 앞으로 한 칸씩 이동
        for (int i = k; i < size; i++)
            a[i] = a[i+1];
        size--;

        // 배열에 항목들이 1/4만 차지한다면 배열을 1/2 크기로 축소
        if (size > 0 && size == a.length / 4)
            resize(a.length / 2);

        return item;
    }
}
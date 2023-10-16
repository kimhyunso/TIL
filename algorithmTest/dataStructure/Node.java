package dataStructure;

public class Node<E> {
    E data;
    Node<E> next; // 다음 노드객체를 가리키는 래퍼런스 변수
    public Node<E> prev;
    
    Node(E data){
        this.data = data;
        this.next = null;
    }
    
}

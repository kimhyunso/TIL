package 자료구조;

public interface MyList<T> {
    // 요소 추가
    boolean add(T value);
    // 특정 위치 요소 추가
    void add(int index, T value);

    // 요소 삭제
    boolean remove(Object value);
    // 특정 위치 요소 삭제
    T remove(int index);

    // 요소 가져오기
    T get(int index);

    // 특정 위치 요소를 새 요소로 대체
    void set(int index, T value);

    // 특정 요소가 리스트에 있는지 여부
    boolean contains(Object value);
    
    // 특정 요소가 몇 번째 위치에 있는지 반환 (순차)
    int indexOf(Object value);

    // 특정 요소가 몇 번째 위치에 있는지 반환 (역순)
    int lastIndexOf(Object o);

    // 요소 갯수 반환
    int size();
    // 요소가 비어있는지 여부
    boolean isEmpty();
    // 요소를 모두 비움
    public void clear();
}

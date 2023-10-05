import java.util.*;

public class MyArrayList<E> implements MyList<E>{
    // 생성자로 배열이 생성될 때 기본용량
    private static final int DEFAULT_CAPACITY = 5;
    // 빈 배열
    private static final Object[] EMPTY_ELEMENTDATA = {};
    // elementData 배열의 총 개수
    private int size;
    // 자료를 담을 배열
    Object[] elementData;

    public MyArrayList(){
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int capacity){
        if (capacity > 0)
            this.elementData = new Object[capacity];
        else if (capacity == 0)
            this.elementData = new Object[DEFAULT_CAPACITY];
        else if (capacity < 0)
            throw new RuntimeException(new IllegalAccessException("리스트 용량을 잘 못 설정하였습니다."));
    
        this.size = 0;
    }


    private void resize(){
        int element_capacity = elementData.length;

        // 용량이 꽉찬 경우
        if (element_capacity == size){
            int new_capacity = element_capacity * 2;
            elementData = Arrays.copyOf(elementData, new_capacity);
            return;
        }

        // 용량에 비해 데이터 양이 적은경우
        if ((element_capacity / 2) > size){
            int half_capacity = element_capacity / 2;
            elementData = Arrays.copyOf(elementData, Math.max(half_capacity, DEFAULT_CAPACITY));
            return;
        }



        // 들어있는 데이터가 하나도 없을 경우 (빈 배열)
        if (element_capacity == 0)

    }




}
package 자료구조;

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
        if (Arrays.equals(elementData, EMPTY_ELEMENTDATA)){
            elementData = new Object[DEFAULT_CAPACITY];
            return;
        }
    }

    @Override
    public boolean add(Object value){
        resize();

        elementData[size++] = value;
        return true;

    }

    @Override
    public void add(int index, Object value){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if (index == size)
            add(value);
        else{
            resize();
            for (int i=size; i>index; i--)
                elementData[i] = elementData[i - 1];

            elementData[index] = value;
            size ++;
        }
    }

    @Override
    public int indexOf(Object value){

        if (value == null){
            for (int i=0; i<size; i++){
                if (elementData[i] == null)
                    return i;
            }

        }else{
            for (int i=0; i<size; i++){
                if (elementData[i].equals(value)){
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object value){
        if (value == null){
            for (int i=size; i >= 0; i--)
                if (elementData[i] == null)
                    return i;
        }else{
            for (int i=size; i>=0; i--)
                if (elementData[i].equals(value))
                    return i;
        }
        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        E element = (E) elementData[index];
        elementData[index] = null;

        for (int i=index; i<size -1; i++){
            elementData[i] = elementData[i + 1];
            elementData[i + 1] = null;
        }

        size --;

        resize();

        return element;
    }


    @Override
    public boolean remove(Object value){
        int idx = indexOf(value);

        if (idx == -1) return false;

        remove(idx);

        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return (E) elementData[index];
    }


    @Override
    public void set(int index, Object value){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        elementData[index] = value;
    }


    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void clear(){
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(Object value){
        return indexOf(value) >= 0 ? true : false;
    }

    @Override
    public String toString(){
        return Arrays.toString(elementData);
    }
}
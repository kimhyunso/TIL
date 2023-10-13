package dataStructure;

import java.util.*;


public class ArrayList<E> implements List<E> {

    // 최소 용적 크기
    private static final int DEFAULT_CAPACITY = 10;
    // 빈 배열
    private static final Object[] EMPTY_ARRAY = {};

    // 요소 개수
    private int size;

    // 요소를 담을 배열
    Object[] array;

    // 생성자 (초기 공간할당 X) ex) ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList(){
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    // 생성자 (초기 공간 할당 O) ex) ArrayList<Integer> list = new ArrayList<Integer>(10);
    public ArrayList(int capactiy){
        this.array = new Object[capactiy];
        this.size = 0;
    }


    @Override
    public boolean add(E value){
        addList(value);
        return true;
    }

    public void addList(E value){
        // 꽉 차있는 상태라면 용적 재할당
        if (size == array.length){
            resize();
        }
        // 마지막 위체에 요소 추가
        array[size++] = value;
    }

    @Override
    public void add(int index, E value){

        // 사이즈를 벗어날 경우 예외발생
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException();
        
        if (index == size)
            addList(value);
        else{
            // 데이터가 꽉 차있다면 재할당
            if (size == array.length)
                resize();
            
            for(int i=size; i>index; i--)
                array[i] = array[i-1];
            
            array[index] = value;
            size++;
        }
    }

    public void addFirst(E value){
        add(0, value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index){
        // 범위를 벗어나면 예외발생
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        // Object -> E 타입으로 캐스팅
        return (E) array[index];
    }

    @Override
    public void set(int index, E value){
        // 범위를 벗어날 경우 예와발생
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        else
            array[index] = value;
    }

    /* 
     * 객체끼리 비교할 때는 == 아니라 반드시 equals로 비교!
     * ( == 주소를 비교하는 것이기 때문에), (equals 값 비교!)
    */

    @Override
    public int indexOf(Object value){
        int i = 0;

        // value와 같은 객체(요소 값)일 경우 i(위치) 반환
        for(i=0; i<size; i++){
            if(array[i].equals(value))
                return i;
        }

        // 일치하는 것이 없는 경우 -1 리턴
        return -1;
    }

    public int lastIndexOf(Object value){
        for(int i=size-1; i>=0; i--){
            if(array[i].equals(value))
                return i;
        }
        return -1;
    }



    @Override
    public boolean contains(Object value){

        // 0 이상이면 요소가 존재한다는 뜻
        if (indexOf(value) >= 0)
            return true;
        else
            return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index){
        // 범위를 벗어날 경우
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        // 삭제될 요소를 반환하기 위해 임시로 받아둠
        E element = (E) array[index];
        array[index] = null;

        // 삭제한 요소의 뒤에 있는 모소 요소들을 한 칸씩 당겨옴
        for (int i = index; i<size-1; i++){
            array[i] = array[i+1];
            // null로 처리하면 가비지컬렉터에 의해 데이터의 메모리를 수거해줌
            array[i+1] = null;
        }

        size --;
        // 데이터가 일정이상 삭제된 경우 용적을 줄임
        resize();
        return element;
    }

    @Override
    public boolean remove(Object value){
        
        // 삭제하고자 하는 인덱스 찾기
        int index = indexOf(value);

        // -1이라면 array에 요소가 없다는 의미이므로 false반환
        if(index == -1)
            return false;

        remove(index);
        return true;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    /*
     * size = 0, 모든요소 = null
     * 용적 = 현재 용적값의 절반
     * -용적이 현재용적값의 절반인 이유-
     * 예시 : 1500개의 데이터가 들어옴
     * 용적 = (10*2) : 20, (20*2) : 40, (40*2) 80, (80*2) 160 ... 2560이 적당함
     * 요소들을 모두 초기화했을지라도 들어올 데이터 또한 1500일 가능성이 높다!
     * 그러므로 절반만 줄인다.
     */
    @Override
    public void clear(){
        // 모든 공간을 null 처리 해준다.
        for (int i=0; i<size; i++)
            array[i] = null;
        size = 0;
        resize();
    }

    /*
     * 얕은 복사 : 주소값이 같은 객체 - 변경시 기존 객체도 변경
     * deep 복사 : 주소값이 다른 객체 - 다른 객체로 인식
     */

    @Override
    public Object clone() throws CloneNotSupportedException{
        // 새로운 객체 생성
        ArrayList<?> cloneList = (ArrayList<?>)super.clone();

        // 새로운 객체의 배열도 생성해주어야 함 (객체는 얕은 복사가 되기때문)
        cloneList.array = new Object[size];

        // 배열의 값을 복사함
        System.arraycopy(array, 0, cloneList.array, 0, size);

        return cloneList;
    }


    // 적절하게 배열의 용적을 변경하기
    private void resize(){
        int array_capacity = array.length;

        /*
         * 초기 ArrayList<?> list = new ArrayList<?>();
         * 일 때 용적 DEFAULT 10으로 할당
         * 주소가 아닌 값을 비교해야하기 때문에 Arrays.equals 사용
         */
        // array, capacity == 0
        if (Arrays.equals(array, EMPTY_ARRAY)){
            array = new Object[DEFAULT_CAPACITY];
            return;
        }


        /*
         * 데이터가 꽉찰 경우 용적을 현재 용적의 2배로 늘림
         * Arrays.copyOf() : @param 복사할 배열, @param 용적의 크기
         */
        // 용량이 꽉 찰 경우
        if (size == array_capacity){
            int new_capacity = array_capacity * 2;

            // copy
            array = Arrays.copyOf(array, new_capacity);
            return;
        }
        /*
         * 데이터는 적은데 빈 공간이 메모리를 차지하고 있는 경우
         * 불필요한 공간을 줄이기 위해
         * 
         */
        // 용적의 절반 미만으로 요소가 차지하고 있을 경우
        if(size < (array_capacity / 2)){
            int new_capacity = array_capacity / 2;

            /* 복사할 배열보다 용적의 크기가 작을 경우 max함수 사용 */
            // copy
            array = Arrays.copyOf(array, Math.max(new_capacity, DEFAULT_CAPACITY));
            return;
        }
    }

    public Object[] toArray(){
        return Arrays.copyOf(array, size);
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a){
        if (a.length < size) {
            // copyOf(원본 배열, 복사할 길이, Class<? extends T[]> 타입)
            return (T[]) Arrays.copyOf(array, size, a.getClass());
        }
        // 원본배열, 원본배열 시작위치, 복사할 배열, 복사할배열 시작위치, 복사할 요소 수 
        System.arraycopy(array, 0, a, 0, size);
        return a;
    }   
}

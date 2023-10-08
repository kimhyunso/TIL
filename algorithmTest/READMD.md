# BufferedReader vs Scanner 차이점
1. BufferedReader : buffer에 저장 한 후 flush
2. Scanner : 정규식이나 여러 편리한 것들을 알아서 해줌

> 따라서 BufferedReader가 더 빠르다.


# Stack Queue
> Stack : 한 곳에서 데이터가 들어갔다 나갔다 한다. (`FIRST IN LAST OUT - FILO`) :: `push()`, `pop()`, `size()`, `isEmpty()`, `peek()`
1. `push()` : 맨 끝에 데이터 삽입
2. `pop()` : 끝에 있는 데이터 삭제 및 리턴 :: `Object`
3. `size()` : stack의 사이즈 확인 :: `int`
4. `isEmpty()` : stack 안이 비어있는지 확인 :: `boolean`
5. `peek()` : 현재 맨 마지막 데이터 리턴 :: `Object`

> Queue : 앞, 뒤에서 데이터가 들어갔다 나갔다 한다. (`FIRST IN FIRST OUT - FIFO`) :: `add()`, `offer()`, `size()`, `isEmpty()`, `peek()`, `poll()`
1. `add()` : 맨뒤에서 데이터 삽입 :: `Error` or `true`
2. `offer()` : 맨뒤에서 데이터 삽입 :: `boolean`
3. `size()` : queue에 사이즈 확인 :: `int`
4. `isEmpty()` : queue 안이 비어있는지 확인 :: `boolean`
5. `peek()` : queue 맨 앞에 있는 데이터 리턴 :: `Object`
6. `poll()` : queue 맨 앞에 있는 데이터 삭제 후 리턴 :: `Object`


# `Arrays.copyOf`, `Arrays.copyOfRange()`
배열 복사

`Arrays.copyOf(배열, 마지막인덱스)`

`Arrays.copyOfRange(배열, 시작인덱스, 마지막인덱스)`

```java
class Main{
    public static void main(String[] args){
        int []number = {1, 2, 3, 4, 5};
        // 인덱스번호    0  1  2  3  4


        // 결과 : [1, 2, 3]
        // 인덱스는 0부터 시작하기 때문에 마지막 인덱스에 -1까지 배열을 만든다.
        int[] arr1 = Arrays.copyOf(number, 3);

        // 결과 : [3, 4, 5]
        // 인덱스는 0부터 시작하기 때문에, 시작인덱스부터 마지막인덱스 -1까지 배열을 만든다.
        int[] arr2 = Arrays.copyOfRange(number, 2, 5);

    }
}

```

# 힙정렬
배열을 사용해 쉽게 구현가능
1. 최대힙 - 부모노드가 자식들 보다 큼
2. 최소힙 - 부모노드가 자식들 보다 작음

# 이진트리
자식이 2개 이하인 트리 구조

# 완전이진트리
마지막 노드(Leaf)를 제외하고 모든 레벨의 노드가 채워져 있는 상태

왼쪽에서 부터 채워져 있어야함



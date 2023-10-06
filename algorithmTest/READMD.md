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



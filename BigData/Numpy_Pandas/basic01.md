# numpy 생성하기
1. 1차원 배열
2. 2차원 배열

```python
import numpy as np
array1ds = np.array([1, 3, 5, 7])
print(f'array1ds : {array1ds}, type ==> {type(array1ds)}')


array2ds = np.array([[1, 2, 3], [4, 5, 6]])
print(f'arrays2ds : {array2ds}, type ==> {type(array2ds)}')
```

# `ndim`
현재 차원을 알 수 있다.

```python
import numpy as np
array1ds = np.array([1, 3, 5, 7, 9])
# result 1 ==> 1차원
print(array1ds.ndim)

array2ds = np.array([[1, 2, 3], [4, 5, 6]])
# result 2 ==> 2차원
print(array2ds.ndim)

array3ds = np.array([[[1, 3],[4, 6]]])
# result 3 ==> 3차원
print(array3ds.ndim)
```

# `shape`
현재 numpy의 행과 열을 출력한다.
```python
import numpy as np
array1ds = np.array([1, 2, 3, 4])
# 1차원안에 4개의 요소가 있다.
# (4, )
print(array1ds.shape)

array2ds = np.array([[1, 2, 3], [3, 5, 6]])
# 2차원안에 2개의 요소가 있고, 1차원에 3개의 요소가 있다.
# (2, 3)
print(array2ds.shape)

array3ds = np.array([[[1, 2, 3], [2, 3, 4]]])

# 3차원에는 1개의 요소가 있고, 2차원에는 2개의 요소가 있으며, 1차원에는 3개의 요소가 있다.
# (1, 2, 3)
print(array3ds.shape)
```

# `arange()`
- 파이썬과 동일 배열을 만든다.
- `np.arange(start, end-1, step)`
```python
import numpy as np
array1ds = np.arange(1, 11)
# [1, 2, 3, 4, ..., 10]
print(array1ds)
```

# `reshape()`
- 배열의 행과 열을 바꾼다.
- **원본 배열은 바뀌지 않는다.**
```python
import numpy as np
array1ds = np.arange(1, 11)
# [1, 2, 3, 4, ..., 10]
reshape_array2ds = array1ds.reshape(2,5)
# 2행 5열짜리 2차원 리스트 형태로 변환되어 출려됨
print(reshape_array2ds)
```

# zeros
0으로 채워진 행렬 생성
```python
import numpy as np
array_int = np.zeros((2, 4), dtpye='int32')
array_float = np.zeros((2, 4), dtpye='float64')
# 2행 4열 짜리 2차원 0으로 채워진 행렬
print(array_int)
# 2행 4열 짜리 2차원 0.으로 채워진 행렬
print(array_float)
```

# ones
1로 채워진 행렬 생성
```python
import numpy as np
array_int = np.ones((2, 4), dtpye='int32')
array_float = np.ones((2, 4), dtpye='float64')
# 2행 4열 짜리 2차원 1로 채워진 행렬
print(array_int)
# 2행 4열 짜리 2차원 1.로 채워진 행렬
print(array_float)
```

# dtype
numpy의 데이터 속성 type을 확인하기 위한 것
```python
# Numpy의 데이터 타입은 다 같은 타입으로 구성된다.
str_array1ds = [1, 2, 'test']
# result ['1', '2', 'test'], dtype ==> str
print(f'str_array1ds : {str_array1ds}, dtpye ==> {str_array1ds.dtype}')

float_array1ds = [1, 2, 5.5]
# result [1., 2., 5.5], dtype ==> float64
print(f'float_array1ds : {float_array1ds}, dtpye ==> {float_array1ds.dtype}')
```

# dtpye의 상호 변환
- `astype()`
- 원본 배열은 바뀌지 않는다.
```python
array_int = np.array([1, 3, 5])
# int => float으로 형변환
array_float = array_int.astype('float64')
# [1., 3. 5.], dtype ==> float64
print(f'array_float : {array_float}, dtype ==> {array_float.dtype}')

# float => int 형변환
array_int = array_float.astype('int32')
# [1, 3, 5], dtype ==> float64
print(f'array_int : {array_int}, dtype ==> {array_int.dtype}')

# 자료 형변환 따른 버림현상 float
array_float = np.array([1.1, 2.2, 4.8])
# float => int 형변환
array_int = array_float2.astype('int32')
# [1, 2, 4], dtype ==> int32
print(f'array_int : {array_int}, dtype ==> {array_int.dtype}')
```
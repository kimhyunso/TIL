# 데이터 분석 수행
Select(자료수집) => preprocessing(전처리) => transform(변환) => model(모델) => Evaluation(평가)

1. [Data Engineer(데이터 엔지니어)] :: 1TB = 10GB * 10대 (하둡분산병렬처리)
2. [Data Architecture(데이터 아키텍처)] => DAsP, DAP
* Select(자료수집) => preprocessing(전처리)
3. [SQL (Stuctured Query Language) - 데이터 호출] => sqld, sqlp
* Select(자료수집) => preprocessing(전처리) 사이
4. [데이터 분석가 ] -> ADsP, 빅데이터 분석기사, ADP
* transform(변환) => model(모델) => Evaluation(평가)

# 데이터 프레임(Data Frame)
열 내의 데이터는 같고 열 간의 데이터는 다르다.

# 머신러닝 알고리즘
정형데이터
1. 지도학습
2. 비지도학습

# 딥러닝 알고리즘
비정형 데이터(텍스트, 이미지)

# python install
`$ pip install sklearn`
# anaconda install
`$ conda install scikit-learn`

# Numpy
> 전치행렬
과학계산을 위한 파이썬 데이터 분석 패키지

ndarray를 만든다.
```python
import numpy as np
array1 = np.array([1, 2, 3])
print('array1 type : ', type(array1))
# (3, )
print('array1의 형태 : ', array1.shape)
```

# 2차원
```python
import numpy as np
array1 = np.array([[1, 2, 3]])
# (1, 3)
print('array1의 형태 : ', array1.shape)
```

# 3차원
```python
import numpy as np
array1 = np.array([[[1, 2, 3]]])
# (1, 1, 3)
print('array1의 형태 : ', array1.shape)
```

# shape
순서대로 3차원 2차원 1차원 요소의 개수를 센다.
```python
import numpy as np
array1 = np.array([[[1, 2, 3]]])
# (1, 1, 3)
print('array1의 형태 : ', array1.shape)
```

# arange
python의 `arrage()`와 비슷

N개의 ndarray를 만든다.

`np.arange(start, stop, step)`
```python
import numpy as np
array1 = np.arange(1, 10)
# (10, )
print('array1의 형태 : ', array1.shape)
```

# zeros
0으로 채워진 행렬 생성
```python
import numpy as np
array_int = np.zeros((2, 4), dtpye='int32')
array_float = np.zeros((2, 4), dtpye='float64')
print(array_int)
print(array_float)
```

# ones
1로 채워진 행렬 생성
```python
import numpy as np
array_int = np.ones((2, 4), dtpye='int32')
array_float = np.ones((2, 4), dtpye='float64')
print(array_int)
print(array_float)
```

# reshape
```python
seq_array.reshape(2, 5)
```

# dtype
Numpy의 데이터 타입은 다 같은 타입으로 구성된다.
```python
import numpy as np
lists_str = [1, 2, 'test']
# '1', '2', 'test'
array = np.array(lists_str)

lists_float = [1, 2, 5.5]
# 1., 2., 5.5
array = np.array(lists_float)
```
## dtpye의 상호 변환
`astype()`
```python
array_int = np.array([1, 3, 5])
array_float = array_int.astype('float64')
print(array_float, array_float.dtype)

array_int2 = array_float.astype('int32')
print(array_int2, array_int.dtype)

# 자료에 따른 버림현상
array_float2 = np.array([1.1, 2.2, 4.8])
array_int3 = array_float2.astype('int32')
print(array_int3)
```

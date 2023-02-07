# 결측값 구하기
- `isna()`

```python
import pandas as pd
import numpy as np

datase = {
    '가' : np.arange(1, 5),
    '나' : np.arange(5, 9),
    '다' : np.arange(9, 13),
    '라' : np.arange(13, 17),
}
df = pd.DataFrame(datase)
'''
가	나	다	라
1	5	9	13 0행
2	6	10	14 1행
3	7	11	15 2행
4	8	12	16 3행
0열 1열 2열 3열
'''

# 모든 결측값의 개수를 확인 할 수 있다.
result = df.isna().sum()

'''
# result ==> type DataFrame
가	나	다	라
F   F	F	F 0행
F   F	F	F 1행
F   F	F	F 2행
F   F	F	F 3행
0열 1열 2열 3열
'''
print(f'{result} ==> type {type(result)}')
```

# 결측값 채우기
- `fillna()`
```python
import pandas as pd
import numpy as np

datase = {
    '가' : np.arange(1, 5),
    '나' : np.arange(5, 9),
    '다' : np.arange(9, 13),
    '라' : np.arange(13, 17),
}
df = pd.DataFrame(datase)
'''
가	나	다	라
1	5	9	13 0행
2	6	10	14 1행
3	7	11	15 2행
4	8	12	16 3행
0열 1열 2열 3열
'''


# 결측값을 N으로 대체한다.
result = df.fillna('N')

# 결측값이 존재하지 않아 위와 그대로 나옴 ==> type : DataFrame
print(f'DataFrame : {result} ==> type : {type(result)}')


# 가인 컬럼의 결측값을 N으로 대체한다.
result = df['가'].fillna('N')

# 결측값이 존재하지 않아 위와 그대로 나옴 ==> type : Series
print(f'result : {result} ==> type : {type(result)}')
```




# 필터함수
- `filter()`
확인하고자 하는 데이터만 추출할 경우

```python
import pandas as pd
import numpy as np

datase = {
    '가' : np.arange(1, 5),
    '나' : np.arange(5, 9),
    '다' : np.arange(9, 13),
    '라' : np.arange(13, 17),
}
df = pd.DataFrame(datase)
'''
가	나	다	라
1	5	9	13 0행
2	6	10	14 1행
3	7	11	15 2행
4	8	12	16 3행
0열 1열 2열 3열
'''

# items : 컬럼명의 해당하는 열들을 가져온다.
result = df.filter(items=['가', '다'])
'''
# result
가 다
1  9   0행
2  10  1행
3  11  2행
4  12  3행
0열 1열
'''
print(f'DataFrame : {result} ==> type : {type(result)}')

# like : 포함된 문자열의 컬럼에 있는 열의 값들을 가져온다.
result = df.filter(like='가')

'''
# result
가
1  0행 
2  1행
3  2행
4  3행
0열
'''
print(f'DataFrame : {result} ==> type : {type(result)}')
```


# `str`
```python
import numpy as np
import pandas as pd

datase = {
    '가' : np.arange(1, 5),
    '나' : np.arange(5, 9),
    '다' : np.arange(9, 13),
    '라' : np.arange(13, 17),
    '다' : ['A', 'B', 'C', 'D'],
}


df = pd.DataFrame(datase)

# 다 열의 length (길이) 값을 구한다. type : Series
result = df['다'].str.len()

'''
# result
다
1  0행 
1  1행
1  2행
1  3행
0열
'''
print(f'result : {result} ==> type : {type(result)}')

# 다 열 안의 'A'가 포함된 값의 대해 False나 True가 나온다. type : Series
result = df['다'].str.contains('A')

'''
# result
다
T  0행 
F  1행
F  2행
F  3행
0열
'''
print(f'result : {result} ==> type : {type(result)}')
```
# series와 dataframe의 차이점
> series : 1차원 (인덱스 자동생성) [n, n, n, n, ...]
>
> dataframe : 2차원 (인덱스 자동생성) [[n, n, n,], [n, n, n,], [n, n, n,], ...]

# pandas 인덱싱
```python
import pandas as pd
datase = {
    '가' : [i for i in range(1, 6)],
    '나' : [i for i in range(6, 11)],
    '다' : [i for i in range(12, 17)],
    '라' : [i for i in range(18, 23)],
}
df = pd.DataFrame(datase)
'''
'가' '나' '다' '라'
 1    6    11   16  ==> 0행
 2    7    12   17  ==> 1행
 3    8    13   18  ==> 2행
 4    9    14   19  ==> 3행
 5    10   15   20  ==> 4행
0열   1열  2열  3열
'''

# 가인행의 열을 가져온다.
result = df['가']
# result [1, 2, 3, 4, 5] ==> type series
print(f'추출한 값 : {result} ==> type {type(result)}')

# [가나다의 행] 데이터를 (0행부터 2행-1까지) 추출한다.
result = df[:2]
# result [[1, 6, 11, 16], [2, 7, 12, 17]] ==> type dataframe
print(f'추출한 값 : {result} ==> type {type(result)}')
```

# 펜시 인덱싱
```python
import pandas as pd
datase = {
    '가' : [i for i in range(1, 6)],
    '나' : [i for i in range(6, 11)],
    '다' : [i for i in range(12, 17)],
    '라' : [i for i in range(18, 23)],
}
df = pd.DataFrame(datase)
'''
'가' '나' '다' '라'
 1    6    11   16  ==> 0행
 2    7    12   17  ==> 1행
 3    8    13   18  ==> 2행
 4    9    14   19  ==> 3행
 5    10   15   20  ==> 4행
0열   1열  2열  3열
'''

# 전체의 행에서 [가와 나의 열만] 추출한다.
result = df[['가', '나']]
# result [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]] ==> type dataframe
print(f'추출한 값 : {result} ==> type {type(result)}')
```

# loc[행, 열]
- 명칭기반 인덱싱
```python
import pandas as pd
datase = {
    '가' : [i for i in range(1, 6)],
    '나' : [i for i in range(6, 11)],
    '다' : [i for i in range(12, 17)],
    '라' : [i for i in range(18, 23)],
}
df = pd.DataFrame(datase)
'''
'가' '나' '다' '라'
 1    6    11   16  ==> 0행
 2    7    12   17  ==> 1행
 3    8    13   18  ==> 2행
 4    9    14   19  ==> 3행
 5    10   15   20  ==> 4행
0열   1열  2열  3열
'''
print(df)

# 전체의 행에서 가인 열의 데이터를 추출한다.
result = df.loc[:, '가']

# result [1, 2, 3, 4, 5] ==> type series
print(f'추출된 데이터 : {result} ==> type {type(result)}')


# 전체의 행에서 [가와 다인] 데이터를 추출한다.
result = df.loc[:, ['가', '다']]

# result [[1, 2, 3, 4, 5], [11, 12, 13, 14, 15]] ==> type dataframe
print(f'추출된 데이터 : {result} ==> type {type(result)}')
```

# iloc[행, 열]
- 위치기반 인덱싱
```python
import pandas as pd
datase = {
    '가' : [i for i in range(1, 6)],
    '나' : [i for i in range(6, 11)],
    '다' : [i for i in range(12, 17)],
    '라' : [i for i in range(18, 23)],
}
df = pd.DataFrame(datase)
'''
'가' '나' '다' '라'
 1    6    11   16  ==> 0행
 2    7    12   17  ==> 1행
 3    8    13   18  ==> 2행
 4    9    14   19  ==> 3행
 5    10   15   20  ==> 4행
0열   1열  2열  3열
'''
print(df)

# 전체 행에서 1열[나]의 데이터를 추출한다.
result = df.iloc[:, 1]

# result [6, 7, 8, 9, 10] ==> type series
print(f'추출한 데이터 : {result} ==> type : {type(result)}')

# 전체 행에서 [1열부터 3열의 [나, 다, 라]] 데이터를 추출한다.
result = df.iloc[:, 1:]

# result [[6, 7, 8, 9, 10], [11, 12, 13, 14, 15], [16, 17, 18, 19, 20]] ==> type dataframe
print(f'추출한 데이터 : {result}, ==> type : {type(result)}')

# 전체 행에서 [1열과 3열만 [나, 라]] 데이터를 추출한다.
result = df.iloc[:, [1, 3]]

# result [[6, 7, 8, 9, 10], [16, 17, 18, 19, 20]] ==> type dataframe
print(f'추출한 데이터 : {result} ==> type : {type(result)}')
```

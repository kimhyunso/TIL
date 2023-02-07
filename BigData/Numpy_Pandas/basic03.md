# boolean 인덱싱
> & : And
>
> | : Or
>
> ~ : Not
>
> ^ : Xor

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
# 가 열에서 1인 데이터의 행을 가져온다.
result = df[df['가'] == 1]
'''
# result, type => DataFrame
가 나 다 라
1  5  9  13 0행
'''
print(f'DataFrame : {result}, type => {type(result)}')


# 가 열에서 4이고, 나 열에서 8인 데이터의 행을 가져온다.
result = df[(df['가'] == 4) & (df['나'] == 8)]
'''
# result, type => DataFrame
가  나  다  라
4	8	12	16 3행
'''
print(f'DataFrame : {result}, type => {type(result)}')
```

# `apply()`
모든 데이터에 일괄 적용시킨다

```python
import numpy as np
import pandas as pd


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

# 가열 데이터를 가져와 1보다 높다면 'N'으로 바꿔라
df['가'] = df['가'].apply(lambda x : 'N' if x > 1 else x)

'''
# result, type : series
가	나	다	라
1	5	9	13 0행
N	6	10	14 1행
N	7	11	15 2행
N	8	12	16 3행
0열 1열 2열 3열
'''
print(f'DataFrame : {df}')


# 행에서 가열의 데이터가 1인 데이터만 'N'으로 변경한다. 나머지는 원래의 값을 갖는다. 
df['가'] = df.apply(lambda x :'N' if x.가 == 1 else x.가, axis=1)

'''
# result, type : series
가	나	다	라
N	5	9	13 0행
2	6	10	14 1행
3	7	11	15 2행
4	8	12	16 3행
0열 1열 2열 3열
'''
print(f'DataFrame : {df}')
```






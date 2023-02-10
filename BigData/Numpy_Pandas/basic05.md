# 데이터 전처리
1. 결측치 대체 및 제거
2. 인코딩
3. 차원 축소 - 컬럼 값이 로우 값보다 많을 경우 실행

## 인코딩
문자형 데이터를 숫자로 변환해주기 위함
1. Labelencoder
2. 원-핫(One-Hot) encoding
## Labelencoder
- 알파벳 순서대로 0, 1, 2, 3 ...으로 변환
- 의미 없는 데이터를 Labelencoder로 변환 했을 시, 데이터의 가중치때문에 정규분포를 이루지 않음
- 의미 있는 데이터를 변환할 때 유용 ex) ['No', 'Yes'], ['male', female]
```python
from sklearn.preprocessing import LabelEncoder
# 테스트용 데이터
items = ['TV', '냉장고', '라디오', '자전거', '컴퓨터', '노트북', '자전거', '믹서기', '믹서기']

# 객체화 insternce
encoder = LabelEncoder()

# 인코딩 작업
result = encoder.fit_transform(items)

# result 인코딩 완료 : [0, 1, 3, 5, 6, 2, 5, 4, 4]
print(f'인코딩 완료 : {result}')
```

## one-hot encoder
- Labelencoder에서 단점을 보완한 인코딩
- 의미 없는 데이터를 변환할 때, 유용 ex) ['냉장고', 'TV']
> Labelencoder ==> 2차원으로 변환 ==> OneHotEncoder
```python
from sklearn.preprocessing import OneHotEncoder
from sklearn.preprocessing import LabelEncoder

# 테스트용 데이터
items = ['TV', '냉장고', '라디오', '자전거', '컴퓨터', '노트북', '자전거', '믹서기', '믹서기']




# 객체화 insternce
encoder = Labelencoder()
eh_encoder = OneHotEncoder()

# Labelencoder
label_result = encoder.fit_transform(items)

# 1차원 ==> 2차원 변환
label_to_2d = label_result.reshape(-1, 1)

# One-Hot 인코딩 작업
one_hot_result = eh_encoder.fit_transform(label_to_2d)
'''
# result 인코딩 완료 toarray(): 
 [[1. 0. 0. 0. 0. 0. 0.]
 [0. 1. 0. 0. 0. 0. 0.]
 [0. 0. 0. 1. 0. 0. 0.]
 [0. 0. 0. 0. 0. 1. 0.]
 [0. 0. 0. 0. 0. 0. 1.]
 [0. 0. 1. 0. 0. 0. 0.]
 [0. 0. 0. 0. 0. 1. 0.]
 [0. 0. 0. 0. 1. 0. 0.]
 [0. 0. 0. 0. 1. 0. 0.]]
'''
print(f'인코딩 완료 : \n {one_hot_result.toarray()}')
'''
# result 인코딩 완료
(0, 0)	1.0
(1, 1)	1.0
(2, 3)	1.0
(3, 5)	1.0
(4, 6)	1.0
(5, 2)	1.0
(6, 5)	1.0
(7, 4)	1.0
(8, 4)	1.0
'''
print(f'인코딩 완료 : \n {one_hot_result}')
```

# K-fold

# 교차검증
k :: 하이퍼파라미터(매개변수)



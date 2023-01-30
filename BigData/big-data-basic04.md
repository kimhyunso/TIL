# GUI
Graphic User Interface
## Front_end
- JAVA
- css
- javascript
- HTML
- Spring
- Spring boot

## Back_end
- server
- DA

## DA
pandas (사람이 편하려고)

Numpy (데이터 처리...) :: DL

# 조건부 확률
집합의 법칙 (합칩합/교집합)

= 확률의 덧셈법칙

= 확률의 곱셈법칙

# 확률

## 상대빈도정의
실험을 무한에 가깝게 지속적으로 시행

## 동등발생정의
논리적 추론이 가능한 것

ex) 동전 던지기 => 앞면, 뒷면 1/2


# 집합
## 여집합


## 합집합
A = {1, 2, 3} + B = {2, 5, 6} => S ={1, 2, 3, 2, 5, 6}

## 교집합
A = {1, 2, 3} and B = {3, 4, 7} => S = {3}


# 조건부 확률
P(B|A) = P(A∩B) / P(A)

P(A|B) = P(A∩B) / P(B)

# 독립사건
처음 사건이 다음에 일어날 사건에 아무런 영향을 주지 않을 때

# 종속사건
한 사건의 발생이 다믕 발생할 사건에 영향을 주는 경우


# 베이즈 정리
P(A|B) = P(A∩B) / P(A∩B) + P(A𝒄∩B)

# 확률 변수
일정한 확률을 가지고 발생하는 사건에 수치를 부여한 것
- 보통 x


# 확률 분포표, 확률 분포 그래프
확룰변수가 취할 수 있는 모든 값들을 어떤 것이라도 표시한 것 ex)그래프, 도표 등...

## 이산확률변수
- 이산확률분포
> 대표적 : 이항분포, 다항분포, 초기하분포, 베르누이분포
## 연속확률변수
- 연속확률분포
> 대표적 : 균일분포, 정규분포, z분포, t분포, f분포, 카이제곱분포, 감마, 베타....

# 확률밀도함수
1. 이산확률분포 - p(x)
2. 연속확률분포 - 범위 f(x)
## 기대값
평균값

# CSV
Comma Seperate Value

# TSV
Tap Seperate Value

# pandas
```python
import pandas as pd
# csv파일을 읽어온다.
# 2차원 데이터
titan_df = pd.read_csv('./titanic/train.csv')
# 행과 열의 개수를 출력해준다
print('행과 열 : ', titan_df.shape)

# 최근 3개의 값만 출력한다.
print(titan_df.head(3))
```
## 단일 요소 추출하기
- iloc : 위치기반 인덱싱
- loc : 명칭기반 인덱싱

```python
import pandas as pd
titan_df = pd.read_csv('./titanic/train.csv')

# 단일 요소 추출하기
# 1. position_based_indexing(위치기반 인덱싱)
# 0번째 요소중 3번째의 데이터
print(titan_df.iloc[0, 3])
# 2. label_based_indexing(명칭기반 인덱싱)
# 0번째 요소중 Name의 데이터
print(titan_df.loc[0, 'Name'])
```

## 원하는 컬럼 가져오기
```python
import pandas as pd
titan_df = pd.read_csv('./titanic/train.csv')

# 1차원
type(titan_df['Name'])

# 2차원
type(titan_df)

# 2차원 일부 추출 => 2차원 데이터
titan_df[['Pclass', 'Name', 'Age']]
# 일부 데이터 중 3번째 행의 값 추출 => 1차원 데이터
titan_df[['Pclass', 'Name', 'Age']].iloc[2]
```

## `value_counts()` 함수
```python
import pandas as pd
titan_df = pd.read_csv('./titanic/train.csv')

# Pclass 값들의 총개수 추출
titan_df['Pclass'].value_counts()
# Pclass와 Age 값들의 총개수 추출
titan_df[['Pclass', 'Age']].value_counts()
```

## 행과 열을 추가 삭제
```python
# 열 추가
titan_df['Age_10'] = 0

# 파생변수 생성하기 - 연구자의 논리적 주관에 따라 데이터 정보에 맞게 생성된 변수
titan_df['Fam_no'] = titan_df.SibSp + titan_df.Parch + 1

titan_df['Age_by_100'] = titan_df.Age * 100
print(titan_df)
# 열 삭제
# 1. 원본에서 컬럼을 지우는 방법
titan_df.drop('Age_10', axis=1, inplace=True)
# 2 원본은 그대로 컬럼을 지우는 방법
titan_df = titan_df.drop(['Age_0', 'Age_by_100'], axis=1)
```
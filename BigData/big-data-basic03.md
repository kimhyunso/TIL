# 통계학
표본조사(Sampling)
- 질
- 사전처리
- 인과 (Casualty)

Sample => Explore => Modify => Model => Assess (반복)

# 빅데이터
전수조사(Census)
- 양
- 사후처리
- 상관 (Correlation)

# 통계학의 자료
1. 질적
    * 문자
2. 양적
    * 숫자
    1. 이산적
    2. 연속적

# 통계학
1. 기술통계학
통계자료
2. 추리통계학
추리할 수 있는 자료


# 통계학의 자료
1. 명목척도
- 단순한 구분기호
2. 서열척도
- 순서
3. 등간척도
- 순서 사이의 간격
4. 비율척도
- 비율

* 절대영점

# 집중화 경향
1. 산술평균
2. 중앙값
3. 최빈값

1. 산술평균
a, b, c

(a+b+c) / 3
 
2. 기하평균
abc^1/3

sqrt(a*b)

3. 조하평균
분류분석 => F1_score

* F1_score = 2*A*B / (A+B)

1. Data Work Flow
데이터 수집 => 데이터 전처리 => 모델링 - 규칙을 찾는다. => 과정평가/결과해석/시각화
2. 통계학의 정의
통계학 vs 빅데이터
## 통계학
표본조사
질
인과관계
## 빅데이터
전수조사
양
상관관계


## 인과관계와 상관관계의 차이점
한 변수가 다른 변수를 설명할 수 있느냐의 여부
## 인과관계를 나타내는 용어(회귀분석)
매출액 = 100 * 영업사원수 + 0
- 매출액
종속변수 = 반응변수 = 목표/목적변수(target) = 레이블(Label)

- 영업사원수
x변수 = 독립변수 = 설명변수 = data


# 통계학의 정의
1. 기술통계학
- 하나의 집단의 자료의 분포, 평균(대표값 등)등을 파악하는 통계학
2. 추리통계학
- 표본(모집단의 일부)을 통해 모집단의 특성- 모평균, 모분산, 모분포)을 추리하는 통계학


## 추리통계학
1. 모수통계학
- 모집단의 분호가 정규분포를 따른다.
- 자료가 연속형(=비율척도)
2. 비모수통계학
    1. 데이터의 수가 작아도
    2. 데이터가 정규분포를 따르지 않아도
    3. 데이터가 비율척도가 아니더라도

# 자료의 종류와 변수의 척도
## 질적변수
문자
## 양적변수
숫자
1. 이산형(정수)
2. 연속형(실수)

# 변수의 척도
명목 - 선호도, 선수의 등번호, 종교, 성별 (사칙연산 안됨)

서열(순서) - 선착순, 반, 석차 (사칙연산 안됨)

등간(구간) - 아날로그 시계, 아날로그 체중계(1. 덧셈뺄셈만 됨. 2. 절대영(0)점이라는 개념이 없다)

비율 - 위의 3개 척도 빼고 다 (실수형) (1. 사칙연산 2. 절대영(0)점이라는 개념이 있다.)

# 대표값
1. 평균값
- 산술, 기하, 조화
2. 최빈값
3. 중앙값

# 인덱싱
## 슬라이싱(Slicing)
- [행, 열]
```python
# 2차원 슬라이싱
import numpy as np
array1 = np.arange(1, 10)

array2d = array1.reshape(3, 3)

print('array2d(0:2, 0:2)', array2d[0:2, 0:2])
print('array2d(1:2, 2:)', array2d[1:2, 2:])
# 정적이라 1차원으로 만듬
print('array2d(0:2, 0)', array2d[0:2, 0])
# 동적이라 2차원으로 만듬
print('array2d(0:2, 0:1)', array2d[0:2, 0:1])
```
## 팬시 슬라이싱(Fancy Slicing)
```python
import numpy as np
array1 = np.arange(1, 10)
array2d = array1.reshape(3, 3)
# 2차원
print('array2d([0,1], 2:)', array2d[[0,1], 2:])
# 1차원
print('array2d([0,1], 2)', array2d[[0,1], 2])
```

# 웹 크롤링 `selenium`
웹 크롤링의 대표적인 라이브러리이다.

자바스크립트 방식으로 크롤링을 한다.
`$ pip install selenium`

## 동적 크롤링
```python
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
import urllib as u
import time

driver = webdriver.Chrome()
driver.get('url주소')
# HTML요소 중 name이 q인 것을 찾는다.
elem = driver.find_element(By.NAME, 'q')
elem.clear()

elem.send_keys('찾고자하는 내용')
# enter를 쳐서 검색하고자 하는 내용을 검색한다.
elem.send_keys(Keys.RETURN)
# 요소 한 개만 찾아 클릭함
driver.find_elements(By.CSS_SELECTOR, 'css class명 tag')[0].click()
# 지정 시간(sec)동안 멈춤
time.sleep(3)
# 클릭한 img나 데이터를 가져옴
src = driver.find_element(By.CSS_SELECTOR, 'css class명 tag')

# 이미지 다운로드
u.request.urlretrieve(src, '이미지이름.png')
```


## 정적 크롤링


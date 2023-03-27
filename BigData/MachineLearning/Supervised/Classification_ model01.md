# ClassiFication : 분류
1. 로지스틱회귀 (Logistic Regression) : 이진분류
2. 서포트벡터머신 (Support Vector Machine : SVM)

내가 예측하고자 하는 Y값이 카테고리처럼 분류할 수 있는 경우 숫자 자체에 의미가 없는 경우 : 이진분류 0, 1, 2 등...

y = Class

x1, x2 데이터가 x, y그래프로 표현됨

x = Feature, Attribute, Column, Demension

x만 = Feature

x and y = Attribute, Column, Demension
 
# Generation
Captity 극대화 -> Overfittig -> Generation 증가

# K-fold
K : 자신이 몇 번 학습을 시킬 것인지

80% : train_data

20% : test_data

# Stratified(층화)
80%의 train_data 안에서 다시 train_data, validation_data, test_data로 나누어 반복 학습한다.

# Accuracy


# ClassiFication
1. Logistic Regression (로지스틱 회귀)

x데이터가 양성(Positive)일 확률

## Logistic Regression
2진분류 모델

두 가지의 경우가 나온다.
1. y값
2. 카테고리 값 ex) 0 or 1
## Cutoff
Hyper-parameter default : 0.5
- 0.5초과의 값으로 설정 시, 모델이 엄격해짐
- 0.5미만의 값으로 설정 시, 모델이 느슨해짐

## Sigmoid Function
$$ y = \frac{1}{1+e^{ax+b}}$$

> 1 / 1 : 상수 + e(자연상수)

# 평가지표
## CrossEntropy
에러율이 낮을 수록 분류를 더 잘한 것이다.

## Logits

# Confusion Matrix (혼동행렬)
classification모델 후 평가지표

|Confusion Matrix|Positive|Negative|
|-|-|-|
|Positive|True Positive|False Positive|
|Negative|True Negative|False Negative|

## 예시
암환자 100명의 데이터를 예측했다면,
|Confusion Matrix|암안걸림|암걸림|
|-|-|-|
|암안걸림|True Positive(30)|False Positive(15)|
|암걸림|False Negative(5)|True Negative(50)|

판단지표 : 암에 걸림에도 불구하고 안 걸렸다고 분류한 경우 위험 = Recall(재현율) 사용해아함

### Recall(재현율)
TP + FN / TP = 30 + 5 / 30

스팸메일을 분류한다면,
|Confusion Matrix|스팸메일아님|스팸메일임|
|-|-|-|
|스팸메일아님|True Positive(30)|False Positive(15)|
|스팸메일임|False Negative(5)|True Negative(50)|

판단지표 : 스팸메일이 아닌데도 불구하고 스팸메일로 분류한 경우 위험 = Precision(정밀도)

### Precision(정밀도)
TP + FP / TP

## F1-Score
Recall + Precision 조화












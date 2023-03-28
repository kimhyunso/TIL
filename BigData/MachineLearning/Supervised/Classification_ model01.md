# ClassiFication : 분류
1. 로지스틱회귀 (Logistic Regression) : 이진분류
2. 서포트벡터머신 (Support Vector Machine : SVM)

> y = Class
> 
> x = Feature, Attribute, Column, Demension : x만 = Feature
>
> x and y = Attribute, Column, Demension

내가 예측하고자 하는 Y값이 카테고리처럼 분류할 수 있는 경우 숫자 자체에 의미가 없는 경우 : 이진분류 0, 1, 2 등...

# 데이터전처리
## Label Encoding
{토끼, 사자, 고양이, 강아지} => {0, 1, 2, 3}

## One-hot Encoding
{토끼, 사자, 고양이, 강아지} => {0001, 0010, 0100, 1000}

# 평가지표
## CrossEntropy
에러율이 낮을 수록 분류를 더 잘한 것이다.
### Entropy
불확실성의 척도로 정보이론에서의 엔트로피는 불확실성을 나타내며 엔트로피가 높다는 것은 정보가 많고 확률링 낮다는 것을 의미한다.

$$ H(x) = -\sum_{i=1}^np(x)logp(x_i) $$

## 혼동행렬 (Confusion Matrix)
|Confusion Matrix|Positive|Negative|
|-|-|-|
|Positive|True Positive|False Positive|
|Negative|True Negative|False Negative|

## Precision(정밀도)
$$ \frac{TP}{TP+FP} $$

> 판단지표 : 스팸메일이 아닌데도 불구하고 스팸메일로 분류한 경우 위험 = Precision(정밀도)

스팸메일을 분류한다면,
|Confusion Matrix|스팸메일아님|스팸메일임|
|-|-|-|
|스팸메일아님|True Positive(30)|False Positive(15)|
|스팸메일임|False Negative(5)|True Negative(50)|

$$\frac{TP}{TP + FP} = \frac{30}{30 + 15}$$

## Recall(재현율)
$$ \frac{TP}{TP+FN} $$

> 판단지표 : 암에 걸림에도 불구하고 안 걸렸다고 분류한 경우 위험 = Recall(재현율) 사용해아함

암환자 100명의 데이터를 예측했다면,
|Confusion Matrix|암안걸림|암걸림|
|-|-|-|
|암안걸림|True Positive(30)|False Positive(15)|
|암걸림|False Negative(5)|True Negative(50)|

$$\frac{TP}{TP + FN} = \frac{30}{30 + 5}$$

## F1-Score
Recall + Precision 조화

## Accuracy
전체 샘플 개수 중 얼마나 알고리즘이 맞는지
$$Accuracy = \frac{올바르게 예측한 샘플 개수}{전체 샘플 개수} = \frac{TP + TN}{TP+TN+FP+FN}$$

## ROC Curve (Receiver Operating Characteristic Curve)
직각일 때 성능이 좋다고 판단함

## AUROC (Area Under the ROC Curve)
ROC Curve 밑의 면적을 기준으로 좋은지 나쁜지를 판단함


## Logistic Regression
2진분류 모델 : 2가지의 분류를 예측함
## Sigmoid Function
> 1 / 1 : 상수 + e(자연상수)

$$ y = \frac{1}{1+e^{ax+b}} $$

## Cutoff
Hyper-parameter default : 0.5
- 0.5초과의 값으로 설정 시, 모델이 엄격해짐
- 0.5미만의 값으로 설정 시, 모델이 느슨해짐

## Threshold : 임계값 = Hyper-parameter
> default : 0.5

Sigmoid 함수를 이용하면 한계점을 정해줘야함
- 높을 수록 엄격해짐
- 낮을 수록 느슨해짐


# SVM (Support Vector Machine)
Margin을 최대화하는 결정 경계(면)을 찾는 기법

C값, gamma값이 커질 수록 오버피팅

## Linearly Unseparable(선형 분리 불가능)
데이터가 분리가 선형적으로 분리가 불가능할 경우

# Soft Margin SVM
## 목적함수
1. MIN
2. MAX

## Margin
1. Max = 2 / ||w||(놈)
2. MIN = Max의 역수

$$ arg min_w, \xi, b\{\frac{1}{2}\left\lvert\left\lvert w\right\rvert\right\rvert^2 + C\sum_{i=1}^{n}\xi_i\} $$

C : Hyper-parameter 작게 주면 무시함

크사이 : 분류된 데이터의 오류 거리


## Kernel Support Vector Machines(커널 서포트 벡터 머신)
2차원 -> Hyper-Parameter(함수)를 통해 3차원 공간으로 이동시킴

## Kernel Function (Hyper-Parameter)
1. 다항함수
2. 가우시안 함수

## 가우시안 함수
RBF (Radial Basis Function) 방사기저함수

# K-Nearset Neighbor Algorithm (KNN)
비슷한 특성을 가진 데이터는 비슷한 범주에 속하는 경향이 있다는 가정하에 사용함

# Hyper-parameter Optimization == HPO 최적 해를 찾아주는 모델
1. Grid-Search
2. Randomized-Search
3. Bayesian-Search

# K-fold
K : 자신이 몇 번 학습을 시킬 것인지

80% : train_data

20% : test_data

# Stratified(층화)
80%의 train_data 안에서 다시 train_data, validation_data, test_data로 나누어 반복 학습한다.















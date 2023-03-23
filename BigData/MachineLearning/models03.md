# 분류모델
# Logistic Regression

## Threshold : 한계점
Sigmoid 함수를 이용하면 한계점을 정해줘야함
- 높을 수록 엄격해짐
- 낮을 수록 느슨해짐


# 평가지표
## ROC Curve (Receiver Operating Characteristic Curve)
직각일 때 성능이 좋다고 판단함

## AUROC (Area Under the ROC Curve)
ROC Curve 밑의 면적을 기준으로 좋은지 나쁜지를 판단함


# 머신러닝 (Machine Learning)
# 분류모델
지도학습모델 분류뿐 아니라 회귀에도 활용가능
# SVM (Support Vector Machine)
Margin을 최대화하는 결정 경계(면)을 찾는 기법

# Soft Margin SVM
## 목적함수
1. MIN
2. MAX

# Margin
1. Max = 2 / ||w||(놈)
2. MIN = Max의 역수


$$ arg min_w, \xi, b\{\frac{1}{2}\left\lvert\left\lvert w\right\lvert\right\lvert^2 + C\sum_{i=1}^{n}\xi_i\} $$


C : Hyper-parameter 작게 주면 무시함

크사이 : 분류된 데이터의 오류 거리


# Linearly Unseparable(선형 분리 불가능)
데이터가 분리가 선형적으로 분리가 불가능할 경우

# Kernel Support Vector Machines(커널 서포트 벡터 머신)
2차원 -> Hyper-Parameter(함수)를 통해 3차원 공간으로 이동시킴

## Kernel Function (Hyper-Parameter)
1. 다항함수
2. 가우시안 함수

# 딥러닝
1. LinearCombination
## 근간
Layer = Learnable Kernel
## 특성교차 (Feature Crosses)

# SVM
C값, gamma값이 커질 수록 오버피팅

# 가우시안 함수
RBF (Radial Basis Function) 방사기저함수

### snake_case
### camelCase
### PascalCase
### kebab-case

# NuMericalValue
## Feature Scale 적용
train_X 데이터만 사용

# 카테고리Value
## One-Hot Encoding
## Label Encoding


# Hyper-parameter Optimization == HPO 최적 해를 찾아주는 모델
1. Grid-Search
2. Randomized-Search
3. Bayesian-Search

# 분류모델
# K-Nearset Neighbor Algorithm

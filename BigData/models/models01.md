# 분류 모델
1. Regression
2. Classification

h(x) = Θ_0x + Θ_1

# Regression
내가 예측하고자 하는 Y값이 수치에 의미가 있는 경우 = 덧셈, 뺄셈, 곱셈가능

y = Numerical Value

x값이 증가함에 따라 3차원 - 4차원 무한히 확장가능

- Overfitting(과적합)
많은 데이터를 학습한 결과 데이터를 외워버려 새로운 데이터에 대한 학습이 떨어지는 경우

# ClassiFication
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

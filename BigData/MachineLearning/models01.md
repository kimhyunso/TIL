# Overfitting(과적합)
많은 데이터를 학습한 결과 데이터를 외워버려 새로운 데이터에 대한 학습이 떨어지는 경우

# Regression : 회귀
내가 예측하고자 하는 Y값이 수치에 의미가 있는 경우 = 덧셈, 뺄셈, 곱셈가능

다른 독립변수 $\theta_0\dots\theta_n$가 연속형

$$ y = ax + y  $$

$$ h(x) = \theta_0x + \theta_1  $$

- y = Numerical Value
- x값이 증가함에 따라 3차원 - 4차원 무한히 확장가능
## 전처리
- StandardScaler
- MinmaxScaler

## 평가지표
- MSE (Mean Squared Error) : 평균제곱오차
- MAE (Mean Absolute Error) : 평균절대값오차
- MAPE (Mean Absolute Percentage Error) : 평균절대값퍼센트오차
- RMSE (Root Mean Squared Error) : 평균제곱에 루트 씌운 오차
- R2 (R Squared Score) 결정계수

## MSE
$$ MSE = \frac{1}{n} \sum_{i=1}^{n} (\hat{Y}_i-Y_i)^2 $$
## MAE
$$ MAE = \frac{1}{n} \sum_{i=1}^{n} \left\lvert\hat{Y}_i-Y_i\right\rvert $$
## MAPE
$$ MAPE = \frac{100}{n} \sum_{t=1}^n \left\lvert\frac{A_t-F_t}{A_t}\right\rvert$$
## RMSE
$$ RMSE = \sqrt{MSE} $$
## R2



# ClassiFication : 분류
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

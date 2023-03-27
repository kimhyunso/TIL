# Overfitting(과적합)
많은 데이터를 학습한 결과 데이터를 외워버려 새로운 데이터에 대한 학습이 떨어지는 경우

# Regression : 회귀
1. 선형회귀 (LinearRegression)
2. 라쏘 회귀 (Lasso regression)
3. 다항 회귀 (Polynomial regression)

내가 예측하고자 하는 Y값이 수치에 의미가 있는 경우 = 덧셈, 뺄셈, 곱셈가능

다른 독립변수 $\theta_0\dots\theta_n$가 연속형

$$ y = ax + y  $$

$$ h(x) = \theta_0x + \theta_1  $$

- y = Numerical Value
- x값이 증가함에 따라 3차원 - 4차원 무한히 확장가능
## 피처스케일링(표준화, 정규화)
- StandardScaler
- MinmaxScaler
## 표준화 (Standardization)
### StandardScaler
- 평균이 0이고 분산이 1인 정규 분포로 만드는 것

$$ (x_i-(x의 최솟값)) / (x의 최댓값 - x의 최솟값) = (x_i-min(x))/(max(x)-min(x)) $$

## 정규화 (Normalization)
### MinmaxScaler
- 모든 값을 0~1 사이의 값으로 바꾸는 것이다. 음수도 예외 없이 다 바꾼다.

$$ (x_i - (x의 평균)) / (x의 표준편차) = (x_i-\mu) / \sigma $$

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
## $R^2$
### SST (Sum of Squared Total) : 관측치 - 예측값
### SSE (Sum of Squared Error) : 관측값 - 예측값, 즉 잔차제곱합 RSS와 같음
### SSR (Sum of Squared to Regression) : 예측값 - 평균값

$$ R^2 = \frac{\sum{(\hat{Y}-\bar{Y})^2}}{\sum{(Y-\bar{Y})^2}} = \frac{SSR}{SST} or 1 - \frac{\sum{(Y-\hat{Y})^2}}{\sum{(Y-\bar{Y})^2}} = 1 - \frac{SSE}{SST} $$


$$ R^2 = \frac{\sum{(예측값-타겟평균값)^2}}{\sum{(관측값-타켓평균값)^2}} or 1-\frac{\sum{(관측값-예측값)^2}}{\sum{(관측값-타켓평균값)^2}}$$

$$ R^2 = 1 - \frac{\sum{오차^2}}{\sum{편차^2}}$$


## Gradient Descent(경사하강법)
x = θ  y = MSE값을 미분을 하여 접선의 기울기를 구하여 최적화된 MSE값을 도출하는 알고리즘

1. y = θ_1x + θ_0 : 원인 ex) 2x + 3 (θ1의 값은 랜덤)
2. 모델 모양 위치
3. 결과 = MSE

2번을 없앤다면 원인이 결과를 낳는다.

## Leaning Rate = α = 보폭
Hyper Parameter (초매개변수)

## Optimaization 최적화
MSE' = 0(미분방정식)을 통해 구할 수 있음
## Local Mimima 국소최소값 :: 주의
**경사하강법 도중 미세한 경사들이 MSE의 적절한 값으로 대체될 수 있음**

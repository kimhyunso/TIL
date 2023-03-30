# 인공신경망 ANN(Artificial Neural Network)
> 입력층 - 히든층 - 출력층
>
> 행렬곱 연산을 통해 결과값을 내놓는다. 결과값을 $g(x)$함수를 통해 찾아낸다.

$$ x_1 \theta_1 + x_2\theta_2 + x_3\theta_3 + \theta_0 = \sum_{i}\theta_ix_i $$

- $x_n$ : 행
- $\theta_n$ : 다음 노드로 뻗어나가는 가지(가중치)
- $g(x)$ : Activation Functionss = Hyper parameter

# Activation Functions = Hyper parameter
> 비선형 함수
$$ g(\sum_{i}\theta_ix_i) $$

1. Sigmoid
2. tanh(Hyperbolic Tangent)
3. ReLU

## Sigmoid
$$ g(z) = \frac{1}{e^{-z}} $$

## tanh
$$ g(z) = \frac{e^{z} - e^{-z}}{e^{z} + e^{-z}} $$
## ReLU
$$ g(z) = max(0, z) $$

## Leaky ReLU
$\alpha$ : Hyper-parameter

$$g(z) = max(\alpha z, z)$$


## 카테고리 분류 (Classfication)
카테고리의 개수 만큼 출력층이 존재

## 연속형 데이터 예측(Regression)
하나의 출력층만 존재


# 단층 퍼셉트론
두 개의 입력 한개의 출력으로 이루어진 인공신경망

# 다층 퍼셉트론
두 개의 입력 여러 개의 Hidden Layer가 있는 인공신경망


# 최적의 $\theta_0$ 값 찾기
1. Xavier
2. He

## Xavier
- Sigmoid
- tanh

표준 편차가 $\sqrt{\frac{1}{n}}$ 인 정규분포를 따르도록 가중치 초기화

## He
- ReLU

표준편차가 $\sqrt{\frac{2}{n}}$ 인 정규분포를 따르도록 가중치 초기화












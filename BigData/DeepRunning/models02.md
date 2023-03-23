# Weight Regularization
Cost Function 최적의 해

> MSE
$$J(\theta)= \frac{1}{m} \sum_{i=1}^m(h_\theta{(x^{(i)})-y^{(i)}})^2$$

$$ J(\theta) = MSE + \lambda R(\theta)$$

## Trade-off 관계
MSE가 커지면, $\lambda R(\theta)$값이 작아지고, MSE가 작아지면 $\lambda R(\theta)$값이 커진다.

$\lambda$값이 커지면 Overfitting 확률이 낮아지고, $\lambda$값이 커지면 Overfitting 확률이 높아진다. 


## Lasso : L1
$$\theta_1^2 + \theta_2^2$$

## Ridge : L2
$$ \left \lvert \theta_1^2 + \theta_2^2 \right \rvert$$

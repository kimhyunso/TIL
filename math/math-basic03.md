# 소인수분해

솟수로만 이루어진 숫자들까지 나누는 것

# 약수

소인수분해한 숫자로 표현할 수 있는 경우의 모든 것

$$ 12의 소인수분해 : 2 \times 6 \therefore 2^2 \times 3^1 $$

$$ 경우의 수1 : 2, 3을 사용안한다 \therefore 2^0 \times 3^0 \therefore 1 $$

$$ 경우의 수2 : 2를 1번 사용한다 \therefore 2^1 \therefore 2 $$

$$ 경우의 수3 : 3을 1번 사용한다 \therefore 3^1 \therefore 3 $$

$$ 경우의 수4 : 2를 2번 사용한다. \therefore 2^2 \therefore 4 $$

$$ 경우의 수5 : 2를 1번 3을 1번 사용한다. \therefore 2 \times 3 \therefore 6 $$

$$ 경우의 수6 : 2를 2번 3을 1번 사용한다. \therefore 2 \times 2 \times 3 \therefore 12 $$

> 즉, 12의 약수는 12를 소인수 분해한 모든 경우의 수다.
# 공약수

두 수를 소인수분해한 수들 중 공통으로 만들어 낼 수 있는 모든 수

$$ 12의 약수 \therefore 1, 2, 3, 4, 6, 12 $$

$$ 18의 약수 \therefore 1, 2, 3, 6, 9, 18 $$

$$ 12와 18의 공약수 : 2^2 \times 3^1(12) // 2^1 \times 3^2(18) \therefore 두 수중 공통된 모든 수 $$

$$ 경우의 수1 : 아무 것도 사용하지 않는다. \therefore 2^0 \times 3^0 \therefore 1 $$

$$ 경우의 수2 : 2를 1번 사용한다. \therefore 2^1 \therefore 2 $$

$$ 경우의 수3 : 3을 1번 사용한다. \therefore 3^1 \therefore 3 $$

$$ 경우의 수4 : 2를 1번 3을 1번 사용한다. \therefore 2^1 \times 3^1 \therefore 6 $$

즉, A, B 두 수의 공약수는 **소인수분해된 공통된 수들로 만들 수 있는 모든 경우의 수**다.
# 최대공약수 (G)

두 수를 소인수분해한 수들 중 공통된 수

### **TIP**

$$ 숫자 뒤에 0이 나올 경우 2 \times 5로 소인수분해 가능 10 \therefore 2 \times 5 // 100 \therefore 2^2 \times 5^2 // 1000 \therefore 2^3 \times 5^3 \dots 즉 뒤의 제곱만 증가한다. $$

$$ 36과 10의 최대공약수 : 2^2 \times 3^2(36) // 2 \times 5(10) \therefore 두 수의 공통된 수 2 $$

$$ 16과 35의 최대공약수 : 2^4(16) // 3 \times 5(35) \therefore 없음 :: 서로소 $$ 


$$ 18과 36의 최대공약수 : 2^1 \times 3^2(18) // 2^2 \times 3^2(36) \therefore 두 수의 공통된 수 2^1 \times 3^2 :: 18 $$

# 배수
소인수분해한 숫자들의 배수

$$ 18의 배수 : 18, 36, 54, 72 \dots $$

$$ 18의 소인수분해 : 2^1 \times 3^2(18) \times 2 = 36 // 2^1 \times 3^2 \times 3 = 54 // 2^1 \times 3^2 \times 4 = 72 \dots $$

$$ 즉, 18 \times 2, 18 \times 3, 18 \times 4 \dots 와 같음 $$

# 최소공배수 (L)

두 수를 소인수분해한 수들을 모두 나열한 것

$$ 36의 배수 : 36, 72, 108 \dots $$

$$ 12의 배수 : 12, 24, 36, 48, 60 \dots $$

$$ 36과 12의 최소공배수 : 2^2 \times 3^2(36) // 2^2 \times 3(12) \therefore 2^2 \times 3^2 :: 36 $$

$$ 54와 30의 최소공배수 : 2 \times 3^3(54) // 2 \times 5 \times 3(30) \therefore 2^1 \times 3^3 \times 5 :: 270 $$
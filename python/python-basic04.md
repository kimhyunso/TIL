## 모음 제거하기

> 다음 문장의 모음을 제거한 새로운 문자열을 출력하세요.

---


**[입력 예시]**

`'Life is too short, you need python'`

**[출력 예시]**

`Lf s t shrt, y nd pythn`

```python
remove_code = ['i','o','u','e','a']
result = ''
for my in my_str:
    if my not in remove_code:
        result += my
    
print(result)
```
---

## 과일 개수 골라내기

> 내 장바구니에 과일이 몇 개인지, 과일이 아닌 것은 몇개인지 출력하세요.
>
> 장바구니에 담긴 과일과, 과일 판별 리스트는 다음과 같습니다.
> ```python
> basket_items = {'apples': 4, 'oranges': 19, 'kites': 3, 'sandwiches': 8}
> fruits = ['apples', 'oranges', 'pears', 'peaches', 'grapes', 'bananas']
> ```

---

**[출력 예시]**

과일은 23개이고, 11개는 과일이 아닙니다.

```python
basket_items = {'apples': 4, 'oranges': 19, 'kites': 3, 'sandwiches': 8}
fruits = ['apples', 'oranges', 'pears', 'peaches', 'grapes', 'bananas']

fruit_count = 0
not_fruit_count = 0
for key in basket_items:
    if key in fruits:
        fruit_count += basket_items[key]
    else:
        not_fruit_count += basket_items[key]

print(f'과일은 {fruit_count}개이고, {not_fruit_count}개는 과일이 아닙니다.')
```
---
## 영어 이름 출력하기 

> 영어 이름은 가운데 이름을 가지고 있는 경우가 있습니다.
>
> 가운데 이름은 대문자로 축약해서 나타내는 코드를 작성하세요.

---
**[입력 예시]**

Alice Betty Catherine Davis

**[출력 예시]**

Alice B. C. Davis

```python
name = 'Benicio Monserrate Rafael Del Toro asdasdasd AsSssads Sanchez'
names = name.split()
new_str = ''

for idx in range(len(names)):
    if idx == 0 or idx == len(names) - 1:
        new_str += names[idx] + ' ' 
    else:
        new_str += names[idx].replace(names[idx][1:],'. ')

print(new_str)
```
---
## 구구단 출력하기
> 2단부터 9단까지 반복문을 사용하여 구구단을 출력하세요.
---
**[출력 예시]**
```
------- [2 단] -------
2 X 1 = 2
2 X 2 = 4
2 X 3 = 6
2 X 4 = 8
2 X 5 = 10
2 X 6 = 12
2 X 7 = 14
2 X 8 = 16
2 X 9 = 18

------- [3 단] -------
...
```

```python
for dan in range(2, 10):
    print(f'------- [{dan} 단] -------')
    for num in range(1, 10):
        print(f'{dan} x {num} = {dan * num}')
    print()
```

---
## 개인정보보호
> 사용자의 핸드폰번호를 입력 받고, 개인정보 보호를 위하여 뒷자리 4자리를 제외하고는 마스킹 처리하세요.
> * 핸드폰번호는 010으로 시작해야하고 11자리여야한다.
> * 핸드폰번호를 입력하지 않았다면 "핸드폰번호를 입력하세요"를 출력한다.

---

**[입력 예시]**

01012341234

**[출력 예시]**

*******1234

```python
while True:
    phone_num = input()
    if phone_num[0:3] != '010' and len(phone_num) != 11:
        print('핸드폰번호를 다시 입력해주세요')
    else:
        print(phone_num.replace(phone_num[0:11-4],'*'*7))
        break
```
---
## 정중앙
> 사용자가 입력한 문자열중 가운데 글자를 출력하세요. 
> * 단, 문자열이 짝수라면 가운데 두글자를 출력하세요.

---

**[입력 예시]**

abc

**[출력 예시]**

b

```python
char_str = input()
div = len(char_str)//2

if len(char_str) % 2 == 0:
    print(char_str[div-1:div+1])
else:
    print(char_str[div])
```
---
## 소수 찾기

> 조건, 반복문을 응용하여 numbers 리스트의 요소들이 소수인지 아닌지 판단하는 코드를 작성하세요.

---


**[입력 예시]**

26, 39, 51, 53, 57, 79, 85

**[출력 예시]**
```python
26 는 소수가 아닙니다. 2 는 26 의 인수입니다.
39 는 소수가 아닙니다. 3 는 39 의 인수입니다.
51 는 소수가 아닙니다. 3 는 51 의 인수입니다.
53 는 소수입니다.
57 는 소수가 아닙니다. 3 는 57 의 인수입니다.
79 는 소수입니다.
85 는 소수가 아닙니다. 5 는 85 의 인수입니다.
```

- 빅오 표기법 (O, big-O)

```python
numbers = [26, 39, 51, 53, 57, 79, 85]

demis = [2, 3, 5, 7]
result = 0

for number in numbers:
    for demi in demis:
        if number % demi == 0:
            result = demi
            break
    if number % demi:
        print(f'{number}는 소수입니다.')
    else:
        print(f'{number}는 소수가 아닙니다. {result}는 {number}의 인수 입니다.')

# 강사님 답안
numbers = [26, 39, 51, 53, 57, 79, 85]

for n in numbers:
    # n ** 0.5 => (n^2)
    for x in range(2, int(n ** 0.5)):
        if n % x == 0:
            print(f'{n} 는 소수가 아닙니다. {x} 는 {n} 의 인수입니다.')
            break
else:
    print(f'{n} 는 소수입니다.')
```
---
## 보너스 로또
1등 : 다 일치

2등 : 어려움. 5개일치 + 나머지 하나가 보너스 (2 3 4 5 6 8)

3등 : 5개

4등 : 4개

5등 : 3개
```python
my_numbers = [1, 2, 3, 4, 5, 6]
jackpot_numbers = [2, 1, 4, 5, 6, 7]
bonus_number = 8
cnt = 0
result = ''

for number in my_numbers:
    if number in jackpot_numbers:
        cnt += 1
        
if cnt == 5 and bonus_number in my_numbers:
    result = '2등'
elif cnt == 6:
    result = '1등'
elif cnt == 5:
    result = '3등'
elif cnt == 4:
    result = '4등'
elif cnt == 3:
    result = '5등'
        
print(result)
```

# 함수 (Function)
- 가독성
- 재사용성
- 유지보수

```python
def cube(x):
    return x ** 3

# result 10 ^ 3
cube(10)


# 반복구간은 변수를 선언하여 처리하자 n//2
def my_list_max(list_a, list_b):
    total_a, total_b = sum(list_a), sum(list_b)
    if total_a > total_b:
        return list_a
    elif total_a < total_b:
        return list_b
    else:
        return '같음'
```
# 매개변수
## 위치 인자
```python
def cylinder(half, height):
    return 3.14 * (half ** 2) * height

# result 1*2*3*4
print(1, 2, 3, 4, sep='*', end='*')
```

# 기본 인자 값
```python
def greeting(name='익명'):
    return print(f'{name}, 안녕?')
```



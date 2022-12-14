# Mark Down 기초문법

1 ~ 6 header
# 1번째
## 2번째
### 3번째
#### 4번째
##### 5번째
###### 6번째

---

## 리스트
### 순서있는 리스트(OL)
1. 1번
   1. 1번들여쓰기
      1. 테스트
      2. 테스트1
   2. tap
      1. 테스트
   3. shit tap
2. 2번
   1. 1번 들여쓰기
   2. 2번 들여쓰기
3. 3번
4. 4번
5. 5번
### 순서없는 리스트(UL)
 - 짜장면
 - 짬뽕
 - 라면
 - 밥
1. test
2. test
3. test

---
## 인라인 강조
중요한 것을 **굵게 표시**, 주의할 것은 *기울이고*, `코드 혹은 명령어`는 따로 표시
- 굵게 : (**)
- 이텔릭 : (*)
- 코드 강조 : (``)


---
## 블럭강조

### 표
|명령어|설명|예시|옵션|
|-|-|-|-|
|`mkdir`|Create Forder|`$ mkdir mydirectory`| |
|`cd`|Change Drectory|`$ cd mydirectory`| |
|`ls`|File lists|`$ ls`| -l, -a, -d|
|`touch`|Create File|`$ touch 1.txt`| |
|`rm`|Remove Files|`$ rm 1.txt`|-r -f|
|`pwd`|My Location|`$ pwd`| |


### 코드

```python
a = input()
print(a)
```
```java
public void main(){

}
```
```C
int main(){
   return 0;
}
```
---

## 기타
### 인용문
> 일단 유명해지자

### 수식블럭
latex
- 인라인 수식 : ($$)
- 블럭 수식 : ($$$$)

$x+y$
$$
   x+y
$$

### 이미지 / 하이퍼링크
[표시 텍스트]\(링크)

[구글](https://google.com)

![TestImage]()

# GIT
version 관리 시스템

## git init
디렉토리에 .git/ 폴더를 만듬 -> Repository

## git add
스테이지에 올리는 행위

## git commit
사진찍는 행위

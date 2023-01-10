# async와 defer
HTML 문서 파싱 종료시, javascript 파일을 다운로드 받고 파일이 다운받아지면 javascript를 실행한다.
> HTML => javascript downloda =>  javascript excute
## async
HTML 파싱과 동시에 javascript 파일을 다운받고 HTML 로딩이 종료되며 javascript를 실행시킨다.
> HTML, javascript download => javascript excute
```javascript
<script src="asyn1" async></script>
```

## defer
HTML 파싱과 동시에 javascript 파일을 다운받고 HTML 파싱을 계속 진행한다.

HTML 파싱이 끝났을 때, javascript 파일을 실행시킨다.

기본적으로 `true`
> HTML, javascript download => HTML => javascript excute
```javascript
<script src="asyn1" defer></script>
```

# 변수 선언
1. `var`
2. `let`
3. `const`


## var
똑같은 이름의 변수가 선언되도 동작됨
```javascript
var name = '홍길동';
console.log(name);

var name = "임꺽정";
console.log(name);
```

## let
ES6 이후 추가됨

똑같은 이름의 변수가 선언되면 에러

변수에 재할당가능 (mmutable)
```javascript
let name = "홍길동";
console.log(name);
// 에러
let name = "임꺽정";
console.log(name);

name = "임꺽정";
console.log(name);
```

## const
ES 6이후 추가됨

똑같은 이름의 변수가 선언되면 에러

변수에 재할당 불가능 (immutable)
```javascript
const name = "홍길동";
console.log(name);

// 에러
const name = "임꺽정";
console.log(name);

// 에러
name = "임꺽정";
console.log(name);
```

# 호이스팅
`var` 선언문이나 `function` 선언문 등을 해당 스코프의 선두로 옮긴 것처럼 동작하는 특성

> 선언단계 > 초기화단계 > 할당 단계

## `var` 선언단계와 초기화단계 동시에 이루어짐

```javascript
// undefind
console.log(name);

var name;
// undefind
console.log(name);

// 할당 단계
name = '홍길동'
console.log(name);
```

## `let` 선언단계와 초기화 단계가 나누어져있음

```javascript
// 에러
console.log(name);

let name;
// undefind
console.log(name);

// 할당 단계
name = '홍길동';
console.log(name);
```

# 자료형
|type|설명|예시|
|-|-|-|
|`int`|숫자형|`const i = 123;`|
|`Bigint`|아주 큰 숫자형|`const i = 1234567890123456789012345678901234567890n;`|
|`string`|문자형|`const str = 'hello';`|
|`boolean`|조건판단형|`const b = true`|
|`null`|존재하지 않는 값|`const n = null`|
|`undefined`|값이 할당되어 있지 않는 상태|`const u;`|

## 문자형(string)
1. 큰 따옴표("")
2. 작은 따옴표('')
3. 역 따옴표 백틱(``)
```javascript
let name = "홍길동";
console.log(`나의 이름은 ${name}입니다.`);
```

# 객체
```javascript
var dog = { name:'강아지',  kind:'포메라니안'};
console.log("강아지 이름 : "+dog.name+" 강아지 품종 : "+dog.kind);
```

# 비교연산자

|연산자|이름|
|-|-|
|`===`|엄격히 일치|
|`!==`|불일치|

```javascript
'1' === 1 // false
5 === 2 + 3 // true
```
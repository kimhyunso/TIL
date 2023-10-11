# 사용이유
예외 발생 중 NullPointException NPE를 처리하기 너무 귀찮다.

# 기존
```java
public class Main{
    public static void main(String[] args){
        // 첫번째 방법
        String age = null;
        try{
            int ageToInt = Integer.parseInt(age);
        }catch(Exception e){
            System.out.println(e.getMessage() + " 에러 발생!");
        }

        // 두번째 방법
        String age1 = null;
        int ageToInt1 = 0;
        if (age1 != null)
            ageToInt1 = Integer.parseInt(age1);
        else
            System.out.println("에러로 실행안됨");
    }
}
```

# `Optional<T>`
null이 올 수 있는 값을 감싸는 Wrapper 클래스

- null safety

# 대체
```java

// 비어있는 Optional 객체로 초기화
Optional<String> age  = Optional.empty();

// Optional.empty
System.out.println(age);

// false
System.out.println(age.isPresent());

// 값이 Null이 아닌 경우
Optional<String> age = Optinal.of("23");


// 값이 Null일 수도, 아닐 수도 있는 경우
Optional<String> age = Optional.ofNullable("23");

// 값이 없다면 "0"을 리턴 :: 파라미터로 값을 받는다.
String myAge = optional.orElse("0");

String myAge = optional.orElse(getAge());

// 파라미터로 함수형 인터페이스(함수)를 받는다.
String myAge = optional.orElseGet(this::getAge();

public String getAge(){
    return "23";
}

```

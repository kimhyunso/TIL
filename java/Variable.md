# 변수
primitive type

|type|설명|
|-|-|
|`int`|정수형 변수|
|`float`|실수형 변수|
|`boolean`|논리형 변수|
|`String`|문자열 객체|
|`char`|한 문자를 담는 변수|

# 메서드
> 기본적으로 동사형으로 만듬 (할 일)

```java
public void runing(){
    System.out.println("뛰는 중 입니다.");
}
```

# 매개변수
1. Call by Value
2. Call by Reference


## Call by Value
매개변수 자리에 Value를 던져 실행시킴 Value에는 아무런 변화가 없음
```java
public class Example{
    public static void main(String[] args){
        int time = 3;
        seeping(time);
    }

    private void seeping(int time){
        System.out.println("저는 "+time+"시간 동안 자고 있습니다.");
    }
}
```

## Call by Reference
매개변수가 메모리 주소를 참조하고 있기 때문에 함수에서 값이 변경되면 main에서 준 변수도 바뀜 (객체형)
```java

public void callMethod(){
    String name1 = "홍길동";
    String name2 = "김자바";

    System.out.println("Before Call Method : " + "name1 = "+ name1 + "name2 = " + name2);
    method2(name1, name2);
    System.out.println("After Call Method : " + "name1 = "+ name1 + "name2 = " + name2);
}

public static void callByReferenceMethod(String name1, String name2){
    name1 = "강아지";
    name2 = "고양이";
}
```






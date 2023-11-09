# Profiles
개발을 각 환경에 맞게 해야할 때 (SERVER와 LOCAL의 설정이 다름)

# 커멘드 라인 인수
`--xxx=값`

`String[] args`에 값 전달

```java
public static void main(String[] args){
    for(String arg : args){
        log.info("arg={}", arg);
    }
}
```

# VM 옵션 인수
`-Dxxx=값` 

```java
Properties properties = System.getProperties();
```

# `#---`
`xxx.properties` 파일 안에 요소들을 논리적으로 구분함
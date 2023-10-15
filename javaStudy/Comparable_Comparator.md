# `Comparable`, `Comparator`
객체를 비교할 수 있도록 만든다.

# `Comparable`
param 한개 필요

자기자신과 매개변수를 비교

# 사용법
```java
public class Member implements Comparable<Member>{
    // 비교할 대상들
    private int age;
    private int money;

    // 비교 함수
    @Override
    public int comparaTo(Member o){
        return -1;
    }
}
```

# `Comparator`
param 두 개 필요

매개변수 끼리 비교





# `@Configuration`
- 스프링컨테이너에 bean을 이용해 등록할 수 있게 설정해주는 것

```java
@Configuration
public class MyConfig{
    @Bean
    public Member getMember(){
        return new Member();
    }
}
```

# `@Componet`
- 스프링 컨테이너에 bean으로 등록하는 것
```java
@Componet
public class Member{
    public String getMember(){
        return "memberName!";
    }
}
```

# `@Service`
- 스프링 컨테이너에 bean으로 등록하는 것


# `@Repository`
- 스프링 컨테이너에 bean으로 등록하는 것









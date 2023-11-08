
# 객체와 테이블 매핑
- `@Entity` : 기본 생성자가 있어야함
- `@Table`

```java
@Table(name = "MEMBER")
@Entity
@NoArgsConstructor
public class Member{
    private Long id;
}
```

# 기본키 매핑
- `@Id`
## 기본키 할당 전략
1. 기본키 직접할당 - 객체에 키본키를 직접할당하여 사용하는 방식
2. IDENTITY - 기본키 생성을 데이터베이스에 위임하는 방식 :: 트랜잭션이 지원하는 쓰기 지연 지원 X
3. SEQUENCE - 
4. TABLE

```java
@Entity
public class Member{
    @Id
    private Long id;
}
```

# 필드와 컬럼 매핑
- `@Column`

```java
@Entity
public class Member{
    @Id
    private Long id;
    @Column(name = "USER_NAME")
    private String name;
}
```
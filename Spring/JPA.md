# 영속성 컨텍스트

# 엔티티 생명주기
1. 비영속 - 영속성 컨텍스트와 관계없음 
2. 영속 - 영속성 컨텍스트에 저장된 상태
3. 준영속 - 영속성 컨텍스트에 저장되었다가 분리된 상태
4. 삭제 - 삭제된 상태

# 1차 캐시
영속성 컨텍스트에 영속되어 있는 객체는 영속성 컨텍스트에서 관리하여 1차 캐시 안에 있는 객체를 반환받으려고 할때, 
데이터베이스를 접근하지 않고, 캐시에 있는 객체를 넘겨준다.

```java
// 영속됨
// 1차 캐시 사용
Member member1 = entityManager.find(member.class, id);
Member member2 = entityManager.find(member.class, id);
```

# 동일성 보장
영속성 컨텍스트에 있는 객체는 항상 같은 객체임을 보장한다.
```java
// 영속됨
Member member1 = entityManager.find(member.class, id);
Member member2 = entityManager.find(member.class, id);
// true
member1 == member2
```

# 트랜잭션을 지원하는 쓰기 지연
쿼리 실행시, 쓰기 지연 SQL 저장소와 1차 캐시에 SQL문과 객체를 저장한다.
`commit`이 실행되면 쑈기 지연 SQL 저장소에 있는 쿼리들이 실행된다.
```java
transaction.begin();

entityManager.persist(member);
Member member1 = entityManager.find(member.class, id);
Member.setName("김개똥");

transaction.commit();
```

# 변경 감지
영속성 컨텍스트에 보관할 때, 그 시점을 사진으로 찍어보관한 후(스냅샷), 
데이터 변경이 감지되면 수정쿼리를 작성해서 지연 SQL 저장소에 보낸다.
```java
entityManager.persist(member);

// 변경감지
member.setName("홍길동");
```

# 지연로딩
실체 객체를 대신 프록시 객체를 로딩해두고 해당 객체를 실제 사용할 때,
영속성 컨텍스를 통해 데이터를 불러오는 방법

# 플러시
영속성 컨텍스트에 저장한 엔티티는 플러시 시점에 데이터베이스에 반영한다.
일반적으로 트랜잭션을 `commit`할 때, 영속성 플러시가 플러시 된다.

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

# 연관관계 매핑
`@ManyToOne`, `@JoinColumn`




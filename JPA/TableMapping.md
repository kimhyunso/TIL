# 전제조건
> 데이터베이스 테이블은 `Join`을 통해 양방향 조회가능
>
> 하지만, 객체는 불가능!
>
> 단뱡향 연관관계를 2번 사용하여 양방향 연관관계를 형성하는 것처럼 보이는 것


# 단방향 연관관계
회원과 팀이 있을 경우, 회원->팀 or 팀->회원 둘 중 한 쪽만 참조하는 것
- `@ManyToOne` : 연관관계 매핑
- `@JoinColumn` : 조인될 컬럼

```java
@Entity
class Member{
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
}
@Entity
class Team{
    private String team_id;
    private String name;
}
```


# 객체 그래프 탐색
한 객체와 연관된 객체를 가져오는 것

```java
@Entity
class Member{
    @Id
    private String id;
    private String username;
    private Team team;
}
@Entity
class Team{
    @Id
    private String team_id;
    private String name;
}

Member member = new Member("memberA", "userName1");
// 객체 그래프 탐색
Team team = member.getTeam();
```

# 양방향 연관관계
- `@OneToMany` : `mappedBy` 속성을 통해 연관관계의 주인 설정

```java
@Entity
class Member{
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
}
@Entity
class Team{
    @Id
    private String team_id;
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<Member>();
}
```
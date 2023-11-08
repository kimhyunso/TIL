# 단방향 연관관계
회원과 팀이 있을 경우, 회원->팀 or 팀->회원 둘 중 한 쪽만 참조하는 것

# 객체 그래프 탐색
한 객체와 연관된 객체를 가져오는 것

```java
@Data
class Member{
    private String id;
    private String username;
    private Team team;
}

@Data
class Team{
    private String team_id;
    private String name;
}

Member member = new Member("memberA", "userName1");
// 객체 그래프 탐색
Team team = member.getTeam();
```

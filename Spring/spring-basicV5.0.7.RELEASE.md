# Maven, Gradle
빌드도구

# spring
스프링은 기본 생성시, 빌드도구와 context.xml들이 자동 생성된다.

|Eclipse IDE|Intellij IDE|
|-|-|
|web.xml|web.xml|
|root-context.xml|applicationContext.xml|
|servlet-context|displatcher-servelt.xml|


# SingleTon (싱글톤) 패턴
어플리케이션을 실행 중에 한 객체가 인스턴스화 되었다면, 인스턴스화 된 객체는 불변함
## `@Autowired`
root-context.xml이나 servlet-context.xml에 등록되어 있다면 `new`로 객체를 할당하지 않음 항상 불변한 메모리에 상주 
```java
@Service
public class ExampleService{
    @Autowired
	private ExampleMapper mapper;
}
```

# lombok
getter, setter, contruct 등을 자동 생성해줌
```java
@Data
@AllArgsConstructor
public class Example{
    private String name;
    private String age;
    private String phoneNum;
    private String addr;
}
```


# `@Controller`
Model과 View를 이어주는 매개체
##  `@RequestMapping("/api/main")`
Mapping된 URL로 접속가능
```java
@Controller
@RequestMapping("/hello/")
public void testController(){

    @GetMapping("/get")
    public void gethome(){
        return "jspFile";
    }

    @PostMapping("/post")
    public void posthome(){
        return "jspFile";
    }
} 
```

# Service
통신하고자 하는 인터페이스를 만듬
```java
public interface ReplyService {
	public int register(ReplyVO vo);
	public ReplyVO get(Long rno);

	public int modify(ReplyVO reply);
	public int remove(Long rno);
	public List<ReplyVO> getList(Criteria cri, Long bno);
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
}
```

# Mapper.xml
데이터베이스와 연결하여 CRUD를 도와주는 매개체
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//ibatis.apache.org//DTD Mapper 3.0//EN" "http://ibatis.apache.org/dtd/ibatis-3-mapper.dtd">
  
<mapper namespace="org.zerock.mapper.ReplyMapper">
	<insert id="insert">
		insert into tbl_reply (rno, bno, reply, replyer)
		values (seq_reply.nextval, #{bno}, #{reply}, #{replyer})
	</insert>
	
	<select id="read" resultType="org.zerock.domain.ReplyVO">
		select * from tbl_reply where rno = #{rno}
	</select>
	
	<delete id="delete">
		delete from tbl_reply where rno = #{rno}
	</delete>
	
	<update id="update">
		update tbl_reply set reply = #{reply}, updateDate = sysdate where rno = #{rno}
	</update>

	<select id="getListWithPaging" resultType="org.zerock.domain.ReplyVO">
		<![CDATA[
			select rno, bno, reply, replyer, replyDate, updateDate from
			(
				select /*+INDEX(tbl_reply idx_reply)*/
				rownum rn, rno, bno, reply, replyer, replyDate, updateDate
				from tbl_reply
				where bno = #{bno}
				and rno > 0
				and rownum <= #{cri.pageNum} * #{cri.amount}
			) where rn > (#{cri.pageNum} - 1) * #{cri.amount}
		]]>
	</select>
	
	<select id="getCountByBno" resultType="int">
		<![CDATA[
			select count(rno) from tbl_reply where bno = #{bno}
		]]>
	</select>
	
</mapper>
```


# ServiceIml
서비스 인터페이스를 상속받은 클래스, 실제 일을 하는 곳
```java
@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyMapper mapper;
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public ReplyVO get(Long rno) {
		return mapper.read(rno);
	}
	
	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		return mapper.getListWithPaging(cri, bno);
	}
	@Override
	public int modify(ReplyVO reply) {
		return mapper.update(reply);
	}
	// 트랜잭션 처리 게시물 업데이트와 댓글 삽입이 동시에 진행
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		return mapper.insert(vo);
	}
	// 트랜잭션 처리
	@Transactional
	@Override
	public int remove(Long rno) {
		ReplyVO vo = mapper.read(rno);
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		return mapper.delete(rno);
	}
	
	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
	}
	
}
```

# `@RestContoller`
JSON 데이터를 처리하기 위해 만들어짐
```java
private ReplyService service;

@GetMapping(value="/pages/{bno}/{page}", produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
public ResponseEntity<ReplyPageDTO> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno){
    // 페이징 클래스
    Criteria cri = new Criteria(page, 10);
    // Mapping 된 Service
    return new ResponseEntity<>(service.getListPage(cri, bno),HttpStatus.OK);
}
```

# `@ModelAttribute` 과 `@RequestParam`의 차이점
> `@ModelAttribute` : 객체
> 
> `@RequestParam` : 단일 값




```java
@GetMapping(value="/pages/{bno}/{page}")
public String getList(@RequestParam("name") String name, @ModelAttribute("TestVO") TestVO){
	return 'views';
}
```


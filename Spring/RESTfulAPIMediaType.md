# `produces` 속성 - 다중 미디어 타입지원
> 컨트롤러 메소드가 JSON 데이터를 생성한다는 것을 나타냄
```java
@RequestMapping(value = "/data", produces="application/json")
public ResponseEntity<Data> getDate(){}
```

# `consumes` 속성 - 다중 미디어 타입지원
> 컨트롤러 메소드가 JSON 데이터를 소비한다는 것을 나타냄

```java
@RequestMapping(value = "/data", conumes="application/json")
public ResponseEntity<Data> processData(@RequestBody Data data){}
```


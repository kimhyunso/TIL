# RESTfulAPI

# 1. stateless(무상태) 상태 비저장

**서버는 클라이언트 세션에 대한 정보를 저장하지 않는다.**

각 요청은 독립적이게 되며, 이전 요청과 무관하게된다.

# 2. 리소스 식별

GET, POST, PUT, DELETE 등과 같은 HTTP 메소드를 사용하여 리소스와 상호 작용할 수 있도록함

# 3. 리소스 조작

-   GET (리소스 검색)
-   POST (새리소스 생성)
-   PUT (기존 리소스 업데이트)
-   DELETE (리소스 제거)

# 4. 통일된 인터페이스

1.  표현지향  
    표현을 사용하여 클라이언트와 서버 간 데이터를 교환

-   application/json - JSON형식 데이터 표현
-   text/plain - 일반텍스트 표현 : ASCII, UTF-8 인코딩 사용
-   text/html - HTML문서 표현
-   application/xml - XML형식 데이터 표현
-   application/octet-stream - 바이너리 형식 : 사람이 읽을 수 없거나 미리 정의된 미디어 유형에 맞지 않을 경우 사용
-   application/pdf - PDF파일 형식

2.  메타데이터 : 각 요청 및 응답 메시지에는 그 목적과 수신자가 어떻게 처리해야 하는지 설명하기에 충분한 정보가 포함되어있다.

# 5. 계층화된 시스템

각 계층이 특정 책임을 맡고 독립적으로 개발 및 확장할 수 있는 계층구조를 적용함

-   레이어에는 로드 밸런서, 캐시, 프록시, 방화벽 빛 다양한 서버 구성요소 포함될 수 있음

# 6. 캐시 가능성

서버는 HTTP 응답에 캐시 해더를 지정하여 응답의 캐시 가능 여부와 기간을 표시할 수 있음

# 연습문제

서점 애플리케이션을 위한 RESTful API 작성

-   모든 책을 가져온다.
-   ID로 특정 책을 가져온다.
-   새 책을 추가한다.
-   기존 책을 업데이트한다.
-   책을 삭제한다.


```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book{
    private int id;
    private String title;
    private String author;
}

@RestController
@RequestMapping("/books")
public class BookController{
    private List<Book> books = new ArrayList<Book>();

    // 모든 책을 가져오기
   @GetMapping("/")
   public List<Book> getAllBooks(){
           return books;
   }

   // ID로 특정 책을 가져오기
   @GetMapping("/{id}")
   public Book getBookById(@PathVariable int id){
           return books.stream()
        .filter(book -> book.getId() == id)
        .findFirst()
        .orElseThrow(()->new RuntimeException("Book not found with ID: " + id));
   }

   // 새 책을 추가하기
   @PostMapping("/")
   public Book addBook(@RequestBody Book book){
           books.add(book);
        return book;
   }


   // 기존 책을 업데이트하기
   @PutMapping("/{id}")
   public Book updateBook(@PathVariable int id,
   @RequestBody Book updatedBook){
           Book bookToUpdate = books.stream()
        .filter(book -> book.getId() == id)
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));  
   }

   // 책을 삭제하기
   @DeleteMapping("/{id}")
   public void deleteBook(@PathVariable int id){
           books.removeIf(book -> book.getId() == id);
   }
}
```
# `ControllerAdvice`
Spring 안에서 발생하는 에러를 모아 처리해줌

# `ExceptionHandler`
어떤 Exception에 대한 에러를 컨트롤할 것인지 판단해줌 
- 여러개 사용 가능 :: {}

```java
@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public String runtimExceptionResolve(Exception e) {
        return e.getMessage();
    }
}

```
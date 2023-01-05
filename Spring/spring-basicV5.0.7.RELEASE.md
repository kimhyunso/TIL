# lombok

# Maven, Gradle
형상관리자

# `@Controller`
Model과 View를 이어주는 매개체

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

# `@RequestMapping("/api/main")`


# `@RestContoller`
```java

@RestController
@RequestMapping("/hello/")
public void testRestContoller(){
    public ResponseEntity<?,?> home(){
        return "jsp";
    }
}
```

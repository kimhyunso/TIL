# JSP 란?
Java 언어로 이루어진 서버 페이지를 의미한다.

# MVC 패턴

> Model : 실제 데이터
> 
> View : 사용자에게 보여주는 공간
> 
> Controller : 데이터와 UI(UserInterface) 사이에 있는 중간 매개체

# 영역 or 페이지의 가동 범위
> **application > session > request > page**

1. application
   * 서버를 닫지 않는 한 계속 지속 
2. session
   * 서버측에서 관리되는 연결단위 : 일정시간이 지나면 소멸함
3. request
   * 페이지(브라우저)를 닫으면 소멸
4. page
   * 페이지가 이동하면 소멸

* **cokie** : 클라이언트 측에 저장되는 파일 : 일정시간이 지나면 소멸함

# JSP 지시자
* JSP 페이지의 전체적인 속성을 지정할 때 사용함
1. page
2. include
3. taglib

> `page` : 해당 페이지의 전체적인 속성 지정

> `include` : 별도의 페이지를 현재 페이지에 삽입

> `taglib` : 태그라이브러리의 태그 사용

`<%@include file=".jsp">` : request, page 영역 공유

`<jsp:include page=".jsp"/>` : request 영역만 공유

`<jsp:forword page=".jsp"/>` : request 영역만 공유

```jsp
<jsp:inlcude page="">
​	<jsp:param name="test1" value="테스트1"/>
</jsp:include >

application.getAttribute("my_values");
request.getRequestDispatcher(".jsp").forward(request, response);
pageContext.forward(".jsp");
```

## application
`application.getAttribute(name);` : 어플리케이션에 저장되어 있는 값 꺼내옴

`application.setAttribute(name, value);` : 어플리케이션에 값을 저장

## session
`session.getAttribute(name);` : 세션 값 가져오기

`session.setAttribute(name, value);` : 세션 값 추가하기 **`Object` 타입으로 리턴**

## request
- 웹브라우저를 통해 서버에 어떤 정보를 요청하는것
- 클라이언트에서 넘어오는 데이터를 서버 측에서 받아오는 객체
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 객체</title>
</head>
<body>
클라이언트 IP = <%= request.getRemoteAddr() %> <br>
서버포트 = <%= request.getServerPort() %> <br>
컨텍스트 경로 = <%= request.getContextPath() %> <br>
요청 URI = <%= request.getRequestURI() %> <br>
요청 HTTP 메서드 = <%= request.getMethod() %> <br>
HTTP 요청 정보 길이 = <%= request.getContentLength() %> <br>
요청정보 인코딩 = <%= request.getCharacterEncoding() %> <br>
요청정보 콘텐츠타입 = <%= request.getContentType() %> <br>
요청정보 프로토콜 = <%= request.getProtocol() %> <br>
서버이름 = <%= request.getServerName() %> <br>
</body>
</html>
```

## response
- 웹브라우저의 요청에 응답하는것
- 응답의 정보를 가지고 있는객체를 response객체라고 말함
- 서버측에서 클라이언트측으로 데이터를 전달하기 위한 객체



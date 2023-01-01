# SQL 인젝션 방지
**PrepearStatement 사용할 것!**

```java
try{
    String tableName = props.getProperty("jdbc.tableName");
    String name = props.getProperty("jdbc.name");
    String query = "SELECT * FROM" + tableName + "WHERE Name = " + name;
    stmt = con.prepareStatement(query);
    rs = stmt.executeQuery();
}catch(Exception e){}

try{
    String tableName = props.getProperty("jdbc.tableName");
    String name = props.getProperty("jdbc.name");
    String query = "SELECT * FROM ? WHERE Name = ?";
    stmt = con.prepareStatement(query);
    stmt.setString(1, tableName);
    stmt.setString(2, name);
    rs = stmt.executeQuery();
}catch(Exception e){}
```

# XSS방지
**특수문자 방지할 것!**

~~~javascript
<%
    String name = request.getParameter("name");
    if(name != null){
       name = name.replaceAll("<", "&lt;");
       name = name.replaceAll(">", "&gt;");
       name = name.replaceAll("&", "&amp;");
       name = name.replaceAll("\", "&quot;");
    }
%>
~~~

# 악성 파일 업로드 공격 방지
**exe 파일을 방지할 것!**
~~~java
public void upload(HttpServletRequest request) throws ServeletException{
    MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
    String next = (String) mRequest.getFileName().next();
    MultipartFile file = mRequst.getFile(next);
    if(file == null) return;
    if(fileName != null){
        if(fileName.endsWith(".doc") || fileName.endsWith(".hwp")
          || fileName.endsWith(".pdf") || fileName.endsWith(".xls")){
            //file 업로드
        }else{
            throw new ServeltException("에러");
        }
    }
}
~~~


# String 메소드

# 문자 추출(charAt())
> 한문자(Character)를 추출함
```java
String phoneNum = "01012345678";
for (int i=0; i<phoneNum.length; i++)
    System.out.println(phoneNum.charAt(i));
```

# 문자열 비교(equals())
- `new String`으로 객체를 생성 시, Heap에 객체를 생성하게됨
- ""(쌍따옴표)로 초기화 시, **String poll**에 이순신이라는 문자열 하나만 있으며, strVar2와 strVar3는 그것을 참조한다.

```java
String strVar1 = new String("이순신");
String strVar2 = "이순신";
String strVar3 = "이순신";

if(strVar1 == strVar2)
    System.out.println("같은 주소값을 참조");

if(strVar1 == strVar3)
    System.out.println("같은 주소값을 참조");

if(strVar1.equals(strVar2))
    System.out.println("같은 내용물[값(문자열)] 가짐");
```

### 바이트 배열로 변환(getBytes())
네트워크 문자열을 전송하거나 문자열을 암호화할 때 문자열을 바이트 배열로 변환한다.

~~~java
public class StringGetBytesClass{
    public static void main(String[] args){
        String str = "안녕하세요";
        
        byte[] bytes1 = str.getBytes();
        System.out.println("bytes1.length: "+bytes1.length);
        String str1 = new String(bytes1);
        System.out.println("bytes1->String: "+str1);
        
        try{
            byte[] bytes2 = str.getBytes("EUC-KR");
            System.out.println("bytes2.length: "+bytes2.length);
            String str2 = new String(bytes2, "EUC-KR");
            System.out.println("bytes2->String: "+str2);
            
            byte[] bytes2 = str.getBytes("UTF-8");
            System.out.println("bytes2.length: "+bytes2.length);
            String str2 = new String(bytes2, "UTF-8");
            System.out.println("bytes2->String: "+str2);
        }catch(UnsupportedException e){
            e.printStackTrace();
        }
    }
}
~~~

### 문자열 찾기(indexOf())
문자열이 시작되는 인덱스를 리턴한다.

​문자열이 포함되어 있지 않다면 -1을 리턴함
~~~java
public class StringIndexOfClass{
    public static void main(String[] args){
        String subject = "자바 프로그래밍";
        
        int location = subject.indexOf("프로그래밍");
        System.out.println(location);
        
        if(subject.indexOf("자바") != -1)
            System.out.println("자바와 관련된 책이군요.");
        else
            System.out.println("자바와 관련없는 책이군요.");
    }
}
~~~

### 문자열 길이(length())
문자열의 길이를 리턴한다.

~~~java
public class StringLengthClass{
    public static void main(String[] args){
        String ssn = "7306241230123";
        int length = ssn.length();
        if(length == 13)
            System.out.println("주민번호 자리수가 맞습니다.");
        else
 			System.out.println("주민번호 자리수가 틀립니다.");           
    }
}
~~~

### 문자열 잘라내기(substring())
~~~java
public class StringSubstingClass{
    public static void main(String[] args){
        String ssn = "880815-1234567";
		//0부터 6번째까지 잘라냄        
        String firstNum = ssn.substring(0,6);
        System.out.pritln(firstNum);
        //7부터 끝까지 잘라냄
        String secondNum = ssn.substring(7);
        System.out.println(secondNum);
    }
}
~~~

### 알파벳 소·대문자 변경(toLowerCase(), toUpperCase())
~~~java
public class StringToLowerCaseUpperCaseClass{
    public static void main(String[] args){
        String str1 = "Java Programming";
        String str2 = "JAVA Programming";
        
        System.out.println(str1.equals(str2));
        
        String lowerStr1 = str1.toLowerCase();
        String lowerStr2 = str2.toLowerCase();
        System.out.println(lowerStr1.equals(lowerStr2));
 		//대소문자 신경안쓰고 비교       
        System.out.println(str1.equalsIgnoreCase(str2));
    }
}
~~~

### 문자열 앞뒤 공백 잘라내기(trim())
~~~java
public class TrimClass{
    public static void main(String[] args){
        String tel1 = " 02";
        String tel2 = "123 ";
        String tel3 = "  1234  ";
        
        String tel = tel1.trim() + tel2.trim() + tel3.trim();
        System.out.println(tel);
    }
}
~~~

### 문자열 변환(valueOf())
기본 타입을 문자열로 변환한다.

~~~java
public class ValueOfClass{
    public static void main(String[] args){
        String str1 = String.valueOf(10);
        String str2 = String.valueOf(10.5);
        String str3 = String.valueOf(true);
        
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
~~~

### split() 메소드
split() 매소드는 정규표현식을 구분자로 해서 문자열을 분리 후, 문자열 배열로 리턴한다.

~~~java
public class StringSplitClass{
    public static void main(String[] args){
        String text = "홍길동&이수홍,박연수,김자바-김영호";
        
        String[] names = text.split("&|,|-");
        
        for(String name : names)
            System.out.println(name);
    }
}
~~~

# StringTokenizer 클래스
문자열이 특정 구분자로 연결되어있을 경우, 구분자를 제거하고 문자열을 리턴한다.
~~~~java
public class StringTokenizerClass{
    public static void main(String[] args){
        String text = "홍길동/이수홍/박연수";
        
        StringTokenizer st = new StringTokenizer(text, "/");
        int countTokens = st.countTokens();
        for(int i=0; i<countTokens; i++){
            String token = st.nextTokens();
            System.out.println(token);
        }
        
        System.out.println();
        
        st = new StringTokenizer(text,"/");
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            System.out.println(token);
        }
    }
}
~~~~
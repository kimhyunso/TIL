# String 메소드

# 문자 추출(`charAt(index)`)
- @param index : 추출할 인덱스값 - 필수값
> 한문자(Character)를 추출함
```java
String phoneNum = "01012345678";
for (int i=0; i<phoneNum.length; i++)
    System.out.println(phoneNum.charAt(i));
```

# 문자열 비교(`equals(value)`)
- @param value : 비교할 문자열 - 필수값
- `new String`으로 객체를 생성 시, Heap에 객체를 생성하게됨
- ""(쌍따옴표)로 초기화 시, **String poll**에 이순신이라는 문자열 하나만 있으며, strVar2와 strVar3는 그것을 참조한다.

```java
String strVar1 = new String("이순신");
String strVar2 = "이순신";
String strVar3 = "이순신";

if(strVar1 == strVar2)
    System.out.println("같은 곳을 참조");

if(strVar1 == strVar3)
    System.out.println("같은 곳을 참조");

if(strVar1.equals(strVar2))
    System.out.println("같은 내용물[값(문자열)] 가짐");
```


# 문자열 찾기(`indexOf(searchValue, position)`) - 정방향
- @param searchValue : 찾고자하는 문자열 - 필수값
- @param position : searchValue를 찾기 시작할 위치 - 선택
> 문자열이 시작되는 인덱스를 리턴한다.
> 
> 문자열이 포함되어 있지 않다면 -1을 리턴함

```java
String subject = "자바 프로그래밍";
// 3
int index = subject.indexOf("프로그래밍");
System.out.println(index);

if(subject.indexOf("자바") != -1)
    System.out.println("자바와 관련된 책이군요.");
else
    System.out.println("자바와 관련없는 책이군요.");
```

# 문자열 찾기(`lastIndexOf(searchValue, position)`) - 반대방향
- @param searchValue : 찾고자하는 문자열 - 필수값
- @param position : searchValue를 찾기 시작할 위치 - 선택
> 마지막부터 순차적으로 찾은 인덱스를 리턴한다.
>
> 문자열이 포함되어 있지 않다면 -1을 리턴

```java
String subject = "자바 프로그래밍";

// 3
int index = subject.lastIndexOf("프로그래밍");
System.out.println(index);

if(subject.lastIndexOf("자바") != -1)
    System.out.println("자바와 관련된 책이군요.");
else
    System.out.println("자바와 관련없는 책이군요.");
```

# 문자열 길이(`length()`)
- 문자열의 길이를 리턴한다.

```java
String ssn = "7306241230123";
int length = ssn.length();
System.out.println(length);
if(length == 13)
    System.out.println("주민번호 자리수가 맞습니다.");
else
    System.out.println("주민번호 자리수가 틀립니다.");           
```

# 문자열 잘라내기(`substring(beginIndex, endIndex)`)
- @param beginIndex : 자를 위치를 정하는 인덱스 - 필수
- @param endIndex : beginIndex부터 endIndex까지 자를 위치 - 선택

```java
String ssn = "880815-1234567";
//0부터 6번째까지 잘라냄        
String zeroToSix = ssn.substring(0,6);
System.out.pritln(zeroToSix);
//7부터 끝까지 잘라냄
String seven = ssn.substring(7);
System.out.println(seven);
```

# 알파벳 소·대문자 변경(`toLowerCase()`, `toUpperCase()`)
- String은 immutable 객체이기 때문에 `toLowerCase()`, `toUpperCase()`는 할당을 해야만한다.

```java
String str1 = "Java Programming";
String str2 = "JAVA Programming";

str1.toLowerCase();
str2.toUpperCase();
// 변경되어있지 않음
System.out.println(str1);
System.out.println(str2);

String lowerStr = str1.toLowerCase();
String upperStr = str2.toUpperCase();

System.out.println(lowerStr1);
System.out.println(upperStr);

//대소문자 신경안쓰고 비교       
System.out.println(str1.equalsIgnoreCase(str2));
```

# 문자열 앞뒤 공백 잘라내기(`trim()`)
```java
String tel1 = " 02";
String tel2 = "123 ";
String tel3 = "  1234  ";

String tel = tel1.trim() + tel2.trim() + tel3.trim();
System.out.println(tel);
```

# 문자열 변환(`valueOf()`)
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

# 문자열 지정된 문자로 자르기 (`split(value)`)
- @param value : 자르는 기준이되는 문자열 - 선택

> split() 매소드는 지정한 문자를 기반으로 문자열을 잘라 배열로 리턴한다.

```java
// 정규표현식 사용
String text = "홍길동&이수홍,박연수,김자바-김영호";
String[] names = text.split("&|,|-");
for(String name : names)
    System.out.println(name);

String text = "홍길동&박연수&김영호";
String[] names = text.split("&");
for(String name : names)
    System.out.println(name);

```

# StringTokenizer 클래스
문자열이 특정 구분자로 연결되어있을 경우, 구분자를 제거하고 문자열을 리턴한다.

```java

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
```
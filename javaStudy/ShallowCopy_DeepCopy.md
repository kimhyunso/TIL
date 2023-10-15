# 객체 해시코드(hashcode)

- 객체의 동등 비교를 위해서는 `equals()`만 재정의하지 말고 `hashCode()`도 재정의해서 논리적 동등 객체일 경우 동일한 해시코드가 리턴되도록해야한다. 
- ​객체를 식별하는 하나의 정수값이다.

![hashcodeImage](https://github.com/kimhyunso/TIL/blob/master/java/images/hashcodeImage.png)

~~~java
public class Key{
    private int key;
   	public Key(int key){
        this.key = key;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Key){
            Key key = (Key)obj;
            if(this.key == key.getKey())
                return true;
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        return this.key;
    }
    
    public int getKey(){
        return key;
    }
}

public class HashMapClass{
    public static void main(String[] args){
 		HashMap<Key,String> map = new HashMap<Key,String>();       
    	map.put(new Key(1),"홍길동");
        
        String value = map.get(new Key(1));
        System.out.println(value);
    }
}
~~~


# 객체 문자 정보(toString())

- ​기본적으로 "클래스명@16진수해시코드"로 구성된 문자열을 리턴한다.

~~~java
public class SmartPhone{
    private String company;
    private String os;
    
    public SmartPhone(String company, String os){
        this.company = company;
        this.os = os;
    }
    
    @Override
    public String toString(){
        return company+", "+os;
    }
}

public class SmartPhoneEx{
    public static void main(String[] args){
        SmartPhone myPhone = new SmartPhone("구글","안드로이드");
        String str = myPhone.toString();
        System.out.println(str);
    }
}
~~~

# 객체 복제(clone)
1. 얕은 복제
2. 깊은 복제


## 얕은 복제(thin clone)

실제 값을 복사하는 것

~~~java
public class Member{
    private String id;
    private String name;
    private String password;
    private int age;
    private int[] scores;

    public Member(String id, String name, String password, int age, int[] scores){
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.scores = scores;
    }

    @Override
    public String toString(){
        return "Member{"
                +"ID: "+this.id
                +" name: "+this.name
                +" password: "+this.password
                +" age: "+this.age
                +" scores"+ Arrays.toString(scores)
                +"}";

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }
}

public class MainClass{
    public static void main(String[] args){
        Member member = new Member("1","홍길동","blue",30,new int[]{30,40,50});
        Member clonedMember = member;
        clonedMember.setName("김자바");
        clonedMember.setAge(50);

        if(clonedMember.equals(member)){
            System.out.println("두 객체는 같은 주소를 가르킨다.");
        }

        //cloneMember만 변경했는데 같이 변경됨
        System.out.println(member);
        System.out.println(clonedMember);
    }
}
~~~

# 깊은 복제(deep clone)

메모리 주소값을 복사한다.

​복사되는 객체는 Cloneable 인터페이스를 구현 받아야한다.

~~~java
public class Member implements Cloneable{
    private String name;
    private int age;
    private int[] scores;
    private Car car;
    
    public Member(String name, int age, int[] scores, Car car){
        this.name = name;
        this.age = age;
        this.scores = scores;
        this.car = car;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return (Member) super.clone();
    }
    
    public Member getMember(){
        Member cloned = null;
        try{
            cloned = (Member) clone();
        }catch(CloneNotSupportedException e){}
        return cloned;
    }
    
    @Override
    public String toString(){
        return "Member{"
            +"name: "+this.name
            +" age: "+this.age
            +" scores: "+Arrays.toString(scores)
            +" car: "+car.getModel()
            +"}";
    }
    
    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
}

public class Car{
    private String model;

    public Car(String model){
        this.model = model;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }
}

public class MainClass{
    public static void main(String[] args){
        Member member = new Member("김자바",30,new int[]{30,50,100},new Car("그랜저"));
        Member clonedMember = member.getMember();
        clonedMember.setAge(50);
        clonedMember.setName("홍길동");

        if (member.equals(clonedMember)){
            System.out.println("두 객체는 다른 주소를 가르킨다.");
        }

        System.out.println(member);
        System.out.println(clonedMember);
    }
}

~~~

# 복사 생성자, 복사 팩터리 (갚은 복사)
```java

public class CopyObject {

    private String name;
    private int age;

    public CopyObject() {}


    /* 복사 생성자 */
    public CopyObject(CopyObject original) {
        this.name = original.name;
        this.age = original.age;
    }


    /* 복사 팩터리 */
    public static CopyObject copy(CopyObject original) {
        CopyObject copy = new CopyObject();
        copy.name = original.name;
        copy.age = original.age;
        return copy;
    }

    public CopyObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public Class Main{
    public static void main(String[] args){
        CopyObject original = new CopyObject("홍길동", 20);
        CopyObject copyConstructor = new CopyObject(original);
        CopyObject copyFactory = CopyObject.copy(original);

        copyConstructor.setName("김자바");
        copyFactory.setName("김개똥");

        System.out.println(original.getName());
        System.out.println(copyConstructor.getName());
        System.out.println(copyFactory.getName());
    }
}
```
# 객체 소멸자(finalize())[자바 11버전 사용X권장]

​자바는 참조하지 않는 메모리는 쓰레기 수집기가 자동적으로 소멸시킨다.

​소멸 시키기 전에 finalize() 메소드를 실행시킨다.

~~~java
public class Counter{
    private int no;
    public Counter(int no){
        this.no = no;
    }
    
    @Override
    protected void finalize() throws Throwable{
        System.out.println(no+"번 객체 소멸");
    }
}

public class FinalizeClass{
    public static void main(String[] args){
        Counter counter = null;
        for(int i=1; i<=50; i++){
            counter = new Counter(i);
            
            counter = null;
            //쓰레기 수집기 실행 요청
            System.gc();
        }
    }
}
~~~

# Objects 클래스
객체비교, 해시코드 생성, null여부 체크 등을 하는 정적메소드를 가지고 있다.

## 객체비교(compare(T a, T b, Comparetor&lt;T&gt;c))
두 객체를 비교해서 int값으로 리턴한다.

~~~java
public class Student{
    private int sno;
    public Student(int sno){
        this.sno = sno;
    }
    
    public int getSno(){
        return sno;
    }
    
    public void setSno(int sno){
        this.sno = sno;
    }
}

public class StudentComparetor implements Comparetor<Student>{
    @Override
    public int compare(Student a, Student b){
        if(a.getSno() < b.getSno()) return -1;
        else if(a.getSno() == b.getSno()) return 0;
        else return 1;
    }
}

public class CompareClass{
    public static void main(String[] args){
        Student s1 = new Student(1);
        Student s2 = new Student(1);
        Student s3 = new Student(2);
        
        int result1 = Objects.compare(s1,s2, new StudentComparetor());
        int result2 = Objects.compare(s2,s3, new StudentComparetor());
        
    }
}

~~~

## 동등비교(Objects.equals() or Objects.deepEquals())
두 객체를 동등비교한다.

~~~java
public class ObjectsClass{
    public static void main(String[] args){
        Integer o1 = 1000;
        Integer o2 = 1000;
        //true
        //값과 주소값 비교
        System.out.println(o1.equals(o2));

        //두 객체의 주소가 달라도 참조값은 같은지 비교
        System.out.println(Objects.equals(o1,o2));	//true 
        System.out.println(Objects.equals(o1,null)); //false
        System.out.println(Objects.equals(null,o2)); //false
        System.out.println(Objects.equals(null,null)); //true
        //두 객체의 주소는 달라도 값은 같은지 비교
        System.out.println(Objects.deepEquals(o1,o2)); //true
		
        Integer[] arr1 = {1,2};
        Integer[] arr2 = {1,2};
        System.out.println(Objects.equals(arr1,arr2)); //false
        System.out.println(Objects.deepEquals(arr1,arr2)); //true
        System.out.println(Arrays.deepEquals(arr1,arr2)); //true
        System.out.println(Objects.deepEquals(null,arr2)); //false
        System.out.println(Arrays.deepEquals(arr1,null)); //false
        System.out.println(Arrays.deepEquals(null,null)); //true
    }
}
~~~

## 해시코드 생성(hash(), hashCode())
~~~java
public class Student{
    private int sno;
    private String name;
    public Student(int sno, String name){
        this.sno = sno;
        this.name = name;
    }
    @Override
    public int hashCode(){
        return Objects.hash(sno,name);
    }
}
public class HashCodeClass{
    public static void main(String[] args){
        Student s1 = new Student(1,"홍길동");
        Student s1 = new Student(1,"홍길동");
        //같은 해쉬코드
        System.out.println(s1.hashCode());	
        System.out.println(Objects.hash(s2));
    }
}
~~~

## 널 여부조사(isNull(), nonNull(), requireNonNull())
~~~java
public class NullClass{
    public static void main(String[] args){
        String str1 = "홍길동";
        String str2 = null;
        
        System.out.println(Objects.requireNonNull(str1));
        
        try{
            String name = Objects.requireNonNull(str2);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try{
            String name = Objects.requireNonNull(str2,"이름이 없습니다.");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
         try{
            String name = Objects.requireNonNull(str2,()->"이름이 없어요.");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
~~~

## 객체 문자 정보(toString())
~~~java
public class ToStringClass{
    public static void main(String[] args){
        String str1 = "홍길동";
        String str2 = null;
        
        System.out.println(Objects.toString(str1));
        System.out.println(Objects.toString(str2));
        System.out.println(Objects.toString(str2,"이름이 없습니다."));
    }
}
~~~

# System 클래스
System 클래스를 이용하면 운영체제의 일부 기능을 이용할 수 있다.

## 프로그램 종료(exit())
- 강제적으로 JVM을 종료시킬 때 사용한다.
- 정상 종료 : 0
- 비정상 종료 : 0 이외의 값

~~~java
public class ExitClass{
    public static void main(String[] args){
        //보안 관리자 설정
        System.setSecurityManger(new SecurityManger(){
           @Override
            public void checkExit(int status){
                if(status != 5)
                    throw new SecurityException();
            }
        });
        
        for(int i=0; i<10; i++){
            System.out.println(i);
            try{
                System.exit(i);
            }catch(SecurityException e){
                
            }
        }
    }
}
~~~

## 쓰레기 수집기 실행(gc())

메모리는 JVM이 알아서 자동으로 관리한다.

​JVM은 메모리가 부족시, CPU 유휴시간을 이용해 쓰레기 수집가(Garbage Collector)를 실행시켜 사용하지 않는 객체를 자동으로 제거한다.

​System.gc() 메소드를 사용하면 쓰레기를 가능한 빨리 수집해달라고 요청한다.

~~~java
public class Employee{
    private int eno;
    public Employee(int eno){
        this.eno = eno;
        System.out.println("Employee("+eno+") 가 메모리에서 생성됨");
    }
    @Override
   	public void finalize(){
        System.out.println("Employee("+eno+") 이 메모리에서 재거됨");
    }
    public int getEno(){
        return eno;
    }
}
public class GcClass{
    public static void main(String[] args){
        Employee emp;
        emp = new Employee(1);
        emp = null;
        emp = new Employee(2);
        emp = new Employee(3);
        System.out.println("emp가 최종적으로 참조하는 시원번호: ");
        System.out.println(emp.getEno());
        System.gc();
    }
}
~~~

## 현재 시각 읽기(currentTimeMillis(), nanoTime())

~~~java
public class SystemTimeClass{
    public static void main(String[] args){
        long time1 = System.nanoTime();
        
        int sum = 0;
        for(int i=1; i<=100000; i++)
            sum += i;
        
        long time2 = System.nanoTime();
        
        System.out.println("1~100000까지의 합: "+sum);
        System.out.println("계산에 "+(time2-time1)+" 나노초가 소요되었습니다.");
    }
}
~~~

## 현재 프로퍼티 읽기(getProperty())
시스템의 속성값을 알 수 있다.

~~~java
public class GetPropertyClass{
    public static void main(String[] args){
        String osName = System.getProperty("os.name");
        String userName = System.getProperty("user.name");
        String userHome = System.getProperty("user.home");
        
        System.out.println("운영체제 이름: "+osName);
        System.out.println("사용자 이름: "+userName);
        System.out.println("사용자 홈디렉토리: "+userHome);
        
        System.out.println("--------------------------");
        System.out.println(" [ key ]  value");
        System.out.println("--------------------------");
        
        Properties props = System.getProperties();
        Set keys = props.keySet();
        for(Object objKey : keys){
            String key = (String) objKey;
            String value = System.getProperty(key);
            System.out.println(" [ key ]  "+value);
        }
    }
}
~~~

## 환경 변수 읽기(getenv())
~~~java
public class SystemClass{
    public static void main(String[] args){
        String javaHome = System.getenv("JAVA_HOME");
        System.out.println("JAVA_HOME: "+javaHome);
    }
}
~~~

# Class 클래스

​메타데이터 정보를 가지고 있다.

​메타데이터란 클래스의 이름, 생성자정보, 필드 정보, 메소드 정보이다.

~~~~java
public class Car(){
    String name;
    public Car(){}
    public void method(){}
}

public class ClassEx{
    public static void main(String[] args){
        Car car = new Car();
        Class clazz1 = car.getClass();
        System.out.println(clazz1.getName());
        System.out.println(clazz1.getSimpleName());
        System.out.println(clazz1.getPackage().getName());
        System.out.println();
        
        try{
            Class clazz2 = Class.forName("Car");
            System.out.println(clazz2.getName());
       	 	System.out.println(clazz2.getSimpleName());
        	System.out.println(clazz2.getPackage().getName());
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
~~~~

# 리플렉션
​필드 배열, 메소드 배열, 생성자 배열을 리턴한다.

~~~java
public class Car(){
    String name;
    public Car(){}
    public void method(){}
}
public class RelectionClass{
    public static void main(String[] args){
        Class clazz = Class.forName("Car");
        
        System.out.println("[클래스 이름]");
        System.out.println(clazz.getName());
        System.out.println();
        
        System.out.println("[생성자 정보]");
        Constructor[] constructors = clazz.getDeclearedConstructor();
        for(Constructor cons : constructors){
            System.out.print(cons.getName()+"(");
            Class[] parameters = cons.getParameterTypes();
            printParameters(parameters);
            System.out.println(")");
        }
        System.out.println();
        
        System.out.println("[필드 정보]");
        Field[] fields = clazz.getDeclearedFiedls();
        for(Field field : fields){
            System.out.println(field.getType().getSimpleName()+" "+field.getName());
        }
       	System.out.println();
        
        System.out.println("[메소드 정보]");
        Method[] methods = clazz.getDeclearedMethods();
        for(Method method : methods){
            System.out.print(method.getName() +"(");
            Class[] parameters = method.getParameterTypes();
            printParameters(parameters);
            System.out.println(")");
        }
    }
    
    private static void printParameters(Class[] parameters){
        for(int i=0; i<parameters.length; i++){
            System.out.print(parameters[i].getName());
            if(i<parameters.lenth-1)
                System.out.print(",");
        }
    }
}
~~~

# 동적 객체 생성(newInstance())

​new 연산자를 사용하지 않고 동적으로 객체를 생성할 수 있다.

​반드시 클래스에 기본 생성자가 존재해야 한다.

​자바 8버전만 사용하는 듯 [자바 11버전부턴 사용 비권장]

~~~java
public interface Action{
    public void execute();
}
public class SendAction implements Action{
    @Override
    public void execute(){
        System.out.println("데이터를 보냅니다.");
    }
}
public class ReceiveAction implements Action{
    @Override
    public void execute(){
        System.out.println("데이터를 받습니다.");
    }
}
public class NewInstanceClass{
    public static void main(String[] args){
        try{
            Class clazz = Class.forName("Action");
            Action action = (Action) clazz.newInstance();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(InstantiationException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
~~~

# String 클래스

​문자열을 생성하는 방법과 추출, 비교, 찾기, 분리, 변환 등 처리한다.

## String 생성자
파일의 내용을 읽거나, 네트워크를 통해 받은 데이터는 byte[]배열 이므로 이것을 문자열로 변환하기 위해 사용된다.

~~~java
public class StringClass{
	public static void main(String[] args){
        byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
        
        //byte배열 전체를 String 객체로 생성
        String str1 = new String(bytes);
       	//지정한 문자셋으로 디코딩
        String str2 = new String(bytes, "UTF-8");
		
        //배열의 offset인덱스 위치부터 length까지 String 객체로 생성
        String str3 = new String(bytes,6,4);	//74의 위치부터 4개만
        //지정한 문자셋으로 디코딩
        String str4 = new String(bytes,6,4,"UTF-8");
    }
}

public class KeyboardToStringClass{
    public static void main(String[] args){
        byte[] bytes = new byte[100];
        
        System.out.print("입력: ");
        int readByteNo = System.in.read(bytes);
        
        String str = new String(bytes,0,readByteNo-1);
        System.out.println(str);
    }
}
~~~

## String 메소드

### 문자 추출(charAt())

~~~java
public class StringCharAtClass{
    public static void main(String[] args){
        String ssn = "010624-1230123";
        char gender = ssn.charAt(7);	//0부터 시작해서 7번째 문자 추출함
    	switch(gender){
            case 1:
            case 3:
                System.out.println("남자입니다.");
            	break;
            case 2:
            case 4:
                System.out.println("여자입니다.");
				break;
        }
    }
} 
~~~

### 문자열 비교(equals())

~~~java
public class StringEqualsClass{
    public static void main(String[] args){
        String strVar1 = new String("신민철");
        String strVar2 = "신민철";
        
        if(strVar1 == strVar2)
            System.out.println("같은 String 객체를 참조");
        else
            System.out.println("다른 String 객체를 참조");
        
        if(strVar1.equals(strVar2))
            System.out.println("같은 문자열을 가짐");
        else
            System.out.println("다른 문자열을 가짐");
    }
}
~~~

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


 # 정규 표현식과 Pattern 클래스

문자열 형식을 검증하는 것이다.

## 정규 표현식 작성 방법
|기호|설명|예시|
|-|-|-|
|`[]`|한 개의 문자 검증|`[abc]` : a, b, c 중 한 개 문자<br>`[^abc]` : a, b, c를 제외한 한 개 문자<br>`[a-zA-Z]` : a~z, A~Z 중 한 개 문자|
|`\d`|한개의 숫자||
|`\s`|공백||
|`\w`|한 개의 알파벳 또는 한 개의 숫자, `[a-zA-Z_0-9]`와 동일||
|`?`|없음 또는 한 개||
|`*`|없음 또는 한 개 이상||
|`+`|한 개 이상||
|`{n}`|정확히 n개||
|`{n,}`|최소한 n개||
|`{n, m}`|n개에서부터 m개까지||
|`()`|그룹핑||

# Pattern 클래스
- Pattern.matches("정규식", "검증할 문자열");

~~~java
public class PatternClass{
    public static void main(String[] args){
        String regExp = "(02|010)-\\d{3,4}-\\d{4}";
        String data = "010-123-4567";
        boolean result = Pattern.matches(regExp,data);
        if(result)
            System.out.println("정규식과 일치합니다.");
        else
            System.out.println("정규식과 일치하지 않습니다.");
        
        regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
        data = "angel@navercom";
        result = Pattern.matches(regExp, data);
        if(result)
            System.out.println("정규식과 일치합니다.");
		else
            System.out.println("정규식과 일치하지 않습니다.");
    }
}
~~~

# Arrays 클래스
- Arrays 클래스는 배열 조작기능을 가지고 있다.
- 배열 조작 = 배열의 복사, 항목 정렬, 항목 검색과 같은 기능

## 배열 복사

~~~java
public class ArrayCopyClass{
    public static void main(String[] args){
        char[] arr1 = {'J','A','V','A'};
        
        //방법 1
        char[] arr2 = Arrays.copyOf(arr1,arr1.length);
        System.out.println(Arrays.toString(arr2));
        
        //방법 2
        //arr1[1] ~ arr1[2]를 arr3[0] ~ arr3[1]로 복사
        char[] arr3 = Arrays.copyOfRange(arr1,1,3);
        System.out.println(Arrays.toString(arr3));
        
        
        //방법 3
        char[] arr4 = new char[arr1.length];
        System.arraycopy(arr1,0,arr4,0,arr1.length);
        for(int i=0; i<arr4.length; i++)
            System.out.println("arr4["+i+"]="+arr4);
    }
}
~~~

## 배열 항목 비교
~~~java
int[][] original = {
    {1,2},
    {3,4}
};

//얕은 복사 후 비교
System.out.println("[얕은 복사 후 비교]");
int[][] arryInt1 = Arrays.copyOf(original,original.length);
System.out.println("배열 번지 비교: " + original.equals(arryInt1));
System.out.println("1차 배열 항목값 비교: " + Arrays.equals(original,arrayInt1));
System.out.println("중첩 배열 항목값 비교: " + Arrays.deepEquals(original,arrayInt1));

//깊은 복사 후 비교
System.out.println("[깊은 복사 후 비교]");
int[][] arryInt2 = Arrays.copyOf(original,original.length);
arryInt2[0] = Arrays.copyOf(original[0], original[0].length);
arryInt2[1] = Arrays.copyOf(original[1], original[1].length);
System.out.println("배열 번지 비교: " + original.equals(arryInt2));
System.out.println("1차 배열 항목값 비교: " + Arrays.equals(original,arrayInt2));
System.out.println("중첩 배열 항목값 비교: " + Arrays.deepEquals(original,arrayInt2));
~~~


## 배열 항목 검색
배열에서 특정 값이 위치한 인덱스를 얻는 것을 배열 검색이라고 한다.

​`binarySearch()`는 배열이 정렬 되어 있어야 검색이 가능하다.

~~~java
public class Member implements Comparable<Member>{
    private String name;
    public Member(String name){
        this.name = name;
    }
    @Override
    public int compareTo(Member o){
        return name.compareTo(o.name);
    }
    public String getName(){
        return name;
    }
}

public class SearchClass{
    public static void main(String[] args){
        int[] scores = {99,97,98};
        Arrays.sort(scores);
        int index = Arrays.binarySearch(scores, 99);
        System.out.println("찾은 인덱스: "+index);
        
        String[] names = {"홍길동","박동수","김자바"};
        Arrays.sort(names);
        index = Arrays.binarySearch(names, "홍길동");
        System.out.println("찾은 인덱스: "+index);
        
        Member m1 = new Member("홍길동");
        Member m2 = new Member("박동수");
        Member m3 = new Member("김자바");
        Member[] members = {m1,m2,m3};
        Arrays.sort(members);
        index = Arrays.binarySearch(members, m1);
        System.out.println("찾은 인덱스: "+index);
    }
}
~~~

# Wrapper(포장) 클래스
- 포장 객체의 특징은 기본 타입의 값을 내부에 두고 포장한다. 외부에서 변경할 수 없다.
- java.lang 패키지에 포함되어 있다.


|기본 타입|포장 클래스|
|`byte`|`Byte`|
|`char`|`Character`|
|`short`|`Short`|
|`int`|`Integer`|
|`long`|`Long`|
|`float`|`Float`|
|`double`|`Double`|
|`boolean`|`Boolean`|

# 박싱(Boxing)과 언박싱(Unboxing)
- 기본타입의 값을 포장 객체로 만드는 것을 박싱이라고 한다.
- 포장객체에서 기본 타입의 값을 얻어내는 과정을 언박싱이라고 한다.

~~~java
public class BoxingUnBoxingClass{
    public static void main(String[] args){
        //Boxing
        Integer obj1 = new Integer(100);
        Integer obj2 = new Integer("200");
        Integer obj3 = new Integer.valueOf("300");
        
        //Unboxing
        int value1 = obj1.intValue();
        int value2 = obj2.intValue();
        int value3 = obj3.intValue();
        
        System.out.println(value1);
        System.out.println(value2);
    	System.out.println(value3);
    }
}
~~~

## 자동 박싱과 언박싱
- 자동 박싱 : 포장 클래스에 기본타입의 값이 대입될 경우
- 자동 언박싱 : 기본타입에 포장 클래스가 대입되는 경우
- 컬렉션 객체에 int 값을 저장하면 자동 박싱이 일어난다.

~~~java
List<Integer> list = new ArrayList<Integer>();
list.add(200); //자동 박싱
~~~

~~~java
public class AutoBoxingUnBoxingClass{
    //자동 Boxing
    Integer obj = 100;
    System.out.println("value: "+obj.intValue());
    
    //대입 시 자동 Unboxing
    int value = obj;
    System.out.println("value: "+value);
    
    //연산 시 자동 Unboxing
    int result = obj + 100;
    System.out.println("result: "+result);
}
~~~

## 문자열을 기본 타입 값으로 변환

~~~java
public class StringToPrimitiveValueClass{
    public static void main(String[] args){
        int value1 = Integer.parseInt("10");
        double value2 = Double.parseDouble("3.14");
        boolean value3 = Boolean.pareBoolean("true");

        System.out.println("value1: "+value1);
        System.out.println("value2: "+value2);
        System.out.println("value3: "+value3);
    }
}
~~~

## 포장 값 비교
- 포장 객체는 내부의 값을 비교하기 때문에 ==, != 연산자를 사용할 수 없다.
- equals() 메소드로 내부의 값을 비교하는 것이 좋다.

~~~java
public class ValueCompareClass{
    public static void main(String[] args){
        System.out.println("[-128~127 초과값일 경우]");
        Integer obj1 = 300;
        Integer obj2 = 300;
        System.out.println("==결과: "+(obj1 == obj2));
        System.out.println("언박싱후 ==결과: "+(obj1.intValue()==obj2.intValue()));
        System.out.println("equals() 결과: "+obj1.equals(obj2));
        
        System.out.println("[-128~127 범위값일 경우]");
        Integer obj3 = 10;
        Integer obj4 = 10;
        System.out.println("==결과: "+(obj3 == obj4));
        System.out.println("언박싱후 ==결과: "+(obj3.intValue()==obj4.intValue()));
        System.out.println("equals() 결과: "+obj3.equals(obj4));
    }
}
~~~







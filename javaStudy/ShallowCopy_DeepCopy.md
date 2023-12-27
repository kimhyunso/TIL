# 객체 해시코드(hashcode)

- 객체의 동등 비교를 위해서는 `equals()`만 재정의하지 말고 `hashCode()`도 재정의해서 논리적 동등 객체일 경우 동일한 해시코드가 리턴되도록해야한다. 
- ​객체를 식별하는 하나의 정수값이다.

![hashcodeImage](https://github.com/kimhyunso/TIL/blob/master/java/images/hashcodeImage.png)

```java
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

Key key1 = new Key(10);
Key key2 = new Key(10);

System.out.println(key1);
System.out.println(key2);

if (key1.equals(key2))
    System.out.println("두 객체는 동일한 객체입니다.");
else
    System.out.println("두 객체는 다른 객체입니다.");
```


# 객체 문자 정보(toString())

- ​기본적으로 "클래스명@16진수해시코드"로 구성된 문자열을 리턴한다.

~~~java
public class ClassName{
    private int key;

    public SmartPhone(int key){
        this.key = key;
    }
}

ClassName myClass = new ClassName(10);
// 둘이 같음
System.out.println(myClass);
System.out.println(myClass.toString());
~~~

# 객체 복제(clone)
1. 얕은 복제
2. 깊은 복제


## 얕은 복제(thin clone)

실제 값을 복사하는 것

~~~java
public class Member{
    private int id;
    private String name;
    private int age;

    public Member(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {this.name = name;}
    public String getName(){return name;}
}

Member member = new Member(1, "홍길동", 23);
Member clonedMember = member;

if(clonedMember.equals(member)){
    System.out.println("두 객체는 같은 주소를 가르킨다.");
}

clonedMember.setName("김자바");

//cloneMember만 변경했는데 같이 변경됨
System.out.println(member.getName());
System.out.println(clonedMember.getName());
~~~

# 깊은 복제(deep clone)

메모리 주소값을 복사한다.

​복사되는 객체는 Cloneable 인터페이스를 구현 받아야한다.

~~~java
public class Member implements Cloneable{
    private int id;
    private String name;
    private int age;
    

    public Member(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    
    public Member getMember(){
        Member cloned = null;
        try{
            cloned = (Member) clone();
        }catch(CloneNotSupportedException e){}
        return cloned;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return (Member) super.clone();
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}

Member member = new Member(2, "김자바", 26);
Member clonedMember = member.getMember();

if (member.equals(clonedMember))
    System.out.println("두 객체는 다른 주소를 가르킨다.");

clonedMember.setName("홍길동");

System.out.println(member.getName());
System.out.println(clonedMember.getName());
~~~


# CallByReference, CallByValue

> CallByValue를 호출한 데이터의 값은 바뀌지 않는 방면, CallByReference를 호출한 데이터의 값은 바뀐다.

```java
public void callByValue(int value){
    value = 10;
}

int value = 20;
// 변경되지 않음
callByValue(value);

public void callByReference(int[] arr){
    arr[0] = 30;
}

int arr[] = {1};
callByReference(arr);
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

Counter counter = null;
for(int i=1; i<=50; i++){
    counter = new Counter(i);
    
    counter = null;
    //쓰레기 수집기 실행 요청
    System.gc();
}
~~~

# Objects 클래스
객체비교, 해시코드 생성, null여부 체크 등을 하는 정적메소드를 가지고 있다.

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







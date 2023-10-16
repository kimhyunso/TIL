# 객체 지향프로그램(OOP : Object Oriented Programming)

    부품에 해당하는 객체들을 먼저 만들고 이것들을 하나씩 조립하여 합쳐 완성시키는 것
    객체란 : 현실세계에 있는 대상을 컴퓨터로 옮기는 것
    속성(properties) = 명사
    메소드(Module) = 동사

사람
- [속성] 이름, 나이 //필드에 해당
- [동작] 웃다, 먹다 //메소드에 해당

자동차
- [속성] 색상, 속도 //필드에 해당
- [동작] 달린다, 멈춘다 //메소드에 해당


# 객체간의 상호작용

​객체 점(.) 연산자를 붙여 호출한다.
~~~java
public MainClass{
    public static void main(String[] args){
        int result = SumClass.sum(10,20);
    }
}
public SumClass{
    public static int sum(int x, int y){
        return x + y;
    }
}
~~~
## 객체간의 관계
완성품인 객체를 모델링하고 객체를 하나씩 설계한 후 조립하는 것

# 객체지향 프로그램의 특징
1. 캡슐화
   
    접근 제한자를 사용해 외부에서 데이터를 강제 수정 불가능하게 만듬
2. 상속 (다중상속x)

    부모 클래스가 가지고 있는 것을 자식클래스에게 물려줌
3. 다형성
   
    같은 타입이지만 실행 결과가 다양한 객체를 이용 가능

# 다형성
interface, abstract class 사용
~~~java
public interface Car{
    private void run();
    private void stop();
}
public class HyundaiCar implements Car{
    @Override
    public void run(){
        System.out.println("나는 현대차 달린다~");
    }
    @Override
    public void stop(){
        System.out.println("나는 현대차 멈춘다 ㅜ.ㅜ");
    }
}

public class KumhoCar implements Car{
    @Override
    public void run(){
        System.out.println("나는 금호차 달린다~");
    }
    @Override
    public void stop(){
        System.out.println("나는 금호차 멈춘다 ㅜ.ㅜ");
    }
}

Tire tire;
tire = new HyundaiTire();
tire.run();
tire.stop();
tire = new KumhoTire();
tire.run();
tire.stop();   
~~~

# 클래스의 구성 멤버

1. 필드 : 객체가 가지고 있는 정보들
2. 생성자 : 객체 생성 시, 초기화해주는 역활
3. 메소드 : 객체의 동작 [낙타 표기법(camelCase)로 표기함]

~~~java
public class ClassName{
    private int field1; //필드
    private static final int FIELD_2 = 100; //필드
    private String name; //필드
    
    public ClassName(){	//생성자
        
    }
    
    public ClassName(String name){	//생성자
        this.name = name;
    }
    
    public void methodOne(){	//메소드
        
    }
    
    public int methodTwo(){		//메소드
        return 20;
    }
    
    public void methodThree(String name){	//메소드
        this.name = name;
    }
}
~~~



# 필드 값 접근

​클래스이름.필드 이름

​생성자나 메소드에서 매개변수값과 필드의 이름이 같을 경우 : this 사용

~~~java
public class ClassName{
    public String name;
    public ClassName(String name){
        this.name = name;
    }
}

ClassName className = new ClassName("홍길동");	//생성자 호출
className.name = "김자바";	//필드 호출    
~~~

# 오버로딩(Overroading)
같은 이름의 메소드를 정의하는 것 (생성자 포함)

`this()` : 자신의 생성자 호출
~~~java
public class ClassName{
    private String name;
    private int age;
    
    public ClassName(){}
    public ClassName(String name){
        this.name = name;
    }
    public ClassName(int age){
        this.age = age;
    }
    public className(String name, int age){
        this(name);
        this(age);
    }

    private int sum(x, y){
        return x + y;
    }

    private int sum(x, y, z){
        return x + y + z;
    }
}
~~~
# 정적 필드 선언

`static` 사용시 선언가능

자바프로그램이 끝나지 않는 한 메모리에 상주

정적요소는 클래스이름.정적요소로 접근가능
~~~java
public class ClassName{
	static int number = 10;	//정적 필드 선언
    public static void method(){}	//정적 메소드 선언
	public static int add(int num1, int num2){}	//정적 메소드 선언
}

public class ClassName{
	static int number = 10;
    public static void method(){}
}

public class MainClass{
 	public static void main(String[] arg){
        ClassName.number = 20;
        ClassName.method();
    }   
}
~~~

# 정적 초기화 블록
`static{}` 사용
~~~java
public class ClassName{
    static int num1;
    static int num2;
    public static void method(){
        System.out.println("static method Running...");
    }
    
    static{
        num1 = 10;
        num2 = 20;
        method();
    }
}
~~~

# 싱글톤(Singleton)

​메모리의 참조를 한 곳으로 하겠다. 한 클래스에 한 객체만 존재하도록 제한한다.
1.  클래스 외부에서 new 연산자로 호출할 수 없도록 막음
2. 자신 타입인 외부에서 접근불가한 정적 필드 하나를 선언한다.
3. 외부에서 호출 가능한 정적 메소드 getInstance()를 선언하고, 정적 필드를 리턴한다.

~~~java
public class SingletonClass{
    private static SingletonClass singleton = new SingletonClass();
    private SingletonClass(){}
    public static SingletonClass getInstance(){
        return singleton;
    }
}

public class useClass{
    public static void main(String[] arg){
        //같은 객체 참조
        SingletonClass singleton1 = SingletonClass.getInstance();
        SingletonClass singleton2 = SingletonClass.getInstance();
    }
}
~~~
# final 필드와 상수
final변수는 한번 초기화 시, 수정할 수 없는 필드이다.
~~~java
public class FinalField{
	final int finalField1 = 20;
    final int finalField2;
    public FinalField(int finalField2){	//생성자
        this.finalFiedl2 = finalFiedld2;
    }
}
~~~

# 상수(Static final)

​불변의 값

​공용성을 띄고 있다.

​대문자로 쓰는 것이 관례

~~~java
public class StaticFinalField{
    static final int SOURCE_1 = 10;
    static final int SOURCE_2;
    static{
        System.out.println("Static Block Running...");
        SOURCE_2 = 100;
    	staticMethd();
    }
    public static void staticMethod(){
        System.out.println("staticMethod() Running...");
    }
    
}
~~~



# 패키지
상위패키지.하위패키지.클래스

​클래스 이름이 동일하더라도 패키지(폴더)가 다르면 다른 클래스로 인식한다.
~~~java
//import 상위패키지.하위패키지.클래스
import java.util.Objects;
~~~

# 접근 제한자
|접근제한|적용대상|접근할 수 없는 클래스|
|-|-|-|
|public|클래스, 필드, 생성자, 메소드|없음(어디에서나 접근가능)|
|protected|필드, 생성자, 메소드|자식 클래스가 아닌 다른 패키지에 있는 클래스들 접근불가|
|default|클래스, 필드, 생성자, 메소드|다른 패키지에 있는 클래스들 접근불가|
|private|필드, 생성자, 메소드|모든 외부 클래스들 접근 불가|


# Getter와 Setter 메소드
객체는 외부에서 직접적으로 접근하는 것을 막는다

이유 : 객체의 무결성이 깨지기 때문에

객체지향 프로그램은 메소드를 통해 데이터 변경하는 방법을 선호한다.
~~~java
public class GetterSetter{
    private int speed;
    private boolean stop = true;
    
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public void isStop(){
        return stop;
    }
    public void setStop(boolean stop){
        this.stop = stop;
    }
}

public class Main{
    public static void main(String[] args){
        GetterSetter getterSetter = new GetterSetter();
        getterSetter.setSpeed(30);
        System.out.println(getterSetter.getSpeed());
        getterSetter.setStop(!getterSetter.isStop());
        System.out.println(getterSetter.isStop());
    }
}
~~~



# 어노테이션(= 메타데이터)

컴파일 과정과 실행과정에서 코드를 어떻게 컴파일하고 처리할 것인지를 알려주는 정보

​클래스, 필드, 메소드만 어노테이션 적용 가능

​리플렉션 : 런타임 시에 클래스의 메타정보를 얻는 기능

~~~java
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintAnnotation{
    String value() defualt "-";
    int number() default 15;
}

public class Service {
    @PrintAnnotation
    public void method1(){
        System.out.println("실행 내용1");
    }

    @PrintAnnotation("*")
    public void method2(){
        System.out.println("실행 내용2");
    }

    @PrintAnnotation(value="#", number=20)
    public void method3(){
        System.out.println("실행 내용3");
    }
}

public class PrintAnnotationEx{
	public static void main(String[] args){
        Method[] declaredMethods = Service.class.getDeclaredMethods();
        for(Method method : declaredMethods){
            if(method.isAnnotationPresent(PrintAnnotation.class)){
                
                PrintAnnotation printAnnotation =
                    method.getAnnotation(PrintAnnotation.class);

                System.out.println("["+method.getName()+"]");

                for(int i=0; i<printAnnotation.number(); i++)
                    System.out.print(printAnnotation.value());

                System.out.println();

                try{
                    method.invoke(new Service());
                }catch (Exception e){}
                System.out.println();
            }
        }
    }
}
~~~




















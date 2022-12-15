# 인터페이스

​개발 코드와 객체가 서로 통신하는 접점 역활을 한다.

​컴파일시, .class로 나타난다.

​인터페이스를 구현받은 객체들은 대체가 가능한 부품들이다.



![interfaceImage](/uploads/cdc0d8201f09fb231509d06fc08dd3bc/interfaceImage.png)


~~~java
public interface InterfaceName{
    //잘 안씀
    public int num = 10;
    public abstract void method1();	//abstract 키워드 생략시, 기본 추상메소드
    public void method();
    public int sum(int x, int y);
}

public class ImplClassName implements InterfaceName{
    @Override
    public void method1(){

    }

    @Override
    public void method(){

    }

    @Override
    public int sum(int x, int y){
        return x + y;
    }
}
~~~

​인터페이스 안에서 선언된 변수들은 모두 상수가 되며,

​인터페이스 안에서 선언된 메소드들은 모두 추상 메소드가 된다.

# 인터페이스 안 default 메소드[자바 8버전부터]

​default 메소드는 기본적으로 public 특성이다.

​무조건 오버라이딩 하는 추상메소드에 비해 상속을 받지 않아도 상관없다.

~~~java
public interface InterfaceName{
    public default void method(int cnt){
        if(cnt == 0) System.out.println("0");
        else if(cnt == 1) System.out.println("1");
        else if(cnt == 2) System.out.println("2");
    }
}
public class InterfaceImpl implements InterfaceName{}
~~~

# 인터페이스 사용방법
~~~java
public interface InterfaceName{
    public void myMethod();	//abstract 키워드 생략시, 기본 추상메소드
}

public class FirstClass implements InterfaceName{
    @Override
    public void myMethod(){
        System.out.println("FirstClass method() Running...");
    }
}

public class SecondClass implements InterfaceName{
    @Override
    public void myMethod(){
        System.out.println("SecondClass method() Running...");
    }
}

public class MainClass{
    public static void main(String[] args){
        InterfaceName interfaceName;
        
        interfaceName = new firstClass();
        interfaceName.method();
        
        intrefaceName = new SecondClass();    	   
        interfaceName.method();
    }
}

~~~

# 익명 구현 객체

​일회성 구현 객체를 만들기 위해 사용

~~~java
public interface InterfaceName{
    public void run();
}

public class MainClass{
    public static void main(String[] args){
        InterfaceName interfaceName = new InterfaceName(){
          	@Override
           	public void run(){
                System.out.println("interfaceName Running...");
            }
        };
        interfaceName.run();
    }
}
~~~



# 다중 인터페이스의 구현 클래스

​인터페이스는 상속(extends)와 다르게 다중 구현(implements)이 가능하다.(인터페이스가 나온 이유 다중 상속을 지원하기 위해서)

~~~java
public interface FirstInterface{
    public void firstMethod();
}
public interface SecondInterface{
    public void secondMethod();
}
public class ImClass implements FirstInterface, SecondInterface{
    @Override
    public void fistMethod(){

    }
    @Override
    public void secondMethod(){

    }
}
~~~
# 인터페이스 내 디폴트 메소드 사용

​인터페이스를 구현한 객체가 있어야 사용이 가능하다.

~~~java
public interface InterfaceName{
    public default void name(){}
}
public class ClassName implements InterfaceName{
    @Override
    public void name(){
        System.out.println("ClassName name() Running...");
    }
}

public class MainClass{
    public static void main(String[] args){
        InterfaceName interfaceName = new ClassName();
        interfaceName.name();
    }
}
~~~



# 인터페이스 내 정적 메소드 사용
​정적 메소드는 바로 호출이 가능하다.

~~~java
public interface InterfaceName{
    public static void name(){
        System.out.println("InterfaceName name() Running...");
    }
}
public class MainClass{
    public static void main(String[] args){
        InterfaceName.name();
    }
}
~~~


# 인터페이스 다형성

​인터페이스를 상속받은 클래스들은 서로 대체가 가능하다.

~~~java
public interface Animal{
    public void eat();
    public void sleep();
    public void poop();
}
public class Dog implements Animal{
    @Override
    public void eat(){
        System.out.println("강아지는 개걸쓰럽게 먹는다.");
    }
    @Override
    public void sleep(){
        System.out.println("강아지는 조용히 잠잔다.");
    }
    @Override
    public void poop(){
        System.out.println("강아지는 아무데나 싼다.");
    }
}

public class Cat implements Animal{
    @Override
    public void eat(){
        System.out.println("고양이는 얌전하게 먹는다.");
    }
    @Override
    public void sleep(){
        System.out.println("고양이는 높은 곳에서 잠잔다.");
    }
    @Override
    public void poop(){
        System.out.println("고양이는 전용변기에 싼다.");
    }
}
public class MainClass{
    public static void main(String[] args){
        Animal animal = new Dog();
        animal = new Cat();
    }
}
~~~
# 인터페이스 배열 선언

~~~java
public interface Tire{}
public class HankooTire implements Tire{}
public class ClassName{
    Tire[] = {
    	new HankooTire(),
        new HankooTire(),
        new HankooTire(),
        new HankooTire()
    };
}
~~~

# 매개변수의 다형성
​매개변수에 인터페이스를 받을 수 있다.

​인터페이스를 상속받은 객체들은 매개변수로 넘겨줄 수 있다.

~~~java
public interface Vechicle{
    public void run();	//자동 추상메소드
}
public class Bus implements Vechicle{
    @Override
    public void run(){
        System.out.println("Bus run() Running...");
    }
}
public class Taxi implements Vechicle{
    @Override
    public void run(){
        System.out.println("Taxi run() Running...");
    }
}

public class RunningClass{
    public RunningClass(){}
   	public void running(Vehicle vehicle){
        vehicle.run();
    } 
}

public class MainClass{
    public static void main(String[] args){
        RunningClass runClass = new RunningClass();
        runClass.running(new Bus());
        runClass.running(new Taxi());
    }
}

~~~

# 강제 타입변환

​인터페이스를 상속받은 클래스를 인터페이스로 구현할 경우, 인터페이스에 있는 메소드만 실행이 가능하다.

~~~java
public interface InterfaceName{
    public void talk();
    public int sum(int num1, int num2);
    public String getMyName();
}
public class ClassName implements interfaceName{
    @Override
    public void talk(){
        System.out.println("ClassName talk() Running...");
    }
    @Override
    public int sum(int num1, int num2){
        return num1+num2;
    }
    @Override
    public String getName(){
        return "ClassName";
    }

	public void running(){
        for(int i=0; i<10; i++){
        	System.out.println("Running...");    
        }
    }
    
   	public int mius(int num1, int num2){
        return num1 - num2;
    }
}

public class MainClass{
    public static void main(String[] args){
        InterfaceName inName = new ClassName();
        inName.sum(10,20);
        inName.talk();
        inName.getName();
        
        ClassName className = (ClassName) inName;
        className.running();
        className.mius(20,30);
    }
}
~~~


# 객체 타입확인(Instanceof)
~~~java
public interface Animal{
    public void sound();
}
public class Dog implements Animal{
    @Override
    public void sound(){
        System.out.println("멍멍");
    }
}
public class Cat implements Animal{
    @Override
    public void sound(){
        System.out.println("냐옹");
    }
}
public class CompareClass{
    public void compare(Animal animal){
        if(animal instanceof Dog)
            animal = new Dog();
        else if(animal instanceof Cat)
            animal = new Cat();
        
        animal.sound();
    }
}

public class MainClass{
    
    public static void main(String[] args){
        CompareClass compareClass = new CompearClass();
        compareClass.compare(new Dog());
        compareClass.compare(new Cat());
    }
}
~~~

# 인터페이스 상속

​인터페이스는 다중 상속을 허용한다.

~~~java
public interface A{
    public void methodA();
}
public interface B{
    public void methodB();
}
public interface C{
    public void methodC();
}
public class ImClass implements A,B,C{
    @Override
    public void methodA(){
        System.out.println("ImClass methodA() Running...");
    }
    @Override
    public void methodB(){
        System.out.println("ImClass methodB() Running...");
    }
    @Override
    public void methodC(){
        System.out.println("ImClass methodC() Running...");
    }
}
~~~

# 인터페이스 디폴드 메소드 필요성
기존 인터페이스를 확장해서 새로운 기능을 추가하기 위해서 사용된다.

​디폴드 메소드를 만듦으로써, 구현 받은 클래스에서 무조건 오버라이딩을 할 필요없다.

~~~java
public interface DefaultInterface{
    public default void method(){
        System.out.println("DefaultInterface...");
    }
}
public class ImClass implements DefaultInterface{
    //오버라이드(재정의) 할 필요 없다
    
    @Override
    public void method() {
        System.out.println("ImplClass");
    }
}
~~~

# 디폴트 메소드가 있는 인터페이스 상속
1. 단순히 상속만 받는다.
2. 재정의 할 필요 없다.(오버라이딩)
3. 추상 메소드로 만든다.

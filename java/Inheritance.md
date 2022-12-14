# 상속

​부모가 자식에게 물려주는 것

최상위 클래스 = `Object`

​만약, 부모클래스와 자식클래스가 다른 패키지에 존재한다면 defualt 접근제한자 상속 제외

다중 상속허용X

`final` 클래스는 상속할 수 없다.

~~~java
public class SuperClass{
    public SuperClass(){
        System.out.println("나는 부모 클래스다");
    }

}
//result 나는 부모 클래스다
public class ChildClass extends SuperClass{}
//bad
public class ChildClass extends SuperClass,Math{}
~~~

# 오버라이딩 (Override)

부모클래스의 메소드를 자식클래스에서 재정의하는 것

`final` 메소드는 오버라이딩을 할 수 없다.
~~~java
public class SuperClass{
    int money;
    public void bank(){
        money = 10000;
    }
}

public class ChildClass extends SuperClass{
    @Override
    public void bank(){
        money -= 5000;
    }
}
~~~

# 부모 생성자 호출
`super()` 사용
~~~java
public class SuperClass{
    private static int money;
    public SuperClass(int money){
        this.money = money;
    }

    public static void printMoney(){
        System.out.println("부모클래스 : "+money);
    }
}
public class ChildClass extends SuperClass{
    public ChildClass(int money){
        super(money);
    }
}

public class Main{
    public static void main(String[] args){
        ChildClass childClass = new ChildClass(1000);
        SuperClass.printMoney();
    }
}
~~~



# 다형성

같은 타입이지만 실행 결과가 다양한 것

​객체를 부품화 시킨다.

## 자동 타입변환

​자식은 부모의 특징과 기능을 상속받기 때문에 부모와 동일하게 취급가능

​부모타입으로 자동 타입변환된 객체는 부모 클래스에 선언된 필드와 메소드만 선언가능하다.

단, 자식 클래스가 부모 클래스의 메소드를 오버라이딩했을 경우 자식 클래스 메소드가 실행된다.

~~~java
public class Driver{
    public void drive(Vehicle vehicle){
        vehicle.run();
    }
}

public class Bus extends Vehicle{
    @Override
    public void run(){
     	System.out.println("Bus run()...");
    }
}

public class Taxi extends Vehicle{
    @Override
    public void run(){
     	System.out.println("Taxi run()...");
    }
}

public class Vehicle{
    public void run(){
        System.out.println("Vehicle run()...");
    }
}

public class MainClass{
    public static void main(String[] arg){
        Driver driver = new Driver();
        driver.drive(new Bus());
        driver.drive(new Taxi());
    }
}
~~~

# 강제 타입 변환(Casting)

​부모 타입을 자식 타입으로 강제 변환

~~~java
public class SuperClass{}
public class ChildClass extends SuperClass{}
public class MainClass{
    public static void main(String[] arg){
        SuerClass superClass = new ChildClass();
        ChildClass childClass = (ChildClass) superClass;
    }
}
~~~



# 객체 타입 확인 (instanceof)
객체가 어떤 클래스의 인스턴스인지를 확인한다.

~~~java
public class CompareClass1{}
public class CompareClass2 extends CompareClass1{}
public class MainClass{
    public static void compare(CompareClass1 compareClass1){
        if(compareClass1 instanceof CompareClass2)
            System.out.println("같은 객체이다.");
        else
            System.out.println("다른 객체이다.");
    }
    public static void main(String[] arg){
        compare(new CompareClass1());
        compare(new CompareClass2());
    }
}
~~~



# 추상 클래스 (abstract class, Interface)

​공통된 특성을 추출한 클래스이다.

​부모 클래스로만 사용

​직접 new()로 생성하여 사용 불가 = 인스턴스 생성불가

목적
1. 실제 클래스들의 공통된 필드와 메소드의 이름을 통일화 할 목적
2. 실제 클래스를 작성할 때 시작을 절약
~~~java
public abstract class SuperClass{
    private String name;
    public abstract void method();
    public String myName(){
        return name;
    }
}

public class ChildClass extends SuperClass{
    @Override
    public void method(){
        
    }
}
~~~

# 추상 메소드와 오버라이딩

​추상 메소드 : 메소드의 선언은 통일하고, 실제 클래스마다 달라야하는 경우 사용

~~~java
public abstract class Animal{
    private String kind;
    public abstract void sound();	//공통된 메소드
    public String getKind(){
        return kind;
    }
    public void setKind(String kind){
        this.kind = kind;
    }
}

public class Dog extends Animal{
    @Override
    public void sound(){
        System.out.println("멍멍");
    }
}

public class Cat extends Animal{
    @Override
    public void sound(){
        System.out.println("야옹");
    }
}

public class MainClass{
    public static void main(String[] arg){
        Animal animal;
        
        animal = new Dog();
        animal.setKind("강아지");
        animal.sound();
        
        
        animal = new Cat();
        animal.setKind("고양이");
        animal.sound();
    }
}
~~~




# 중첩 클래스와 중첩인터페이스
- 중첩(Nasted) 클래스 : 클래스 내부에 선언한 클래스
- 중첩인터페이스 : 클래스 내부에 선언한 인터페이스
- UI 프로그래밍시, 이벤트 처리 목적으로 활용

장점
- 두 클래스의 필드를 서로 쉽게 접근이 가능하고 외부에는 불필요한 관계 클레스를 감춤으로써, 코드의 복잡성을 줄일 수 있다.


# 중첩 클래스 (Nasted Class)
1. 클래스의 필드로서 선언되는 경우 : 멤버 클래스
2. 메소드 내부에서 선언되는 경우 : 로컬 클래스

~~~java
public class ClassA{
    class ClassB{}	//멤버 클래스
    public void method(){
        class ClassC{}	//로컬 클래스
    }
}
~~~

# 인스턴스 멤버 클래스
​인스턴스 멤버 클래스는 static 키워드 없이 선언된 필드 클래스이다.

~~~java
public class ClassA{
    class ClassB{}	//인스턴스 멤버 클래스
}
~~~

# 정적 멤버 클래스
​정적 멤버 클래스는 static 키워드를 써서 선언된 필드 클래스이다.

~~~java
public class ClassA{
    // 정적 멤버 클래스
	static class ClassB{}
}
~~~

# 로컬 클래스

​메소드 내에 선언되는 클래스

static 키워드를 붙일 수 없다.

​주로 비동기 처리를 위해 스레드 객체를 만들 때 사용한다.

~~~java
public class ClassA{

    public void method(){
        // 로컬 클래스
        class ClassB{
            //생성자
            public ClassB(){}
            //필드
            private int field1;
            public int field2;
            protected int field3;
            //메소드
            public void classBMethod(){}
        }
    }
}
~~~

# 멤버 클래스에서 사용 제한

​인스턴스 멤버 클래스는 클래스 내에 있는 필드, 메소드 모두 접근이 가능하다.

​정적 멤버 클래스는 정적 필드, 메소드만 접근이 가능하다.

~~~java
public class ClassA{
    int field;
    public void method(){
        System.out.println("myField Value : "+field);
    }
    static int stField;
    public static void stMethod(){
        System.out.println("Call Static Method....");
    }

    //외부에서 접근불가
    class ClassB{
        public ClassB(){
            field = 10;
            method();
        }
    }
    static class ClassC{
        public ClassC(){
            stField = 20;
            stMethod();
        }
    }
}
public class MainClass{
    public static void main(String[] args){
        ClassA classA = new ClassA();
        int field = classA.field;
        field = 30;
        System.out.println("current field Value : "+field);
        classA.method();
        ClassA.stMethod();
        int stField = ClassA.stField;
        stField = 40;
        System.out.println("current static field value : "+stField);
        //Error
        //ClassA.ClassB abClass = new ClassA.ClassB();
        ClassA.ClassC acClass = new ClassA.ClassC();
    }
}
~~~

# 로컬 클래스에서 사용 제한
​로컬클래스 내부에서는 바깥 클래스의 필드, 메소드를 제한 없이 사용할 수 있다.

​로컬클래스는 매개변수값이 final인 매개값만 접근이 가능하다.

​자바 8버전 이후 final 키워드는 생략가능하다.

~~~java
public class A{
    int field;
   	public void method1(){}
    public void method2(final int num, int sum){
        class B{
            int fieldB = num;
            int sumB = sum;
            public B(){
                field = 10;
                method1();
            }
        }
    }
}
~~~

# 중첩 클래스에서 바깥 클래스 참조 얻기
​중첩 클래스 내부의 필드나 메소드를 사용하고 싶으면 this 키워드를 사용한다.

​바깥 클래스의 필드나 메소드를 사용하고 싶다면,

​바깥 클래스.this.필드명 / 바깥 클래스.this.메소드명

~~~java
public class A{
    int fieldA;
    public void methodA(){}
    class B{
        int fieldB;
        public void methodB(){
            A.this.fieldA = 20;
            A.methodA();
        }
    }
}

public class MainClass{
    public static void main(String[] args){
        A a = new A();
        A.B b = a.new B();
        b.fieldB = 20;
        b.methodB();
    }
}
~~~

<h3>중첩 인터페이스</h3>

​	UI프로그래밍에서 이벤트를 처리할 목적으로 많이 활용된다.

~~~java
public class Button{
    OnClickListener listener;
    
    public void setOnClickListener(OnClickListener listener){
        this.listener = listener;
    }
    
    public void touch(){
        listener.onClick();
    }
    
    interface OnClickListener{
        public void onClick();
    }
} 
~~~

<h3>익명 객체</h3>

​	이름없는 객체

​	익명 객체는 생성자를 선언할 수 없다.

​	익명 객체는 단독으로 사용할 수 없고, 클래스를 상속하거나 인터페이스를 구현해야만 생성할 수 있다.

1. 필드 익명객체
2. 로컬 익명객체

~~~java
public class Parent{
    public void run(){}
}
public class Child extends Parent{}
public class A{
    Parent field = new Child();	//필드 익명객체
    Parent parent = new Parent(){
        int childField;
        public void method(){}
        @Override
        public void run(){}
    };	//필드 익명객체
    
	public void method(){
        Parent localVar1 = new Child();	//로컬 익명객체
    	Parent localVar2 = new Parent(){
          	int childField;
            public void method(){}
            @Override
            public void run(){}
        };
    }
}
~~~

<h3>익명 객체의 로컬 변수 사용</h3>

​	final 키워드의 매개값을 사용한다.

​	자바 8버전 부터는 final을 적지 않아도 final로 인식한다.

~~~java
public class Parent{}
public class A{
    public void method(final int number){
        Parent parent = new Parent(){
        	int field = number;
        };
    }
}
~~~


package javaStudy;


class Parent{
    public Parent(){
        System.out.println("나는 부모입니다.");
    }
}

class Child extends Parent{
    public Child(){
        System.out.println("나는 자식입니다.");
    }
}


abstract class Animal{
    private String kind;
    public abstract void sound();	//공통된 메소드
    public String getKind(){
        return kind;
    }
}



class Cat extends Animal{

    @Override
    public void sound(){
        System.out.println("야옹");
    }
}

class Dog extends Animal{
    @Override
    public void sound(){
        System.out.println("멍멍");
    }
}


public class InheritanceTest {
    public static void main(String[] args){
        // 나는 부모입니다.
        // 나는 자식입니다.
        Child child = new Child();


        Cat cat = new Cat();
        cat.sound();

        Dog dog = new Dog();
        dog.sound();
    }
}

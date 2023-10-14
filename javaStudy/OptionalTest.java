package javaStudy;

import java.util.*;





class ClassName{
    private int age;
    private String name;

    public ClassName(int age, String name){
        this.age = age;
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}



public class OptionalTest {

    public static void main(String[] args){

        Optional<Integer> optional = Optional.of(20);
        System.out.println(optional.get());

        Optional<String> ageOptional = Optional.empty();
        String myAge = ageOptional.orElse("123");
        System.out.println(myAge);

        Optional<String> testOptional = Optional.ofNullable(null);
        System.out.println(testOptional);

        ClassName className = new ClassName(23, "kim");
        Optional<String> classOptional = Optional.empty();
        String name = classOptional.orElseGet(className::getName);
        System.out.println(name);
    }

}

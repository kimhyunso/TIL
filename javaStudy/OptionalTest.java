

import java.util.*;


class StudyTest{
    private int age;
    private String name;

    public StudyTest(int age, String name){
        this.age = age;
        this.name = name;
    }

    public StudyTest(){

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

        StudyTest studyTest = new StudyTest(23, "hyun");
        Optional<String> classOptional = Optional.empty();
        String name = classOptional.orElseGet(studyTest::getName);
        System.out.println(name);

    }

}

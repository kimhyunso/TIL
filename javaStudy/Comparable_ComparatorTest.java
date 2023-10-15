package javaStudy;

import java.util.*;


class Person implements Comparator<Person>{

    private int age;
    private int money;

    public Person(int age, int money){
        this.age = age;
        this.money = money;
    }

    @Override
    public int compare(Person o1, Person o2){
        if (o1.money > o2.money)
            return 1;
        else if (o1.money == o2.money)
            return 0;

        return -1;
    }

    /*@Override
    public int compare(Person o1, Person o2){
        return o1.money - o2.money;
    }*/
}




class Member implements Comparable<Member>{

    private int age;
    private int money;

    public Member(int age, int money){
        this.age = age;
        this.money = money;
    }

    /*@Override
    public int compareTo(Member o){

        if(this.age > o.age)
            return 1;
        else if(this.age == o.age)
            return 0;

        return -1;
    }*/
    // overflow 발생여지에 대해 반드시 확인해야함
    @Override
    public int compareTo(Member o){
        return this.age - o.age;
    }
}


public class Comparable_ComparatorTest {

    public static void main(String[] args){
        Member aMember = new Member(17, 10000);
        Member bMember = new Member(16, 2000);

        int isBig = aMember.compareTo(bMember);

        if (isBig > 0)
            System.out.println("aMember 객체가 bMember 객체보다 나이가 많습니다.");
        else if (isBig == 0)
            System.out.println("aMember 객체와 bMember 객체는 나이가 같습니다.");
        else
            System.out.println("bMember 객체가 aMember 객체보다 나이가 적습니다.");



        Person aPerson = new Person(20, 200000);
        Person bPerson = new Person(25, 10000000);


        isBig = aPerson.compare(aPerson, bPerson);

        if (isBig > 0)
            System.out.println("bPerson 객체가 aPerson 객체보다 돈이 많습니다.");
        else if (isBig == 0)
            System.out.println("aPerson 객체와 bPerson 객체는 돈이 같습니다.");
        else
            System.out.println("bPerson 객체가 aPerson 객체보다 돈이 적습니다.");
        

        
    }
    
}

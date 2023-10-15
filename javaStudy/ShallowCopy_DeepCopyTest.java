package javaStudy;


class NormalClass{

}

class EqualsClass{
    private int key;
    public EqualsClass(int key){this.key = key;}
    public int getKey(){return key;}

    @Override
    public boolean equals(Object obj){
        if (obj instanceof EqualsClass){
            EqualsClass eclass = (EqualsClass)obj;
            if (key == eclass.getKey())
                return true;
        }
        return false;
    }
}

class EqualsHashCode{
    private int key;
    public EqualsHashCode(int key){this.key = key;}
    public int getKey(){return key;}

    @Override
    public boolean equals(Object obj){
        if (obj instanceof EqualsHashCode){
            EqualsHashCode ehcode = (EqualsHashCode) obj;
            if (key == ehcode.getKey())
                return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return key;
    }
}

class User implements Cloneable{
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return (User) super.clone();
    }


    public User getUser(){
        User cloned = null;
        try{
            cloned = (User) clone();
        }catch(CloneNotSupportedException e){}
        return cloned;
    }

}


public class ShallowCopy_DeepCopyTest {
    public static void main(String[] args){
        NormalClass normal1 = new NormalClass();
        NormalClass normal2 = new NormalClass();
        normalEquals(normal1, normal2);

        EqualsClass equalsClass1 = new EqualsClass(10);
        EqualsClass equalsClass2 = new EqualsClass(10);
        eualsClassEquals(equalsClass1, equalsClass2);

        EqualsHashCode hashCode1 = new EqualsHashCode(20);
        EqualsHashCode hashCode2 = new EqualsHashCode(20);
        eualsHashCodeEquals(hashCode1, hashCode2);


        User user1 = new User(1, "kim", 23);
        User user2 = user1;
        if (user1.equals(user2))
            System.out.println("user1과 user2는 같습니다.");

        user2.setName("hyun");
        
        // user2의 객체만 바꾸었을 뿐인데 user1도 바뀌어 있다.
        System.out.println(user1.getName());
        System.out.println(user2.getName());

        User userOrigin = new User(1, "hyunso", 27);
        User userClone = userOrigin.getUser();

        if (userOrigin.equals(userClone))
            System.out.println("userOrigin과 userClone은 같습니다.");


        userClone.setName("홍길동");
        
        // userOrigin과 userClone과의 값이 다르다.
        System.out.println(userOrigin.getName());
        System.out.println(userClone.getName());

        int arr[] = {1};
        int value = 1;
        callByValue(value);
        // 바뀌지 않았음
        System.out.println("callByValue : " + value);

        callByReference(arr);
        // 바뀜
        System.out.println("callByReference : " + arr[0]);
    }



    public static void callByValue(int value){
        value = 20;
    }

    public static void callByReference(int arr[]){
        arr[0] = 20;
    }


    public static void normalEquals(NormalClass obj1, NormalClass obj2){
        System.out.println("==========hashCode()=============");
        System.out.println(obj1);
        System.out.println(obj2);

        System.out.println("\n==========toString()=============");
        System.out.println(obj1.toString());
        System.out.println(obj2.toString());

        if (obj1.equals(obj2))
            System.out.println("\n[equals]첫번째 객체와 두번째 객체는 동등하다.");
        else
            System.out.println("\n[not equals]첫번째 객체와 두번째 객체는 동등하지 않다.");

        if (obj1 == obj2)
            System.out.println("[==]첫번째 객체와 두번째 객체는 같다.");
        else
            System.out.println("[!=]첫번째 객체와 두번째 객체는 같지 않다.");

        System.out.println("=================NormalClass()=====================");

    }

    public static void eualsClassEquals(EqualsClass obj1, EqualsClass obj2){
        System.out.println("==========hashCode()=============");
        System.out.println(obj1);
        System.out.println(obj2);

        System.out.println("\n==========toString()=============");
        System.out.println(obj1.toString());
        System.out.println(obj2.toString());

        if (obj1.equals(obj2))
            System.out.println("\n[equals]첫번째 객체와 두번째 객체는 동등하다.");
        else
            System.out.println("\n[not equals]첫번째 객체와 두번째 객체는 동등하지 않다.");

        if (obj1 == obj2)
            System.out.println("[==]첫번째 객체와 두번째 객체는 같다.");
        else
            System.out.println("[!=]첫번째 객체와 두번째 객체는 같지 않다.");

        System.out.println("=================EqualsClass()=====================");

    }

    public static void eualsHashCodeEquals(EqualsHashCode obj1, EqualsHashCode obj2){
        System.out.println("==========hashCode()=============");
        System.out.println(obj1);
        System.out.println(obj2);

        System.out.println("\n==========toString()=============");
        System.out.println(obj1.toString());
        System.out.println(obj2.toString());

        if (obj1.equals(obj2))
            System.out.println("\n[equals]첫번째 객체와 두번째 객체는 동등하다.");
        else
            System.out.println("\n[not equals]첫번째 객체와 두번째 객체는 동등하지 않다.");

        if (obj1 == obj2)
            System.out.println("[==]첫번째 객체와 두번째 객체는 같다.");
        else
            System.out.println("[!=]첫번째 객체와 두번째 객체는 같지 않다.");

        System.out.println("=================EqualsHashCode()=====================");

    }

    

    



}

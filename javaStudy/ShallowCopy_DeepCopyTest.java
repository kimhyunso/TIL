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

package javaStudy;

class ClassName<E>{
    private E element;

    // 재네릭 파라미터 메소드
    void set(E element){
        this.element = element;
    }

    // 제네릭 타입 반환 메소드
    E get(){
        return element;
    }

    <T> T genericMethod(T o){
        return o;
    }


     // error
    /*static E genericMethod(E object){
        return object;
    }*/

    static <E> E genericMethod1(E o){
        return o;
    }

    static <T> T genericMethod2(T o){
        return o;
    }
}

class ClassNameTwo<K, V>{
    private K key;
    private V value;

    void set(K key, V value){
        this.key = key;
        this.value = value;
    }  

    K getKey(){
        return key;
    }

    V getValue(){
        return value;
    }
}

class DownNumberClass<T extends Number>{}


class UpNumberClass{

}



public class GenericTest {
    public static void main(String[] args){
        ClassName<String> aClass = new ClassName<String>();
        ClassName<Integer> bClass = new ClassName<Integer>();

        aClass.set("10");
        bClass.set(10);

        System.out.println("aClass Data : " + aClass.get());
        System.out.println("a E Type : " + aClass.get().getClass().getName());

        System.out.println();
        System.out.println("b data : " + bClass.get());
        // 반환된 변수의 타입 출력
        System.out.println("b E Type : " + bClass.get().getClass().getName());
        System.out.println();
        /////////////////////////////////////////////////////////////////////////

        ClassNameTwo<String, Integer> classNameTwo = new ClassNameTwo<String, Integer>();
        classNameTwo.set("10", 10);

        System.out.println(" key data : " + classNameTwo.getKey());
        // 반환된 변수의 타입 출력
        System.out.println(" key type : " + classNameTwo.getKey().getClass().getName());

        System.out.println(" value data : " + classNameTwo.getValue());
        System.out.println(" key type : " + classNameTwo.getValue().getClass().getName());

        
        System.out.println("<T> returnType : " + aClass.genericMethod(3).getClass().getName());
        System.out.println("<T> returnType : " + aClass.genericMethod("ABCD").getClass().getName());
        System.out.println("<T> returnType : " + aClass.genericMethod(bClass).getClass().getName());


        System.out.println("<E> returnType : " + ClassName.genericMethod1("3").getClass().getName());
        System.out.println("<T> returnType : " + ClassName.genericMethod2(3).getClass().getName());

        // error
        // DownNumberClass<String> downNumber = new DownNumberClass<String>();

        DownNumberClass<Integer> number = new DownNumberClass<Integer>();
    }
}

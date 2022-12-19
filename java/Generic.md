# 제네릭
제네릭 사용이유 : 잘못된 타입이 될 수 있는 문제를 컴파일과정에서 제거가 가능하다.

장점
   
   1. 컴파일 시 강한 타입 체크를 할 수 있다.
   2. 타입 변환(casting)을 제거한다.


# 제네릭 타입(class &lt;T&gt;, interface &lt;T&gt;)

제네릭 타입을 사용하지 않으면 타입캐스팅이 계속 일어나 프로그램 효율이 좋지 않다.

~~~java
public class Box{
    private Object object;
    public Object get(){
        return object;
    }
    public void set(Object object){
        this.object = object;
    }
}
public class Apple{}
public class MainClass{
    public static void main(String[] args){
        Box box = new Box();
        //자동 타입 변환
        box.set("오렌지");
        //강제 타입 변환
        String name = (String) box.get();
        
        //자동 타입 변환
        box.set(new Apple());
        //강제 타입 변환
        Apple apple = (Apple) box.get();
    }
}
~~~

~~~java
public class Box<T>{
    private T t;
    public T get(){
        return t;
    }
    public void set(T t){
        this.t = t;
    }
    
}
public class Apple{}
public class MainClass{
    public static void main(String[] args){
        Box<String> box = new Box<String>();
        box.set("오렌지");
        String name = box.get();
        
        Box<Apple> appleBox = new Box<String>();
        appleBox.set(new Apple());
        Apple apple = appleBox.get();
    }
}
~~~

# 멀티 타입 파리미터(class&lt;K, V, ...&gt;, interface&lt;K, V, ...&gt;)
자바 7버전 이후 부터 다이아몬드 연산자를 간단하게 작성이 가능하다.

~~~java
public class Car{}
public class Tv{}
public class ModelClass<T,M>{
    private T kind;
    private M model;
    
    public T getKind(){
        return kind;
    }
    public void setKind(T kind){
        this.kind = kind;
    }
    public M getModel(){
        return model;
    }
    public void setModel(M model){
        this.model = model;
    }
}
public class MainCalss{
    public static void main(String[] args){
        ModelClass<Tv, String> modelClass = new ModelClass<>();
        //ModelClass<Tv, String> modelClass = new ModelClass<Tv, String>();
        modelClass.setKind(new Tv());
		modelClass.setModel("스마트Tv");
        Tv tv = modelClass.getKind();
        String name = modelClass.getModel();
        
        ModelClass<Car, String> carClass = new ModelClass<>();
        //ModelClass<Car, String> carClass = new ModelClass<Car, String>();
        carClass.setKind(new Car());
        carClass.setModel("포르쉐");
        Car car = carClass.getKind();
        String modelName = carClass.getModel();
    }
}
~~~

# 제네릭 메소드(&lt;T, R&gt; R method(&lt;T t&gt;))

~~~java
public class Box<T>{
    private T t;
    public T get(){
        return t;
    }
    public void set(T t){
        this.t = t;
    }
}
public class Until{
    public static <T> Box<T> boxing(T t){
        Box<T> box = new Box<>();
        box.set(t);
        return box;
    }
}
public class MainClass{
    public static void main(String[] args){
        Box<Integer> box1 = Util.<Integer>boxing(100);
        int intValue = box1.get();
        
        Box<String> box2 = Util.<String>boxing("오렌지");
        String strValue = box2.get();
    }
}
~~~

# 제네릭 비교

~~~java
public class Pair<K, V>{
    private K key;
    private V value;
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey(){return key;}
    public V getValue(){return value;}
}
public class Util{
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2){
        boolean keyResult = p1.getKey().equals(p2.getKey());
        boolean valueResult = p1.getValue().equals(p2.getValue());
        return keyResult && valueResult;
    }
}

public class CompareMethodEx {
    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(1,"사과");
        Pair<Integer, String> p2 = new Pair<>(1,"사과");
        boolean result1 = Util.<Integer, String>compare(p1,p2);
        if(result1)
            System.out.println("동등한 객체입니다.");
        else
            System.out.println("동등하지 않는 객체입니다.");

        Pair<String, String> p3 = new Pair<>("User1","홍길동");
        Pair<String, String> p4 = new Pair<>("User2","홍길동");
        boolean result2 = Util.compare(p3,p4);

        if(result2)
            System.out.println("동등한 객체입니다.");
        else
            System.out.println("동등하지 않는 객체입니다.");
    }
}
~~~

# 제한된 타입 파라미터(&lt;T extends 최상위타입&gt;)
타입 파라미터를 제한할 필요가 있다.
~~~java
public class Util{
    public static <T extends Number> int compare(T t1, T t2){
        double d1 = t1.doubleValue();
        double d2 = t2.doubleValue();
        return Double.compare(d1,d2);
    }
}
public class MainClass{
    public static void main(String[] args){
        int result1 = Util.compare(10,20);
        System.out.println(result1);
        
        int result2 = Util.compare(3.14,5);
        System.out.println(result2);
    }
}
~~~

# 와일드카드 타입(&lt;?&gt;, &lt;? extends ...&gt;, &lt;? super ...&gt;)
​?를 일반적으로 와일드카드라고 부른다.
- 제네릭타입&lt;?&gt; (제한없음)
  
    모든 클래스나 인터페이스 타입이 올 수 있다.
- 제네릭타입&lt;? extends 상위타입&gt; (상위클래스 제한)
  
    상위 타입이나 하위 타입만 올 수 있다.
- 제네릭타입&lt;? super 하위타입&gt; (하위클래스 제한)

    하위 타입이나 상위 타입이 올 수 있다.
~~~java
public class Person{
    private String name;
    public Person(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
}
public class Worker extends Person{
    public Worker(String name){
        super(name);
    }
}
public class Student extends Person{
    public Student(String name){
        super(name);
    }
}
public class HighStudent extends Student{
    public HighStudent(String name){
        super(name);
    }
}

public class Course<T>{
    private String name;
    private T[] students;
    
    public Course(String name, int capacity){
        this.name = name;
        students = (T[])(new Object[capacity]);
    }
    public String getName(){return name;}
    public T[] getStudents(){return students;}
    public void add(T t){
        for(int i=0; i<students.length; i++){
            if(students[i] == null){
                students[i] = t;
                break;
            }
        }
    }
}

public class WildCardClass{
    //모든 과정
    public static void registerCourse(Course<?> course){
        System.out.println(course.getName()+" 수강생: "
                           +Arrays.toString(course.getStudents()));
    }
    
    public static void registerCourseStudent(Course<? extends Student> course){
        System.out.println(course.getName()+" 수강생: "
                           +Arrays.toString(course.getStudents()));
    }
    
    public static void registerCourseWorker(Course<? super Worker> course){
        System.out.println(course.getName()+" 수강생: "
                           +Arrays.toString(course.getStudents()));
    }
}

public class MainClass{
    public static void main(String[] args){
        Course<Person> personCourse = new Course<>("일반인과정",5);
        personCourse.add(new Person("일반인"));
        personCourse.add(new Worker("직장인"));
        personCourse.add(new Student("학생"));
        personCourse.add(new HighStudent("고등학생"));
        
        Course<Worker> workerCourse = new Course<>("직장인과정",5);
        workerCourse.add(new Worker("직장인"));
        
        Course<Student> studentCourse = new Course<>("학생과정",5);
        studentCourse.add(new Student("학생"));
        studentCourse.add(new HighStudent("고등학생"));
        
        Course<HighStudent> highStudentCourse = new Course<>("고등학생과정", 5);
        highStudentCourse.add(new HighStudent("고등학생"));
        
        WildCardClass.registerCourse(personCourse);
        WildCardClass.registerCourse(workerCourse);
        WildCardClass.registerCourse(studentCourse);
        WildCardClass.registerCourse(highStudentCourse);
        System.out.println();
        
        WildCardClass.registerCourseStudent(studentCourse);
        WildCardClass.registerCourseStudent(highStudentCourse);
		System.out.println();
        
        WildCardClass.registerCourseWorker(workerCourse);
        WildCardClass.registerCourseWorker(personCourse);
    }
}

~~~

<h3>제네릭 타입의 상속과 구현</h3>

~~~java
public class Tv{}
public class Product<T, M>{
    private T kind;
    private M model;
    
    public T getKind(){return kind;}
    public void setKind(T kind){this.kind = kind;}
    public M getModel(){return model;}
    public void setModel(M model){this.model = model;}
}
public class ChildProduct<T,M,C> extends Product<T,M>{
    private C company;
    
    public C getCompany(){return company;}
	public void setCompany(C company){this.company = company;}
}
public interface Storage<T>{
	public void add(T item, int index);
    public T get(int index);
}
public class StorageImpl<T> implements Storage<T>{
    private T[] array;
    
    public StorageImpl(int capacity){
        this.array = (T[])(new Object[capacity]);
    }
    @Override
    public void add(T item, int index){
        array[index] = item;
    }
    @Override
    public T get(int index){
        return array[index];
    }
}
public class ChildProductAndStorageClass{
    public static void main(String[] args){
        ChildProduct<Tv, String, String> product = new ChildProduct<>();
        product.setKind(new Tv());
        product.setModel("SmartTv");
        product.setCompany("Samsung");
        
        Storage<Tv> storage = new StorageImpl<Tv>(100);
        storage.add(new Tv(), 0);
        Tv tv = storage.get(0);
    }
}
~~~








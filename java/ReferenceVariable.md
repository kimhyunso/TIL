# 참조형 변수 (Reference Variable)
참조형 변수란 메모리 번지를 참조하는 것들을 말한다. ex) String, 배열(Array), 열거형(Enum)

## 변수 비교
~~~java
public static void main(String[] args){
    //null(비어있음)
    String str1;
    String compareStr1 = "홍길동";
    String compareStr2 = "고양이";

    //첫번째 비교방법
    //메모리 주소 같은지, false
    if(compareStr1 == compareStr2)
    //두번째 비교방법
    //같은 문자열인지, false
    if(compareStr1.equals(compareStr2))
    ~~~

    ## 객체 비교
    ~~~java
    String str1 = new String("Test");
    String str2 = new String("Test");
    //두 객체는 다른 메모리주소를 참조한다.
    //두 객체 비교시
    if(str1 == str2) //false
    if(str1.equals(str2)) //true
}
~~~

# 배열
0부터시작하여 지정한 길이까지 배열이 생성된다.
~~~java
public static void main(String[] args){
    //대입연산자를 이용하여 0~2까지 int배열생성
    int intArray1[] = {80,90,50};
    //int형 데이터 3개를 저장할 수 있도록 지정
    int intArray2[] = new int[3];
    //지정하지 않고 생성
    int intArray3[];
}
~~~

# 2차원배열
|인덱스번호|[0]|[1]|[2]|
|-|-|-|-|
|[0]|90|80|70|
|[1]|60|50|55|
|[2]|30|53|20|
~~~java
public static void main(String[] args){
    int intArray[][] = {
        {90,80,70},
        {60,50,55},
        {30,53,20}
    }
    int intArray[][] = new int[3][3];
    int intArray[][];

}
~~~

# 얕은 복사
System.arraycopy(src, srcPos, dest, destPos, length)
|값|설명|
|-|-|
|src|원본배열|
|srcPos|원본 배열의 복사 시작 위치|
|dest|복사할 배열|
|destPos|복사할 배열의 복사 시작 위치|
|length|복사할 요소의 갯수|

```java
public static void main(String[] args){
    //System.arraycopy(src, srcPos, dest, destPos, length)
    //1차원 배열
    int[] original_array = {1, 2, 3, 4, 5};
    int[] copy_array = new int[5];

    System.arraycopy(original_array,0,copy_array,0,original_array.length);

    for(int array : copy_array){
        System.out.print(array+" ");      
    }
    //리스트 -> 배열
    List<Integer> original_list = new ArrayList<Integer>();
    Integer[] copy_array = {1, 2, 3, 4, 5};

    original_list = (List<Integer>) Arrays.asList(copy_array);

    original_list.stream().forEach(array->System.out.print(array));
}
```

# String 배열
```java
String strArray1[] = {"Java", "Java", "C"};
String strArray2[] = new String[]{"Java", "Java", "C"};
String strArray3[] = new String[2];
String strArray4[];
//메모리 주소가 같은지 비교 true(같음)
if(strArray1[0] == strArray[1])
//메모리 주소가 같은지 비교 false(다름)
if(strArray1[1] == strArray[2])
//문자열이 같은지 비교 true(같음)
if(strArray1[0].equals(strArray[1]))
//문자열이 같은지 비교 false(다름)
if(strArray1[1].equals(strArray[2]))
```

strArray1[0] == strArray[1] 이 같은 이유는 메모리주소를 같은 번지를 사용하고 있기 때문이다.

<h2>열거형</h2>

~~~java
public enum Week{
    MONDAY,		//0
    TUESDAY,	//1
    WEDNEDAY,	//2
    THURSDAY,	//3
    FRIDAY,		//4
    SATURDAY,	//5
    SUNDAY		//6
}
public static void main(args[]){
    Week today = null;
    Week today = Week.SUNDAY;

    //문자열반환 SUNDAY
    String name = today.name();
    //몇번째 순서인지 반환 6
    int ordinal = today.ordianl();

    //열거형 비교
    Week day1 = Week.FRIDAY;
    Week day2 = Week.WEDNEDAY;

    //5-3 = 2
    int result1 = day1.compareTo(day2);
    //3-5 = -2
    int result2 = day2.compareTo(day1);
    //매개값으로 준 문자열과 동일한 객체를 리턴함
    Week weekDay = Week.valueOf("FRIDAY");
    //열거 객체를 배열로 리턴한다.
    Week[] days = Week.values();
}
~~~






























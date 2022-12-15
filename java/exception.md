# 예외와 예외 클래스

종류
1. 일반 예외 (Exception)
   
   컴파일하는 과정에서 예외 처리 코드가 필요한지 검사하는 것 (`try catch` 처리가 필요한 코드)
2. 실행 예외 (RuntimeException)

    컴파일하는 과정에서 예외 처리 코드를 검사하지 않는 예외들 (갑자기 예외가 발생하는 코드)
~~~java
public class ExceptionClass{
    public static void main(String[] args){
        //interruptedException 발생[일반예외]
        //Thread.sleep(500);
        try{
            Thread.sleep(500);
        }catch(interruptedException e){}
        
        String name = null;
        //nullPorintException 발생[실행 예외]
        System.out.println(name);	
        
        int intArray[] = {20,30,50};
        for(int i=0; i<5; i++)
            //ArrayIndexOutOfBoundsException 발생[실행 예외]
            System.out.println(intArray[i]); 
    }
}
~~~
# 예외 처리 코드
`try{}catch(Exception e)`
~~~java
public class TryCatchException{
    public static void main(String[] args){
        try{
            //예외 발생 코드
        }catch(Exception e){
            //예외 처리
        }finally{
            //항상 실행
        }
        int num = 10;
        try{
            num = num / 0;
        }catch(Exception e){
            System.out.println("0으로 잘못 나누었습니다.");
        }finally{
            num++;
        	System.out.println(num);
        }
    }
}
~~~

# 다중 catch
​다중 catch 사용시, 상위 Exception이 하위 Exception 보다 먼저 선언되어야 한다.

~~~java
public class CatchExceptoin{
    public static void main(String[] args){
        try{
            Thread.sleep(100);
            int num = 100 / 0;
        }catch(InterruptedException e){
            //인터럽트 예외만 처리
            System.out.println("Thread Exception...");
        }catch(Exception e){
            //모든 예외 처리
            System.out.pritnln("Divide Zero Exception...");
        }
    }
}
~~~

# 멀티 catch
~~~java
public class MutiCatchException{
    public static void main(String[] args){
        try{
            Thread.sleep(100);
            int intArray[] = {100,40,50};
        	for(int i=0; i<5; i++)
                System.out.pritnln(intArray[i]);
        }catch(InterruptedException e | ArrayIndexOfBoundsException e){
        	//인터럽트 예외와 배열인덱스 예외 처리
            System.out.println("Thread Exception...");
            System.out.println("Array Exception...");
        }
    }
}
~~~



# 자동 리소드 닫기

리소스 객체는 AutoCloseable 인터페이스를 구현받아야 한다.

~~~java
public class FileInputStream implements AutoCloseable{
    private String file;
    public FileInputStream(String file){
        this.file = file;
    }
    public void read(){
        System.out.println(file+"을 얻습니다.");
    }
    
    @Override
    public void close() throws Exception{
        System.out.println(file+"을 닫습니다.");
    }
}

public class TryWithResourceEx{
    public static void main(String[] args){
        try(FileInputStream fis = new FileInputSteam("file.txt")){
            fis.read();
            // 강제 Exception
            throw new Exception();
        }catch(Exception e){
            System.out.pritnln("예외 처리 코드가 실행되었습니다.");
        }
    }
}
~~~

# 예외 떠넘기기

​메소드에 throws 키워드를 사용하여 그 메소드를 호출한 곳에서 예외를 처리한다.
~~~java
public class ThrowsException{
    public static void main(String[] args){
        try{
            running();
        }catch(Exception e){
            System.out.println("Exception..."+e.getMessage());    
        }
    }
    public static void running() throws ClassNotFoundException, NullPointerException{
        Class.forName("java.lang.String2");
        int intArray[] = {100,200,300};
        for(int i=0; i<5; i++)
            System.out.println(intArray[i]);
    }
}
~~~

# 사용자 정의 예외와 예외 발생

​사용자 정의 예외 : 에플리케이션 예외

## 사용자 정의 예외

~~~java
public class MyException extends Exception{
    public MyException(){}
    public MyException(String message){
        super(message);
    }
}
public class MyRuntimeExcetion extends RuntimeExceptin{
    public MyRuntimeException(){}
    public MyRuntimeException(String message){
        super(message);
    }
}
public class Main{
    public static void main(String[] args){
        Exception ex;
        try{
            String num = null;
            System.out.println(num + 10);
        }catch(Exception e){
            ex = new MyException(e.getMessage());
            ex = new MyRuntimeException(e.getMessage());
        }
    }
}

~~~

## 예외 발생시기키

~~~java
public class RunException{
    public static void main(String[] args){
        try{
            //예외 강제로 발생
            throw new Exception("Exception...");
        }catch(Exception e){}
    }
}
~~~

# 예외 정보 얻기
~~~java
public class GetException{
    public static void main(String[] args){
        try{
            
        }catch(Exception e){
            String message = e.getMessage();	//예외발생 메시지
            e.printStackTrace();	//예외발생 경로 추적
        }
    }
}
~~~


















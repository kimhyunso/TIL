# 입력 스트림과 출력 스트림
프로그램이 데이터를 입력 받을 때는 입력 스트림, 데이터를 보낼 때는 출력 스트림이라고 불른다.

​스트림의 특성이 단방향이므로, 하나의 스트림으로 입출력 모두를 할 수는 없다.

​java.io 패키지에서 제공한다.

1. 바이트(byte) 기반 스트림
   * 그림, 멀티미디어, 문자 등 모든 종류의 데이터를 받고 보낼 수 있다. 
2. 문자 기반 스트림
   * 문자만 받고 보낼 수 있도록 특화되어 있다.

|추상 클래스|설명|
|-|-|
|`InputStream`|바이트 기반 입력 스트림의 최상위 클래스이다.|
|`OutputStream`|바이트 기반 출력 스트림의 최상위 클래스이다.|
|`Reader`|문자 기반 입력 스트림의 최상위 클래스이다.|
|`Writer`|문자 기반 출력 스트림의 최상위 클래스이다.|

# InputStream
`FileInputStream`, `BufferedInputStream`, `DataInputStream` 클래스는 모두 `InputStream`을 상속받았다.

## read() 메소드
`read()` : 입력 스트림으로부터 1바이트르 읽고, 4바이트 int타입으로 리턴한다.

​더 이상 입력 스트림으로부터 바이트를 읽을 수 없다면 -1을 리턴한다.
~~~java
InputStream is = new FileInputStream("C:/test.jpg");
int readByte;
while((readByte = is.read()) != -1 ){}
~~~

## read(byte[] b) 메소드
매개값으로 받은 byte 배열 길이 만큼 바이트를 읽고 배열에 저장한다.

​더 이상 입력 스트림으로부터 바이트를 읽을 수 없다면 -1을 리턴한다.

~~~java
InputStream is = new FileInputStream("C:/test.jpg");
int readByteNo;
byte[] readBytes = new byte[100];
while((readByteNo = is.read(readBytes)) != -1){}
~~~

## read(byte[] b, int off, int len) 메소드
입력 스트림으로 부터 len개부터 off값 만큼 배열에 저장한다.

~~~java
InputStream is = new FileInputStream("C:/test.jpg");
int readByteNo;
byte[] readBytes = new byte[100];
while((readByteNo = is.read(readBytes,0,100)) != -1){}
~~~

## close() 메소드
입력 스트림의 자원을 풀어주는 역활을 한다.

~~~java
InputStream is = new FileInputStream("C:/test.jpg");
is.close();
~~~

# OutputStream
`FileOutputStream`, `PrintStream`, `BufferedOutputStream`, `DataOutputStream` 클래스 모두 `OutputStream`을 상속받았다.

## write(int b) 메소드
int(4바이트) 중 끝에 1바이트만 출력 스트림으로 보낸다.
~~~java
OutputStream os = new FileOutputStream("C:/test.txt");
byte[] data = "ABC".getBytes();
for(int i=0; i<data.length; i++)
    os.write(data[i]); //"A", "B", "C"를 하나씩 출력
~~~

## write(byte[] b) 메소드
매개값으로 주어진 바이트 배열의 모든 바이트를 출력 스트림으로 보낸다.
~~~java
OutputStream os = new FileOutputStream("C:/test.txt");
byte[] data = "ABC".getBytes();
os.write(data); //"ABC" 모두 출력
~~~

## write(byte[] b, int off, int len)
off부터 len개의 바이트만 출력 스트림으로 보낸다.
~~~java
OuptStream os = new FileOutputStream("C:/test.txt");
byte[] data = "ABC".getBytes();
os.write("data",1,2); //"BC"만 출력
~~~

## flush()와 close() 메소드
출력 스트림 내부에는 작은 버퍼가 존재하여, 데이터가 출력되기 전 버퍼에 쌓여있다가 순서대로 출력된다.

​`flush()` : 버퍼에 잔류해있는 데이터를 모두 출력시키고, 버퍼를 비우는 역활을 한다.

​`close()` : 출력스트림의 자원을 풀어주는 역활을 한다.

~~~java
OutputStream os = new FileOutputStream("C:/test.txt");
byte[] data = "ABC".getBytes();
os.write(data);
os.flush();
os.close();
~~~

# Reader
`FileReader`, `BufferedReader`, `InputStreamReader` 클래스는 모두 `Reader` 클래스를 상속받았다.

## read() 메소드
입력 스트림으로부터 한 개의 문자(2바이트)를 읽고 int(4바이트) 타입으로 리턴한다.

~~~java
Reader reader = new FileReader("C:/test.txt");
int readData;
while((readData = reader.read()) != -1){
    char charData = (char) readData;
}
~~~

## read(char[] cbuf) 메소드
매개값으로 주어진 문자 배열의 길이만큼 문자를 읽고 배열에 저장한다.

~~~java
Reader reader = new FileReader("C:/test.txt");
int readCharNo;
char[] cbuf = new char[2];
while((readCharNo = reader.read(cbuf)) != -1){}
~~~

## read(char[] cbuf, int off, int len) 메소드
​입력스트림으로 부터 len개 부터 off개까지 저장한다.

~~~java
Reader reader = new FileReader("C:/test.txt");
int readCharNo;
char[] cbuf = new char[100];
while((readCharNo = reader.read(cbuf)) != -1){}
~~~

## close() 메소드
Reader의 자원을 풀어주는 역활을 한다.

~~~java
Reader reader = new FileReader("C:/test.txt");
reader.close;
~~~

# Writer
`FileWriter`, `BufferedWriter`, `PrintWriter`, `OutputStreamWriter` 클래스들 모두 `Writer` 클래스를 상속받았다.

## write(int c) 메소드
주어진 매개변수 int(4바이트) 안에서 끝에 있는 2바이트(한 개의 문자)만 출력 스트림으로 보낸다.

~~~java
Writer writer = new FileWriter("C:/test.txt");
char[] data = "홍길동".toCharArray();
for(int i=0; i<data.length; i++)
    writer.write(data[i]);	//"홍", "길", "동"을 하나씩 출력
~~~

## write(char[] cbuf) 메소드
매개값으로 주어진 char[] 배열의 모든 문자를 출력 스트림으로 보낸다.

~~~java
Writer writer = new FileWriter("C:/test.txt");
char[] data = "홍길동".toCharArray();
writer.write(data);	//"홍길동" 모두 출력
~~~

## write(char[] c, int off, int len) 메소드
len부터 off까지 문자를 출력 스트림으로 보낸다.
~~~java
Writer writer = new FileWriter("C:/test.txt");
char[] data = "홍길동".toCharArray();
writer.write(data,1,2);	//"길동"만 출력
~~~

## write(String str)와 write(String str, int off, int len) 메소드
`write(String str)` : 문자열 전체를 출력스트림으로 보낸다 

`write(String str, int off, int len)` : off부터 len까지의 문자만을 보낸다.

​문자 출력 스트림의 내부에는 작은 버퍼가 존재하여, 데이터가 출력되기 전 버퍼에 쌓여있다가 순서대로 출력된다. 그렇기 때문에 `flush()` 메소드를 사용하여 모든 문자가 출력되게 해야한다.

​`close()` 메소드는 `Writer`의 자원을 풀어주는 역활을 한다.

~~~java
Writer writer = new FileWriter("C:/test.txt");
String data = "안녕 자바 프로그램";
writer.write(data);
writer.flush();
writer.close();
~~~

# 콘솔 입출력
1. ​입력 스트림 : System.in
2. 출력 스트림 : System.out
3. 에러 스트림 : System.err

# System.in 필드
InputStream의 `read()` 메소드는 1바이트만 읽기 때문에 한글과 같이 2바이트를 필요로하는 경우는 `read()` 메소드로 읽을 수 없다. 

한글을 읽을 경우는 `read(byte[] b)`메소드를 사용하거나, `read(btye[] b, int off, int len)` 메소드를 사용해야 한다.
~~~java
public class SystemInClass {
    public static void main(String[] args) throws IOException {
        System.out.println("==메뉴==");
        System.out.println("1. 예금 조회");
        System.out.println("2. 예금 출금");
        System.out.println("3. 예금 입금");
        System.out.println("4. 종료 하기");
        System.out.print("메뉴를 선택하세요: ");

        InputStream is = System.in;
        char inputChar = (char)is.read();

        switch (inputChar){
            case '1':
                System.out.println("예금 조회를 선택하셨습니다.");
                break;
            case '2':
                System.out.println("예금 출금을 선택하셨습니다.");
                break;
            case '3':
                System.out.println("예금 입금을 선택하셨습니다.");
                break;
            case '4':
                System.out.println("종료 하기를 선택하셨습니다.");
                break;
        }
    }
}
~~~

~~~java
public class SystemInKoreanEx {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;

        byte[] datas = new byte[100];

        System.out.print("이름: ");
        int nameBytes = is.read(datas);
        String name = new String(datas, 0, nameBytes-1);

        System.out.print("하고 싶은 말: ");
        int commentBytes = is.read(datas);
        String comment = new String(datas,0,commentBytes-1);

        System.out.println("입력한 이름: "+name);
        System.out.println("입력한 하고 싶은 말: "+comment);
    }
}
~~~

# System.out 필드
콘솔에 출력하기 위해 사용된다.

~~~java
public class SystemOutEx {
    public static void main(String[] args) throws IOException {
        OutputStream os = System.out;

        for(byte b=48; b<58; b++)
            os.write(b);

        os.write(10);

        for(byte b=97; b<123; b++)
            os.write(b);
        os.write(10);

        String hangul = "가나다라마바사아자차카타파하";
        byte[] hangulBytes = hangul.getBytes();
        os.write(hangulBytes);
        os.flush();
    }
}
~~~

# Console 클래스
~~~java
public class ConsoleEx {
    public static void main(String[] args) {
        Console console = System.console();

        System.out.print("아이디: ");
        String id = console.readLine();

        System.out.print("비밀번호: ");
        char[] charPass = console.readPassword();
        String strPassword = new String(charPass);

        System.out.println("-----------------");
        System.out.println(id);
        System.out.println(strPassword);
    }
}
~~~

# Scanner 클래스
java.util 패키지의 Scanner 클래스를 이용하면, 콘솔의 기본타입의 값을 읽을 수 있다.

~~~java
public class ScannerEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("문자열 입력> ");
        String inputString = scanner.nextLine();
        System.out.println(inputString);
        System.out.println();

        System.out.print("정수 입력> ");
        int inputInt = scanner.nextInt();
        System.out.println(inputInt);
        System.out.println();

        System.out.print("실수 입력> ");
        double inputDouble = scanner.nextDouble();
        System.out.println(inputDouble);
    }
}
~~~


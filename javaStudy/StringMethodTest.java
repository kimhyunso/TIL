public class StringMethodTest {
    public static void main(String[] args){
        String phoneNum = "01012345678";
        // charAtPrint(phoneNum);
        // equals();
        // indexOf();

        // length();

        // lastIndexOf();
        // subString();
        // upperLowerCase();
        split();
    }

    public static void split(){
        String text = "홍길동&이순신&광개토대왕&을지문덕";
        String names[] = text.split("&");
        for (String name : names)
            System.out.println(name);

        text = "홍길동&이수홍,박연수,김자바-김영호";
        names = text.split("&|,|-");
        for (String name : names)
            System.out.println(name);
    }


    public static void upperLowerCase(){
        String str1 = "java PROGRAMING";
        String str2 = "JAVA programing";

        String strToUpper = str1.toUpperCase();
        String strToLower = str2.toLowerCase();
        System.out.println(str1);
        System.out.println(str2);

        System.out.println(strToUpper);
        System.out.println(strToLower);

        System.out.println(str1.equalsIgnoreCase(str2));
    }


    public static void length(){
        String ssn = "01012345678";
        System.out.println(ssn.length());
    }

    public static void lastIndexOf(){
        String subject = "자바 프로그래밍";

        // 3
        int index = subject.lastIndexOf("프로그래밍");
        System.out.println(index);

        if(subject.lastIndexOf("자바") != -1)
            System.out.println("자바와 관련된 책이군요.");
        else
            System.out.println("자바와 관련없는 책이군요.");

    }

    public static void subString(){
        String number = "01234567891011";
        String threeToSix = number.substring(3, 6);
        System.out.println(threeToSix);

        String sixToMax = number.substring(5);
        System.out.println(sixToMax);
    }


    public static void indexOf(){
        String subject = "자바 프로그래밍";

        int index = subject.indexOf("프로그래밍");
        System.out.println(index);

        if(subject.indexOf("자바") != -1)
            System.out.println("자바와 관련된 책이군요.");
        else
            System.out.println("자바와 관련없는 책이군요.");
    }

    
    public static void charAtPrint(String str){
        for(int i=0; i<str.length(); i++)
            System.out.println(str.charAt(i));
    }

    public static void equals(){
        String name1 = "이순신";
        String name2 = new String("이순신");

        String name3 = "이순신";

        if (name1 == name3)
            System.out.println("name1과 name3가 참조하는 곳이 같다.");

        if (name1 == name2)
            System.out.println("name1과 name2가 참조하는 곳이 같다.");

        if (name1.equals(name2))
            System.out.println("name1과 name2의 내용물이 같다.");

        if (name1.equals(name3))
            System.out.println("name1과 name3의 내용물이 같다.");
    }
}

public class StringMethodTest {
    public static void main(String[] args){
        String phoneNum = "01012345678";
        // charAtPrint(phoneNum);


        String name1 = "이순신";
        String name2 = new String("이순신");

        String name3 = "이순신";

        if (name1 == name3)
            System.out.println("sdfs");

        if (name1.equals(name2))
            System.out.println("sada");

        System.out.println(name1.hashCode());
        System.out.println(name2.hashCode());
        System.out.println(name3.hashCode());
    }   
    
    public static void charAtPrint(String str){
        for(int i=0; i<str.length(); i++)
            System.out.println(str.charAt(i));
    }
}

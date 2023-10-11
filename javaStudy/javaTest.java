package javaStudy;

public class javaTest {
    public static void main(String[] args){
        String age = null;
        try{
            int ageToInt = Integer.parseInt(age);
        }catch(Exception e){
            System.out.println(e.getMessage() + " 에러 발생!");
        }

        // 두번째 방법
        String age1 = null;
        int ageToInt1 = 0;
        if (age1 != null)
            ageToInt1 = Integer.parseInt(age1);
        else
            System.out.println("에러로 실행안됨");

    }
}

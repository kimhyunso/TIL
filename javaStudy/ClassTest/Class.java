package ClassTest;

public class Class {

    public static void main(String[] args){
        Hyundea hyundea = new Hyundea();
        int start = hyundea.run();
        int end = hyundea.stop();

        System.out.println("hyundea : " + (end - start) + " 만큼 달렸습니다.");

        Kia kia = new Kia();
        start = kia.run();
        end = kia.stop();

        System.out.println("kia : " + (end - start) + " 만큼 달렸습니다.");
    }    
    
}

class MainClass{
    public static void main(String[] args){
        System.out.println(SumClass.sum(10, 2));
    }
}

class SumClass{
    public static int sum(int x, int y){
        return x + y;
    }
}

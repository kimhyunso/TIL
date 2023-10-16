
@FunctionalInterface
interface MySum{
    public int sum(int x, int y);
}

public class LamdbaTest {

    public static void main(String[] args){
        
        MySum  myLamdb = (x, y) -> {return x+y;};
        System.out.println(myLamdb.sum(20, 30));

    }
    
}

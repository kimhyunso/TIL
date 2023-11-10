package ClassTest;

public class Kia implements Car{
    
    private int runningTime = 0;

    @Override
    public int run(){
        runningTime = 20;
        System.out.println("kia 달리는 중~");
        return runningTime;
    }

    @Override
    public int stop(){
        runningTime = 30;
        System.out.println("kia 멈췄음!");
        return runningTime;
    }
}
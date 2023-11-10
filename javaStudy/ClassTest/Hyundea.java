package ClassTest;

public class Hyundea implements Car{

    private int runningTime = 0;

    @Override
    public int run(){
        runningTime = 10;
        System.out.println("hyundea 달리는 중~");
        return runningTime;
    }

    @Override
    public int stop(){
        runningTime = 12;
        System.out.println("멈췄음!");
        return runningTime;
    }
}
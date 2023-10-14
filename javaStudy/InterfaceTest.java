package javaStudy;

import java.text.SimpleDateFormat;

interface Car{
    public long stop();
    public long start();
    public void move(int x);
}

class Hyundai implements Car{
    @Override
    public long start(){
        return System.currentTimeMillis();
    }

    @Override
    public void move(int x){
        
        for (int i=0; i<x; i++){
            for (int j=0; j<x; j++){}
        }
    }

    @Override
    public long stop(){
        return System.currentTimeMillis();
    }
}

class Kia implements Car{

    @Override
    public long start(){
        return System.currentTimeMillis();
    }


    @Override
    public void move(int x){
        for (int i=0; i<x; i++){
            for (int j=0; j<x; j++){}
        }
    }

    @Override
    public long stop(){
        return System.currentTimeMillis();
    }
}



public class InterfaceTest {
    public static void main(String[] args){
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss.SSS");

        Car hyundai = new Hyundai();
        long start = hyundai.start();
        hyundai.move(100000);
        long stop = hyundai.stop();

        System.out.println("출발 시간 : " + simpleDateFormat.format(start));
        System.out.println("도착 시간 : " +  simpleDateFormat.format(stop));

        Car kia = new Kia();

        long kiaStart = kia.start();
        kia.move(100000);
        long kiaStop = kia.stop();

        System.out.println("출발 시간 : " + simpleDateFormat.format(kiaStart));
        System.out.println("도착 시간 : " +  simpleDateFormat.format(kiaStop));        
    }
    
}

package fastcampus.소금폭탄_13223;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String current = input.readLine();
        String drop = input.readLine();

        String currentUnits[] = current.split(":");
        int currentHour = Integer.parseInt(currentUnits[0]);
        int currentMinute = Integer.parseInt(currentUnits[1]);
        int currentSecond = Integer.parseInt(currentUnits[2]);
        int currentSecodAmount = currentHour * 3600  + currentMinute * 60 + currentSecond;
        
        String dropUnits[] = drop.split(":");
        int dropHour = Integer.parseInt(dropUnits[0]);
        int dropMinute = Integer.parseInt(dropUnits[1]);
        int dropSecond = Integer.parseInt(dropUnits[2]);
        int dropSecodAmount = dropHour * 3600  + dropMinute * 60 + dropSecond;

        int needSecondAmout = dropSecodAmount - currentSecodAmount;
        if (needSecondAmout <= 0)
            needSecondAmout += 24 * 3600;

        int needHour = needSecondAmout / 3600;
        int needMinute = (needSecondAmout % 3600) / 60;
        int needSecond = needSecondAmout % 60;

        System.out.printf("%02d:%02d:%02d", needHour, needMinute, needSecond);

    
    }
    
}
 
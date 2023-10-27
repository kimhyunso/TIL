package programmers.달리기경주;

import java.util.*;

public class Main {
    public static void main(String[] args){
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        solution(players, callings);
    }

    public static String[] solution(String[] players, String[] callings){
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        int cnt = 0;
        for (String player : players){
            map.put(player, cnt++);
        }


        for (String calling : callings){
            int rank = map.get(calling);
            String beforePlayer = players[rank-1];

            players[rank-1] = calling;
            players[rank] = beforePlayer;
            
            map.put(calling, rank-1);
            map.put(beforePlayer, rank);
        }




        return players;
    }

}

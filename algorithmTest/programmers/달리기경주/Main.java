package programmers.달리기경주;

/**
 * 얀에서는 매년 달리기 경주가 열립니다. 
 * 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다. 
 * 예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때, 
 * 해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다. 
 * 즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.
 * 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때, 
 * 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.
 */

/**
 * 풀이법 : HashMap 이용
 * player의 이름과 등수를 매칭되도록 HashMap에 저장 후
 * 해설진이 부른 이름에 따라 이름의 등수와 현재 등수보다 전의 player를 구한 후
 * 해설진이 부른 player와 해설진이 부른 player 등수보다 높은 사람을 서로 바꾼 후
 * 해설진이 부른 player는 자신 보다 높은 등수의 사람 rank을 부여받고,
 * 높은 등수의 사람은 등수를 한단계 감소시킨다. 
 */


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

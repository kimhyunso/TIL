package programmers.체육복;

/**
 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 
 * 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
 * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 
 * 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
 * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 */


 /**
  * 풀이법 : 
  * people 배열에 체육복을 잃어버린 사람은 -1, 체육복 여벌이 있는 사람은 +1, 
  * answer는 n만큼 할당 (체육활동에 나갈 수 있는 인원수)
  * 반복을 하며, 
  * 1. 체육복을 잃어버린 사람을 찾음
  * 1-1. 내 왼쪽에 있는 사람이 여벌의 체육복이 있는지 : 체육복을 빌린 사람은 +1, 체육복을 빌려준 사람은 -1
  * 1-2. 내 오른쪽에 있는 사람이 여벌의 체육복이 있는지 : 체육복을 빌린 사람은 +1, 체육복을 빌려준 사람은 -1
  * 1-3. 양옆에 여벌의 체육복을 빌려줄 수 없다면 : answer-1
  */


public class Main {
    public static void main(String[] args){
        int n = 5;
        int lost[] = {2, 4};
        int reserve[] = {3};
        System.out.println(solution(n, lost, reserve));
    }


    public static int solution(int n, int[] lost, int[] reserve){
        
        int people[] = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;

        for (int r : reserve)
            people[r-1]++;
        
        for (int i=0; i<people.length; i++){
           
            if (people[i] == -1){
                // 앞의 조건은 벽 0이하인 데이터를 차단
                // (현재-1) 전에 있는 사람이 체육복을 갖고 있는지
                if (i-1 >= 0 && people[i-1] == 1){
                    // 체육복을 빌린 사람은 증가
                    people[i]++;
                    // 체육복을 빌려준 사람은 감소
                    people[i-1]--;

                // 앞의 조건은 벽 people.length 초과 데이터 차단
                // (현재+1) 다음 사람이 체육복을 갖고 있는지
                }else if(i+1 < people.length && people[i+1] == 1){
                    // 체육복을 빌린 사람은 증가
                    people[i] ++;
                    // 체육복을 빌려준 사람은 감소
                    people[i+1] --;
                }else
                    // 양옆에 빌려줄 사람이 없다면 체육운동을 나갈 수 없으므로 감소
                    answer --;

            }
        }

        return answer;
    }

}

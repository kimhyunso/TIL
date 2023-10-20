package programmers.체육복;

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

            // 체육복을 잃어버렸음
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

/**
 * 등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.
 */

 /**
  * 풀이법 : 
  * 1. 등차일 경우 = 두번째 요소에서 첫번째 요소를 뺀 값이 두번째 요소에서 세번째 요소를 뺀 값과 같은지 (같다면 등차)
  * 현재 배열에 있는 마지막 요소 + (두번째 요소 - 첫번째 요소)
  * 2. 등비일 경우 = 마지막 요소 * (두번째 요소 / 첫번째 요소)
  */

class Main{

    public static void main(String[] args){

        int[] common = {1, 2, 3, 4};
        solution(common);
    }


    public static int solution(int[] common){
        int answer = 0;

        // 등차수열일 경우
        if((common[1] - common[0]) == (common[2] - common[1])) 
            answer = common[common.length-1] + (common[1] - common[0]);
        // 등비수열일 경우
        else 
            answer = common[common.length-1] * (common[1] / common[0]);
        
        return answer;
    }

}
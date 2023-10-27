package programmers.옹알이;

public class Main {
    public static void main(String[] args){

        String babbling[] = {"ayayeayaaya"};

        System.out.println(solution(babbling));
    } 

    public static int solution(String[] babbling){
        
        int answer = 0;

        String words[] = {"aya", "ye", "woo", "ma"};
        String duplicatedWord[] = {"ayaaya", "yeye", "woowoo", "mama"};

        for (int i=0; i<babbling.length; i++){
            String word = babbling[i];
            for (int j=0; j<words.length; j++){
                int firstIndex = word.indexOf(words[j]);
                int lastIndex = word.lastIndexOf(words[j]);

                if (firstIndex + words[j].length() != lastIndex && firstIndex != -1){
                    word = word.replace(duplicatedWord[j], "1");
                    word = word.replace(words[j], " ");                    
                }
               
            }

            if (word.trim().length() == 0)
                answer ++;

        }
        
        return answer;
    }
}

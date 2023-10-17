package baekjoon.회사에있는사람_7785;

import java.util.*;


class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        HashSet<String> hashSet = new HashSet<String>();

        for (int i=0; i<n; i++){
            String lists[] = input.nextLine().split(" ");
            if (lists[1].equals("enter"))
                hashSet.add(lists[0]);
            else if (lists[1].equals("leave")){
                hashSet.remove(lists[0]);
            }
        }

        List<String> answer = new ArrayList(hashSet);
		Collections.sort(answer, Collections.reverseOrder());
		for (String s : answer){
		    System.out.println(s);
		}

    }

    
}

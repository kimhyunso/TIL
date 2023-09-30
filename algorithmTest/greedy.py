# 현재 상황에서 당장 좋은 것만 고르는 것
# 정당성 분석

# 거스름돈 문제
# 가장 큰 화폐부터 거술러주기
N = 1260
coins = [500, 100, 50, 10]


result = 0


for coin in coins:
    result += N // coin
    N = N % coin


print(result)

'''
public class Main{
    public static void main(String[] args){
        int n = 1260;
        int cnt = 0;
        int[] coins = {500, 100, 50, 10};

        for (int i = 0; i<conis.length; i++){
            cnt += n / coins[i];
            n = n % coins[i];
        }

        System.out.println(cnt);
    }
}
'''


# 1이 될때까지
# 최대한 많이 나누기
'''
N, K = map(int, input().split())
result = 0

def divideCount(N):
    count = 0
    while N != 1:
        N = N // K
        count += 1
    return count


if N % K == 0:
    result = divideCount(N)
else:
    N - 1
    result += 1
    result += divideCount(N)


print(result)
'''

'''
# N log N
n, k = map(int, input().split())
result = 0

while True:
    # N이 K로 나누어 떨어지는 수가 될 때까지 빼기
    # 만약 N이 K로 나누어 떨어지지 않는다고 했을 때 가장 가까운 K로 나누어 떨어지는 수가 어떤건지를 찾고자 할 때 사용
    # target K로 나누어 떨어지는 수
    target = (n // k) * k

    # 총 연산을 수행하는 횟수
    # 1을 빼는 연산을 몇번 수행할지 한번에 더하는 것
    result += (n - target)
    # n이 target
    n = target
    
    # N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
    if n < k:
        break
    
    # K로 나누기
    result += 1
    n //= k


# 마지막으로 남은 수에 대하여 1씩 빼기
result += (n-1)
print(result)
'''


'''
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true){
            int target = (n/k) * k;
            result += (n-target);
            n = target;

            if (n < k) break;

            result += 1;
            n/=k;
        }

        result += (n - 1);
        System.out.println(result);

    }
}
'''

# 곱하기 혹은 더하기

'''
S = input()
# 처음에 들어오면 첫번째 녀석을 갖는다
result = int(S[0])


for i in range(1, len(S)):
    num = int(S[i])

    if num <= 1 or result <=1:
        result += num
    else:
        result *= num

print(result)
'''

'''
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        // 첫번째 문자를 숫자로 변경  첫번째 문자 - 아스키코드 0
        long result = str.charAt(0) - '0';
        for (int i=1; i<str.length(); i++){
            int num = str.charAt(i) - '0';
            if (num <=1 || result <=1){
                result += num;
            }else{
                result *= num;
            }

        }
        System.out.println(result);


    }


}
'''
N = int(input())
peer = list(map(int, input().split()))
peer.sort()

# 총 그룹의 수
result = 0
# 현재 그룹에 포함된 모험가의 수
count = 0

for i in peer:
    # 현재 그룹에 해당 모험가를 포함시키기
    count += 1
    # 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
    if count >= i:
        # 총 그룹 수 증가시키기
        result += 1
        # 현재 그룹에 포함된 모험가의 수 초기화
        count = 0

print(result)

'''
public class Main{
    public static int n;
    public static ArrayList<Integer> arrayList = new ArrayList<Integer>();


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++){
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);

        // 총 그룹의 수
        int result = 0;
        // 현재 그룹의 수
        int count = 0;

        for (int i=0; i<n; i++){
            count += 1;
            if (count >= arrayList.get(i)){
                result += 1;
                count = 0;

            }
        }

        System.out.println(result);
    }

}


'''









    















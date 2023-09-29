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
# TODO : 내일하기


S = list(map(int, input()))
# 처음에 들어오면 첫번째 녀석을 갖는다
current_char = S[0]
result = 0



for i in range(1, len(S)-1):
    if current_char == 0 or S[i] == 0:
        result = current_char + S[i]
    else:
        result = current_char * S[i]

    current_char = S[i]

print(result)




      


    















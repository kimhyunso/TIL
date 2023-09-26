numbers = list(map(int, input().split()))
N = numbers[0]
K = numbers[1]
k_num = 0


for i in range(1, N):
	if N % i == 0 & i == K:
		k_num = i


print(k_num)
numbers = list(map(int, input().split()))
N = numbers[0]
K = numbers[1]
k_num = 0


for i in range(1, N+1):
	if N % i == 0 and i == K:
		k_num = i
		break


print(k_num)
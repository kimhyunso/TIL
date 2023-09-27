N = int(input())
sequnce_list = list(map(int, input().split()))
result = []

for i in range(N):
    result.append(sequnce_list.pop())

print(*result)


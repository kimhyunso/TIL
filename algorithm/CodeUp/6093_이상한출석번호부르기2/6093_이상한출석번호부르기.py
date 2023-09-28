N = int(input())
call_number_list = list(map(int, input().split()))
result = []

for i in range(N):
    result.append(call_number_list.pop())


print(*result)
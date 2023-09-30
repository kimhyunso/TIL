N = int(input())
call_number_list = list(map(int, input().split()))
result = call_number_list[0]



for i in range(N-1):
    if result > call_number_list[i+1]:
        result = call_number_list[i+1]
 


print(result)

N = int(input())
call_number_list = list(map(int, input().split()))
students = [0 * _ for _ in range(23)]


for i in range(N):
    students[call_number_list[i-1]-1] += 1


print(*students)
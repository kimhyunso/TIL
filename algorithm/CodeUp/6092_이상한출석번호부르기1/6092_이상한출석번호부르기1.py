N = int(input())
call_number_list = list(map(int, input()))
students = [for _ in range(23)]


for i in range(N):
    students[i-1] += 1


print(students)
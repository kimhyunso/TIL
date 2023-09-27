number = list(map(int, input()))
result = ''

for n in range(len(number)):
    result += str(number.pop())



print(result)
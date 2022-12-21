import sys
import os
sys.stdin = open("input.txt")

def solved(numbers):
    result = 0
    for number in numbers:
        result += number

    return result = round(result / len(numbers))


T = int(input())

for tc in range(1, T + 1):
    numbers = list(map(int, input().split()))
    result = solved(numbers)
    print(f'#{tc} {result}')

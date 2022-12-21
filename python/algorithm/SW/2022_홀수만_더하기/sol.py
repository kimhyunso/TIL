import sys
sys.stdin = open('input.txt')

T = int(input())

def solve(numbers):
    result = 0
    for number in numbers:
        if number % 2:
            result += number
    return result

for tc in range(1, T+1):
    numbers = list(map(int, input().split()))
    result = solve(numbers)

    print(f'#{tc} {result}')


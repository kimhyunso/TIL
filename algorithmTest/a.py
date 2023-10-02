def bubbleSort(numbers):
    cnt = 0
    for i in range(len(numbers)):
        for j in range(len(numbers)-1):
            if numbers[i] < numbers[j+1]:
                numbers[i] = numbers[i] + numbers[j+1]
                numbers[j] = numbers[i] - numbers[j+1]
                numbers[i] = numbers[j] + numbers[j+1]
                cnt += 1
    return cnt

numbers = list(map(int, input().split()))
sortList = bubbleSort(numbers)
print(sortList)

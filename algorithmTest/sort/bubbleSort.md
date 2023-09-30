# bubbleSort O(n^2)
가장 좋지 않은 정렬기법이다.

```python
def bubbleSort(numbers):
    for i in range(len(numbers)):
        for j in range(len(numbers)-1):
            if numbers[i] < numbers[j+1]:
                numbers[i] = numbers[i] + numbers[j+1]
                numbers[j] = numbers[i] - numbers[j+1]
                numbers[i] = numbers[i] - numbers[j+1]

numbers = list(map(int, input().split()))
bubbleSort(numbers)
```

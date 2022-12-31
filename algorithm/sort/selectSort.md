# selectSort O(n^2)
```python
def selectSort(numbers):
    for i in range(len(numbers)):
        for j in range(i, len(numbers)):
            if numbers[i] < numbers[j]:
                numbers[i] = numbers[i] + numbers[j]
                numbers[j] = numbers[i] - numbers[j]
                numbers[i] = numbers[i] - numbers[j]

numbers = list(map(int, input().split()))
selectSort(numbers)
```


# quickSort O(NlogN)
보통은 재귀함수를 사용한다.
1. pivot 값을 정한다.
2. pivot 값을 기준으로 왼쪽과 오른쪽을 나눈다.
3. 왼쪽의 경우
   1. pivot 값을 정한다.
   2. pivot 값을 기준으로 왼쪽과 오른쪽을 나눈다.
4. 오른쪽의 경우
   1. pivot 값을 정한다.
   2. pivot 값을 기준으로 왼쪽과 오른쪽을 나눈다.
5. 반복한다.
6. 최종적으로 정렬된 리스트를 병합한다.

```python
def quick_sort(numbers):
    if len(numbers) <= 1:
        return numbers
    pivot = numbers[len(numbers) // 2]

    lesser_arr, equal_arr, greater_arr = [], [], []
    for num in numbers:
        if num < pivot:
            lesser_arr.append(num)
        elif num > pivot:
            greater_arr.append(num)
        else:
            equal_arr.append(num)
    return quick_sort(lesser_arr) + equal_arr + quick_sort(greater_arr)


for tc in range(1, T+1):
    N = int(input())
    numbers = list(map(int, input().split()))
    result = quick_sort(numbers)
    print(result)
```
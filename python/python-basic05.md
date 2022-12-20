# Value copy (Shallow Copy)
얕은 복사

1 차원
```python
import copy
# primitive 복사는 메모리 주소값이 따로 존재한다
num1 = 123
copy_num1 = num1
num2 = 'abcd'
copy_num2 = num2
num3 = True
copy_num3 = num3
num4 = None
copy_num4 = num4

# 1차원 복사
list_data = [1, 2]
copy_list_data = list_data[:]  # 밑에와 같은 결과
copy_list = copy.copy(copy_list)  # 위와 같은 결과

# reference 복사
list_data = [1, 2]
copy_list_data = list_data
dict_data = {'key':'value'}
copy_dict_data = dict_data
tuple_data = (1, 2,)
copy_tuple_data = tuple_data
def func(x):
    return x
```

# Referece Copy (deep Copy)
깊은 복사

2 차원 이상 사용
```python
import copy

list_data = [
    [1, 2, 3],
    [1, 2, 3],
]
copy_list = copy.deepcopy(list_data)
```

# 튜플, list
result = sum([1, 2, 3, 4])

print(result)


min_result = min(7, 3, 5, 2)
max_result = max(7, 3, 5, 2)

print(min_result, max_result)


result = eval('(3+5)*7')
print(result)

result = sorted([9, 1, 8, 5, 4])
reverse_result = sorted([9, 1, 8, 5, 4], reverse=True)

print(result)
print(reverse_result)

array = [('홍길동', 35), ('이순신', 75), ('아무개', 50)]
result = sorted(array, key=lambda x: x[1], reverse=True)
print(result)





from itertools import permutations, combinations, product, combinations_with_replacement


data = ['A', 'B', 'C']
result = list(permutations(data, 3))
print(result)



data = ['A', 'B', 'C']
result = list(combinations(data, 2))
print(result)


data = ['A', 'B', 'C']

result = list(product(data, repeat=2))
print(result)

data = ['A', 'B', 'C']

result = list(combinations_with_replacement(data, 2))
print(result)


from collections import Counter

counter = Counter(['red', 'blue', 'red', 'green', 'blue', 'blue'])

print(counter['blue'])
print(counter['green'])
print(dict(counter))


import math


def lcm(a, b):
    return a * b // math.gcd(a, b)

a = 21
b = 14

# 최대 공약수 
print(math.gcd(21, 14))
# 최소 공배수
print(lcm(a, b))













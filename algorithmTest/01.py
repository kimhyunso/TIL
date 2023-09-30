# 양의 정수
a = 1000
print(a)

# 음의 정수
a = -7
print(a)

# 0 
a = 0
print(a)


a = 777
print(a)

a = a + 5
print(a)

a = a - 3 
print(a)

# 실수형 데이터
# 양의 실수
a = 157.93
print(a)

# 음의 실수
a = -1837.2
print(a)

# 소수부가 0일 때 0을 생략
a = 5.
print(a)

# 정수부가 0일 때 0을 생략
a = -.7
print(a)

a = 1e9
print(a)

a = int(1e9)
print(a)

a = 0.3 + 0.6
print(a)

if a == 0.9:
    print(True)
else:
    print(False)


a = 0.3 + 0.6
print(round(a ,4))
if round(a, 4) == 0.9:
    print(True)
else:
    print(False) 

a = 7
b = 3

print(a / b)

print(a % b)

print(a // b)



print(a ** b)


a = [_ for _ in range(1, 10)]
print(a)

print(a[3])

# 크기가 N이고, 모든 값이 0인 1차원 리스트 초기화
n = 10
a = [0] * n
print(a)


a = [7, 3, 2, 5, 9]
#    0  1  2  3  4
print(a)

a[4] = 4
print(4)

a = [_ for _ in range(1, 10)]
print(a[7])


print(a[-1])

print(a[-3])

a[3] = 7
print(a)


print(a[3])

print(a[1:4])

array = [i for i in range(10)]

print(array)


array = [i for i in range(20) if i % 2 == 1]

print(array)


array = [i * i for i in range(1, 10)]
print(array)



n = 4
m = 3

array = [[0] * m for _ in range(n)]
print(array)



a = [1, 4, 3]
print('기본 리스트 : ', a)

a.append(2)
print('원소 삽입 : ', a)

a.sort()
print('오름차순 정렬 : ', a)

a.sort(reverse=True)
print('내림차순 정렬 : ', a)



a = [4, 3, 2, 1]

a.reverse()
print('원소 뒤집기 : ', a)


a.insert(2, 3)
print('인덱스 2에 3 추가', a)

print('값이 3인 데이터 개수 : ', a.count(3))


a.remove(1)
print('값이 1인 데이터 삭제 : ', a)

a = [1, 2, 3, 4, 5, 5, 5]
remove_set = {3, 5}

result = [i for i in a if i not in remove_set]
print(result)



data = 'Hello World'
print(data)

data = "Don't you know \"Python\""

print(data)




a = 'Hello'
b = 'World'
print(a + b)

a = 'String'
print(a * 3)

a = 'ABCDEF'
print(a[2 : 4])



# 불가능(Immutable) a[2] = 'bb'


a = (1, 2, 3, 4)

# 서로 다른 성질의 데이터를 묶어서 관리할 때, 사용 - 리스트 보다 메모리를 효율적으로 사용해야 할 때
print(a)
# 불가능(Immutable) a[2] = 1

data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
data['코코넛'] = 'Coconut'

print(data)

if '사과' in data:
    print('"사과"를 키로 가지는 데이터가 존재합니다.')



key_list = data.keys()

value_list = data.values()
print(key_list)

print(value_list)


b = {
    '홍길동' : 97,
    '이순신' : 98
}
print(b)



key_list = list(b.keys())
print(key_list)

print(b['이순신'])


data = set([1, 1, 2, 3, 4, 4, 5])
print(data)

data = {1, 1, 2, 3, 4, 4, 5}
print(data)


a = {1, 2, 3, 4, 5}

b = {3, 4, 5, 6, 7}

# 합
print(a | b)

# 교
print(a & b)

# 차
print(a - b)

data = {1, 2, 3}
data.add(4)
print(data)

data.update([5, 6])
print(data)

data.remove(3)
print(data)

# 사전 , 집합 순서가 없기 때문에 인덱싱 불가














































'''
# 오른쪽, 위쪽, 왼쪽, 아래쪽
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

# 현재 위치
x, y = 2, 2

for i in range(4):
    # 다음 위치
    nx = x + dx[i]
    ny = x + dy[i]
    print(nx , ny)
'''

'''

N = int(input())
matrix = [[0 for _ in range(N)] for _ in range(N)]
direction = list(map(str, input().split()))

dx = [0, 0, 0, 0]
dy = [0, 0, 0, 0]


x, y = 0, 0

'''

'''
n = 3
matrix = [[0 for i in range(n)] for i in range(n)]
count = 1



for i in range(n):
    for j in range(n, 0, -1):
        matrix[i][j-1] = count
        count += 1

    for k in range(n):
        print(matrix[i][k], end=' ')
    print()
'''


'''
n = int(input())
matrix = [[0 for _ in range(n)] for _ in range(n)]
count = 1


for i in range(n):
    for j in range(n):
        matrix[j][i] = count
        count += 1

for i in range(n):
    for  j in range(n):
        print(matrix[i][j], end=' ')
    print()
'''


'''
n = int(input())
matrix = [[0 for _ in range(n)] for _ in range(n)]
count = 1

for i in range(n):
    for j in range(n, 0, -1):
        matrix[j-1][i] = count
        count += 1

for i in range(n):
    for  j in range(n):
        print(matrix[i][j], end=' ')
    print()
    
'''


		
'''
n, m = map(int, input().split())
matrix = [[0 for _ in range(m)] for _ in range(n)]
count = n * m


for i in range(n):
	for j in range(m):
		matrix[i][j] = count
		count -= 1
		print(matrix[i][j], end=' ')

	print()
'''

'''
n, m = map(int, input().split())
matrix = [[0 for _ in range(m)] for _ in range(n)]
count = n * m


for i in range(n):
    for j in range(m-1, -1, -1):
        matrix[i][j] = count
        count -= 1
    
    for j in range(m):
        print(matrix[i][j], end=' ')

    print()
'''
'''
n, m = map(int, input().split())
matrix = [[0 for _ in range(m)] for _ in range(n)]
count = n * m

for i in range(m):
    for j in range(n):
        matrix[j][i] = count
        count -= 1


for i in range(n):
    for j in range(m):
        print(matrix[i][j], end=' ')
    print()
'''

'''
n, m = map(int, input().split())
matrix = [[0 for i in range(m)] for j in range(n)]

count = n * m


for i in range(m):
    for j in range(n-1, -1, -1):
        matrix[j][i] = count
        count -= 1



for i in range(n):
    for j in range(m):
        print(matrix[i][j], end=' ')
    print()

'''

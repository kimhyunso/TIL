N = 6
result = []

for i in range(N):
	bracket_list = list(map(str, input()))
	left_bracket = 0
	right_bracket = 0
	
	for bracket in bracket_list:
		if bracket == '(':
			left_bracket += 1
		else:
			right_bracket += 1
	if left_bracket == right_bracket :
		result.append('YES')
	else:
		result.append('NO')
		
for n in result:
	print(n)

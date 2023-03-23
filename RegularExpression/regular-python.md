# 정규표현식 - python

## `match(패턴, 문자열)`
> 패턴에 맞는 문자열 중 맨 앞 글자만 갖고 온다.
>
> 찾고자하는 문자열이 맨 앞에 위치에 있어야함
```python
# 정규표현식 라이브러리
import re
# match(패턴, 문자열)
# 패턴 중 가-힣만 찾는다. 찾고자하는 문자열이 맨앞에 있어야함
test = re.match('[가-힣]', 'ABCDabcd가나다')
# None
print(f'결과물 : {test} type : {type(test)}')

# 패턴 중 가-힣만 찾는다. 찾고자하는 문자열이 맨앞에 있어야함
test = re.match('[가-힣]', '가나다ABCDabcd')
# '가' 한개의 글자만 갖고옴
print(f'결과물 : {test[0]} type : {type(test)}')
```

## `search(패턴, 문자열)`
> `match()`와 유사
>
> 다른점 : 찾고자하는 문자열이 아무데나 있어도됨
```python
import re
# search(패턴, 문자열)
# 패턴 중 가-힣만 찾는다. 찾고자하는 문자열이 아무데나 있어도됨
test = re.search('[가-힣]', 'abcd가나라마마efg')
# '가' 한개의 글자만 갖고옴
print(f'결과물 : {test[0]} type : {type(test)}')
```


## `findall(패턴, 문자열)`
> 패턴을 통해 찾은 문자열을 list로 반환한다.
```python
import re
# findall(패턴, 문자열)
# 패턴 중 가-힣만 찾는다. 반환 : list
test = re.findall('[가-힣]', '테스트ABCD가나다라abcd')
# ['테', '스', '트', '가', '나', '다', '라']
print(f'결과물 : {test} type : {type(test)}')
```

## `finditer(패턴, 문자열)`
> 패턴을 통해 찾은 문자열을 iterator(반복자)로 반환한다.
```python
import re
# finditer(패턴, 문자열)
# 패턴 중 가-힣만 찾는다. 반환 : iterator(반복자)
test = re.finditer('[가-힣]', '테스트  ABCDab가나다라cd')
# 반복자는 반복문을 통해서 데이터를 가져와야함
for word in test:
    print(f'결과물 : {word[0]} type : {type(word)}')
```

## `fullmatch(패턴, 문자열)`
> 패턴에 완벽히 일치하는 문자열을 갖고온다.
```python
import re
# fullmatch(패턴, 문자열) :: 완벽히 일치해야함
# 패턴 중 가나다인 것만 추출한다.
test = re.fullmatch('가나다', '테스트 ABCDabcd')
# None
print(f'결과물 : {test} type : {type(test)}')

test = re.fullmatch('가나다', '가나다')
# '가나다'
print(f'결과물 : {test[0]} type : {type(test)}')
```

## `split(패턴, 문자열, 최대 split 수)`
> 패턴에 맞는 문자열을 없애서 '' (공백) 리스트 형태로 반환한다.
```python
import re
# split(패턴, 문자열, 최대 split수)
# 대문자, 소문자 A~Z까지 모든 영어를 기준으로 쪼갠다. 
test = re.split('[A-Za-z]', 'abaabaasabvaa테스트 데이터 ')
# ['', '', '', '', '', '', '', '', '', '', '', '', '', '테스트 데이터 ']
print(f'결과물 : {test} type : {type(test)}')

# 2개 이상부터는 쪼개지 않는다.
test = re.split('[A-Za-z]', 'abaabaasabvaa테스트 데이터 ', 2)
# ['', '', 'aabaasabvaa테스트 데이터 ']
print(f'결과물 : {test} type : {type(test)}')
```

## `sub(패턴, 교체할 문자열, 문자열, 최대 교체 수)`
> 패턴에 맞는 것을 문자열에서 찾은 후 교체할 문자열로 바꾼다.
```python
import re
# sub(패턴, 교체할 문자열, 문자열, 최대 교체 수)
# 대문자, 소문자 A~Z까지 '가'로 바꾼다.
test = re.sub('[A-Za-z]', '가', 'abcdefgABCD')
# ('가가가가가가가가가가', 10)
print(f'결과물 : {test} type : {type(test)}')

# 2개 이상부터는 바뀌지 않는다.
test = re.sub('[A-Za-z]', '가', 'abcdefg', 2)
# 가가cdefg
print(f'결과물 : {test} type : {type(test)}')
```

## `subn(패턴, 교체할 문자열, 문자열, 최대 교체 수)`
> 패턴에 맞는 것을 문자열에서 찾은 후 교체할 문자열로 바꾼다. 
> 
> 교체한 문자열 개수도 출력해줌
```python
import re
# subn(패턴, 교체할 문자열, 문자열, 최대 교체 수)
# 대문자, 소문자 A~Z까지 '가'로 바꾼 결과와 개수를 tuple로 출력한다.
test = re.subn('[A-Za-z]', '가', 'abcdefABCD')
print(f'결과물 : {test} type : {type(test)}')

# 2개 이상부터는 바뀌지 않는다.
test = re.subn('[A-Za-z]', '가', 'abcdefABCD', 2)
print(f'결과물 : {test} type : {type(test)}')
```


## `compile(패턴)`
> 미리 패턴을 지정해줌
```python
# compile(패턴)
# 패턴을 미리 지정해줌
test = re.compile('[A-Za-z]')
# 문자 대체
result = test.sub('가', 'abcd')
# '가가가가'
print(f'결과물 : {result} type : {type(result)}')
```
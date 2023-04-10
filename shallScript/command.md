# 변수
> `$`

```sh
#!/bin/sh
NAME="홍길동"
AGE=29
echo "name : $NAME, age : $AGE"
NAME="김갑자"
echo ${NAME}
```
# 입력
> `read`

```sh
#!/bin/sh

read NAME
echo "Hello! $NAME!"
```

# 출력
> `echo`


```sh
#!/bin/sh
echo "Hello World"
```

# 반복문
```sh
#!/bin/sh
for [변수명] in ({range} | [변수])
do
    [명령문]
done
```

# 명령문에서 Linux 명령어 사용 예시
```sh
#!/bin/bash
for var in {1..10} 
do
 	echo `mv "day $var.md" "day0$var.md"`
done
```







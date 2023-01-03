# 변수
> `$`

# 반복문
```sh
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







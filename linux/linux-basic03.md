<h2>특수접근 권한 : 확장퍼미션</h2>

맨 앞자리는 특수 접근 권한

setUID : 맨 앞자리 4

setGID : 맨 앞자리 2

스티키 비트 : 맨앞자리 1

<h3>setUID</h3>

해당 프로그램을 실행하는 동안 임시로 파일의 소유자의 권한을 프로그램을 수행

권한 - rwsrwxrwx

<h3>setGID</h3>

해당 프로그램을 실행하는 동안 임시로 파일의 소속 그룹의 권한으로 프로그램을 수행

권한 - rwxrwsrwx

<h3>setUID, setGID 설정하는 방법</h3>

보안취약함

1. 기호모드(심볼릭 방식)로 설정

   chmod u+s : setUID

   chmod g+s : setGID

2. 숫자모드(8진수 방식)

   chmod 4??? : setUID

   chmod 2??? : setGID

   chomd 0??? : Default

<h1>리눅스 명령어</h1>

chmod -R 755 [디렉토리]

파일, 하위디렉토리에 모두 적용

## sticky bit

디렉토리에만 설정 가능 [자료공유] 

스티키 비트가 설정된 디렉토리 내에 생성된 파일들은 소유자와 root외 다른 사용자는 삭제하지 못한다.

디렉토리에 쓰기 권한이 있는 경우 디렉토리에서 파일을 만들고 삭제하고 수정할 수 있다.

대표적인 예) /tmp

<b>chmod 1??? [디렉토리이름]</b>

권한 - rwxrwxrwt

<h3>참고</h3>

find / -perm -4000

find / -perm -2000

find / -perm -1000

find /  &#92;( -perm -4000 -o perm -2000  &#92;) -ls

<h1>프로세스</h1> 

부모 - 자식 관계

프로세스 시초 : systemd, kthreadd

자식 프로세스는 할 일이 끝나면 부모 프로세스에게 결과를 돌려주고 종료

<b>PID : 프로세스 고유번호</b>

<b>uuid : 장치의 고유번호</b>

<h3>프로세스 종류</h3>

1. 데몬프로세스

   백그라운드 서비스 

2. 고아 프로세스

   부모프로세스 종료 -> 자식프로세스 종료안됨 / 고아프로세스 -> systemd부모가 되어줌

3. 좀비 프로세스

   종료를 했는데 버그로 종료가 안됨 : defunct

<h2>프로세스 목록 보기</h2>

1. 유닉스(SVR4) 옵션 : ps -ef
2. BSD 옵션 : ps aux
3. GNU 옵션 : ps --pid

ppy : ? = 백그라운드 프로세스

<h3>Kill</h3>

프로세스에게 보낼 수 있는 시그널 정보

9 : 강제종료

<h3>TOP</h3>

PR, NI : 우선순위

SAWP : 가상메모리

프로세스 정보, CPU 사용량, 메모리 사용량, 좀비프로세서 확인 등등

<h2>포그라운드 백그라운드</h2>

포그라운드 : sleep 30

백그라운드 : sleep 30 &

<h3>jobs</h3>

백그라운드 작업을 모두 보여줌

Done : 종류

Terminated : 비정상적 종료

1. <b>포그라운드 작업 -> 일시정지 단축키 ctrl + z</b>
2. <b>ctrl + d : 정상종료</b>
3. <b>ctrl + c : 강제종료</b>

bg % [작업번호] : 백그라운드로 작업변환

fg % [작업번호] : 포그라운드로 작업변환

<h2>nohup</h2>

로그아웃한 이후에도 백그라운드 작업을 계속 실행한다.

nohup 명령어 &

<h2>스케쥴링</h2>

작업 예약

만든이 권한

1. at

   1회 예약

   at [시간] 

   at -l : 리스트, at -r [작업번호] : 작업 삭제

2. crontab

   반복 예약

   crontab -e
   
   [분] [시간] [일] [월] [요일] [명령어]
   
   crontab -l : 리스트, crontab -r  : 삭제

<h3>마운트</h3>

파티션[저장공간]과 디렉토리가 연결되는 과정

/etc/fstab 파일에 설정

<h3>마운트 포인트</h3>

파티션과 연결되는 디렉토리를 마운트 포인트라고 한다.

<h3>mount</h3>

mount -t [파일타입] -o [권한] /div/sr0 [마운트할 디렉토리]

blkid

lsblk -f



하드디스트, ssd : /dev/sd

/dev/sda : 전체 디스크

/dev/sda1 : 파티션 1

<h3>df -Th</h3>

디스크 정보 확인가능

df -h

<h1>RPM 패키지 설치</h1>

scp  : 원격 파일 복사

scp [파일이름] [아이디]@[IP | 도메인명]:[리눅스에 복사할 디렉토리]

rpm -Uvh

rpm -U : 설치 또는 업데이트

rpm -vh : 설치과정 보여줌

rpm -qa : 설치된 파일 정보들

rpm-e : 소프트웨어 삭제

<h1>yum & dnf 패키지 설치</h1>

repository를 가지고 있다. - 저장소

repository에서 설치파일을 가져와서 설치한다.

패키지 의존성을 해결함 (설치에 필요한 파일들을 자동으로 설치해줌 [반자동화])

우분트 : rpm -> deb, yum -> apt

yum info [소프트웨어이름] : 소프트웨어 정보확인

yum update : 모두 업데이트 / yum update [소프트웨어이름] : 해당 패키지만 업데이트

yum remove [소프트웨어이름] : 제거

 yum repolist : 저장소 정보확인 가능

<b>pstree : 프로세스들을 트리구조로 보여줌, pstree -p</b>

<h3>init 런레벨</h3>

0 : 시스템종료

1 : 단일 사용자 모드(긴급모드)

3 : CLI 모드

5 : GUI 모드

6 : 재시작

<h3>systemd 유닛</h3>

설정 값이 있는 텍스트파일

service : 데몬을 시작, 종료, 재시작을 관리함

<h3>systemctl 명령어</h3>

유닛을 관리하는 명령어

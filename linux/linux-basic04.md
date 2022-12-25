<h2>systemctl</h2>

systemctl -a : 모든 프로세스의 상태를 보여줌

systemctl status [유닛명] : 해당 프로세스의 상태 및 로그를 보여줌

systemctl start [유닛명] : 시작

systemctl stop [유닛명] : 멈춤

systemctl restart [유닛명] : 재시작

systemctl enable [유닛명] : 활성화

systemctl disable [유닛명] : 비활성화

<h3>runlevel</h3>

런레벨 확인가능

<h3>who -r</h3>

런레벨 확인가능

<h3>init</h3>

init [런레벨]

<h2>데몬 프로세스</h2>

1. 독자형

   서비스별로 항상 동작

2. 슈퍼데몬

   xinetd, inetd

   서비스 요청이 오면 해당 데몬을 동작시킴

<h3>Kthreadd</h3>

커널프로세스의 단군할아버지

<h1>파일 아카이브와 압축</h1>

파일 아카이브 : 여러 파일을 묶는 것

압축 : 파일 용량을 줄이는 것

<h3>tar : 파일을 묶는 것</h3>

마그네틱테이프 같은 이동식 저장장치에 보관하기 위해 사용하는 명령

tar cvf [만들 파일명] [묶을 파일명]

tar tvf [확인할 압축파일] : 파일안의 내용확인 

tar xvf [풀 압축파일]

<h3>아카이브 + 압축</h3>

tar czvf [파일명] [압축할 파일명] : [파일명].tar.gz = gzip

tar cjvf [파일명] [압축할 파일명] : [파일명].tar.bz2 = bzip2

<h3>압축</h3>

1. gzip, gunzip

   gzip [파일명] : tar 파일을 gzip파일로 압축해줌

   -l : 파일내요확인 옵션

   gunzip [파일명] : 압축해제

2. bzip2, bunzip2

   bzip2 [파일명] : tar파일을 bzip2 파일로 압축해줌

   bunzip2 [파일명] : 압축해제

3. zip, unzip

   zip : 압축 + 아카이브

   unzip : 압축해제

<h1>계정</h1>

1. /etc/passwd [주그룹 정보]

   0번 : 루트, 1000이상 : 사용자계정

   로그인ID : x : UID : GID : 설명 : 홈디렉토리 : 로그인 쉘

   로그인 ID가 다르더라도 UID로 판단한다.

   1. 로그인ID : 사용자 ID
   2. x : 패스워드(/etc/shadow) [보안]
   3. UID : 0~999번 + 65534번 시스템 사용자 (0:root, 1000이상 : 사용자계정)
   4. GID : 해당사용자가 소속해 있는 그룹번호 
   5. 설명 : 사용자의 정보기록
   6. 홈디렉토리 : 기본 홈디렉토리
   7. 로그인 셀 : 기본 셀

2. /etc/shadow

   패스워드를 보관하는 파일

   root 계정으로만 확인 가능

   로그인ID : 암호 : 최종변경일 : min : max : warning : inactive : expire : flag

   1. 로그인ID : 사용자 ID
   2. 암호 : 실제 비밀번호 저장(암호화)
   3. 최종변경일 : 암호를 마지막으로 변경한 날짜 1970년 1월 1일 기준
   4. MIN : 최소 기간 [패스워드를 변경한 후 다시 전의 패스워드로 바꾸는 것을 막기 위함]
   5. MAX : 최대기간 ex) 세달 마다 바꿔야한다.
   6. WARNING : 암호 만료되기 전, 경고를 시작하는 날 수
   7. INACTIVE : 암호 만료 후, 이 항목에 지정한 날 수만큼 로그인 가능
   8. EXPIRE : 사용자 계정이 만료되는 날
   9. FLAG : 안씀

3. /etc/login.defs

   계정이 생성될 때, 계정 관련된 기본 값을 정의

4. /etc/group 파일 [보조그룹정보]

   그룹 이룸 : x : GID : 그룹멤버(보조그룹)

   id [계정명] : 주그룹, 보조그룹 확인가능 - 주그룹과 보조그룹이 같으면 주그룹만 있고 보조그룹은 없는 것 

   (주그룹[UID] - 보조그룹[GID])

<h3>change -l root</h3>

1. 계정 만들기

   useradd : 계정만들기

   passwd : 비밀번호 생성

   su - [계정명] : 계정전환

2. 계정 수정하기

   usermod :  계정수정

3. 계정 삭제하기

   userdel : 계정삭제

   userdel -r : 홈디렉토리 같이 삭제

4. 그룹 만들기

   groupadd : 그룹 만들기

5. 그룹 수정하기

   groupmod : 그룹 수정

   groupmod -g : GID 수정

6. 그룹 삭제하기

   groupdel : 그룹 삭제

<h2>chage</h2>

계정의 설정값 변경 가능

<b>chage -l [계정명]</b>

EUID : 실제 사용되고 있는 권한 ex) passwd[비밀번호 변경]

<h3>who</h3>

<h3>w</h3>

<h3>last</h3>

최근 접속기록확인

<h3>who am i</h3>

UID 기준

<h3>id</h3>

UID 기준

who, w, last, who am i, id : 사용자 로그인 정보 확인하기

<h2>sudo</h2>

root 권한으로 명령어를 1번 실행할 수 있다.

<b>su - : 계정전환</b>

그룹 wheel : sudo를 가능하게 함

/etc/sudoers

[계정명]           ALL=(ALL)          [NOPASSWD : ALL | ALL]

<h3>passwd</h3>

passwd -l [사용자계정] : 계정을 잠금

passwd -u [사용자계정] : 계정을 잠금

<h2>chown</h2>

소유자를 변경하는 명령어

chown [소유자명] [그룹명] [파일]

chown -R [소유자명] [그룹명] [파일명] : 하위디렉토리 소유자, 그룹 전부 변경

var/www/html : 웹페이지 저장소

<h2>XPRESS ENGINE</h2>

LINUX

APACHE

MYSQL -> MARIADB

PHP

AMP로 웹사이트 구축

<h3>방화벽열기</h3>

firewall-cmd --permanent --add-service=http

firewall-cmd --permanent --add-service=80

firewall-cmd --reload : 재시작 후 적용됨






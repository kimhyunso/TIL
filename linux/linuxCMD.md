# 리눅스 명령어



| 명령어                                | 설명                          | 옵션                           | 옵션설명                                                     | 예시                                                         |
| :------------------------------------ | ----------------------------- | ------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| cd                                    | Change Drectory               |                                |                                                              | `$ cd linux`                                                 |
| mv                                    | File, Folder 이동, or 이름 변경             |                                |                                                              | `$ mv File1 File2`                                           |
| cp                                    | Copy And Paste                | -r                             | -r 폴더 복사                                                 | `$ cp File1 File2 `                                          |
| rm                                    | Remove File                   | -r, -f                         | -r 폴더삭제, -f  강제삭제                                    | `$ rm RemoveFile`                                            |
| ssh                                   | Remote Connection             |                                |                                                              | `$ ssh root@IP`                                              |
| scp                                   | Remote File Copy And Paste    |                                |                                                              | `$ scp TransFile root@IP:/Directory `                        |
| ls                                    | File,Folder List              | -l, -d , -a                    | -l 상세히, -d 디렉토리, -a 숨김파일                          | `$ ls -l`                                                    |
| sytemctl                              | System Service Control        | start, enable, stop, disable   |                                                              | `$ systemctl start httpd`<br />`$ systemctl enable httpd`    |
| id                                    | UID GID check                 |                                |                                                              | `$ id root`                                                  |
| chmod                                 | Authorization                 | -wrx wrx wrx                   | sticky bit                                                   | `$ chmod 7777 File`                                          |
| which                                 | File Location                 |                                |                                                              | `$ which ls`                                                 |
| find                                  | Find File, Search File        | -name                          |                                                              | `$ find /Directory -name "*.txt"`                            |
| grep                                  | Find Text in File             |                                |                                                              | `$ grep Text File`                                           |
| cat                                   | View TextAll in File          |                                |                                                              | `$ cat File`                                                 |
| more                                  | 지정한만큼 볼 수 있음         | -                              |                                                              | `$ more -10 File`                                            |
| tail                                  | 일정 뒷부분만 보기            |                                |                                                              | `$ tail File`                                                |
| man                                   | CMD Manual                    |                                |                                                              | `$ man cat`                                                  |
| diff                                  | 파일, 폴더 공통점 차이점 비교 |                                |                                                              | `$ diff oldFile newFile`                                     |
| mkdir                                 | Create Directory              |                                |                                                              | `$ mkdir Directory`                                          |
| sudo                                  | root Authority                |                                |                                                              | `$ sudo cat /etc/shadow`                                     |
| ifconfig                              | IP 정보 확인                  |                                |                                                              | `$ ifconfig`                                                 |
| ip addr                               | IP 정보 확인                  |                                |                                                              | `$ ip addr`                                                  |
| route                                 | 라우팅 테이블 확인            |                                |                                                              | `$ route`                                                    |
| netstat                               | 네트워크 정보 확인            |                                |                                                              | `$ netstat`                                                  |
| yum install                           | 설치 파일 인스톨              | -y                             | -y 동의                                                      | `$ yum -y docker-ce install`                                 |
| zip                                   | zip파일 압축                  |                                |                                                              | `$ zip File.zip File1 File2`                                 |
| unzip                                 | zip파일 해제                  |                                |                                                              | `$ unzip File.zip`                                           |
| tar                                   | 파일 묶기                     | -cvf, -tvf, -xvf, -czvf, -cjvf | -cvf 파일묶기, -tvf 묶인 파일내용확인, -xvf 묶은 파일 풀기, -czvf 아카이브+압축.tar.gz, -cjvf 아카이브+압축.tar.bz2 | `$ tar -cvf makeFile file1 file2`<br />`$ tar -tvf file.tar`<br />`$ tar -xvf file.tar` |
| top                                   | 실시간 프로세스 정보확인      |                                |                                                              | `$ top`                                                      |
| kill                                  | 프로세스 죽이기               | 9                              |                                                              | `$ kill 1234`                                                |
| &                                     | 프로세스 백그라운드           |                                |                                                              | `$ sleep 30`<br />                                           |
| ln                                    | 하드링크, 심볼릭링크 생성     | -s                             | -s 심볼릭 링크                                               | `$ ln File hardLink`<br />`$ ln -s file link`                |
| touch                                 | 파일생성                      |                                |                                                              | `$ touch newFile`                                            |
| echo                                  | 문자를 화면에 출력            | >, >>                          | 리다이렉트                                                   | `$ echo "text" > file`<br />`$ echo "newText" >> file`       |
| /div/null                             | 쓰래기통                      |                                |                                                              | `$ echo HelloLinux > /dev/null`                              |
| export                                | 환경변수 설정                 |                                |                                                              |                                                              |
| ;, \|, &&, \|\|                       | 명령어 연속실행               |                                |                                                              | `$ cat log | grep test`<br />`$mv file1 file2 ;  `           |
| who                                   | 런레벨 확인                   | -r                             |                                                              | `$ who -r`                                                   |
| init                                  | 런레벨로 실행                 |                                |                                                              | `$ init 4`                                                   |
| gzip                                  | tar 파일을 gzip 파일로 압축   | -l                             |                                                              | `$ gzip file.tar`                                            |
| gunzip                                | gzip 파일 압축해제            |                                |                                                              | `$ gunzip file.tar.gzip`                                     |
| bzip2                                 | tar 파일을 bzip2 파일로 압축  |                                |                                                              | `$ bzip2 file.tar`                                           |
| bunzip2                               | bzip2 파일 압축해제           |                                |                                                              | `$ bunzip2 file.tar.bzip2`                                   |
| useradd                               | 계정만들기                    |                                |                                                              | `$ useradd user1`                                            |
| usermod                               | 계정 수정                     | -l                             | -l 아이디 변경                                               | `$ usermod -l user1 moduser `                                |
| userdel                               | 계정 삭제                     | -r                             | -r 계정 홈디렉토리 같이삭제                                  | `$ userdel -r user1`                                         |
| groupadd                              | 그룹 생성                     |                                |                                                              | `$ groupadd myGroup`                                         |
| groupmod                              | 그룹 수정                     | -g, -n                         | -g GID수정 -n 새그룹명                                       | `$ groupmod -g 510 -n newGroup myGroup `                     |
| groupdel                              | 그룹 삭제                     |                                |                                                              | `$ groupdel myGroup`                                         |
| last                                  | 최근 접속한 기록 확인         |                                |                                                              | `$ last`                                                     |
| change                                | 암호를 주기적으로 변경 가능   | -l                             | -l 비번 변경일, 유효기간 등확인 가능                         | `$ change -l user1`                                          |
| passwd                                | 비번 설정 및 변경             |                                |                                                              | `$ passwd user1`                                             |
| chown                                 | 소유자 변경                   | -R                             | -R 하위디렉토리까지 전부 변경                                | `$ chown -R user1 myGroup file`                              |
| firewall-cmd-permanent --add-service= | 방화벽 열기                   |                                |                                                              | `$ firewall-cmd --permanent --add-service=http`              |










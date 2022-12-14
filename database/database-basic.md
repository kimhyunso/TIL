# 데이터 조작어(DML :  Data Manipulation Language)
|명령어|설명|예시|
|-|-|-|
|SELECT|조회 및 검색|`select * from [테이블] where [조건]`|
|INSERT|삽입|`insert [테이블] into (colnum1, colnum2, colnum3) values('value1','value2','value3')`|
|UPDATE|갱신|`update [테이블] set colnum = 'newValue' where [조건]`|
|DELETE|삭제|`delete from [테이블] where [조건]`|



# 데이터 정의어 (DDL : Data Definition Language)
|명령어|설명|예시|
|-|-|-|
|CREATE|테이블 생성|`create [테이블]([타입][이름][조건],[타입][이름][조건]...)`|
|ALTER|테이블 변경 [컬럼 추가]|`alter talbe [테이블] add column [이름] [타입] [조건]`|
|ALTER|테이블 변경 [컬럼 변경]|`alter talbe [테이블] modify column [변경이름] [변경타입] [변경조건]`|
|ALTER|테이블 변경 [컬럼 삭제]|`alter talbe [테이블] drop column`|
|ALTER|테이블 변경 [테이블이름변경]|`alter talbe [테이블] change column [변경이름] [타입] [조건]`|
|ALTER|테이블 변경 [칼럼이름변경]|`alter talbe [테이블] rename [new테이블명]`|
|DROP|테이블 삭제|`drop [테이블]`|


# 데이터 제어어 (DCL : Data Control Language) 
|명령어|설명|예시|
|-|-|-|
|GRANT|권한부여 [로컬]|`GRANT ALL PRIVILEGES ON [DB명.테이블명] TO [user@host] IDENTIFIED BY 'password'`|
|GRANT|권한부여 [아이피]|`GRANT ALL PRIVILEGES ON [DB명.테이블명] TO user@192.168.0.100 IDENTIFIED BY 'password';`|
||권한 적용|`FLUSH PRIVILEGES`|
|REVOKE|권한해제 [삽입, 갱신, 생성]|`REVOKE insert, update, create ON [DB명.테이블명] TO [user@host]`|
|REVOKE|권한해제 [ALL]|`REVOKE ALL ON [DB명.테이블명] TO [user@host]`|
||권한확인|`SHOW GRANTS FOR [user@host]`|


# 트랜잭션 제어어 (TCL : Transaction Control Language)
|명령어|설명|예시|
|-|-|-|
|COMMIT|작업 내용을 물리적 디스크로 저장/적용|`commit`|
|ROLLBACK|commit을 사용하지 않았다면, 이전 상태로 되돌림|`rollback`|

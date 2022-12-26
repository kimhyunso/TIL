# docker

가상화 기술의 발전

높은 이식성

환경에 구애받지 않는다. ex) 언어 version

이미지 저장소 : 레지스트리(Registry) - 도커허브[Repository]

# 가상화

1. 네이티브 / 베어메탈

   비어있는 하드웨어에 하이퍼바이저 설치 후 가상머신 설치

   자원소모 호스트 가상화보다 덜함

2. 호스트 가상화

   운영체제 위에 하이퍼바이저 설치 후 가상머신 설치

   ex) workstation wmware

3. 컨테이너 가상화

   논리적으로 격리된 구역을 분리된 서버처럼 만드는 가상화기법

<h3>장점</h3>

1. 게스트 운영체제 불필요
2. 이식성
3. 상호운용성

<h3>주요기능</h3>

1. 이미지 생성 및 관리
2. 이미지 공유
3. 컨테이너 동작

<h3>OverlayFS</h3>

cow 방식

<h1>docker 명령어</h1>

1. docker search [검색할 이미지명]

   찾은 이미지 Repository 보여줌

2. docker pull [이미지명]

   이미지 다운로드

3. docker tag

   도커 태그 변경, 이름 변경 가능

4. docker rmi

   도커이미지 삭제

5. docker push [이미지이름]

   도커 이미지 업로드

6. docker ps

   컨테이너 정보확인

   docker ps -a : 실행 중이지 않는 모든 컨테이너 확인

7. docker inspect [이미지이름]

   컨테이너 자세한 정보출력

   이미지 + 컨테이너 + 네트워크 + 볼륨 = docker object

8. docker run --name [이름] [이미지]

   일반적인 컨테이너 포그라운드 실행

   컨테이너 만들고 시작함(이미지가 없으면 해당 이미지를 레지스트리에서 검색 후 다운)

   docker pull +docker create + docker start = run

   -it : input, output 운영체제 컨테이너를 포그라운드로 실행

   -d : 백그라운드 시작

9. docker stop

   도커 멈추기

10. docker rm [컨테이너이름] : 정지한 컨테이너만 삭제

    -f : 컨테이너 무조건 삭제

11. docker attach [컨테이너이름], docker exec [컨테이너이름] [명령어]

    컨테이너 접근 : 주로 운영체제

12. docker rename [이름] [새이름]

    컨테이너이름바꿀때 사용

13. docker cp 

    호스트 -> 컨테이너 파일복사

    컨테이너 -> 호스트 파일복사

14. docker diff

    A : 추가되었다

    D : 삭제되었다

    C : 기존 디렉토리가 변경되었다.

15. dockerfile

<h1>컨테이너 네트워크</h1>

도커 오브젝트 : 네트워크 + 볼륨 + 컨테이너 + 이미지

1. bridge
2. host
3. null

docker network create

--subnet 192.168.0.0/24 --gateway 192.168.0.254 [네트워크이름]

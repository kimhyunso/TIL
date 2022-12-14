<h1>docker network</h1>

네트워크 오브젝트 : 브릿지, 호스트, NULL
네트워크 기능 : link, 포트포워딩

도커 오브젝트 : 이미지, 컨테이너, 네트워크, 볼륨

<h3>host</h3>

외부에서 컨테이너를 접속 가능

포트 중복 불가

run -d --net host --name [컨테이너 이름] [이미지이름]

<h3>curl -L</h3>

WorkingDir : 현재 디렉토리

Entrypoint : 지정한 명령을 수행

<h3>none</h3>

아무 네트워크도 할당하지 않겠다.

통신하면 안되는 컨테이너 할당 시 설정

run -d --net none --name [컨테이너 이름] [이미지이름]

<h3>링크기능</h3>

컨테이너 끼리 통신하기 위함

컨테이너는 IP를 동적으로 받아오기 때문에 항상 일치하지 않음

컨테이너가 IP가 동적으로 변경되어도 통신이 유지되도록 하는 기능

호스트 이름으로 접근

docker run -d --name [컨테이너이름] --link [컨테이너 이름] [이미지 이름]

양방향 아님

별칭 지정 가능

docker run -d --name [컨테이너이름] --link [컨테이너이름]:[별칭] [이미지이름]

<h3>포트포워딩</h3>

외부에서 컨테이너에 접근하기 위해 사용하는 방식

방화벽을 자동으로 열어준다

docker run -d -p 8080:80 --name [컨테이너이름] [이미지이름]

<h2>볼륨</h2>

저장장소

컨테이너 : 휘발성메모리

데이터가 날아가지 않게 컨테이너의 디렉토리와 호스트 볼륨저장장치와 마운트하는 작업

컨테이너 파일 -> 컨테이너 레이어 저장 [컨테이너와 함께 삭제됨]

1. Bind Mount

   초기 도커부터 사용했던 방식

   호스트 특정 디렉토리와 컨테이너의 디렉토리를 연결하는 방식

   관리 효율좋지 않음, 보안성 낮음

2. 볼륨

   Monutpoint : 실제저장공간 디렉토리

   docker run -d --name [컨테이너이름] -v [볼륨이름]:[마운트할 디렉토리]:[권한] [이미지이름]

<h2>환경변수</h2>

run -it -e [설정할 변수] -e [설정할 변수] --name [컨테이너이름] [이미지이름] 

이미지를 제작할 때 패스워드 같은 환경변수를 설정하기 위해 사용 : ex) DB설정

<h3>로그</h3>

docker logs db1

<h3>컨테이너 자원할당</h3>

docker run -d --name [컨테이너이름] --memory="200m" [이미지이름]

docker update

docker run -d  --name  [컨테이너이름] --cpus 0.3 [이미지이름]

<h1>dockerfile</h1>

이미지를 제작할 수 있다.

코드 형태의 텍스트 문서

FROM : 베이스 이미지 지정

<h3>볼륨삭제</h3>

docker volume rm [볼륨이름]

docker rm -vf [컨테이너 이름]

<h4>모든 컨테이너 삭제</h4>

docker 

<h4>모든 볼륨 지우기</h4>

docker volume prune

docker run --name [컨테이너 이름] -rm [이미지이름]

<h1>AWS</h1>

big-camp

bc_hskim



IaaS : OS

PaaS : OS + 플랫폼

SaaS : OS + 플랫폼 + 소프트웨어

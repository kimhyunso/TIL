# 프로젝트 만들기
`django-admin startproject <mysite>`


# 프로젝트 앱 만들기
`python mange.py startapp <appname>`

# MTV 패턴
mvc 패턴과 동일

Model : 데이터

Templates : 뷰(html)

Controller : 데이터와 뷰를 이어주는 매개체

# URL 요청 시
1. URL을 갖고 마스터 `urls.py`에게 가서 찾아서 app폴더에 보냄
2. URL을 갖고 app폴더에서 `urls.py`을 찾음, `views.py`로 보냄
3. `views.py`에서 함수를 실행시킴
4. 함수에서 html을 response시, app폴더에서 templates를 찾는다.

# 중복 HTML
> settings => TEMPLATES in 'DIRS' 추가
> 
> 'DIRS' : BASE_DIR/'폴더명'


# template tag
`{% block %}` `{% endblock %}`

`{{ variable }}` `{for }` `{if}`
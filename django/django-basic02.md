# app_name
django가 보는 templates가 공통되기 때문에 templates에 같은 html이 있다면 먼저 인식된 app의 HTML이 실행되는 것을 방지하기 위해 사용한다.

태그명
```python
from django.urls import path
from . import views

app_name = 'data'

urlpatterns = [
    path('', views.index, name='index'),
]
```

```HTML
{% include 'base.html' %}

{% block content %}
    <h1>Review/Hello</h1>
    <a href="{% url 'review:index' %}">review/index</a>
{% endblock content %}
```


# Variable Routing
```python

from django.urls import path
from . import views

app_name = 'data'

urlpatterns = [
    # data/
    path('', views.index, name='index'),
    # data/input/
    # data/hello/<name>/ => Variable Routing
    # hello/neo/ => 안녕 neo,
    # hello/andy/ => 안녕 andy,
    # data/hello/
    path('hello/<str:name>/', views.hello, name='name'),
]

```

# HTML Form 데이터 받아오기
1. request.POST
2. request.GET

## get방식
DB에 변경사항이 없을 경우의 요청 (R)
```python
def get_html(request):
    context = {
        'data' : data,
    }
    return render(request, 'index.html', context)
```

## post방식 : csrf_token
1. DB에 변경사항이 있을 경우 (C, U, D)
2. 복제 방지 token사용해야함
```html
<form action="url" method="post">
    {% csrf_token %}
</form>
```

```python
def user_output(request):
    context = {
        'username' : request.POST['username'],
    }
    return redirect('url')
```

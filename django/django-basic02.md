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

## post방식 : csrf_token
복제 방지 token
```python
def user_output(request):
    context = {
        'username' : request.POST['username'],
        'password' : request.POST['password'],
    }
    return render(request, 'data/user_output.html', context)
```

```HTML
{% include 'base.html' %}
{% block content %}
<h1>User Input</h1>
{% comment %} post => csrf_token 필수 {% endcomment %}
<form action="{% url 'data:user_output' %}" method="post">
    {% csrf_token %}
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit">
</form>

{% endblock content %}
```
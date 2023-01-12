# ORM (Object Relation Mapper)
DB와 Server언어를 연결해주는 중계자

> Server => ORM => DB
> 
> Server <= ORM <= DB

# Create (생성)
```python
from board.models import Article
article = Article()
article.title = '1번글'
article.content = '내용'
article.author = '작성자'
article.save()

# 만듬과 동시에 save()
article = Article.objects.create(title='제목', content='내용', author='작성자')
```
# Read (조회)
```python
from board.models import Article
# 단일 조회
## objects => 매니저
Article.objects

article = Article.objects.get(id=1)
article = Article.objects.get(pk=1)
article.title
article.content
article.id

# 전체 조회
articles = Article.objects.all()
for article in articles:
    print(article.title)
```
# Update (수정)
**수정해야할 한 가지의 객체를 가져와야한다.**
```python
# Update (수정)
article = Article.objects.get(id=1)
article.title = 'tests'
article.content = 'content update'
article.save()
```
# Delete (삭제)
**수정해야할 한 가지의 객체를 가져와야한다**
```python
article = Article.objects.get(id=1)
article.delete()

# Delete (삭제)
Article.objects.get(id=1).delete()
```

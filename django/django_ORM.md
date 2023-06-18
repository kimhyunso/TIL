# ORM (Object Relational Mapping)
> model.py에 정의된 모델을 통해 CRUD 쿼리를 직접 사용하지 않고 데이터를 가져올 수 있다.
>

## Insert

```python
from .models import Book, Article
from django.views.decorators.http import require_http_methods
from django.core.files.storage import FileSystemStorage

@require_http_methods(['POST'])
def save(request):
    data = request.POST.get('formData')

    error_message = "파일형식이 잘못되었습니다"
    context = {
        'message' : error_message,
    }
    STATUS = 400
    fs = FileSystemStorage()

    file_data = request.FILES['bookCover']
    allowed_extensions = ['png', 'jpg', 'jpeg', 'bmp']
    file_extension = emp_img.name.split('.')[-1].lower()

    if file_extension not in allowed_extensions:
        return JsonResponse(context, status=STATUS)

    book = Book()
    book.title = data['title']
    book.comment = data['comment']
    book.author = data['author']
    book.bookCover = file_data
    book.save()
```


## Select

# HTML
인터넷에서 서로 주고 받을 수 있는 문서를 작성하는 도구

# HyperText
링크 이동 가능한 문서(글)

# Markup
역활

# head
외부파일의 참조, 메타데이터의 설정

# 요청
URL을 통해 서버에게 요청한다.
1. get
2. post

# element
opening tag + closing tag

# attribute
속성값 할당 가능

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>attribute</title>
</head>
<body>
    <!-- attribute -->
    <a href="https:google.com" target="_blank">구글 바로가기</a>
</body>
</html>
```

# global attribute
```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>attribute</title>
</head>
<body>
    <!-- global attribute -->
    <div>
        <label for="my-name">이름 : </label>
        <input type="text" id="my-name">
    </div>

    <div>
        <label for="my-email">이메일 : </label>
        <input type="email" id="my-eamil">
    </div>
</body>
</html>
```

# 시맨틱 웹
태그를 좀 더 직관적으로 의미있는 것으로 기술하자

`<b></b>` 대신 `<strong></strong>` 사용

`<i></i>` 대신 `<em></em>` 사용

`<div></div>` 대신 `<nav></nav>`, `<header></header>`, `<aside></aside>`, `<section></section>`, `<article></article>`, `<footer></footer>`, `<section></section>`

## 검색 엔진 최적화(SEO)

# Emmet

# 웹 접근성
웹을 접근하지 못하는 사람들을 위해서 좀 더 신경써서 쉽게 접근 할 수 있도록 만들어야 한다.

# block과 inline
`block` : 다음 요소(element)가 다음줄로 내려감

`inline` : 다음 요소가 같은 줄에 진행됨

# web 1.0 web 2.0 web 3.0 차이
> web 1.0 : read only 참여불가
>
> web 2.0 : 사용자가 작성가능 (데이터 중앙화) 참여가능
>
> web 3.0 : 탈중앙화, 블록체인 (데이터 탈중앙화) 지분가능



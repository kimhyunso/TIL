# 선택자
HTML 요소를 선택해 변경함
```css
.green-small{font-size:30px; color:green;}
```

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>css intro</title>
    <style>
        /* 선택자 (셀렉터) */
        /* 연쇄작용 cascading style sheet */
        /* p {color:red; font-size:20px;} */
        p.medium-blue{color:blue; font-size:30px;}
    </style>
    <!-- file link .css -->
    <link rel="stylesheet" href="./00_intro.css">
</head>
<body>
    <!-- CSS 적용 3가지 방법 -->
    <!-- inline css -->
    <p style="color:red; font-size:25px;">This is Big Red</p>
    <!-- Head Style Tag -->
    <p class="medium-blue">This is Medium Blue</p>
    <!-- File css -->
    <p class="small-green">This is Small Green</p>
    <div class="medium-blue">
        Div & Medium-blue
    </div>
    <div class="small-green">
        Div & Small-green
    </div>
</body>
</html>
```

# property
```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>css intro</title>
    <style>
        /* 선택자 {property}*/
        p {color:red; font-size:20px;}
    </style>
</head>
<body>
    <!-- CSS 적용 3가지 방법 -->
    <!-- inline css -->
    <p>This is Big Red</p>
    <!-- Head Style Tag -->
    <p>This is Medium Blue</p>
    <!-- File css -->
    <p>This is Small Green</p>
</body>
</html>
```

# 셀렉터의 종류
1. 전체셀렉터
2. 태그 셀렉터
3. ID 셀렉터
4. 클래스 셀렉터
5. 어트리뷰트 셀렉터
6. 복합셀렉터
   1. 후손 셀렉터
   2. 자식 셀렉터
   3. 형제 셀렉터
7. 가상 클래스 셀렉터
8. 가상 요소 셀렉터
```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>css intro</title>
    <style>
        /* 연쇄작용 cascading style sheet */
        /* 전체셀렉터 */
        *{color:black; font-size:15px;}
        /* 태그셀렉터 */
        p{color:green; font-size:20px;}
        /* ID셀렉터 [잘하지 않음]*/
        /* #red{color:red; font-size:25px;} */
        /* 클래스셀렉터 */
        .blue{color:blue; font-size:17px;}
        /* class 어트리뷰트 값이 container인 모든 요소를 선택 */
        .container{color:blue; font-size:12px;}
        .big{font-size:24px;}
        /* 어트리뷰트 셀렉터 */
        a[href]{color:yellow; font-size:30px;}
        /* 가상 클래스 셀렉터 */
        a:hover { color: red; }
    </style>
</head>
<body>
    <div class="container">
        직계자손
        <p class="big">P1 입니다.</p>
        <p>P2 입니다.</p>
    </div>
    <!-- CSS 적용 3가지 방법 -->
    <!-- inline css -->
    <p id="red">This is Big Red</p>
    <!-- Head Style Tag -->
    <p class="blue">This is Medium Blue</p>
    <!-- File css -->
    <p>This is Small Green</p>
    <a href="https:google.com">구글바로가기</p>
</body>
</html>
```

# 크기
1. px : 절대값 
2. em : 상속값 * 1.2 = 상대값 (%)
3. rem : 최상위 요소의 사이즈 기준 상대값

## viewport
1. vw : 너비의 1/100
2. vh : 높이의 1/100
```HTML
<!DOCTYPE html>
<html>
<head>
  <style>
    body { margin: 0px; }
    .item {
      width: 50vw;
      height: 100vh;
    }
    .item1{background:red;}
    .item2 {background-color: orange;}
  </style>
</head>
<body>
  <div class='item item1'>item1</div>
  <div class='item item2'>item2</div>
</body>
</html><!DOCTYPE html>
<html>
<head>
  <style>
    body { margin: 0px; }
    .item {
      width: 50vw;
      height: 100vh;
    }
    .item1{background:red;}
    .item2 {background-color: orange;}
  </style>
</head>
<body>
  <div class='item item1'>item1</div>
  <div class='item item2'>item2</div>
</body>
</html>
```

# padding, margin, border

```HTML
<!DOCTYPE html>
<html>
  <head>
    <style>
      div {
        padding:25px;
        border: 25px solid red;
        margin: auto;
      }
    </style>
  </head>
  <body>
    <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
  </body>
</html>
```

# box-sizing
박스의 margin, padding, width 를 합한 값이 width 값이다

```HTML
<!DOCTYPE html>
<html>
  <head>
    <style>
        /* 600 + 50*4 + 10 = 810px */
      .content-box {
        width: 600px;
        border: 10px solid;
        padding: 50px;
        margin: 50px;
        background-color: red;
      }
      /* 총합 : 600px */
      .border-box {
        box-sizing: border-box;
        width: 600px;
        border: 10px solid;
        padding: 50px;
        margin: 50px;
        background-color: red;
      }
    </style>
  </head>
  <body>
  <div class="content-box">content-box</div>
  <div class="border-box">border-box</div>
</body>
</html>
```

# display
1. inline
> 가로 화면이 끝날때까지 이어진다.
2. block
> 다음 줄로 넘어간다.

# flex
Main Axis(주축) : 가로
Cross Axis(교차 축) : 세로

## 주축을 움직임
`justify-content`
## 교차 축을 움직음
`align-items`
## 방향을 바꿈 주축, 교차축을 바꿈
`flex-direction : column` - 주축을 교차 축과 변경

`flex-direction : row` - 주축이 가로

`flex-direction : row-reverse` - 주축을 왼쪽에서 오른쪽으로 변경

`flex-direction : colum-reverse` - 주축과 교차 축을 변경하고 주축을 밑에서 위로 바꿈









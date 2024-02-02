# HTML / CSS

- html 파일 기본 구조

    ```html
    <!DOCTYPE html>
    	<head>
    		<----!내용 입력!--->
    	</head>
    	<body>
    		<----!내용 입력!--->
    	</body>
    </html>
    ```

- CSS

    ```css
    body,h1,h2 {
        margin:0px;
        padding:0px;
    }
    ```


## 이력서 만들기

- index.html

    ```html
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>김멋사의 이력서</title>
        <link rel="stylesheet" href="codelion.css">
    </head>
    <body>
    <div class="mainbox">
        <div class="title-box">
            <h1>김멋사</h1>
            <p class="name-text">HTML/CSS 개발자</p>
        </div>
        <section>
            <h2>ABOUT ME</h2>
            <p class="about-me-text">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
        </section>
        <section>
            <h2>EXPERIENCE</h2>
            <div class="float-wrap">
                <p class="title-text">Awesome Programming Company</p>
                <p class="year-text">2020 - Now</p>
            </div>
            <p class="desc-text">Front-End Web Developer</p>
            <p class="desc-subtext">HTML/CSS, JS, React, ...</p>
            <div class="float-wrap">
                <p class="title-text">Ministry of Health</p>
                <p class="year-text">2015 - 2018</p>
            </div>
            <p class="desc-text">UI/UX Designer</p>
            <p class="desc-subtext">Web design</p>
            <div class="float-wrap">
                <p class="title-text">Freelance Work</p>
                <p class="year-text">2011 - 2015</p>
            </div>
            <p class="desc-text">Graphic Designer</p>
            <p class="desc-subtext">Graphic Design, Editorial Design</p>
        </section>
    
        <section>
            <h2>ACTIVITIES</h2>
            <div class="float-wrap">
                <p class="title-text">Front-End Web Developer Forum Volunteer</p>
                <p class="year-text">2019 - 2020</p>
            </div>
            <p class="desc-text">Application Page Development</p>
            <p class="desc-subtext">Lorem ipsum dolor sit amet.</p>
            <div class="float-wrap">
                <p class="title-text">LIKELION SEOUL</p>
                <p class="year-text">2017 - 2018</p>
            </div>
            <p class="desc-text">Teacher in Mutsa University</p>
            <p class="desc-subtext">Lorem ipsum dolor sit amet.</p>
            <div class="float-wrap">
                <p class="title-text">Open Source Committer</p>
                <p class="year-text">2011 - 2013</p>
            </div>
            <p class="desc-text">Angular JS</p>
            <p class="desc-subtext">Lorem ipsum dolor sit amet.</p>
        </section>
    
        <section>
            <h2>EDUCATION</h2>
            <div class="float-wrap">
                <p class="title-text">Mutsa University</p>
                <p class="year-text">2008 - 2012</p>
            </div>
            <p class="desc-text">Computer Science and Engineering</p>
            <div class="float-wrap">
                <p class="title-text">Mutsa High school</p>
                <p class="year-text">2006 - 2008</p>
            </div>
            <p class="desc-text">Visual Communication Design</p>
            <div class="float-wrap">
                <p class="title-text">Online Programming Academy</p>
                <p class="year-text">2006 - 2007</p>
            </div>
            <p class="desc-text">Python Course</p>
        </section>
    
        <section>
            <h2>AWARDS</h2>
            <div class="float-wrap">
                <p class="title-text">LIKELION SEOUL</p>
                <p class="year-text">2018</p>
            </div>
            <p class="desc-text">Best Developer Award</p>
        </section>
    
        <div class="sns-wrap">
            <a href="http://facebook.com"><img class="sns-img" src="images/facebook.png"></a>
            <img class="sns-img" src="images/twitter.png">
            <img class="sns-img" src="images/linked-in.png">
            <img class="sns-img" src="images/insta.png">
        </div>
    </div>
    <footer>
        <p>Copyright CODE LION All rights reserved. </p>
    </footer>
    </body>
    </html>
    ```

- codelion.css

    ```css
    @import url('https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800&display=swap');
    
    * {
        font-family: 'Montserrat';
    }
    
    body,h1,h2 {
        margin:0px;
        padding:0px;
    }
    
    body {
        min-width: fit-content;
    }
    
    h1 {
        font-size:36px;
        font-weight: bold;
        font-style: italic;
    }
    
    h2 {
        font-size:20px;
        color:#282828;
        font-weight: lighter;
        margin-bottom: 16px;
        border-bottom: 1px solid #ebebeb;
        padding-bottom: 5px;
    }
    
    .name-text {
        font-size:16px;
        color:#7c7c7c;
        font-weight: bold;
    }
    
    .about-me-text {
        font-size:10px;
        line-height: 16px;
    }
    
    .mainbox {
        width: 610px;
        padding: 30px;
        margin: 30px;
        margin-right: auto; /*요소 바깥 오른쪽 여백*/
        margin-left: auto;
        border: 1px solid #ebebeb; /* 테두리: 두께, 종류(실선), 색상 */
        box-shadow: 0 1px 20px 0 rgba(0, 0, 0, 0.1);
    }
    
    .title-box {
        text-align: right;
    }
    
    section {
        margin-bottom:24px;
    }
    
    .float-wrap {
        overflow: hidden;
    }
    
    .title-text {
        font-size:11px;
        font-weight: bold;
        color: #282828;
        float: left;
    }
    
    .year-text{
        font-size:11px;
        font-weight: bold;
        color: #282828;
        float: right;
    }
    
    .desc-text {
        font-size: 9px;
    }
    
    .desc-subtext {
        font-size: 9px;
        color:#282828;
        padding-left:16px;
    }
    
    .sns-img {
        width:12px;
        height:12px;
    }
    
    .sns-wrap {
        text-align:right;
    }
    
    footer {
        text-align: center;
        background-color: #1e1e1e;
        padding: 20px;
        font-size: 12px;
        color: #919191;
    }
    ```


---

# JavaScript

### 주석

- 코드는 읽을 수 없는 글
- 코드를 설명하거나 코드를 실행하고 싶지 않을때 사용

### 데이터 상자 만들기

- 변수 : var
- var name = ‘’”

```jsx
var name = '엄준식';
```

- ES6에서는 let 또는 const

### 자료형

- string
- int, float
- bool → true/false
- typeof 데이터 → 결과로 데이터 타입 반환

```jsx
document.write(typeof name);
```

---

## 로또 추첨기 만들기

- Math.random() → 0이상 1미만 실수
- parseInt(): 정수로 변환
- *45+1 → 1 ~ 45이상의 실수

    ```jsx
    parent(MAth.random()* 45 +1);
    ```

- 배열(Array) 이용

    ```jsx
    var lotto =[];
    ```

- lotto.push(parent(MAth.random()* 45 +1)); 반복 → 반복문 이용
    - index0f() : 값이 없으면 -1 return

    ```jsx
    for(var i = 0; i < 6; i++) {
    	var num = parseInt(Math.random() * 45 + 1); 
    	if (lotto.indexOf(num) == -1) {
    	lotto.push(num);
    	}
    }
    ```


## jQuery

- 간한 문법
- 편리한 API
- 크로스브라우징

    ```jsx
    function hello() {
    	console.log('hello');
    }
    ```

- 익명함수 사용

    ```jsx
    $('#click').click()
    ```


---

## 스타크래프트 만들기

```jsx
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>스타크래프트</title>
    <style>
        .background {
            position: relative;
            background-image: url('background.png');
            background-size: 500px 330px;
            width: 500px;
            height: 330px;
        }
        #drone {
            position: absolute;
            width: 100px;
            height: 100px;
            top: 100px;
            left: 60px;
        }
        #bunker {
            position: absolute;
            width: 150px;
            height: 150px;
            top: 80px;
            right: 20px;
        }
        #spit {
            display: none;
            position: absolute;
            top: 140px;
            left: 150px;
            width: 50px;
            height: 30px;
            z-index: 2;
        }
    </style>
</head>
<body>
    <h1 id='hp'>HP: 3</h1>
    <div class='background'>
        <img id='drone' src="drone.png" alt="drone">
        <img id='spit' src="spit.png" alt="spit">
        <img id='bunker' src="bunker.png" alt="bunker">
    </div>
    <script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
    <script>
        var hp = 3;
        $('#drone').click(function() {
            $('#spit').fadeIn();
            $('#spit').animate({'left': '+=250px'});
            $('#spit').fadeOut(function(){
                hp = hp - 1;
                $('#hp').text('HP: ' + hp);
                if (hp == 0) {
                    $('#bunker').fadeOut();
                }
            });
            $('#spit').css({left: 150});
        });
    </script>
</body>
</html>
```
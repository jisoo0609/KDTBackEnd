# HTML 작성하기

## HTML의 요소

- 중첩해서 만들 수 있음
- 계층적 구조 표현

  ### 요소 (element)

    - HTML을 이루는 단위

  ### 태그 (tag)

    - HTML 요소를 정의
    - 여는 태그, 닫는 태그로 짝을 이룬다
    - `<title>` `</title>`

  ### 내용 (content)

    - HTML 요소가 담고있는 정보가 작성되는 부분

## HTML 속성 (Attribute)

- 요소에 대한 추가 정보를 제공
- 이름=“값” 형태로 작성

## HTML의 구조

- `<head>`
    - HTML 문서 자체에 대한 정보 (metadata) 정의
- `<body>`
    - HTML 문서를 통해 사용자에게 전달하고 싶은 정보가 담기는 요소

---

## HTML Body

### 문단 (Paragraphs)

- 공백으로 줄바뀜 X
    - `&nbsp;`
    - `<br>`
- 보여주려는 데이터가 실제로 공백이거나 줄바꿈일때 사용하는게 바람직

### 목록 (List)

- 순서가 있는 리스트
    - `<ol>`

    ```html
        <!-- 순서가 있는 목록 -->
        <h3>아침 만들기</h3>
        <!-- Ordered list -->
        <ol>
            <!-- list item -->
            <li>식빵 굽고</li>
            <li>치즈 올리고</li>
            <li>계란 후라이</li>
        </ol>
    ```

- 순서가 없는 리스트
    - `<ul>`

    ```html
       	<!-- 순서가 없는 목록 -->
        <h3>오늘 할일</h3>
        <!-- Unordered list -->
        <ul>
            <!-- List item -->
            <li>OOP 공부</li>
            <li>1일 1문제</li>
            <li>HTML 연습</li>
        </ul>
    ```

- 리스트 아이템
    - `<li>`

    ```html
            <!-- list item -->
            <li>식빵 굽고</li>
            <li>치즈 올리고</li>
            <li>계란 후라이</li>
    ```


### 이미지 (images)

- src 속성으로 이미지 위치 지정
- alt 속성으로 대체 텍스트 정의

    ```html
    <!-- 이미지 -->
        <div>
            <!-- Source -->
            <img src="fish.png" alt="">
            <!-- arternate -->
            <img src="null.png" alt="없어요">
        </div>
    ```


### 링크 (Anchor)

- 하이퍼링크 만들때 사용
- target 속성을 사용해 링크를 여는 동작 정의 가능
- _blank 사용하면 새 탭에서 열림

    ```html
    <div>
            <!-- anchor -->
            <a href="https://google.com">Google</a>
            <a href="https://www.naver.com">Naver</a>
            <!-- anchor에 target 속성으로 어디(어떤 탭)에 열지를 결정 -->
            <a href="https://github.com" target="_blank">Github</a>
        </div>
    ```


### division, span

- 여러 내용을 하나의 요소로 묶기 위한 역할
- 겉으로 드러나는 형식은 없으나 CSS와 함께 활용

### 양식 (form)

- 사용자가 데이터를 작성할 양식 요소

### 입력 (input)

- 사용자가 데이터를 기입하는 요소

    ```html
        <!-- form 요소 -->
        <form>
            <h2>계좌 만들기</h2>
            <!-- input 요소 -->
            이름:
            <input type="text"><br><br>
            주소:
            <input type="text"><br><br>
            주민등록번호:
            <input type="text"><br><br>
            성별
            <label>
                남: <input type="radio" name="gender">
            </label>
            <label for="">여: </label>
            <!-- 설명을 여기 넣어주고 싶다 -->
            <!-- input의 id 속성을 부여 -->
            <input type="radio" name="gender" id="female">
            <br><br>
            <!-- 양식 제출 버튼 -->
            <input type="submit" value="만들기">
        </form>
    ```


### label

- 사용성을 높일 수 있음

    ```html
            <label>
                남: <input type="radio" name="gender">
            </label>
    ```


---

# CSS

- Casecading Style Sheets
- 스타일 (색, 글씨체, 크기 등)을 표현하기 위한 언어
- 어떤 요소가 어떻게 보일지를 정의

## CSS 문법

- 어떤 요소 선택해서 어떻게 변경할지 선언

  ### 선택자 (selector)

    - 어떤 요소에 적용할지

  ### 선언 (Declaration)

    - 속성과 값 정의

  ### 속성 (Property)

    - 어떤 표현을 변경할지
    - 글씨체, 크기, 생상 등

  ### 값 (Value)

    - 속성을 어떻게 변경할지

### Inline CSS

- HTML 요소에 직접 표현
- 적용 빠르고 개별적 요소에 적용 가능
- 반복되는 요소에는 중복 코드 많이 생성됨
- 정확하게 특정 요소에 적용 가능

    ```html
    <!-- 1. 요소에 직접 스타일 적용 - Inline CSS -->
            <!-- 장점: 빠르고 정확 -->
            <!-- 단점: 무지하게 많이 반복 -->
            <h1 style="color: red">Inline CSS</h1>
    ```


### Internal (Embadded) CSS

- `<head>` 내부의 `<style>` 요소에 작성
- 문서 전체에 CSS 적용하기 용이함
- CSS를 HTML 요소들에서 분리해 따로 관리 가능
- 여러 HTML 문서에는 적용 불가

    ```html
            <!-- 2. head에 style 추가 -->
            <style>
                h2 {
                color: green;
                }
            </style>
    ```

    ```html
    <!-- 2. HTML head에 style 요소 작성 - Internal(Embaded) CSS -->
            <!-- 장점: CSS를 따로 관리하고, HTML 전체에 적용 가능 -->
            <!-- 단점: 웹사이트 페이지가 늘어나면 반복해서 head에 작성해줘야 함 -->
            <h2>Internal CSS</h2>
    ```


### External CSS

- 외부 파일을 `<link>`요소로 불러오기
- 여러 HTML 문서에 사용 가능
- 주로 사용되는 방법
- CSS를 가져오기 위해 추가로 한 번의 요청 발생

    ```html
    <!-- 3. 링크로 외부 CSS 추가 -->
            <link rel="stylesheet" href="style.css">
    ```

    ```css
    h3 {
        color : blue
    }
    ```

    ```html
    <!-- 3. 외부 파일(.css)에 작성 - External CSS -->
            <!-- 장점: 여러 페이지에 걸쳐 비슷한 디자인을 적용시킬 수 있다 -->
            <!-- 단점: CSS를 적용하기 위해 다시 요청을 해야한다 -->
            <h3>External CSS</h3>
            <h3>Second h3</h3>
            <h3>Third h3</h3>
    ```


## CSS Sector

- 어떤 요소를 선택해서 어떻게 변경할지 정함
- 선택자 작성 방법에 따라 어떤 요소에 스타일 적용할지 결정 가능
- 특정 요소를 지정하기 위해, 요소에 id와 class 속성을 부여하기도 함

  ### 요소 선택자

    - 요소를 선택
    - 더 우선하는 CSS 없다면 해당 요소 전부 선택

    ```css
    /* p는 모든 p 요소를 지칭한다 */
    p {
        color: purple;
    }
    ```

  ### id 선택자 (#{id})

    - 속성 id의 값을 기준으로 요소 선택
    - id는 중복해서 부여하지 않음
    - 하나의 요소를 특정 지을 때 사용

    ```css
    /* id는 하나의 요소를 지칭한다 */
    #red {
        color: red;
    }
    ```

  ### class 선택자 (.{class})

    - 속성 class의 값이 해당 클래스를 포함하는지를 기준으로 요소를 선택
    - class는 여러 요소에 중복해서 부여 가능
    - 반복되는 요소를 지정하기 위해 주로 활용

    ```css
    /* class는 특정 요소들을 지칭한다 */
    .blue {
        color: blue;
    }
    ```


## CSS 우선순위

- 일반적이고 더 보편적인 규칙에서 상세한 규칙 순으로 적용
- Cascading
1. 중요한 (!important) 규칙 (사용 권장 X)
2. Inline CSS
3. id, class, 요소 등

## font styling

- 글자 스타일 적용
- 간단한 글씨 표현 조절

    ```css
    h1 {
        text-align: center;
        font-style: italic;
    }
    ```

    ```css
    p {
        text-align: justify;
        font-weight: bold;
    }
    ```
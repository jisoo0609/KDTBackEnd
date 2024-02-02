# CSS Box Model

## Block & Inline

### Block Element

- 추가하면 줄바꿈 일어남
- 화면의 크기만큼 가로폭 차지
- `<h1>`,`<p>` 등의 요소

### Inline Element

- 추가해도 줄바꿈 일어나지 않음
- 내용의 크기만큼 폭 차지
- `<a>` 추가해도 줄 바뀌지 않음

## CSS Box Model

- 서로 다른 요소들끼리 박스 형태로 배치하는 것 결정
- 요소를 그릴 때 상자를 바탕으로 요소와 요소의 내용, 다른 요소들을 어떻게 그릴지 결정하는 방법

### CSS Box Model 구조

![CSS Box Model](/image/231214.png)

- content
  - 요소 내부의 내용
- padding
  - 테두리부터 요소의 내용까지 공간
- border
  - 요소의 테두리
- margin
  - 요소의 테두리부터 외부의 요소와의 공간
## width & height

- Block 요소의 크기는 width, height 속성을 주면 크기 조절 가능

    ```css
    .box {
        background-color: dodgerblue;
        color: white;
        width: 150px;
        height: 150px;
    }
    ```


## margin & padding

- 4가지 방향이 모두 동일하면 margin, padding 속성 활용 가능
- 상하좌우 동일한 간격이 됨

### margin

- 요소와 요소의 간격을 조정하기 위해 사용
- margin 방향: top, right, bottom, left

    ```css
    /* 네 방향으로 margin을 작성 가능 */
    .margin-4 {
        margin-top: 50px;
        margin-right: 100px;
        margin-bottom: 150px;
        margin-left: 200px;
    }
    ```


### padding

- 요소의 테두리와 요소의 내용의 간격을 조정하기 위해 사용
- 방향: top, right, bottom, left

    ```css
    /* 네 방향으로 padding을 작성 가능 */
    .padding-4 {
        padding-top: 20px;
        padding-right: 30px;
        padding-bottom: 40px;
        padding-left: 50px;
    }
    ```


## border

- 테두리를 만듦

    ```css
    .border {
        /* 테두리 굵기 */
        border-width: 1px;
        /* 테두리 형식 */
        border-style: solid;
        /* 테두리 색상 */
        border-color: black;
    }
    ```


## Position

- 요소의 배치를 결정
- top, left, right, bottom으로 방향, 거리 결정

### relative

- 원래 배치되어야 하는 위치에서 주어진 top, left, right, bottom 값 만큼 멀어지게 이동
- 다른 요소의 위치를 변경시키지 않음

    ```css
    /* relative */
    .relative {
        background-color: green;
        position: relative;
        top: 100px;
        left: 100px;
    }
    ```


### absolute

- static이 아닌 가장 가까운 조상 요소를 기준으로 top, left, right, bottom 값 만큼 멀어지게 배치

    ```css
    /* absolute */
    .absolute {
      background-color: yellowgreen;
      position: absolute;
      left: 50px;
      top: 50px;
    }
    ```


### fixed

- 브라우저 화면(viewport)을 기준으로 top, left, right, bottom 값 만큼 멀어지게 배치
- 스크롤을 움직여도 화면에 고정된 UI 나타남

    ```css
    /* fixed */ 
    .fixed{
        position: fixed;
        right: 20px;
        bottom: 20px;
        background-color: magenta;
    }
    ```


### sticky

- 일반적인 요소처럼 보이다가 어느 시점부터 fixed 됨

    ```css
    /* sticky */
    .sticky {
        position: sticky;
        background-color: chocolate;
        top: 100px;
        left: 100px;
    }
    ```


### z-index

- position을 바꾸면 요소들이 쌓이게 된다
- z-index 속성을 부여해 높이를 조절
- 숫자가 클수록 위에 쌓이게 됨

    ```css
    .color-red {
        background-color: red;
        position: absolute;
        left: 50px;
        z-index: 5;
    }
    ```

    ```css
    .color-orange {
        background-color: orange;
        position: absolute;
        left: 100px;
        z-index: 4;
    }
    ```
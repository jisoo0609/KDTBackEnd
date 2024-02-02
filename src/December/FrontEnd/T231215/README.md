# CSS Flexbox

## Layout

- UI를 사용자가 보기 편하고 매력있게 배치하는 것

## Flexbox

- display: flex; 를 적용하고 추가적인 속성을 넣어주어 요소들의 배치를 지정할 수 있다
- 정렬할 주축을 만들고 축을 기준으로 요소를 배치한다
- 기본값은 좌 → 우
- Flex Container가 Flex Item을 정렬함

### Flex Direction

```css
flex-direction: /* 조건 */;
```

- 주축의 방향을 설정하는 속성
    - row
        - 좌 → 우 (기본값)
    - column
    - row-reverse
        - 우 → 좌
    - column-reverse
        - 하 → 상

### flex-wrap

```css
flex-wrap: /* 조건 */;
```

- item이 늘어나 들어갈 공간이 부족할 경우 사용 가능
    - wrap
        - 넘치는 요소 다음 줄에 출력
    - nowrap
        - 요소의 수를 줄여서라도 한 줄에 출력

## 요소 정렬하기

- 전체 가운데 정렬
    - justify-content 와 align-items 둘 다 center로 설정하면 가운데 정렬 가능

    ```html
    <div class="container-flex justify-content-center align-items-center> 
    	<div class="box">중앙정렬</div>
    </div>
    ```


### justify-content

```css
justify-content: /* 정렬조건 */;
```

- 주 축의 방향에 맞춰 요소들을 정렬
    - flex-start
        - 주축의 시작 방향으로 정렬
    - flex-end
        - 주축의 끝 방향으로 정렬
    - center
        - 주축 가운데로 정렬
- 요소들 사이로 여백 배치 가능
    - space-around
        - 각 요소 주변에 같은 여백 배치
    - space-between
        - 요소 사이에만, 동일한 여백 넣어줌
        - 양 끝 요소는 부모의 테두리에 닿음
    - space-evenly
        - 모든 여백이 동일

### align-items

```css
align-items: /* 조건 */;
```

- 교차축의 방향으로 요소를 정렬
    - flex-start
        - 교차축의 시작 (row의 경우 위쪽) 방향으로 정렬
    - flex-end
        - 교차축의 끝 (row의 경우 아래쪽) 방향으로 정렬
    - center
        - 교차축의 가운데로 정렬
    - stretch
        - height가 고정되어 있지 않은 경우
        - 교차축 방향을 채움

### align-contents

```css
align-contents: /* 조건 */;
```

- 요소가 두 줄 이상일 때, 각 줄 단위로 정렬하는 경우 사용
- justify-content와 동일한 값 사용
- 한 줄의 요소만 있으면 의미 없음
- 각 줄이 하나의 요소라고 생각하고 교차축 방향으로 justify-content

---

# Bootstrap

- open-source frontend framework
- 미리 만들어진 CSS와 JavaScript를 통해 CSS 속성을 쉽게 적용할 수 있게 함
- 이미 만들어진 다양한 UI를 활용할 수 있음
- 홈페이지에서 다운로드 받거나 CDN을 통해 인터넷에서 바로 받아옴

### Bootstrap Grid System

- 화면의 사이즈에 따라 요소를 재배치하는 시스템
- 본래 편집 디자인에서 나온 개념을 flex box로 구현
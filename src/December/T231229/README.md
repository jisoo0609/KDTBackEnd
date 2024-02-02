# WebMVCConfigurer

- Spring MVC의 Java Config 설정을 구성하기 위한 인터페이스 중 하나
- Spring Boot에서 웹 애플리케이션을 구성할 때 사용됨
- 주로 `WebMvcConfigurerAdapter` 클래스를 상속하여 구현

# Controller (Handler) 클래스 작성하기

- `@Controller` 애노테이션
- 맵핑을 위해 `@RequestMapping` 애노테이션을 클래스나 메소드에서 사용

## @RequestMapping

- Http 요청과 이를 다루기 위한 Controller 의 메소드를 연결하는 어노테이션
- Http Method 와 연결하는 방법

    ```java
    @RequestMapping("/users", method=RequestMethod.POST)
    ```

- 사용방식

  ### 경로 패턴 사용

    - 정적으로 표현된 구체적인 경로만이 아니라 동적으로 표현된 경로 패턴 지정 가능
        - URI 템플릿 형식의 경로 패턴
        - URI 템플릿 형식의 경로 패턴 + 정규 표현식
        - 앤트 스타일 경로 패턴

  ### 요청 파라미터 사용

    - params속성을 사용
    - 지정 형식
        - `name`
            - 지정한 파라미터가 존재하는 경우
        - `!name`
            - 지정한 파라미터가 존재하지 않는 경우
        - `name=value`
            - 파라미터 값이 지정한 값에 해당하는 경우
        - `name!=value`
            - 파라미터 값이 지정한 값에 해당하지 않는 경우

  ### 요청 헤저 사용

    - headers속성을 사용
    - 지원 형식 params 속성과 동일

  ### Content-Type 헤더 사용

  ### Accept 헤더 사용


# 애노테이션

## 인수에 지정 가능한 애노테이션

### `@PathVariable`

- `@RequestMapping` 의 path 에 변수명을 입력받기 위한 place holder 가 필요
- place holder 의 이름과 PathVariable 의 name 값과 같으면 mapping
- required 속성은 default true
- `@RequestParam`
    - Mapping 된 메소드의 Argument 에 붙일 수 있는 어노테이션
    - @RequestParam의 name에는 http parameter 의 name 과 멥핑
    - @RequestParam의 required는 필수인지 아닌지 판단
- `@RequestHeader`
    - 요청정보의 헤더 정보를 읽어들 일 때 사용
    - `@RequestHeader(name="헤더명") String 변수명`
- `@RequestBody`
- 요청 본문 내용을 가져오기 위한 애노테이션
    - 요청 본문은 HttpMessageConverter구조를 사용해 지정한 타입으로 변환
- `@CookieValue`
    - 쿠키 값을 가져오기 위한 애노테이션

## 관례에 따른 묵시적 인수 값 설정

- 인수의 타입이 String이나 Integer같은 간단한 타입인 경우
    - 인수의 이름과 일치하는 요청 파라미터에서 값 가져올 수 있음
    - 인수의 타입이 자바빈즈의 기본 속성명과 일치하는 객체 Model에서 가져올 수 있음
    - 빈에 해당하는 객체가 Model에 없다면 기본 생성자를 호출해 새로운 객체 생성

## 타입 선택시 주의점

- 서블릿 API(HttpServletRequest, HttpServletResponse, HttpSession, Part)
- 저수API(InputStream, OutputStream, Reader, Writer, Map)의 타입 사용 가능하지만

  → 애플리케이션에서 유지보수성을 떨어뜨릴 수 있음


## 입력값 검사

- 스프링 MVC는 Bean Validation기능을 이용해 요청 파라미터 값이 바인딩된 폼 클래스의 입력값 검사를 함
- 메소드 매개변수에 폼 클래스를 정의
- `@org.springframework.validation.annotation.Validated` 또는 `@javax.validation.Valid`를 지정

### 입력값 검사 판정

- 입력값 검사와 검사 결과(BindingResult)를 만드는 것은 프레임워크에서 함
- 입력값 검사 결과에 대한 오류를 판단하고 그에 맞는 처리는 애플리케이션에서 구현 필요
- 입력값 검사 후 오류 정보를 확인하려면 `BindingResult`의 메서드 사용해야 함

---

# Thymeleaf

- HTML, XML, JavaScript, CSS와 같은 마크업 언어를 처리하기 위한 wkqk xpavmfflt dpswls
- 버 사이드와 클라이언트 사이드의 렌더링을 모두 지원
- 자바 코드에 깊이 종속되지 않고 일반적인 웹 개발 패러다임에 적합
- 자바의 객체를 마크업으로 변환하고, 그 반대로도 마크업에서 객체를 추출하는 기능을 제공
- 뷰와 컨트롤러 사이의 의존성을 줄이고, 유지보수성 생산성 높임
- 다국어 처리와 같은 기능을 내장 → 국제화된 웹 애플리케이션 개발에 적합

## 라이브러리 추가

```java
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'4
// pring Security를 사용할 경우 추가
implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5
```

## 문법

### 변수 표현식

- ${} 사용 {}안에 변수명 넣으면 해당 변수의 값 출력 가능
- `${name}`

### 반복문

- th:each 디렉티브를 사용하여 반복문 작성
- 변수를 사용하여 반복문을 작성하며, 반복하는 컬렉션의 요소를 순회하면서 작업 수행

```java
<ul>
	<li th:each="user : ${users}" th:text="${user.name}"></li>
</ul>
```

### 조건문

- th:if 디렉티브를 사용하여 조건문을 작성
- 변수를 사용하여 조건을 작성하며, 조건에 따라 다른 작업을 수행

```java
// isAdmin 변수의 값에 따라, 관리자 페이지와 일반 사용자 페이지 중 하나 출력
<div th:if="${isAdmin}">
	관리자 페이지
</div>
<div th:if="${not isAdmin}">
	일반 사용자 페이지
</div>
```

### 속성 값 설정

- th:attr 디렉티브를 사용하여 HTML 속성의 값을 설정
- 변수를 사용하여 속성의 값에 동적으로 값을 할당
- 동적인 웹 페이지를 작성

```java
// href 속성의 값을 동적으로 할당
// userId 변수의 값을 URL 경로에 포함
<a th:attr="href=@{/user/{id}(id=${userId})}">사용자 정보</a>
```

---

# Controller

## Controller에서 중복되는 부분을 처리하는 방법

- 별도의 객체로 분리
- 별도의 메소드로 분리

## Controller / Service

- 비지니스 메소드를 별도의 Service객체에서 구현하도록 하고 컨트롤러는 Service 객체를 사용

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/d2152b7f-cc08-4868-88c2-80db2f3750de/8bd77374-c9e5-4cf8-a330-197b616d46de/Untitled.png)

# 서비스(Service)

- 비지니스 로직(Business logic)을 수행하는 메소드를 가지고 있는 객체
- 하나의 비지니스 로직은 하나의 트랜잭션으로 동작

# 트랜잭션 (Transaction)

- 하나의 논리적인 작업을 의미

## 트랜잭션의 특징

### 원자성 (Atomicity)

- 전체가 성공하거나 전체가 실패하는 것
- rollback하거나 commit을 하게 되면 하나의 트랜잭션 처리가 완료

### 일관성 (Consistency)

- 트랜잭션의 작업 처리 결과가 항상 일관성이 있어야 한다는 것
- 트랜잭션이 진행되는 동안에 데이터가 변경되더라도 업데이트된 데이터로 트랜잭션이 진행되는 것이 아니라, 진행 하기 위해 참조한 데이터로 진행
- 사용자는 일관성 있는 데이터를 볼 수 있음

### 독립성 (Isolation)

- 둘 이상의 트랜잭션이 동시에 병행 실행되고 있을 경우 어느 하나의 트랜잭션이라도 다른 트랜잭션의 연산에 끼어들 수 없음
- 하나의 특정 트랜잭션이 완료될때까지, 다른 트랜잭션이 특정 트랜잭션의 결과를 참조할 수 없음

### 지속성 (Durability)

- 트랜잭션이 성공적으로 완료되었을 경우, 결과는 영구적으로 반영

## 서비스 객체에서 중복으로 호출되는 코드의 처리

- 데이터 엑세스 메소드를 별도의 Repository(Dao) 객체에서 구현
- 서비스는 Repository객체를 사용
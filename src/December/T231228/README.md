# Bean Scope

- 빈의 생존 기간
- DI 컨테이너가 관리
- 스프링 프레임워크에서 사용 가능한 Bean Scope
    - singleton
        - DI 컨테이너를 기동할 때 빈 인스턴스 하나가 만들어지고. 이후부터는 그 인스턴스를 공유하는 방식
        - 기본 스코프
    - prototype
        - DI 컨테이너에 빈을 요청할 때마다 새로운 빈 인스턴스가 만들어짐
        - 멀티 스레드 환경에서 오작동이 발생하지 않아야 하는 빈일 경우 사용
    - request
        - HTTP 요청이 들어올 때마다 새로운 빈 인스턴스 생성
        - 웹 애플리케이션을 만들 때만 사용 가능
    - session
        - HTTP 세션이 만들어질 때마다 새로운 빈 인스턴스 생성
        - 웹 애플리케이션을 만들때만 사용 가능

## 빈 설정 방법의 차이

- 자바 기반 설정 방식
    - 자바 클래스에 @Configuration애노테이션, 메소드에 @Bean애노테이션을 사용해서 빈을 정의하는 방법
    - 스프링 3.0부터 사용 가능
    - 스프링 부트에서 이 방식을 많이 사용
- 애노테이션 기반 설정 방식
    - @Component같은 마커(Marker) 애노테이션이 부여된 클래스를 탐색해서 (Component scan) DI컨테이너에 빈을 자동으로 등록하는 방법

## 스코프 설정

- 자바 기반의 설정
- @Bean 애노테이션이 붙은 메소드에 @Scope 애노테이션을 추가해서 스코프를 명시
- Bean은 기본적으로 싱글턴이지만 prototype으로 지정할 경우 매번 새로운 인스턴스가 생성

```java
@Bean
@Scope(“prototype”)
MyService myService(){
	return new MyService();
}
```

### 다른 스코프의 빈 주입

- 스코프 별 빈의 생명 길이
    - singleton > session > request
- DI 컨테이너에 의해 주입된 빈은 자신의 스코프와 상관없이 주입받는 빈의 스코프를 따름
    - prototype 스코프 빈을 singleton 스크포 빈에 주입할 경우

      prototype 스코프 빈은 singleton빈이 살아있는한 다시 만들 필요가 없음

      → singleton과 같은 수명


## Bean의 생명 주기

- DI 컨테이너에서 관리되는 빈의 생명주기
1. 빈 초기화 단계 (initialization)
2. 빈 사용 단계 (activation)
3. 빈 종료 단계 (destruction)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/d2152b7f-cc08-4868-88c2-80db2f3750de/293ecc60-ed87-438e-ac15-7dc01362f72a/Untitled.png)

- 순서
    1. 스프링이 빈을 인스턴스화 한다.
    2. 스프링이 값과 빈의 레퍼런스를 빈의 프로퍼티로 주입한다.
    3. 빈이 BeanNameAware를 구현하면 스프링이 빈의 ID를 setBeanName()메소드에 넘긴다.
    4. 빈이 BeanFactoryAware를 구현하면 setBeanFactory()메소드를 호출하여 빈 팩토리 전체를 넘긴다.
    5. 빈이 ApplicationContextAware를 구현하면 스프링이 setApplicationContext()메소드를 호출하고 둘러싼 애플리케이션 컨텍스트에 대한 참조를 넘긴다.
    6. 빈이 Bean PostProcessor인터페이스를 구현하면 스프링은 postProcessBeforeInitialization()메소드를 호출한다.
    7. 빈이 InitializingBean인터페이스를 구현하면 스프링은 afterPropertiesSet()메소드를 호출한다. 마찬가지로 빈이 init-method와 함께 선언됐으면 지정한 초기화 메소드가
       호출된다.
    8. 빈이 BeanPostProcessor를 구현하면 스프링은 postProcessAfterInitialization()메소드를 호출한다.
    9. 빈은 애플리케이션에서 사용할 준비가 된 것이며, 애플리케이션 컨텍스트가 소멸될때까지 애플리케이션 컨텍스트에 남아있게 된다.
    10. 빈이 DisposableBean인터페이스를 구현하면 스프링은 destroy()메소드를 호출한다. 마찬가지로 빈이 destory-method와 함께 선언됐으면 지정된 메소드가 호출된다

## 생명주기 관련 애노테이션

- `@PostConstruct`
    - JSR-250 스펙으로 JSR-250을 구현하고 있는 다른 프레임워크에서도 사용가능
    - 인스턴스 생성 후에 호출
- `@Bean(initMethod="init")`
    - 초기화 메서드 사용 가능

    ```java
    @Bean(initMethod="init")
    public MyBean mybean(){
    	return new MyBean();
    }
    ```

- `@PreDestroy`
    - JSR-250스펙에서 정의
    - 종료될 때 사용할 메소드 위에 사용
- `@Bean(destroyMethod="destroy")`
    - 종료될 때 호출될 수 있도록 함

## 빈 설정 분할

- DI 컨테이너에서 관리하는 빈이 많아지면 많아질수록 설정 내용도 많아져 관리하기 어려워짐
- 빈 설정 범위를 명확히 하고 가독성도 높이기 위해 목적에 맞게 분할해야 함
- 자바 기반 설정 분할
    - `@import` 사용
- XML 기반 설정 분할
    - `<import>` 사용

## Profile 별 설정 구성

- 스프링 프레임워크에서는 설정 파일을 특정 환경이나 목적에 맞게 선택적으로 사용할 수 있도록 그룹화 가능 → Profile
- 자바 기반 설정 방식에서 프로파일 지정
    - `@Profile` 사용
    - `@Profile(“dev”)` ,`@Profile(“dev”, “real”)`
- XML 기반 설정
    - <Mbeans>요소의 profile 속성 활용

### Profile 선택

- 자바 명령행 옵션으로 프로파일 지정
    - `Dspring.profiles.active=real`
- 환경 변수로 프로파일 지정
    - export SPRING_PROFILES_ACTIVE=real
- spring.profiles.active를 지정하지 않으면 기본값으로 spring.profiles.default에 지정된 프로파일 사용

---

# MyService & MyDao

- 연관관계 - MyService가 MyDao 가짐

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/d2152b7f-cc08-4868-88c2-80db2f3750de/72d58d40-6efd-4eec-8737-fd6651d99142/Untitled.png)

- 프로그래머가 직접 인스턴스 생성하고 주입하는 방법
- setter 주입

```java
MyService myService = new MyService();
MyDao myDao = new MyDao();
myService.setMyDao(myDao);
```

- 생성자에 주입

```java
MyService myService = new MyService(new MyDao());
```

- 컴포넌트 스캔 방식으로 설정
- 코드
    - MyDao

    ```java
    package com.example.webexam.dao;
    
    import org.springframework.stereotype.Repository;
    
    @Repository
    public class MyDao {
    	public String get(){
    		return "dao가 리턴하는 값";
    	}
    }
    ```

    - MyService

    ```java
    packkage com.example.webexam.service;
    
    import com.example.webexam.dao.MyDao;
    import org.springframework.stereotype.Service;
    
    @Service
    public class MyService {
    	private fianl MyDao myDao;
    
    	public MyService(MyDao myDao) {
    		this.myDao = myDao;	
    	}
    	
    	public String serviceMethod() {
    		return "service에서 호출 : " + myDao.get();	
    	}
    }
    ```

    - HelloController

    ```java
    package com.example.webexam.controller;
    
    import com.example.webexam.service.MyService;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    @RestController
    public class HelloController {
    	private final MyService myService;
    	public HelloController(MyService myService) {
    		this.myService = myService;
    	}
    	
    	@GetMapping("/hello")
    	public String hello(){
    		return "controller : " + myService.serviceMethod();
    	}
    }
    ```


### Java Config 이용

- 코드
    - MyDao - `@Repository` 제거

    ```java
    package com.example.webexam.dao;
    
    import org.springframework.stereotype.Repository;
    
    public class MyDao {
    	public String get(){
    		return "dao가 리턴하는 값";
    	}
    }
    ```

    - MyService - `@Service` 제거

    ```java
    packkage com.example.webexam.service;
    
    import com.example.webexam.dao.MyDao;
    import org.springframework.stereotype.Service;
    
    public class MyService {
    	private fianl MyDao myDao;
    
    	public MyService(MyDao myDao) {
    		this.myDao = myDao;	
    	}
    	
    	public String serviceMethod() {
    		return "service에서 호출 : " + myDao.get();	
    	}
    }
    ```

    - ApplicationConfig

    ```java
    packagecom.example.webexam.config;
    
    import com.example.webexam.dao.MyDao;
    import com.example.webexam.service.MyService;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    
    @Configuration
    public class ApplicationConfig {
    	@Bean
    	MyService myService(MyDao mydao) {
    		return new MyService(mydao);
    	}
    
    	@Bean
    	MyDao myDao() {
    		return new MyDao();
    	}
    }
    ```


---

# AOP (Aspect Oriented Programming)

- 관점 지향 프로그래밍
- 기존의 OOP언어를 보완하는 확장 형태로 사용
- SpringAOP, AspectJ, JBossAOP 등

### 목적

- 중복을 줄여 적은 코드 수정으로 전체를 변경 가능하게 함
- 관심의 분리 (Separation of Concerns)
    - 핵심 관점 (업무 로직) + 횡단 관점 (트랜잭션/로그/보안/인증 처리 등)

### 장점

- 중복되는 코드 제거
- 효율적인 유지보수
- 높은 생산성
- 재활용성 극대화
- 변화 수용이 용이

### 용어

- Joinpoint
    - 메소드를 호출하는 '시점', 예외가 발생하는 '시점'과 같이 애플리케이션을 실행할 때 특정 작업이 실행되는 '시점'을 의미
- Advice
    - Joinpoint에서 실행되어야 하는 코드
    - 횡단관점에 해당함 (트랜잭션/로그/보안/인증등..)
- Target
    - 실질적인 비지니스 로직을 구현하고 있는 코드
    - 핵심관점에 해당함 (업무로직)
- Pointcut
    - Target 클래스와 Advice가 결합(Weaving)될 때 둘 사이의 결합규칙을 정의
    - Advice가 실행된 Target의 특정 메소드등을 지정
- Aspect
    - Advice와 Pointcut을 합함. 일정한 패턴을 가지는 클래스에 Advice를 적용하도록 지
- Weaving
    - AOP에서 Joinpoint들을 Advice로 감싸는 과정
    - Weaving 하는 작업을 도와주는 것

## Spring AOP의 특징

- 스프링 프레임워크 안에는 AOP를 지원하는 모듈로 스프링 AOP가 포함
- 의존성 추가

```java
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-aop'
}
```

### 활용 기능

- 트랜잭션 관리
- Spring Security에서 제공하는 인가 기능
- 캐싱
    - 캐싱 활성화
    - `@Cacheable` 지정 → 메서드의 매개변수 등을 키로 사용해 메서드의 실행결과를 캐시로 관리
- 비동기 처리
    - `@Async`  지정
    - 반환값으로 CompletableFuture나 DeferredResult타입의 값을 반환 → 해당 메서드 AOP 방식으로 별도의 스레드에서 실행
- 재처리
    - 스프링 Retry라는 프로젝트를 활용해 재처리를 AOP로 구현

---

# DAO (Data Access Object)

- 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 객체
- 보통 데이터베이스를 조작하는 기능을 전담하는 목적으로 만들어짐

# Connection Pool

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/d2152b7f-cc08-4868-88c2-80db2f3750de/a3e690d1-1092-4879-8dfe-07b1a4217117/Untitled.png)

- DB연동에 비용이 많이 들기 때문에 Connection Pool이 미리 여러 Connection을 맺어 둠
- Connection이 필요한 경우 Connection Pool에서 빌려 사용 후 반납

# Data Source

- Connection Pool을 관리하는 목적으로 사용되는 객체
- Connection을 얻어오고 반납하는 등의 작업 수행

---

# Spring MVC

## MVC (Model - View - Controller)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/d2152b7f-cc08-4868-88c2-80db2f3750de/1ad63375-5ec9-4122-aeb8-aa8a71900342/Untitled.png)

### Model

- 애플리케이션 상태(데이터)나 비즈니스 로직을 제공하는 컴포넌트

### View

- 모델이 보유한 애플리케이션 상태(데이터)를 참조하고 클라이언트에 반환할 응답 데이터를 생성하는 컴포넌트

### Controller

- 요청을 받아 모델과 뷰의 호출을 제어하는 컴포넌트
- 요청과 응답의 처리흐름을 제

## Spring Web Module

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/d2152b7f-cc08-4868-88c2-80db2f3750de/93ac8159-76bb-4503-979b-9fcf313458e1/Untitled.png)

# Web Application

- 인터넷이나 인트라넷을 통해 웹 브라우저에서 이용할 수 있는 Application
- 화면으로 응답하는 애플리케이션
    - `@Controller` 사용

  ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/d2152b7f-cc08-4868-88c2-80db2f3750de/2630498a-ce83-43a3-abad-258d838a511a/Untitled.png)

- 데이터로 응답하는 애플리케이션
    - `@RestController` 사용

  ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/d2152b7f-cc08-4868-88c2-80db2f3750de/fad9981b-6494-43ba-97c1-e6f116bc36a6/Untitled.png)


## 개발 특징

- POJO
    - 컨트롤러나 모델 등의 클래스 POJO 형태로 구현
    - 특정 프레임워크에 종속적이지 않음 → 테스트 등에 용이
- 애노테이션을 이용한 정의 정보 설정
    - 요청 매핑과 같은 각종 정의 정보를 설정 파일이 아닌 애노테이션을 이용해 설정
    - 비즈니스 로직과 그 로직을 수행하기 위한 각종 정의 정보가 자바 클래스에 함께 기술 → 효율적인 개발 가능
- 유연한 메소드 시그니처 정의
    - 컨트롤러 클래스의 메소드 매개변수에는 처리에 필요한 것만 골라서 정의
    - 수에 지정할 수 있는 타입도 다양한 타입이 지원
    - 프레임워크가 인수에 전달하는 값을 자동으로 담아주거나 변환 → 사양변경이나 리팩토링에 강한 아키텍처 가지게 됨
- Servlet API 추상화
    - 스프링 MVC는 서블릿 API를 추상화
    - 서블릿 API를 직접 이용하는 것보다 쉽게 개발 가능
- 뷰 구현 기술의 추상화
    - 컨트롤러는 뷰 이름(뷰의 논리적인 이름)을 반환하고, 스프링 MVC는 뷰 이름에 해당하는 화면이 표시되게 함
    - 컨트롤러는 뷰 이름만 알면 되기 때문에 뷰가 어떤 구현기술(JSP, Thymeleaf, Freemarker 등)로 만들어져있는지 자세히 몰라도 됨
- 스프링의 DI 컨테이너와 연계
    - 스프링 MVC는 스프링의 DI 컨테이너 상에서 동작하는 프레임워크
    - 스프링의 DI 컨테이너가 제공하는 DI나 AOP와 같은 구조를 그대로 활용 가능

### MVC 프레임워크로서의 특징

- 풍부한 확장 포인트 제공
    - 스프링 MVC에서는 컨트롤러나 뷰와 같이 각 역할별로 필요한 인터페이스를 제공
    - 기본 동작을 확장하고자 한다면 이러한 인터페이스를 재구현해야함
    - 강력한 커스터마이징
- 엔터프라이즈 애플리케이션에 필요한 기능 제공
    - 스프링 MVC는 단순히 MVC패턴의 프레임워크 구현만 제공한는 것이 아니라 메시지 관리, 세션 관리, 국제화 등 다양한 기능을 제공
- 서드파티 라이브러리와 연계지원
    - 스프링 MVC는 서드파티 라이브러리를 이용할 때 필요한 각종 어댑터를 제공
- 서드파티 라이브러리 자체가 스프링 MVC와의 연계를 지원하는 경우
    - Thymeleaf(템플릿 엔진), HDIV(보안 강화)
## Spring MVC 설정

- com.example.webmvc.config.WebMvcContextConfiguration

```java
@Configuration
public class WebMvcContextConfiguration implements WebMvcConfigurer{
......
}
```
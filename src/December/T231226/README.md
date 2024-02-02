# Spring Boot

- 프로덕션 환경에서 실행할 수 있는 애플리케이션 개발 쉽고 빠르게 가능
- 서드파티 라이브러리나 스프링 플랫폼 설정이 처음부터 들어있어 최소한의 작업으로 개발 시작 가능
- 설정 변경하지 않는 경우 → Tomcat 사용해 동작
- 스프링 부트의 경우 JAR 파일을 지정해 실행하면 내장된 톰캣이 실행된 후 애플리케이션 실행됨
- 애플리케이션 서버의 준비 없이 실행만으로 애플리케이션 동작 가능하다는 장점 존재
- WAR 이용 → 기존 환경의 애플리케이션 서버를 스프링부트를 사용해 애플리케이션 배포 가능

## Spring Boot

- 자체로 완전한 프레임워크는 아님
- 스프링 MVC 패턴 사용
    - 스프링 MVC, Spirng Batch

## Spring Boot의 특징

### 스타터

- 의존관계(dependency)를 간단하게 정의하는 모듈
- 필요한 라이브러리를 준비하거나 각각의 라이브러리 버전을 선정하는 작업 필요X

> Spring-boot-starter-web : 스프링 MVC, 톰캣이 의존관계에 추가됨                                                                                                                                             Spring-boot-starter-jdbc : 스프링 JDBC, 톰캣 JDBC 커넥션 풀(Tomcat JDBC Connection Pool)이 의존관계에 추가
>

### 빌드 도구

- 버전 해결 등 개발을 효율화하는 플러그인
- 자바 애플리케이션 빌드 도구
    - **Maven**
        - 특수한 처리가 필요할 때 독자적인 플러그인 구현
        - `spring-boot-starter-parent` 프로젝트를 부모 프로젝트로 상속
        - 플러그인의 디폴트 설정, 의존, 라이브러리 버전 정의, 자바 컴파일러 준수 레벨, 문자 코드 이어받을 수 있음
        - 값 정의하지 않아도 미리 준비된 디폴트값으로 설정 가능
    - **Gradle**
        - 스크립트를 작성하는 빌드 도구
        - 작업을 자유롭게 작성 가능
        - 멀티 프로젝트를 구성할때 하위 프로젝트에 대해 일괄로 설정하고 필요에 따라 개별적으로 설정 가능 → 스크립트의 작성량 메이븐보다 적음
        - 특수한 처리 필요할 경우 스크립트를 작성하는 것만으로도 대응 가능
        - 설정을 이어받는 부모 클래스가 존재하지 않음로 스타터를 의존관계로 추가해야함
        - `spring-boot-gradle-plugin` 으로 실행가능한 JAR 파일을 작성

### 구성 클래스

- XML이 아닌 어노테이션과 자바로 설정 작성
- `@configuration` 어노테이션 부여한 클래스로 구성
- 구성 클래스는 `@Import` 어노테이션을 사용해 다른 구성을 로드 할 수도 있음

### 자동 구성

- 디폴트 구성이 적용되며 필요한 부분만 설정하면 됨
- `@EnableAutoConfiguraiton` , `@SpringBootApplication` 어노테이션 부여
- `@EnableAutoConfiguraiton`
    - 여러번 부여 불가능하기 때문에 기본 구성 클래스에 부여 권장

### 메인 애플리케이션 클래스

- 자바 명령으로 내장된 톰캣을 실행
- 스프링 부트의 애플리케이션을 실행하는 메서드를 호출
- main 메서드 안에서 `SpringApplication` 클래스의 run 메서드 호출하면 내장된 톰캣이 실행되고 Spring IoC 컨테이너 초기화
- 디폴트 패키지가 아닌 루트 패키지에 배치할 것 권장

### 설정 파일

- 속성을 외부 파일에 정의할 수 있으며, 동작 사양을 쉽게 변경할 수 있다
- 애플리케이션을 실행하면 `application.properties` 설정 파일 읽어들임
- 단위: profile
- 설정 파일의 형식은 YAML로도 지정 가능
    - `application.properties` 대신 `application.yml` 파일 배치하면 자동 로드됨
- `@Validated`
    - 빈 검증(bean validation)으로 속성값 체크
    - 제약 조건을 위반한 값 설정된 경우 애플리케이션 실행 시 예외 발생 → 설정이 빠지거나 틀린 것 바로 발견 가능

    ```java
    @Validated
    public class SomePojo {
    '''
    }
    ```

- `@ConfiguratipnProperties`
    - 느슨한 바인딩(relaxed binding) 이루어짐
    - 클래스 변수와 파일 설정의 키가 정확하게 일치하지 않아도 느슨하게 바인딩됨

    ```java
    @ConfigurationProperties(perfix="foo")
    ```

    - `@Value` 사용해 프로그램에서 설정값 사용하기

    ```java
    @Component
    public class SomePojo {
    	@Value("${foo.remote-address}")
    	String remoteAddress;
    
    	@Value("${foo.security.username}")
    	String securityUsername;
    }
    ```
  # Spring Boot를 이용해 웹 애플리케이션 만들기

- `@Controller` 구현
- controller 패키지를 만들고 그 안에 `HelloController` 클래스 만듦

```java
@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello spring boot!";
    }
}
```

- 브라우저의 http://localhost:8080/hello 에서 실행 가능
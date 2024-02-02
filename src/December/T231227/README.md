# Container

- 인스턴스의 생명주기 관리
- 생성된 인스턴스들에게 추가적인 기능 제공

# IoC (Inversion of Control)

- 제어의 역전
- 개발자는 프로그램의 흐름을 제어하는 코드를 작성하는데, 이 흐름의 제어를 개발자가 아닌 다른 프로그램이 대신 하는 것을 IoC라고 함
- 객체의 생성, 생명주기, 관리까지 모든 객체에 대한 주도권을 프레임워크가 가짐
- Spring Container가 IoC를 담당하는 예

# DI (Dependency Injection)

- 의존성 주입
- 클래스 사이의 의존 관계를 빈(Bean) 설정 정보를 바탕으로 컨테이너가 자동으로 연결해 주는 것
- DI 용어

  ### 의존 객체 (Dependency)

    - 객체 간의 관계 중 하나
    - 객체 A가 객체 B를 사용하는 경우, 객체 A가 객체 B에 의존

  ### 의존 주입 (Dependency Injection)

    - 객체 간의 의존 관계를 설명하는 방법
    - 외부에서 의존 객체를 생성자, setter, 필드 등을 통해 주입하는 방법

  ### Bean

    - 스프링에서 DI를 사용하기 위해 생성되는 객체

  ### Bean Factory

    - 스프링에서 Bean을 생성하고 관리하는 컨테이너

  ### ApplicationContext

    - BeanFactory를 상속한 스프링 컨테이너
    - 다양ㅎ나 기능 제공

  ### Component

    - 스프링에서 Bean을 생성하기 위한 애노테이션 중 하나
    - 해당 클래스를 Bean으로 등록

  ### Qualifier

    - 같은 타입의 Bean이 여러 개 있을 경우 어떤 Bean을 사용할 지 결정하는 용도

  ### Autowiring

    - 자동으로 Bean을 주입하는 기능
    - @Autowired 를 통해 사용

# DI Container

- 스프링 공식 문서에서는 IoC 컨테이너라고 하는데 개발자들은 보통 DI 컨테이너로 표현
- DI 컨테이너에서 인스턴스 관리 시 장점
    - 인스턴스의 스코프 제어 가능
    - 인스턴스의 생명 주기 제어 가능
    - AOP 방식으로 공통 기능 주입 가능
    - 의존하는 컴포넌트 간의 결합도를 낮춰 단위 테스트를 쉽게 만듦
- 종류
    - 스프링 프레임워크
    - CDI(Contexts & Dependency Injection)
    - Google Guice
    - Dagger
- DI 컨테이너 용어

  ### Bean

    - DI 컨테이너가 관리하는 객체
    - 빈은 DI 컨테이너가 생성하고, 초기화하고, 보관하며 필요한 곳에서 제공

  ### Container

    - DI 컨테이너 자체. 객체의 생성과 의존 관계를 설정하는 일

  ### Configuration

    - DI 컨테이너가 객체를 생성하고 의존 관계를 설정하기 위해 참조하는 설정 정보

  ### Injection

    - DI 컨테이너가 생성된 빈에 필요한 의존 객체 주입(Injection)

  ### Autowiring

    - DI 컨테이너가 빈과 빈 간의 의존관계를 자동으로 설정해주는 기능

  ### Scope

    - 빈의 생성 주기와 관련된 범위(Scope) 설정 가능
    - Singleton, Prototype, Request, Session 등

  ### Proxy

    - DI 컨테이너는 빈을 가져올 때, 해당 빈을 감싸는 프록시 객체를 생성 가능
    - proxy 객체는 빈의 메서드 호출을 가로채서 보안, 로깅, 트랜잭션 등의 작업 수행 가능

---

# 의존성 주입 방법

### 필드 기반 의존성 주입 방식 (field-based depedency)

- 애플리케이션의 실제 코드와 상관없는 특정 테스트를 수행하는 경우

### 생성자 기반 의존성 주입 방식 (constructor-based dependency injection)

- 가장 권장되는 방식
- 생성자의 호출 시점에 1회 호출되는 것 보장
- NullPointException 방지 가능
- Player.java

```java
public Player(String name, Dice dice) {
    this.name = name;
    this.dice = dice;
}
```

- DiceGameConfig.java

```java
// 플레이어 등록
// 생성자 기반으로 등록
@Bean
public Player kang(Dice dice){
//return new Player("홍길동",dice);
    Player player = new Player();
    player.setDice(dice);
    player.setName("홍길동");
    return player;
}
```

### 설정자 기반 의존성 주입 방식 (setter-based dependecy)

- 생성자 주입과 다르게 주입받는 객체가 변경될 가능성이 있는 경우에 사용
- 선택적으로 의존성을 주입할 수 있음
- game.java

```java
public void setPlayers(List<Player> players) {
    this.players = players;
}
```

```java
// 설정자 기반 주입을 위한 기본 생성자
public Game(List<Player> players) {
   this.players = players;
}
```

- DiceGameConfig.java
    - game을 생성할 때 Game 클래스에 기본생성자가 없으면 안됨

```java
@Bean
public Game game(List<Player> players){
//  return new Game(players);
    Game game = new Game();
    game.setPlayers(players);
    return game;
}
```

---

# Bean

- 컨테이너가 관리하는 객체
    - 객체의 생명주기 컨테이너를 관리
    - 객체를 싱글톤으로 만들 것인지, 프로토타입으로 만들 것인지 등
- 관점 지향(AOP) 컨테이너 → 빈을 생성, 관리
- Bean 생성 시 기본 생성자가 있어야 함

## 스프링 컨테이너 생성

```java
// 스프링 컨테이너 생성
ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
```

- `ApplicationContext` 스프링 컨테이너. 인터페이스
- 스프링 컨테이너는 XML 기반으로 생성 가능
- 애노테이션 기반의 자바 설정 클래스로 만들 수 있음
- `new AnnotationConfigApplicationContext(UserConfig.class)` 클래스는 `ApplicationContext` 인터페이스의 구현체
- 구성정보(AppConfig.class)의 지정 필요

## 스프링 빈 등록, 의존관계 설정

- .config.UserConfig.class

```java
@Configuration
@ComponentScan(basePackages = "com.example.iocexam")
public class UserConfig {
    @Bean
    public UserDao userDao(){
        UserDao dao = new UserDaoCaramiImpl();
        return dao;
    }

    @Bean
    public UserService userService(UserDao userDao){
        return new UserServiceImpl(userDao);
    }

    @Bean
    public UserController userController(UserService userService){
        return new UserController(userService);
    }
}
```

- 스프링 컨테이너는 파라미터로 넘어온 설정 클래스 정보를 사용해 스프링 빈 등록
- 빈 이름은 메서드 이름을 사용
- 빈 이름을 직접 부여할 수 있음
    - @Bean(name - “Bean 이름”)
- 스프링 컨테이너는 설정 정보를 참고하여 의존관계 주입(DI)

## Bean 설정 형식

- 스프링 컨테이너는 다양한 형식의 설정 정보를 받아들일 수 있게 유연하게 설계되어 있음
- Annotation 기반 방식

    ```java
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)
    ```

    - `AnnotationConfigApplicationContext`를 사용하여 자바코드로 된 설정 정보 넘김
- XML

    ```java
    ApplicationCntext ac= new GenericXmlApplicationContext("app.xml");
    ```

    - XML 설정을 만들고 사용

## 컴포넌트 스캔(Component Scan)

- 지정된 특정 패키지 하위의 클래스를 탐색한 후 IoC 컨테이너에 객체 생성 후 등록함
- @Bean 이나 xml을 통해서 설정 정보에 직접 등록하는 방식을 spring이 자동으로 등록하는 방식
- 클래스 로더(Class Loader)를 스캔하면서 특정 클래스를 찾은 다음 DI 컨테이너에 등록하는 방법
- 별도의 설정이 없는 기본 설정에서 다음과 같은 애노테이션이 붙은 클래스가 탐색 대상이 되고, 탐색된 컴포넌트는 DI 컨테이너에 등록된다
    - `@Component` , `@Controller`, `@Service` ,`@Repository`
    - `@Configuration`
    - `@ControllerAdvice`
    - `@ManagedBean`
    - `@Named`
- 지정한 특정 패키지 이하를 스캔함
    - `@ComponentScan(basePackages = "examples.di")`
- 기본 스캔 대상 외에도 추가로 다른 컴포넌트를 포함하고 싶을 경우 필터를 적용한 컴포넌트를 스캔할 수 있음
- 스프링 프레임워크가 제공하는 필터
    - 애노테이션을 활용한 필터 (ANNOTATION)
    - 할당 가능한 타입을 활용한 필터 (ASSIGNABLE_TYPE)
    - 정규 표현식 패턴을 활용한 필터 (REGEX)
    - AspectJ 패턴을 활용한 필터 (ASPECTJ)

## 오토와이어링 (Autowiring)

- 명시적으로 빈을 정의하지 않고 DI 컨테이너에 빈을 자동으로 주입하는 방식
    - 자바 기반 설정 방식에서 @Bean 메서드를 사용하거나, XML 기반 설정 방식에서 <bean> 요소를 사용하는 것과 유사
- 오토와이어링 방식
    - 타입을 이용한 방식 (Autowiring by Type)
    - 이름을 이용한 방식 (Autowiring by name)

### 타입을 사용한 오토와이어링 방식 (Autowiring by Type)

- `@Autowired` 애노테이션
- Setter 인젝션, 생성자 인젝션, Field 인젝션에서 모두 활용 가능
- 타입으로 오토와이어링 할 경우 기본적으로 의존성 주입이 반드시 성공한다고 가정
    - 주입할 타입에 해당하는 빈을 찾지 못하면 *NoSuchBeanDefinitionException* 발생
    - 필수 조건 사용하고 싶지 않을 경우 `@Autowired(required = false)`로 설정
    - 스프링 4부터는 `@Autowired(required = false)` 대신 JDK 8부터 추가된 java.util.Optional 사용

    ```java
    @Autowired
    Optional<UserService> UserService;
    ```

- 인젝션 가능한 여러개의 빈을 발견할 경우 *NoUniqueBenDefinitionException* 발생
    - `@Qualifier` 애노테이션으로 빈 이름 지정한 후 선택해서 사용해야 함
    - `@Primary` 사용하면 `@Qualifier` 사용하지 않을 경우 우선적으로 선택할 빈 지정 가능
    - `@Qualifier` 역할을 하는 사용자 정의 애노테이션을 사용해 표현하는 것도 가능

      → 사용자 정의 애노테이션에 `@Qualifier` 를 설정


### 이름을 사용한 오토와이어링 방식 (Autowiring by name)

- 빈의 이름이 필드명이나 properties 명과 일치할 경우 빈 이름으로 필드 인젝션 가능
- JSR-250 사양을 지원하는 `@Resource` 애노테이션 활용
- `@Resource` 애노테이션
    - name 속성을 생략 가능.
    - 필드 인젝션 하는 경우 필드이름과 같은 이름의 빈이 선택됨
    - setter 인젝션 하는 경우 properties 이름과 같은 이름의 빈이 선택됨
    - 생성자 인젝션에서는 `@Resource` 애노테이션 사용 불가능
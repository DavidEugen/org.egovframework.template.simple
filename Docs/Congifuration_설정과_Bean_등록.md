# `@Configuration `설정과 `@Bean `등록

## 기본 규칙

>1. 환경설정 역할을 하는 클래스에 `@Configuration`을 붙여준다.
>2. @Bean 을 붙여서 등록하고자 하는 Spring Bean을 정의한다
>   * 메소드 정의시 @Bean 을 붙인다.
>   * 메소드의 Return 타입은 Bean의 Class Type 이다.
>   * 메소드의 이름이 Bean의 이름(XML 설정 당시 id 속성)이다.
>3. 특정 Bean을 Injection 받아서 Bean을 생성해야 할땐 특정 Bean을 생성하는 메소드를 직접 호출, 메소드의 파라미터, 또는 클래스레벨의 @Autowired로 특정 Bean을 Injection 받을 수 있다

### 1. 환경설정 역할을 하는 클래스에 `@Configuration`을 붙여준다.

`@Configuration` (org.springframework.context.annotation)을 붙이면 Spring은 일반 비지니스 Bean과는 달리 설정과 관련된 Bean이라 인식한다. XML 설정에서 `<Bean>` 과 같다

```java
@Configuration
public class ContextApp {
}
```



### 2. @Bean 을 붙여서 등록하고자 하는 Spring Bean을 정의한다











참조

-----

https://zgundam.tistory.com/ : 




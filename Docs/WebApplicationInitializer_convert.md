# WebApplicationInitializer 변환

서블릿은 3.0 이후부터 web.xml 없이도 서블릿 컨텍스트를 구현 가능하게 합니다.

>**서블릿 컨텍스트 초기화**
>서블릿 등록과 매핑, 리스너 등록, 필터 등록 을 담당한다.

## 순수 자바 클래스를 이용한 시동이 가능한 이유

1. javax.servlet.ServletContainerInitializer 인터페이스를 구현한 클래스 만들고 
2. 구현체의 클래스 이름을 /META-INF/services/javax.servlet.ServletContainerInitializer 에 준다.
3. 이 구현 클래스에 WAS 시작시 실행 될 클래스를 `@HandlesTypes` 어노테이션으로 달아준다.

스프링의 경우 이를 spring-web 모듈 내에서 확인 가능하다.

```tex
#/META-INF/services/javax.servlet.ServletContainerInitializer

javax.servlet.ServletContainerInitializer
```

```java
package org.springframework.web;

...

@HandlesTypes(WebApplicationInitializer.class)
public class SpringServletContainerInitializer implements ServletContainerInitializer {
    
    @Override
	public void onStartup(Set<Class<?>> webAppInitializerClasses, ServletContext servletContext) throws ServletException {
        
		List<WebApplicationInitializer> initializers = new inkedList<WebApplicationInitializer>();
		...
		for (WebApplicationInitializer initializer : initializers) {
			initializer.onStartup(servletContext);
		}
	}
}

```

이 `SpringServletContainerInitializer` 클래스는 `@HandlesTypes` 통해 `WebApplicationInitializer.class` 를 지정하고 있다. 이때 `onStartUp( )` 메소드의 인자로, `WebApplicationInitializer.class`로 구현된 클래스 Set과 서블릿 컨텍스트 객체를 파라미터로 넣어준다.

WAS가 시작될 때 onStartup 이 실행되며 `org.springframework.web.WebApplicationInitializer` 인터페이스를 구현한 클래스들을 찾아 `onStartup( )` 메소드를 통해 초기화 작업을 진행하도록 한다.



이 인터페이스를 구현한 클래스를 만들어두면 웹 어플리케이션이 시작할 때 자동으로 onStartup() 메서드가 실행된다.


## 루트 웹 애플리케이션 컨텍스트 등록

```xml
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>    
</listener>
```

> **리스너의 역할**
> Listener는 Servlet Context가 생성하는 이벤트를 전달받는 역할을 한다.
> Servlet Context가 만드는 이벤트는 컨텍스트 초기화 이벤트와 종료 이벤트이다.
> 즉 웹 어플리케이션이 시작되고 종료되는 시점에 이벤트가 발생하고, 리스너를 등록해두면 이를 받을 수 있는 것이다.









참고

---------

https://joont92.github.io/spring/WebApplicationInitializer/

https://offbyone.tistory.com/215


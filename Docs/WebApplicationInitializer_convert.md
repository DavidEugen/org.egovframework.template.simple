# WebApplicationInitializer 변환





## Root WebApplication 등록

### 리스너 등록

> **리스너의 역할**
> Listener는 Servlet Context가 생성하는 이벤트를 전달받는 역할을 한다.
> Servlet Context가 만드는 이벤트는 컨텍스트 초기화 이벤트와 종료 이벤트이다.
> 즉 웹 어플리케이션이 시작되고 종료되는 시점에 이벤트가 발생하고, 리스너를 등록해두면 이를 받을 수 있는 것이다.

<web.xml>

```xml
<listener>
    <!-- /WEB-INF/applicationContext.xml 생성-->
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>    
</listener>
```



<EgovWebApplicationInitializer.class>

```java
ServletContextListener listener = new ContextLoaderListener();
servletContext.addListener(listener);
```



## 설정파일 위치 변경

<web.xml>

```xml
<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>
			classpath*:egovframework/spring/com/context-*.xml
	</param-value>
</context-param>
```



<EgovWebApplicationInitializer.class>

```java
servletContext.setInitParameter("contextConfigLoaction", "classpath*:egovframework/spring/com/context-*.xml");
```



참고

---------




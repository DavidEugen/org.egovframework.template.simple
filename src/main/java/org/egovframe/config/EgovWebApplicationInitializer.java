package org.egovframe.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;

/**
 * @ClassName : EgovWebApplicationInitializer.java
 * @Description : 공통 컴포넌트 3.10 EgovWebApplicationInitializer 참조 작성
 *
 * @author : 윤주호
 * @since  : 2021. 5. 13
 * @version : 1.0
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일              수정자               수정내용
 *  -------------  ------------   ---------------------
 *   2021. 5. 13    윤주호               최초 생성
 * </pre>
 *
 */
public class EgovWebApplicationInitializer implements WebApplicationInitializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(EgovWebApplicationInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		LOGGER.debug("EgovWebApplicationInitializer START-============================================");

		// -------------------------------------------------------------
		// Egov Web ServletContextListener 설정 - System property setting
		// -------------------------------------------------------------
		servletContext.addListener(new org.egovframe.config.EgovWebServletContextListener());

		// -------------------------------------------------------------
		// Spring CharacterEncodingFilter 설정
		// -------------------------------------------------------------
		FilterRegistration.Dynamic characterEncoding = servletContext.addFilter("encodingFilter",
			new org.springframework.web.filter.CharacterEncodingFilter());
		characterEncoding.setInitParameter("encoding", "UTF-8");
		characterEncoding.setInitParameter("forceEncoding", "true");
		characterEncoding.addMappingForUrlPatterns(null, false, "*.do");

		// -------------------------------------------------------------
		// Spring ServletContextListener 설정
		// -------------------------------------------------------------
		ServletContextListener listener = new ContextLoaderListener();
		servletContext.addListener(listener);

		// 설정파일 위치 변경
		servletContext.setInitParameter("contextConfigLoaction", "classpath*:egovframework/spring/com/context-*.xml");


	}

}

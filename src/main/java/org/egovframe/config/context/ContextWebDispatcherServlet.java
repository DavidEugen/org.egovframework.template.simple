package org.egovframe.config.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value= {
	//"/WEB-INF/config/egovframework/springmvc/*.xml"
	"/WEB-INF/config/egovframework/springmvc/egov-com-servlet.xml"
	})
public class ContextWebDispatcherServlet {

}

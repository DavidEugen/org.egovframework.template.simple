package org.egovframe.config.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value= {
	"classpath*:egovframework/spring/com/context-*.xml"
	})
public class ContextApp {

}

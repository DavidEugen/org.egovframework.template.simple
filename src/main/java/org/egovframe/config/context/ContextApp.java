package org.egovframe.config.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value= {
	//"classpath*:egovframework/spring/com/context-*.xml"
	//"classpath:egovframework/spring/com/context-aspect.xml" ,
	//"classpath:egovframework/spring/com/context-common.xml" ,
	//"classpath:egovframework/spring/com/context-datasource.xml" ,
	//"classpath:egovframework/spring/com/context-idgen.xml" ,
	//"classpath:egovframework/spring/com/context-properties.xml" ,
	//"classpath:egovframework/spring/com/context-mapper.xml" ,
	//"classpath:egovframework/spring/com/context-transaction.xml" ,
	//"classpath:egovframework/spring/com/context-validator.xml" ,
	//"classpath:egovframework/spring/com/context-whitelist.xml"
	})
@Import({
	ContextAppAspect.class,
	ContextAppCommon.class,
	ContextAppDatasource.class,
	ContextAppIdGen.class,
	ContextAppProperties.class,
	ContextAppTransaction.class,
	ContextAppValidator.class,
	ContextAppWhiteList.class,
	ContextAppMapper.class
})
public class ContextApp {

}

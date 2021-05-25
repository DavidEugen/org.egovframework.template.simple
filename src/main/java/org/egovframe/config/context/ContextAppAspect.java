package org.egovframe.config.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import egovframework.com.cmm.EgovComExcepHndlr;
import egovframework.com.cmm.EgovComOthersExcepHndlr;

@Configuration
public class ContextAppAspect {

	@Bean
	public EgovComExcepHndlr egovHandler() {
		EgovComExcepHndlr egovComExcepHndlr = new EgovComExcepHndlr();
		return egovComExcepHndlr;
	}

	@Bean
	public EgovComOthersExcepHndlr otherHandler() {
		EgovComOthersExcepHndlr egovComOthersExcepHndlr = new EgovComOthersExcepHndlr();
		return egovComOthersExcepHndlr;
	}

}

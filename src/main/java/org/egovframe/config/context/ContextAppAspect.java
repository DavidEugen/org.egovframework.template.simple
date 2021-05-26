package org.egovframe.config.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;

import egovframework.com.cmm.EgovComExcepHndlr;
import egovframework.com.cmm.EgovComOthersExcepHndlr;
import egovframework.rte.fdl.cmmn.aspect.ExceptionTransfer;
import egovframework.rte.fdl.cmmn.exception.handler.ExceptionHandler;
import egovframework.rte.fdl.cmmn.exception.manager.DefaultExceptionHandleManager;
import egovframework.rte.fdl.cmmn.exception.manager.ExceptionHandlerService;

@Configuration
public class ContextAppAspect {

	@Autowired
	AntPathMatcher antPathMatcher;

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

	@Bean
	public DefaultExceptionHandleManager defaultExceptionHandleManager(ExceptionHandler egovHandler) {
		DefaultExceptionHandleManager defaultExceptionHandleManager = new DefaultExceptionHandleManager();
		defaultExceptionHandleManager.setReqExpMatcher(antPathMatcher);
		defaultExceptionHandleManager.setPatterns(new String[] {"**service.impl.*"});
		defaultExceptionHandleManager.setHandlers(new ExceptionHandler[] {egovHandler});
		return defaultExceptionHandleManager;
	}

	@Bean
	public DefaultExceptionHandleManager otherExceptionHandleManager() {
		DefaultExceptionHandleManager defaultExceptionHandleManager = new DefaultExceptionHandleManager();
		defaultExceptionHandleManager.setReqExpMatcher(antPathMatcher);
		defaultExceptionHandleManager.setPatterns(new String[] {"**service.impl.*"});
		defaultExceptionHandleManager.setHandlers(new ExceptionHandler[] {otherHandler()});
		return defaultExceptionHandleManager;
	}

	/**
	 * @return
	 * Exception 발생시 후처리를 위해 표준프레임워크 실행환경의 ExceptionTransfer를 활용하도록  설정
	 */
	@Bean
	public ExceptionTransfer exceptionTransfer(
		@Qualifier("defaultExceptionHandleManager") DefaultExceptionHandleManager defaultExceptionHandleManager,
		@Qualifier("otherExceptionHandleManager") DefaultExceptionHandleManager otherExceptionHandleManager) {
		ExceptionTransfer exceptionTransfer = new ExceptionTransfer();
		exceptionTransfer.setExceptionHandlerService(new ExceptionHandlerService[] {
			defaultExceptionHandleManager, otherExceptionHandleManager
		});
		return exceptionTransfer;
	}

}

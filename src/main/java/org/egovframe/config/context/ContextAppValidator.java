package org.egovframe.config.context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springmodules.validation.commons.DefaultBeanValidator;
import org.springmodules.validation.commons.DefaultValidatorFactory;

@Configuration
public class ContextAppValidator {

	@Bean
	public DefaultBeanValidator beanValidator() {
		DefaultBeanValidator defaultBeanValidator = new DefaultBeanValidator();
		defaultBeanValidator.setValidatorFactory(validatorFactory());
		return defaultBeanValidator;

	}

	/** validation config location 설정
	 * @return
	 */
	@Bean
	public DefaultValidatorFactory validatorFactory() {
		DefaultValidatorFactory defaultValidatorFactory= new DefaultValidatorFactory();

		defaultValidatorFactory.setValidationConfigLocations(getValidationConfigLocations());

		return defaultValidatorFactory;
	}

	// 좀 더 깔끔한 location 설정 필요
	// xml 설정에서 단일 소스 경로와 ant style pattern을 동시에 사용하여 파싱하는 과정 확인 필요
	private Resource[] getValidationConfigLocations() {

		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();

		List<Resource> validationConfigLocations = new ArrayList<Resource>();

		Resource[] validationRulesConfigLocations = new Resource[]{
			pathMatchingResourcePatternResolver.getResource("classpath:/egovframework/validator/validator-rules-let.xml")
		};

		Resource[] validationFormSetLocations = null;
		try {
			validationFormSetLocations = pathMatchingResourcePatternResolver.getResources("classpath:/egovframework/validator/let/**/*.xml");
		} catch (IOException e) {
			// TODO Exception 처리 필요
		}

		validationConfigLocations.addAll(Arrays.asList(validationRulesConfigLocations));
		validationConfigLocations.addAll(Arrays.asList(validationFormSetLocations));

		return validationConfigLocations.toArray(new Resource[validationConfigLocations.size()]);
	}


}

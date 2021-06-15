package org.egovframe.config.context;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import egovframework.rte.fdl.property.impl.EgovPropertyServiceImpl;

@Configuration
public class ContextAppProperties {

	@Bean(destroyMethod = "destroy")
	public EgovPropertyServiceImpl propertiesService() {
		EgovPropertyServiceImpl egovPropertyServiceImpl = new EgovPropertyServiceImpl();

		Map<String, String> properties = new HashMap<String,String>();
		properties.put("pageUnit", "10");
		properties.put("pageSize", "10");
		properties.put("posblAtchFileSize", "5242880");
		properties.put("Globals.fileStorePath", "/user/file/sht/");
		properties.put("Globals.addedOptions", "false");

		egovPropertyServiceImpl.setProperties(properties);
		return egovPropertyServiceImpl;
	}
}

package org.egovframe.config.context;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextAppWhiteList {

	@Bean
	public List<String> egovPageLinkWhitelist(){
		List<String> whiteList = new ArrayList<String>();
		whiteList.add("main/inc/EgovIncHeader");
		whiteList.add("main/inc/EgovIncTopnav");
		whiteList.add("main/inc/EgovIncLeftmenu");
		whiteList.add("main/inc/EgovIncFooter");
		whiteList.add("main/sample_menu/Intro");
		whiteList.add("main/sample_menu/EgovDownloadDetail");
		whiteList.add("main/sample_menu/EgovDownloadModify");
		whiteList.add("main/sample_menu/EgovQADetail");
		whiteList.add("main/sample_menu/EgovAboutSite");
		whiteList.add("main/sample_menu/EgovHistory");
		whiteList.add("main/sample_menu/EgovOrganization");
		whiteList.add("main/sample_menu/EgovLocation");
		whiteList.add("main/sample_menu/EgovProductInfo");
		whiteList.add("main/sample_menu/EgovServiceInfo");
		whiteList.add("main/sample_menu/EgovDownload");
		whiteList.add("main/sample_menu/EgovQA");
		whiteList.add("main/sample_menu/EgovService");
		return whiteList;
	}
}

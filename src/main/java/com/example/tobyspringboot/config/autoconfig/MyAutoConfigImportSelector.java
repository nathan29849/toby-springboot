package com.example.tobyspringboot.config.autoconfig;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{
			"com.example.tobyspringboot.config.autoconfig.DispatcherServletConfig",
			"com.example.tobyspringboot.config.autoconfig.TomcatWebServerConfig"
		};
	}
}

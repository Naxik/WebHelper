package ru.another.config.dozer;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * @author Another
 *         date: 16.08.2016.
 */
@Configuration
public class MappingConfiguration {

	@Bean
	public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean(@Value("classpath:**/*mapping.xml") Resource[] mappingFiles) {
		final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
		// Other configurations
		dozerBeanMapperFactoryBean.setMappingFiles(mappingFiles);
		return dozerBeanMapperFactoryBean;
	}
}

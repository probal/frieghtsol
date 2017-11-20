package com.freightsol.freightsol.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freightsol.freightsol.filter.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;

import java.io.IOException;

/**
 * Created by probal on 10/17/17.
 */
@Configuration
public class BeanConfig {

   /**
    * AuthenticationFilter is already a Spring @Component itself, So it needs to be disabled form here.
    * Otherwise this filter will be registered twice in bean factory.
    * But still feel free to customise the Filter here
    */
    @Bean
    public FilterRegistrationBean myFilterBean() {
        final FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new AuthenticationFilter());
        filterRegBean.addUrlPatterns("/api/v1/*");
        filterRegBean.setEnabled(Boolean.FALSE);
        filterRegBean.setName("Custom Authentication Filter");
        filterRegBean.setAsyncSupported(Boolean.TRUE);
        return filterRegBean;
    }

    @Bean
    public MappingJackson2HttpMessageConverter MappingJackson2HttpMessageConverter (ApplicationContext applicationContext) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().applicationContext(applicationContext).build();
        return new MappingJackson2HttpMessageConverter(objectMapper) {
            @Override
            protected void writePrefix(JsonGenerator generator, Object object) throws IOException {
                String jsonpFunction =
                        (object instanceof MappingJacksonValue ? ((MappingJacksonValue) object).getJsonpFunction() : null);
                if (jsonpFunction != null) {
                    generator.writeRaw(jsonpFunction + "(");
                }
            }

        };
    }
}

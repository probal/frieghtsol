package com.freightsol.freightsol.config;

import com.freightsol.freightsol.filters.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by probal on 10/17/17.
 */
@Configuration
public class FilterConfiguration {

   /**
    * AuthenticationFilter is already a Spring @Component itself, So it needs to be disabled form here.
    * Otherwise this filter will be registered twice in bean factory.
    * But still feel free to customise the Filter here
    */
    @Bean
    public FilterRegistrationBean myFilterBean() {
        final FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new AuthenticationFilter());
        filterRegBean.addUrlPatterns("/api/v1/private/*");
        filterRegBean.setEnabled(Boolean.FALSE);
        filterRegBean.setName("Custom Authentication Filter");
        filterRegBean.setAsyncSupported(Boolean.TRUE);
        return filterRegBean;
    }
}

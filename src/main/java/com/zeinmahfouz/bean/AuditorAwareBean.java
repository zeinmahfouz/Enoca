package com.zeinmahfouz.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import com.zeinmahfouz.audit.AuditorAwareImpl;

//AuditorAwareimpl sayfada olusturdugumuz implement ekliyoruz
@Configuration
public class AuditorAwareBean {
    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }
}



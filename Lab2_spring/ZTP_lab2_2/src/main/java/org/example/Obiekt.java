package org.example;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Obiekt {
    @Bean
    @Scope("prototype")
    public MyBean mybean (){
        return new MyBean();
    }
}


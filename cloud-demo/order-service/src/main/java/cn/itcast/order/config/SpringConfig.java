package cn.itcast.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {

    /**
     * 创建RestTemplate 并注入Spring容器中
     * @return
     */
//    @Bean(name = "hello")
    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}

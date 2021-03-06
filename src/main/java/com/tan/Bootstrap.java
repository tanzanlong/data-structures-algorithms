package com.tan;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.baibei.log4k8s.Log4k8s;

@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan("com.baibei.wine.paycenter")
@ImportResource({"classpath:config/spring-context.xml"})
public class Bootstrap extends WebMvcConfigurerAdapter implements SchedulingConfigurer{
    
    static{
        Log4k8s.init("discrepancy-money-service");
    }
    

    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        List<TAppConfig> list = tAppConfigService.queryAll();
//        TAppConfig appConfig = list.get(0);
//        String appId = null;
//        String appSecret = null;
//        if(appConfig != null){
//            appId = appConfig.getAppId();
//            appSecret = appConfig.getAppSrcret();
//        }
//        TokenCheckInterceptor tokenCheckInterceptor = new TokenCheckInterceptor(appId, appSecret);
//        registry.addInterceptor(tokenCheckInterceptor).addPathPatterns("/**");
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }
    
    @Bean(destroyMethod="shutdown")
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(30);
    }
}

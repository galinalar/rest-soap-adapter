package ru.adapter;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.spring.boot.CamelSpringBootApplicationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.Servlet;

@SpringBootApplication
@EnableSwagger2
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        CamelSpringBootApplicationController bean = run.getBean(CamelSpringBootApplicationController.class);
        bean.run();

    }

    @Bean
    public ServletRegistrationBean<Servlet> servletRegistrationBean() {
        ServletRegistrationBean<Servlet> registration = new ServletRegistrationBean<>(new CamelHttpTransportServlet(), "/camel/*");
        registration.setName("CamelServlet");
        return registration;
    }
}

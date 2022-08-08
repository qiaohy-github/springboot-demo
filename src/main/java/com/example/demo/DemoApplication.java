package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication //@SpringBootApplication 注解默认包含了 @ComponentScan(value = "com.example.demo")
    //@ComponentScan注解：Spring项目启动时就会加载该包和其子包的带有特定注解的类到Spring容器中。这些注解有@Component、@Bean、@Controller、@Service、@Repository等等。

@MapperScan(value = "com.example.demo.mapper")
//@ComponentScan(value = "com.example") 扫描的范围扩大到整个父包com.example
//@ComponentScan(value = "com.example.demo", "com.example.demo2")// 或 分别扫描两个包，注意：此时，如果仅仅只写@ComponentScan({"com.example.demo2"})将导致com.example.demo 包下的类无法被扫描到（框架原始的默认扫描效果无效了）
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
